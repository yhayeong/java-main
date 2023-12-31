import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import acc.Account; //Bank와 다른 패키지에 있는 Account클래스 사용
import acc.SpecialAccount;
import acc.SpecialAccount_Teacher;
import exception.BankError;
import exception.BankException;

public class Bank {
	
	List<Account> accs = new ArrayList<>();
	
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
		
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>=0 && sel<=5)) throw new BankException("메뉴오류", BankError.MENU);
		return sel;
		
	}//menu()메소드
	
	
	void selAccMenu() throws BankException { //호출부로 위임처리
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특수계좌");
		System.out.print("선택> ");
		int sel = Integer.parseInt(sc.nextLine());

		switch (sel) {
		case 1: makeAccount(); break;
		case 2: makeSpecialAccount(); break; 
		default: throw new BankException("메뉴오류", BankError.MENU);  
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
		accs.add(new Account(id,name,money));
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
		
		accs.add(new SpecialAccount_Teacher(id,name,money,grade));
//		accs.add(new SpecialAccount(id,name,money,grade));
	}
	
	
	Account searchAccById(String id) throws BankException {
		for (int i = 0; i < accs.size(); i++) {
			if(accs.get(i).getId().equals(id)) return accs.get(i);
		}
//		for (Account acc : accs) { //향상 for문
//			if(acc.getId().equals(id)) return acc;
//		}
		return null; 
	}
	
	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id); 
		if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		acc.deposit(money);
		
	}
	
	void withdraw() throws BankException {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id);
		if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		System.out.print("출금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		acc.withdraw(money);
	}
	
	void accountInfo() throws BankException {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if(acc==null) throw new BankException("계좌오류", BankError.NOID);
		System.out.println(acc);
	}
	
	void allAccountInfo() {
		System.out.println("[전체 계좌 조회]");
		System.out.println("개설계좌수: " + accs.size());
		
//		for (int i = 0; i < accs.size(); i++) {
//			System.out.println(accs.get(i));
//		}
//		for(Account acc : accs) { //향상 for문
//			System.out.println(acc);
//		}
		
		//반복자(이터레이터) 이용하여 출력하기
		Iterator<Account> iter = accs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//결론: 간단히 조회출력할때는 향상for문, 반복문 안에서 삭제 등을 수행하는 경우에는 이터레이터를 사용하는것이 좋다
	}
	
	
	
	public static void main(String[] args) { 
	
		Bank bank = new Bank();
		int sel;
		
		while(true) {
			try {
				sel = bank.menu();
				if(sel==0) break;
				switch(sel) {
				case 1: bank.selAccMenu(); break; 
				case 2: bank.deposit(); break;		
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
