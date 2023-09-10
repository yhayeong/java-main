package service;

import java.util.List;
import java.util.Scanner;

import dao.PlayerDAO;
import dao.TeamDAO;
import dto.Player;
import dto.Team;

public class BaseBallService {
	
	static Scanner sc = new Scanner(System.in); 
	TeamDAO teamDao = new TeamDAO();
	PlayerDAO playerDao = new PlayerDAO();
	
	
	// 1. 팀 등록  
	public void regTeam() {
		System.out.println("[팀 등록]");
		System.out.print("팀명: ");
		String name = sc.nextLine();
		System.out.print("연고지: ");
		String local = sc.nextLine();
		
		Team team = new Team(name, local);
		int cnt = teamDao.insertTeam(team);
		if(cnt>0) {
			System.out.println(cnt + "개의 팀이 등록되었습니다.");
		} else {
			System.out.println("팀 등록 실패");
		}
	}
	   
	// 2. 특정팀 조회 (팀명으로)
	public void teamInfo() {
		System.out.println("[팀 조회]");
		System.out.print("팀명: ");
		String name = sc.nextLine();
		
		Team team = teamDao.selectTeam(name);
		if(team==null) System.out.println("해당 팀이 존재하지 않습니다.");
		else System.out.println("----조회 결과----\n" + team);
	}
	   
	// 3. 팀목록 조회  
	public void AllTeamInfo() {
		System.out.println("[팀 목록 조회]");
		List<Team> teamList = teamDao.selectTeamList();
		for (Team team : teamList) {
			System.out.println(team);
		}
	}
	   
	// 4. 선수 등록  
	public void regPlayer() {
		System.out.println("[선수 등록]");
		System.out.print("선수명: ");
		String playerName = sc.nextLine();
		System.out.print("등번호: ");
		Integer backNum = Integer.parseInt(sc.nextLine());
		
		// 팀 목록을 보여준 후 입력받는다 
		System.out.println("<팀 선택>");
//		List<Team> teamList = teamDao.selectTeamList();
//		for (int i=0; i<teamList.size(); i++) {
//			System.out.println((i+1) + ":" + teamList.get(i).getName());
//		}
		System.out.println("1 : SSG랜더스");
		System.out.println("2 : 키움히어로즈");
		System.out.println("3 : LG트윈스");
		System.out.println("4 : KT위즈");
		System.out.println("5 : KIA타이거즈");
		System.out.println("6 : NC다이노스");
		System.out.println("7 : 삼성라이온즈");
		System.out.println("8 : 롯데자이언츠");
		System.out.println("9 : 두산베어스");
		System.out.println("10 : 한화이글스");
		System.out.print("선택(번호)>> ");
		int sel = Integer.parseInt(sc.nextLine());
//		while(true) {
//			String teamName = "";
//			switch (sel) {
//			case 1: teamName = "SSG랜더스"; break;
//			case 2: teamName = "키움히어로즈"; break;
//			case 3: teamName = "LG트윈스"; break;
//			case 4: teamName = "KT위즈"; break;
//			case 5: teamName = "KIA타이거즈"; break;
//			case 6: teamName = "NC다이노스"; break;
//			case 7: teamName = "삼성라이온즈"; break;
//			case 8: teamName = "롯데자이언츠"; break;
//			case 9: teamName = "두산베어스"; break;
//			case 10: teamName = "한화이글스"; break;
//			default: System.out.println("잘못 선택하셨습니다.");
//			}
//			if(1<=sel && sel<=10) break;
//		}
		
		Player player = new Player(playerName, backNum, sel);
		int cnt = playerDao.insertPlayer(player);
		if(cnt>0) System.out.println(cnt + "명의 선수가 등록되었습니다.");
		else System.out.println("선수 등록 실패");
	}
	
	
	// 5. 특정선수 조회 (이름으로) 리턴타입 List
	public void playerInfoByName() {
		System.out.println("[선수 조회]");
		System.out.print("선수명: ");
		String name = sc.nextLine();
		
		List<Player> playerList = playerDao.selectPlayerByName(name);
		if(playerList.size()==0) System.out.println("해당 선수가 존재하지 않습니다.");
		else {
			System.out.println("----조회 결과----");
			for (Player player : playerList) {
				System.out.println(player);
			}
		}
	}
	
       
	// 6. 특정선수 조회 (등번호로) 리턴타입 List cf. 팀이 다르면 중복된 등번호를 가질수있다
	public void playerInfoByBackNum() {
		System.out.println("[선수 조회]");
		System.out.print("등번호: ");
		Integer backNum = Integer.parseInt(sc.nextLine());
		
		List<Player> playerList = playerDao.selectPlayerByBackNum(backNum);
		if(playerList.size()==0) System.out.println("해당 선수가 존재하지 않습니다.");
		else {
			System.out.println("----조회 결과----");
			for (Player player : playerList) {
				System.out.println(player);
			}
		}
	}
	
	
	
	// 7. 특정선수 조회 (번호로) 리턴타입 Player
	public void playerInfoByNum() {
		System.out.println("[선수 조회]");
		System.out.print("선수번호: ");
		Integer num = Integer.parseInt(sc.nextLine());
		
		Player player = playerDao.selectPlayerByNum(num);
		if(player==null) System.out.println("해당 선수가 존재하지 않습니다.");
		else System.out.println("----조회 결과----\n" + player);
	}
	
	
	
	// 8. 특정팀 소속 선수목록 조회 (팀명으로)
	public void playerListByTeamName() {
		System.out.println("[팀 소속선수 목록 조회]");
		System.out.print("팀명: ");
		String teamName = sc.nextLine();
		
		List<Player> playerList = playerDao.selectPlayerByTeam(teamName);
		if(playerList.size()==0) System.out.println("해당 팀에 소속된 선수가 없습니다.");
		else {
			System.out.println("----조회 결과----");
			for (Player player : playerList) {
				System.out.println(player);
			}
		}
	}
	
	
	// 메뉴출력, 사용자입력
	public static int menu() {
		System.out.println("[야구 팀/선수 등록/조회]");
		System.out.println("1. 팀 등록");
		System.out.println("2. 특정팀 조회(팀명으로)");
		System.out.println("3. 팀목록 조회");
		System.out.println("----------------------");
		System.out.println("4. 선수 등록");
		System.out.println("5. 특정선수 조회(이름으로)");
		System.out.println("6. 특정선수 조회(등번호로)");
		System.out.println("7. 특정선수 조회(번호로)");
		System.out.println("8. 특정팀 선수목록 조회)");
		System.out.print("선택>> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	
	// 메인
	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}





/*
SSG랜더스 인천 : 김광현, 김강민
키움히어로즈 서울 : 이정우, 이주형
LG트윈스 서울 : 오지환, 이정용
KT위즈 수원 : 강백호, 박병호
KIA타이거즈 광주 : 박찬호, 양현종
NC다이노스 창원 : 박건우, 김주원
삼성라이온즈 대구 : 구자욱, 오승환
롯데자이언츠 부산 : 이정훈, 한동희
두산베어스 서울 : 양의지, 박재환
한화이글스 대전 : 노시환, 이진영
 * */
