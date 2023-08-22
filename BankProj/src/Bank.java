import java.util.Scanner;

public class Bank {
	
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
		return sc.nextInt();
	}
	
	
	void makeAccount() {
		
	}
	
	void deposit() {
		
	}
	
	void withdraw() {
		
	}
	
	void accountInfo() {
		
	}
	
	void allAccountInfo() {
		
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
