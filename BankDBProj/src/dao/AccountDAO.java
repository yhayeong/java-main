package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import acc.Account;
import acc.SpecialAccount;

public class AccountDAO { 
	
	
	// 연결 객체 생성하는 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));

			conn = DriverManager.getConnection(
							db.getProperty("url"),
							db.getProperty("user"), 
							db.getProperty("password"));
			
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	// 연결 객체 닫는 메소드
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 셀렉트
	public static Account selectAccount(Connection conn, String id) {
		
		Account acc = null;
		String sql = "SELECT * FROM ACCOUNT WHERE ID=?";
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				String rid = rs.getString("ID"); // rs의 컬럼명
				String rname = rs.getString("NAME");
				Integer rbalance = rs.getInt("BALANCE");
				String rgrade = rs.getString("GRADE");

				// 받아온 GRADE컬럼값이 null이면 Account를 객체 생성하고 아니면 SpecialAccount객체를 생성
				if(rgrade==null) {
					acc = new Account(rid, rname, rbalance);
				} else {
					acc = new SpecialAccount(rid, rname, rbalance, rgrade);
				}
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
	}
	
	
	
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
					String rid = rs.getString(1); // rs의 컬럼 인덱스
					String rname = rs.getString(2);
					Integer rbalance = rs.getInt(3);
					String rgrade = rs.getString(4);
					
					if(rgrade==null) accList.add(new Account(rid, rname, rbalance));
					else accList.add(new SpecialAccount(rid, rname, rbalance, rgrade));
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
	}
	
	
	
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
			if(acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount)acc).getGrade()); //자식클래스 SpecialAccount에만 있는 멤버 사용
			} else {
				pstmt.setString(4, null);
			}
			
			// 완성한 쿼리문을 실행
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
	
	
	// 업데이트 (Bank에서 이미 잔액이 갱신된 acc를 인자로 전달받음)
	public static int updateAccount(Connection conn, Account acc) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ID=?";
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
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
