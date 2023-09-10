package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Player;
import dto.Team;

public class PlayerDAO {
	
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
	

	// 4. 선수 등록
	public static int insertPlayer(Player player) {
		int cnt = 0;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PLAYER VALUSE (?, ?, ?, ?)"; //NUM, NAME, BACKNUM, TEAMNUM
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, player.getNum());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getBacknum());
			pstmt.setInt(4, player.getTeamnum());
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
	
	   
	// 5. 특정선수 조회 (이름으로)
	public List<Player> selectPlayerByName(String name) {
		List<Player> playerList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM PLAYER WHERE NAME = ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNum = rs.getInt("NUM");
					String rName = rs.getString("NAME");
					Integer rBackNum = rs.getInt("BACKNUM");
					Integer rTeamNum = rs.getInt("TEAMNUM");
					
					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum));
				}
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
		
		return playerList;
	}
       
	
	// 6. 특정선수 조회 (등번호로-팀이 다르면 중복된 등번호를 가질수있으므로 한명 이상이 반환될수있음)
	public List<Player> selectPlayerByBackNum(Integer backNum) {
		List<Player> playerList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM PLAYER WHERE BACKNUM = ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, backNum);
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNum = rs.getInt("NUM");
					String rName = rs.getString("NAME");
					Integer rBackNum = rs.getInt("BACKNUM");
					Integer rTeamNum = rs.getInt("TEAMNUM");
					
					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum));
				}
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
		
		return playerList;
	}
	
	
	// 7. 특정선수 조회 (번호로)
	public Player selectPlayerByNum(Integer num) {
		Player player = null;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM PLAYER WHERE NUM = ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				Integer rNum = rs.getInt("NUM");
				String rName = rs.getString("NAME");
				Integer rBackNum = rs.getInt("BACKNUM");
				Integer rTeamNum = rs.getInt("TEAMNUM");
				
				player = new Player(rNum, rName, rBackNum, rTeamNum);
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
		
		return player;
	}
	
	
	// 8. 특정팀 소속 선수목록 조회  
	public List<Player> selectPlayerByTeam(String teamName) {
		List<Player> playerList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM PLAYER WHERE TEAMNUM = ?";
		ResultSet rs = null;
		
		try {
			TeamDAO teamDao = new TeamDAO();
			Team team = teamDao.selectTeam(teamName); // 팀명으로 팀을 조회
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, team.getNum()); // 팀의 팀번호를 뽑아 미완성쿼리문을 완성시킴
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNum = rs.getInt("NUM");
					String rName = rs.getString("NAME");
					Integer rBackNum = rs.getInt("BACKNUM");
					Integer rTeamNum = rs.getInt("TEAMNUM");
					
					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum));
				}
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
		
		return playerList;
	}

}
