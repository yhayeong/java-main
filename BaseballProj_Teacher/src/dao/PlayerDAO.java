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

public class PlayerDAO {
	
	// 연결객체 생성 메소드
	public Connection getConnecton() {
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
	//연결객체 닫는 메소드
	public void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// 4. 선수 등록
	public int insertPlayer(Player player) {
		int cnt = 0;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PLAYER (name, backnum, teamnum) VALUES (?, ?, ?)"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setInt(2, player.getBacknum());
			pstmt.setInt(3, player.getTeamnum());
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
		close(conn);
		return cnt;
	}
	
	   
	// 5. 특정선수 조회 (이름으로)
	public List<Player> selectPlayerByName(String name) {
		List<Player> playerList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
//		String sql = "SELECT * FROM PLAYER WHERE NAME = ?"; //-> X. 서비스에서 출력하는 Player의 toString은 팀명을 필요로하기 때문에 DB에서 받아와야함
		String sql = "SELECT p.num, p.name, p.backnum, p.teamnum, t.name "
				+ "from player p join team t on p.teamnum=t.num " 
				+ "where p.name=?";
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
					String rTeamName = rs.getString(5);
					
					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum, rTeamName)); // 팀명이 있는 생성자를 통해 팀명필드에 값을 할당
//					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum, null));
					
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
		close(conn);
		return playerList;
	}
       
	
	// 6. 특정선수 조회 (등번호로-팀이 다르면 중복된 등번호를 가질수있으므로 한명 이상이 반환될수있음)
	public List<Player> selectPlayerByBackNum(Integer backNum) {
		List<Player> playerList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT p.num, p.name, p.backnum, p.teamnum, t.name "
				+ "from player p join team t on p.teamnum=t.num " 
				+ "where p.backnum=?";
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
					String rTeamName = rs.getString(5);
					
					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum, rTeamName));
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
		close(conn);
		return playerList;
	}
	
	
	// 7. 특정선수 조회 (번호로)
	public Player selectPlayerByNum(Integer num) {
		Player player = null;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT p.num, p.name, p.backnum, p.teamnum, t.name "
				+ "from player p join team t on p.teamnum=t.num " 
				+ "where p.num=?";
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
				String rTeamName = rs.getString(5);
				
				player = new Player(rNum, rName, rBackNum, rTeamNum, rTeamName);
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
		close(conn);
		return player;
	}
	
	
	// 8. 특정팀 소속 선수목록 조회  
	public List<Player> selectPlayerByTeam(String teamName) {
		List<Player> playerList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		
//		String sql = "SELECT * FROM PLAYER WEHRE TEAMNUM = (SELECT NUM FROM TEAM WHERE NAME = ?)"; //->X. Player의 toString은 teamName을 출력하고, 생성자에서 teamName을 초기화하므로 팀명을 DB에서 조회해야함
		String sql = "SELECT p.num, p.name, p.backnum, p.teamnum, t.name "
						+ "from player p join team t on p.teamnum=t.num " 
						+ "where t.name=?";
		
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			
			rs = pstmt.executeQuery(); // 서브쿼리로 변경하면 여기서 에러 발생 @@@
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNum = rs.getInt("P.NUM");
					String rName = rs.getString("P.NAME");
					Integer rBackNum = rs.getInt("P.BACKNUM");
					Integer rTeamNum = rs.getInt("P.TEAMNUM");
					String rTeamName = rs.getString("T.NAME");
					
//					Integer rNum = rs.getInt(1);
//					String rName = rs.getString(2);
//					Integer rBackNum = rs.getInt(3);
//					Integer rTeamNum = rs.getInt(4);
					
					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum, rTeamName));
//					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum, null));
//					playerList.add(new Player(rNum, rName, rBackNum, rTeamNum));
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
		close(conn);
		return playerList;
	}

}
