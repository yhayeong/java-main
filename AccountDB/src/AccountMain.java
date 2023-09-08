public class AccountMain {
	
	public static void main(String[] args) {
		
		AccontService service = new AccontService();
		
		
		// 계좌 조회하기
//		service.accountInfo("10001");
		
		// 계좌 개설하기
//		Account acc = new Account("10003", "공길동", 200000, "Silver");
//		service.makeAccount(acc); //Account객체를 만들어서 인자로 전달한다
		
		// 입금하기
//		service.deposit("10003", 50000);
		
		// 출금하기
//		service.withdraw("10002", 20000);
	
		// 전체 계좌 조회
		service.allAccountInfo();
		
	}//main
}
