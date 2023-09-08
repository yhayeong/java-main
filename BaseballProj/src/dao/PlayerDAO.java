package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class PlayerDAO {
	

	// 4. 선수 등록  
	public int insertPlayer(Player player) {
		int cnt = 0;
		
		return cnt;
	}
	
	   
	// 5. 특정선수 조회 (이름으로)
	public List<Player> selectPlayerByName(String name) {
		List<Player> playerList = new ArrayList<>();
		
		return playerList;
	}
       
	
	// 6. 특정선수 조회 (등번호로-팀이 다르면 중복된 등번호를 가질수있으므로 한명 이상이 반환될수있음)
	public List<Player> selectPlayerByBackNum(Integer backNum) {
		List<Player> playerList = new ArrayList<>();
		
		return playerList;
	}
	
	
	// 7. 특정선수 조회 (번호로)
	public Player selectPlayerByNum(Integer num) {
		Player player = null;
		
		return player;
	}
	
	
	// 8. 특정팀 소속 선수목록 조회  
	public List<Player> selectPlayerByTeam(String teamName) {
		List<Player> playerList = new ArrayList<>();
		
		return playerList;
	}

}
