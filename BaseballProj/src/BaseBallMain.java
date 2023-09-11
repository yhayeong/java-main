import service.BaseBallService;

public class BaseBallMain {
	// 메인
	public static void main(String[] args) {
		
		BaseBallService baseballService = new BaseBallService();
		
		int sel = BaseBallService.menu();
		while(true) {
			switch (sel) {
			case 1: baseballService.regTeam(); break;
			case 2: baseballService.teamInfo(); break;
			case 3: baseballService.AllTeamInfo(); break;
			case 4: baseballService.regPlayer(); break;
			case 5: baseballService.playerInfoByName(); break;
			case 6: baseballService.playerInfoByBackNum(); break;
			case 7: baseballService.playerInfoByNum(); break;
			case 8: baseballService.playerListByTeamName(); break;
			case 9: System.out.println("프로그램 종료"); return;
			default: System.out.println("메뉴를 잘못 선택하셨습니다.");
			}
		}
	}
}
