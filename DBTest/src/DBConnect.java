import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBConnect {
	
	// DB연결 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			// <1> 연결객체
			// 연결에 필요한 정보 - 드라이버, URL, 계정, 패스워드
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "1234");  // cf. 클래스명.스태틱메소드 (싱글톤)
			// URL(DB가 설치돼있는 서버pc의 IP주소: 마리아db설치시 지정한 포트넘버-ip로 찾아간 pc의 어떤 서버프로그램인지 식별/db명), 계정, 패스워드
			System.out.println("DB연결 성공");
			
		} catch (Exception e) { // db나 파일입출력은 반드시 e.printStackTrace();로 문제발생내용을 확인해야함 
			e.printStackTrace();
		}
		return conn;
	}//getConnection
	
	
	
	// conn 닫는 메소드
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//close
	
	
	
	public static void insertUser(String id, String name) {
		
		Connection conn = getConnection(); // 연결객체를 생성하는 스태틱메소드 호출
		Statement stmt = null;
		String sql = String.format("INSERT INTO USER (ID, NAME) VALUES ('%s', '%s')", id, name); // 인자로 받은 값으로 쿼리를 만듦
		
		// <2> 실행객체
		
		try {
			stmt = conn.createStatement(); // 연결객체로부터 실행 객체 생성
			int cnt = stmt.executeUpdate(sql); // 테이블의 데이터를 update하는 dml(insert,update,delete)를 수행하고 결과행 수를 반환하는 메소드
			System.out.println(cnt + "개 데이터 삽입"); // 실행후 db에 반영됨을 확인
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally {
			try {
				if(stmt!=null) stmt.close(); // 실행객체 닫기
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn); // 연결객체 닫는 스태틱메소드 호출
		}
	}//insertUser
	
	
	
	
	public static void updateUserName(String id, String name) {
		
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("UPDATE USER SET NAME='%s' WHERE ID='%s'", name, id);
		
		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "개 데이터 변경");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}//updateUserName
	
	
	
	private static void deleteUser(String id) {

		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("DELETE FROM USER WHERE ID='%s'", id);
		
		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "개 데이터 삭제");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}//deleteUser
	
	
	
	/*
	 
	 
	 CRUD
	 
	 
	 DML질의 (삽입,생성,삭제)
	 (1) 연결객체 생성
	 (2) 실행객체 생성 - 예외처리
	 (3) 매개변수를 이용해 쿼리문 작성
	 (4) 실행객체를 통해 쿼리문 실행 후 결과행 수를 반환받기
	 (5) 실행객체와 연결객체를 닫기
	 
	 
	 DQL질의 (조회)
	 (1) 연결객체 생성
	 (2) 실행객체 생성 - 예외처리
	 (3) 매개변수를 이용해 쿼리문 작성
	 (4) 실행객체를 통해 쿼리문 실행 후 결과행집합을 반환받기
	 (5) 결과집합객체와 실행객체와 연결객체를 닫기



	 연결정보를 Properties파일로 빼고, 질의의 리턴타입 클래스로 받고, PreparedStatement를 사용하는 식으로 확장...
	 * */
	
	
	
	private static void userInfo(String id) {
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("SELECT * FROM USER WHERE ID='%s'", id);
		ResultSet rs = null; // 셀렉트문의 리턴값은 결과집합 객체이다
		
		try {
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);
			
			if(rs!=null && rs.next()) { // cf. 이터레이터 사용과 유사 rs.next()의 리턴타입은 boolean
				String resultId = rs.getString("ID"); // 반환받은 레코드(행)을 컬럼단위로 뜯어서 가져옴
				String resultName = rs.getString("NAME");
				System.out.println(resultId + ", " + resultName);
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
			close(conn);
		}
	}//userInfo
	
	
	private static void allUserInfo() {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = String.format("SELECT * FROM USER");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs!=null) {
				while(rs.next()) {
					String resultId = rs.getString(1); // 컬럼명 대신 인덱스 사용
					String resultName = rs.getString(2);
					System.out.println(resultId + ", " + resultName);
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
	}//allUserInfo
	
	
	
	public static void main(String[] args) {
		
//		insertUser("song", "송길동");
//		updateUserName("song", "송송이");
//		deleteUser("song");
//		userInfo("park");
		allUserInfo();
		
	}//main





}


// connector/j를 빌드패스에 추가 후 연결
// ClassNotFound Exception : 틀린 jar를 넣었을때 (mariadb-java-client-3.1.3-sources.jar가 아님을 주의)