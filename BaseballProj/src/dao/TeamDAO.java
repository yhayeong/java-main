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

import dto.Team;

public class TeamDAO {
	
	// 연결객체 생성 메소드
	public static Connection getConnecton() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(
							db.getProperty("url"),
							db.getProperty("user"),
							db.getProperty("password"));
		} catch (Exception e) {;
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// 1. 팀 등록
	public int insertTeam(Team team) {
		int cnt = 0;
		Connection conn = getConnecton();
		String sql = "INSERT INTO TEAM VALUES (?, ?, ?)"; //num, name, local
		PreparedStatement pstmt = null;
		
		try {
			// 미완성쿼리문용 실행객체 생성
			pstmt = conn.prepareStatement(sql);
			// 미완성쿼리문을 완성
			pstmt.setInt(1, team.getNum());
			pstmt.setString(2, team.getName());
			pstmt.setString(3, team.getLocal());
			// 완성한 쿼리문을 실행
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	
	// 2. 특정팀 조회 (팀명으로)
	public Team selectTeam(String teamName) {
		Team team = null;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM TEAM WHERE NAME=?";
		ResultSet rs = null;
		
		try {
			// 쿼리문 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			rs = pstmt.executeQuery();
			
			// 결과객체에서 컬럼값을 뽑아내어 팀객체를 생성
			if(rs!=null && rs.next()) {
				int rNum = rs.getInt("NUM");
				String rName = rs.getString("NAME");
				String rLocal = rs.getString("LOCAL");
				
				team = new Team(rNum, rName, rLocal);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return team;
	}
	
	
	// 3. 팀목록 조회
	public List<Team> selectTeamList() {
		List<Team> teamList = new ArrayList<>();
		Connection conn = getConnecton();
		Statement stmt = null;
		String sql = "SELECT * FROM TEAM";
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNum = rs.getInt("NUM");
					String rName = rs.getString("NAME"); 
					String rLocal = rs.getString("LOCAL"); 
					
					teamList.add(new Team(rNum, rName, rLocal));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return teamList;
	}

}
