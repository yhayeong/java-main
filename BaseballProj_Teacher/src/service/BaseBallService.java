package service;

import java.util.List;
import java.util.Scanner;

import dao.PlayerDAO;
import dao.TeamDAO;
import dto.Player;
import dto.Team;

public class BaseBallService {
	
	static Scanner sc = new Scanner(System.in); 
	
	private TeamDAO teamDao;
	private PlayerDAO playerDao;
	
	public BaseBallService() {
		teamDao = new TeamDAO();
		playerDao = new PlayerDAO();
	}
	
	
	// 1. 팀 등록  
	public void regTeam() {
		System.out.println("[팀 등록]");
		System.out.print("팀명: ");
		String name = sc.nextLine();
		System.out.print("연고지: ");
		String local = sc.nextLine();
		
		Team team = new Team(null, name, local);
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
		
		// 팀 목록을 보여준 후 입력받는다 (Team클래스에 num, name만 문자열로 리턴하는 메소드를 만듦)
		System.out.println("<팀 선택>");
		List<Team> teamList = teamDao.selectTeamList();
		for (Team team : teamList) {
			System.out.println(team.shortString());
		}
		System.out.print("선택(번호)>> ");
		int teamNum = Integer.parseInt(sc.nextLine());

		Player player = new Player(null, playerName, backNum, teamNum, null);
		int cnt = playerDao.insertPlayer(player);
		if(cnt>0) System.out.println(cnt + "명의 선수가 등록되었습니다.");
		else System.out.println("선수 등록 실패");
	}
	
	
	// 5. 특정선수 조회 (이름으로) 
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
	
       
	// 6. 특정선수 조회 (등번호로)
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
	
	
	
	// 7. 특정선수 조회 (번호로) 
	public void playerInfoByNum() {
		System.out.println("[선수 조회]");
		System.out.print("선수번호: ");
		Integer num = Integer.parseInt(sc.nextLine());
		
		Player player = playerDao.selectPlayerByNum(num);
		if(player==null) System.out.println("해당 선수가 존재하지 않습니다.");
		else System.out.println("----조회 결과----\n" + player);
	}
	
	
	
	// 8. 특정팀 소속 선수목록 조회 (팀명으로)
	public void playerListInTeam() {
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
	public int menu() {
		System.out.println("\n[야구 팀/선수 등록/조회]");
		System.out.println("1. 팀 등록");
		System.out.println("2. 특정팀 조회(팀명으로)");
		System.out.println("3. 팀목록 조회");
		System.out.println("4. 선수 등록");
		System.out.println("5. 특정선수 조회(이름으로)");
		System.out.println("6. 특정선수 조회(등번호로)");
		System.out.println("7. 특정선수 조회(번호로)");
		System.out.println("8. 특정팀 선수목록 조회)");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택>> ");
		return Integer.parseInt(sc.nextLine());
	}
}





/*
SSG랜더스 인천 : 김광현(29),김강민(0)
키움히어로즈 서울 : 이정후(51), 이주형(38)
LG트윈스 서울 : 오지환(10),이정용(31)
KT위즈 수원 : 강백호(10), 박병호(52)
KIA타이거즈 광주 : 박찬호(1), 양현종(54)
NC다이노스 창원 : 박건우(37), 김주원(7)
삼성라이온즈 대구 : 구자욱(5),오승환(21)
롯데자이언츠 부산 : 이정훈(48),한동희(25)
두산베어스 서울 : 양의지(25),박재환(73)
한화이글스 대전 : 노시환(8),이진영(45)
 * */
