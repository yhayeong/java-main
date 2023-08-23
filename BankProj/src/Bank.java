import java.util.Scanner;

import acc.Account; //Bank와 다른 패키지에 있는 Account클래스 사용

public class Bank {
	
	Account[] accs = new Account[100];
	int accCnt; //개설된계좌개수
	
	Scanner sc = new Scanner(System.in);
	
	int menu() {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.print("선택> ");
		return Integer.parseInt(sc.nextLine()); //일단 nextLine으로 입력받아서 그 문자열을 정수로 변환
	}
	
	
	void makeAccount() {
		System.out.println("[계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		accs[accCnt++] = new Account(id, name, money);
	}
	
	Account searchAccById(String id) {
		for (int i = 0; i < accCnt; i++) {
//			if(accs[i].id.equals(id)) {
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
		if(acc ==null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		acc.deposit(money);
	}
	
	void withdraw() {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		Account acc = searchAccById(id);
		if(acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
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
		if(acc==null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
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
		//같은 클래스내의 메소드를 호출하는데도 객체 생성하는 이유
		//스태틱메소드 안에서는 같은 스태틱메소드가 아니라면 레퍼런스를 통해서 인스턴스메소드를 호출해야한다
		
		Bank bank = new Bank();
		int sel;
		
		while(true) {
			sel = bank.menu();
			if(sel==0) break;
			switch(sel) {
				case 1: bank.makeAccount(); break;
				case 2: bank.deposit(); break;
				case 3: bank.withdraw(); break;
				case 4: bank.accountInfo(); break;
				case 5: bank.allAccountInfo(); break;
			}
				
		}
		
		
	}

}
