import java.sql.Connection;
import java.util.List;

public class AccontService {
	/*
	 MVC패턴에서 
	 
	 메인 - 서비스 - DAO 
	 
	 *** 서비스와 DAO를 나눈 것 : 
	 서비스에는 비즈니스로직에 따라 '입금', '출금' 등으로 메소드를 만들고 (입금 출금은 각각 select-update 둘다 수행함)
	 DAO에는 실제DB에 대해 질의하는 메소드를 만든다
	 
	 */
	
	
	public void accountInfo(String id) {
		
		Connection conn = Dao.getConnection(); 

		Account acc = Dao.selectAccount(conn, "10001"); //연결객체를 가지고 Dao의 스태틱메소드로 가야 실행객체를 생성한다

		if(acc==null) System.out.println("없는 계좌입니다.");
		else System.out.println(acc);

		Dao.close(conn); 
	}//accountInfo
	
	
	
	public void allAccountInfo() {
		Connection conn = Dao.getConnection(); 
		
		List<Account> accs = Dao.selectAccountList(conn);
		
		System.out.println("=======계좌 목록=======");
		for(Account acc : accs) {
			System.out.println(acc);
		}
		
		Dao.close(conn);
	}//allAccountInfo
	
	
	
	public void makeAccount(Account acc) {
		
		Connection conn = Dao.getConnection(); 
		
		Account resultAcc = Dao.selectAccount(conn, acc.getId()); // select하는 메소드를 먼저 호출

		if(resultAcc!=null) System.out.println("중복 계좌입니다.");
		else {
			int cnt = Dao.insertAccount(conn, acc); // insert하는 메소드 호출
			if(cnt>0) System.out.println(cnt + "개의 계좌가 개설되었습니다.");
		}
				
		Dao.close(conn);
	}//makeAccount
	
	
	
	
	
	public void deposit(String id, Integer money) {
		
		Connection conn = Dao.getConnection(); 
		
		Account acc = Dao.selectAccount(conn, id); // 계좌 조회
		
		if(acc==null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		
		acc.deposit(money); // 찾아온 'Account타입 객체'의 입금메소드를 통해 balance가 바뀐다
		int cnt = Dao.updateAccount(conn, acc); 
		// 갱신된 balance를 가진 Account객체를 인자로 전달 
		// *** 이렇게 할때의 장점 : 하나의 updateAccount메소드로 입금과 출금을 모두 처리할 수 있음
		
		if(cnt>0) {
			System.out.println("----입금 성공----");
			System.out.println(String.format("%s 계좌의 잔액 : %d원", acc.getId(), acc.getBalance()));
		}
		
		Dao.close(conn);
	}//deposit
	
	
	
	public void withdraw(String id, Integer money) {
		
		Connection conn = Dao.getConnection(); 
		
		Account acc = Dao.selectAccount(conn, id); // 계좌 조회
		
		if(acc==null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		
		if(acc.getBalance()<money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		acc.withdraw(money); // Account객체를 대상으로 출금한뒤
		int cnt = Dao.updateAccount(conn, acc); // 출금된 Account객체를 DAO-DB질의쪽으로 전달
		
		if(cnt>0) {
			System.out.println("----출금 성공----");
			System.out.println(String.format("%s 계좌의 잔액 : %d원", acc.getId(), acc.getBalance()));
		}
		
		Dao.close(conn);
	}//withdraw
	
	
	
	
}
