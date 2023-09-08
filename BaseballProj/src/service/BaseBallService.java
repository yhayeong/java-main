package service;

import java.util.Scanner;

public class BaseBallService {
	
	
	// 1. 팀 등록  
	public void regTeam() {
		System.out.println("[팀 등록]");
		System.out.print("팀명: ");
		String teamName = sc.nextLine();
		System.out.print("연고지: ");
		String local = sc.nextLine();
	}
	   
	// 2. 특정팀 조회 (팀명으로)
	   
	// 3. 팀목록 조회  
	   
	// 4. 선수 등록  
	public void regPlayer() {
		System.out.println("[선수 등록]");
		System.out.print("선수명: ");
		String playerName = sc.nextLine();
		System.out.print("등번호: ");
		Integer backNum = Integer.parseInt(sc.nextLine());
		
		// 팀 목록을 보여준 후 입력받는다 - 3번 메소드 호출
		System.out.println("<팀 선택>");
		
		// 1:SSG랜더스
		// 2:키움히어로즈
		// 3:LG트윈스
		// 4:KT위즈
		
		System.out.print("선택(번호)>> ");
		
		
		//.........
		
		
				
	}
	
	
	   
	// 5. 특정선수 조회 (이름으로) 리턴타입 List
       
	// 6. 특정선수 조회 (등번호로) 리턴타입 List cf. 팀이 다르면 중복된 등번호를 가질수있다
	
	// 7. 특정선수 조회 (번호로) 리턴타입 Player
	   
	// 8. 특정팀 소속 선수목록 조회 (팀명으로)
	
	
	
	
	Scanner sc = new Scanner(System.in);
	public int menu() {
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
	
	
	
	

}
