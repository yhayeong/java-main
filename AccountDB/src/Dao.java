import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dao {
	
	// 연결 객체 생성하는 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			/*
			 load메소드를 통해 파일을 가져와서, 
			 그 파일의 키값을 통해 벨류를 얻어오는 getProperty메소드를 이용하여 벨류를
			 드라이버클래스로 지정한다 (반환받은 클래스의 멤버를 사용할 일이 없으므로 딱히 참조변수에 담지는 않음)
			*/
			
			conn = DriverManager.getConnection(
							db.getProperty("url"),
							db.getProperty("user"), 
							db.getProperty("password"));
			
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return conn;
	}//getConnection
	
	
	
	// 연결 객체 닫는 메소드
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//close
	
	
	
	// 셀렉트
	public static Account selectAccount(Connection conn, String id) {
		
		Account acc = null;
		String sql = "SELECT * FROM ACCOUNT WHERE ID=?";
		PreparedStatement pstmt = null; // 미완성(가변) 실행 객체
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성 쿼리문을 가지고 미완성(가변) 실행 객체 생성
			pstmt.setString(1, id); // cf. 물음표의 인덱스는 0이 아닌 1부터 시작함(DB관련인덱스넘버는 1부터시작하고 유일한 예외는 limit) 
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				String resultId = rs.getString("ID"); //rs.getString(1)이렇게 DB의 컬럼의 인덱스를 적어도 됨
				String resultName = rs.getString("NAME");
				Integer resultBalance = rs.getInt("BALANCE");
				String resultGrade = rs.getString("GRADE");
				
				acc = new Account(resultId, resultName, resultBalance, resultGrade);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return acc;
		// if(rs!=null && rs.next())에 들어오면 Account객체를 생성하여 반환하고 조건문에 안걸리면 null을 반환
	}//selectAccount
	
	
	
	
	// 셀렉트
	public static List<Account> selectAccountList(Connection conn) {
		List<Account> accList = new ArrayList<>();
		
		Statement stmt = null;
		String sql = "SELECT * FROM ACCOUNT";
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs!=null) {
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					Integer balance = rs.getInt(3);
					String grade = rs.getString(4);
					accList.add(new Account(id, name, balance, grade));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return accList;
	}//selectAccountList
	
	
	
	// 인서트
	public static int insertAccount(Connection conn, Account acc) {
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ACCOUNT VALUES (?,?,?,?)";
		int cnt = 0;
		
		try {
			// 미완성쿼리문용 실행객체를 만든다
			pstmt = conn.prepareStatement(sql);
			// 미완성쿼리문을 완성시킨다
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getGrade());
			//완성된 쿼리문을 실행하여 결과행의 수를 반환받는다
			cnt = pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}//insertAccount
	
	
	
	// 업데이트 (서비스의 메소드에서 이미 잔액이 갱신된 acc를 인자로 전달받음)
	// *** 서비스의 입금과 출금 메소드 모두 이 메소드를 호출하여 DB에 update 질의를 수행
	public static int updateAccount(Connection conn, Account acc) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ID=?";
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance()); // 인덱스넘버는 미완성쿼리문의 물음표 순서를 의미
			pstmt.setString(2, acc.getId());
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	
	
	
	
}
