import service.BaseBallService;

public class BaseBallMain {
	// 메인
	public static void main(String[] args) {
		BaseBallService service = new BaseBallService();
		
		while(true) {
			int sel = service.menu();
			if(sel==0) {
				System.out.println("프로그램 종료");
				break;
			}
			switch (sel) {
			case 1: service.regTeam(); break;
			case 2: service.teamInfo(); break;
			case 3: service.AllTeamInfo(); break;
			case 4: service.regPlayer(); break;
			case 5: service.playerInfoByName(); break;
			case 6: service.playerInfoByBackNum(); break;
			case 7: service.playerInfoByNum(); break;
			case 8: service.playerListInTeam(); break;
			default: System.out.println("메뉴를 잘못 선택하셨습니다.");
			}
		}
	}//main
}
