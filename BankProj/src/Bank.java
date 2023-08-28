import java.util.Scanner;

import acc.Account; //Bank와 다른 패키지에 있는 Account클래스 사용
import acc.SpecialAccount_Teacher;
import exception.BankError;
import exception.BankException;

public class Bank {
	
	Account[] accs = new Account[100];
	int accCnt; //개설된계좌개수
	
	Scanner sc = new Scanner(System.in);
	
	int menu() throws NumberFormatException { //RuntimeException(과 그 자식)의 경우에는 위임하겠다는 trows~를 생략할 수 있다 				
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.print("선택> ");
//		return Integer.parseInt(sc.nextLine()); //일단 nextLine으로 입력받아서 그 문자열을 정수로 변환
		//엔터만 눌렀을 경우 ""은 null을 가지고있고, 그 null을 Integer로 파싱(해석)할 수 없기 때문에 NumberFormatException발생한다.
		
		
/*		<1>예외 발생한 메소드에서 예외처리
		int sel = 0;
		try {
			sel = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			//###다시 호출하는 처리를 하고자한다. 그럴때 이 메소드에서보다 호출부인 main에 위임하는 것이 더 유리하다 (모든 parseInt하는 메소드마다 다 하는 것은 번거로움)
			System.out.println("####숫자를 입력하세요.");
			menu();
		}
		return sel;
 
 */
		
		
		//<2>try-catch로 감싸지 않고 메소드선언부에 throws~하면 호출부로 예외를 위임하는것
//		return Integer.parseInt(sc.nextLine());
		
		
		
		//<3>====================BankError예외클래스 추가하여 작성
		
		//<3-1> 여기서 예외처리
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>=0 && sel<=5)) {
			try {
				throw new BankException("메뉴오류", BankError.MENU); //예외 발생할 경우에 예외를 발생시키는것(메시지와 약속된 에러코드를 인자로 주면서)
			
			} catch (BankException e) {
				System.out.println(e); //e.toString으로 자동호출됨 (BankException클래스의 toString이 호출됨)
				menu();
			}
		}
		return sel;
		
		
		//<3-2> 호출부로 예외 위임시키기
//		int sel = Integer.parseInt(sc.nextLine());
//		if(!(sel>=0 && sel<=5)) throw new BankException("메뉴오류", BankError.MENU);
//		return sel;
			
		
	}//menu()메소드
	
	
	void selAccMenu() {
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특수계좌");
		System.out.print("선택> ");
		int sel = Integer.parseInt(sc.nextLine());
//		if(sel==1) makeAccount();
//		else if(sel==2) makeSpecialAccount();
		
		//<3> BankException만들고 예외처리
		switch (sel) {
		case 1: makeAccount(); break;
		case 2: makeSpecialAccount(); break;
		default: 
			try {
				throw new BankException("메뉴오류", BankError.MENU); 
			} catch (BankException e) {
				System.out.println(e);
				selAccMenu();
			}
		}
	}//selAccMenu()
	
	
	void makeAccount() {
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		//중복체크 코드 추가---------------------------------
		Account searchedAcc = searchAccById(id);
//		if(searchedAcc!=null) {
//			System.out.println("계좌번호가 중복됩니다.");
//			return;
//		}
		try {
			if(searchedAcc!=null) throw new BankException("중복계좌", BankError.EXISTID);
		} catch (Exception e) {
			System.out.println(e);
			makeAccount();
		}
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		accs[accCnt++] = new Account(id, name, money);
	}
	
	
	void makeSpecialAccount() {
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		Account searchedAcc = searchAccById(id);
		try {
			if(searchedAcc!=null) throw new BankException("중복계좌", BankError.EXISTID);
		} catch (Exception e) {
			System.out.println(e);
			makeAccount();
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP-V, Gold-G, Silver-S, Normal-N) : ");
		String grade = sc.nextLine().toUpperCase();
		
//		accs[accCnt++] = new SpecialAccount(id, name, money, grade);
		accs[accCnt++] = new SpecialAccount_Teacher(id, name, money, grade);
	}
	
	
	Account searchAccById(String id) {
		for (int i = 0; i < accCnt; i++) {
			if(accs[i].getId().equals(id)) {
				return accs[i]; //찾았다면 그걸 가지고 호출부로 간다(바로메소드종료)
			}
		}
		return null; 
	}
	
	void deposit() {
		System.out.println("[입금]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id); //입력한 id가 없다면 null값을 반환받을것
//		if(acc ==null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
		//<3>
		try {
			if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		} catch (BankException e) {
			System.out.println(e);
			deposit();
		}
		
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		acc.deposit(money);
		
	}
	
	void withdraw() {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id);
//		if(acc == null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
		//<3>
		try {
			if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		} catch (BankException e) {
			System.out.println(e);
			withdraw();
		}
		
		System.out.print("출금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		if(acc.getBalance() < money) {
			System.out.println("잔액:" + acc.getBalance() + ", 입력금액: " + money + "\n*잔액이 부족합니다.");
			return;
		} else {
			acc.withdraw(money);
		}
		
	}
	
	void accountInfo() {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
//		if(acc==null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
		//<3>
		try {
			if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		} catch (BankException e) {
			System.out.println(e);
			accountInfo();
		}
		System.out.println(acc.info());
	}
	
	void allAccountInfo() {
		System.out.println("개설계좌수: " + accCnt);
		
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accs[i].info());
		}
	}
	
	
	
	public static void main(String[] args) { 
	
		Bank bank = new Bank();
		int sel;
		
		while(true) {
			//<2> 예외발생하는메소드를 호출하는 곳(여기선 main)에서 예외처리
			try {
				sel = bank.menu(); //Integer.parseInt()를 여기서도 
				if(sel==0) break;
				switch(sel) {
				case 1: bank.selAccMenu(); break; //여기서도... 아래서도 다 호출하므로 예외발생 가능성이 있다-모두 try에 넣는다
				case 2: bank.deposit(); break;		//예외처리를 해당 메소드에서 하는게 아니라 호출부에서 하는 것의 장점: 한번에 처리 가능
				case 3: bank.withdraw(); break;
				case 4: bank.accountInfo(); break;
				case 5: bank.allAccountInfo(); break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("입력형식이 맞지 않습니다. 다시 선택하세요 ");
			}
				
		}//while
		
		
	}//main

}//Bank
