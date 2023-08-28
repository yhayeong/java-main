import java.util.Scanner;

import acc.Account; //Bank와 다른 패키지에 있는 Account클래스 사용
import acc.SpecialAccount_Teacher;
import exception.BankError;
import exception.BankException;

public class Bank {
	
	Account[] accs = new Account[100];
	int accCnt; //개설된계좌개수
	
	Scanner sc = new Scanner(System.in);
	
	int menu() throws BankException {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.print("선택> ");
		
		//<3> BankError예외클래스 추가하여 작성
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>=0 && sel<=5)) throw new BankException("메뉴오류", BankError.MENU);  //예외 발생할 경우에 예외를 발생시키는것 (발생예외를 여기서 처리하지 않았다는것은 호출부로 위임하는것이다)
		return sel;
		
	}//menu()메소드
	
	
	void selAccMenu() throws BankException { //호출부로 위임처리
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특수계좌");
		System.out.print("선택> ");
		int sel = Integer.parseInt(sc.nextLine());

		//<3> BankException만들고 예외처리
		switch (sel) {
		case 1: makeAccount(); break;
		case 2: makeSpecialAccount(); break; 
		default: throw new BankException("메뉴오류", BankError.MENU);  //예외발생시키고 처리하지않았다->호출부로 위임하는것
		}
	}//selAccMenu()
	
	
	void makeAccount() throws BankException {
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account searchedAcc = searchAccById(id);
		if(searchedAcc!=null) throw new BankException("중복계좌", BankError.EXISTID);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		accs[accCnt++] = new Account(id, name, money);
	}
	
	
	void makeSpecialAccount() throws BankException {
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		Account searchedAcc = searchAccById(id);
		if(searchedAcc!=null) throw new BankException("중복계좌", BankError.EXISTID);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP-V, Gold-G, Silver-S, Normal-N) : ");
		String grade = sc.nextLine().toUpperCase();
		
//		accs[accCnt++] = new SpecialAccount(id, name, money, grade);
		accs[accCnt++] = new SpecialAccount_Teacher(id, name, money, grade);
	}
	
	
	Account searchAccById(String id) throws BankException {
		for (int i = 0; i < accCnt; i++) {
			if(accs[i].getId().equals(id)) {
				return accs[i]; //찾았다면 그걸 가지고 호출부로 간다(바로메소드종료)
			}
		}
//		return null; 
		throw new BankException("계좌오류", BankError.NOID);
	}
	
	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id); //입력한 id가 없다면 null값을 반환받을것
		if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		if(money<0) throw new BankException("금액오류", BankError.MINUS);
		acc.deposit(money);
		
	}
	
	void withdraw() throws BankException {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id);
		//<3>
		if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		System.out.print("출금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		if(acc.getBalance() < money) {
			throw new BankException("잔액부족", BankError.LACK);
		} else if(money<0) {
			throw new BankException("금액오류", BankError.MINUS);
		}
		acc.withdraw(money);
	}
	
	void accountInfo() throws BankException {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if(acc==null) throw new BankException("계좌오류", BankError.NOID);
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
			} catch (BankException e) {
				System.out.println(e);
			}
				
		}//while
		
		
	}//main

}//Bank
