import java.util.Scanner;

import acc.Account; //Bank와 다른 패키지에 있는 Account클래스 사용
import acc.SpecialAccount;
import acc.SpecialAccount_Teacher;

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
		
		//try-catch로 감싸지 않고 메소드선언부에 throws~하면 호출부로 예외를 위임하는것
		return Integer.parseInt(sc.nextLine());
	}
	
	
	
	
	/*
	 문제 : 특수계좌 SpecialAccount를 추가하여라  
	1. Account 에 grade(등급)을 추가함. 등급의 종류는 VIP, Gold, Silver, Normal
​
	2. 등급에 따라 차등으로 입금할때마다 이자를 준다. 단, 계좌개설시점의 입금은 제외
	등급에 따라 입금액의 몇퍼 지급 : VIP는 0.04, Gold 0.03, Silver 0.02, Normal 0.01	
	예를들어 VIP가 10000원 입금시 10000+10000*0.04가 입금된다 => 입금액 * 1.04
​
	3. 정보출력시 등급도 포함
	계좌번호:1001, 이름:홍길동, 잔액:100000, 등급:VIP
	 */
	
	void selAccMenu() {
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특수계좌");
		System.out.print("선택> ");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel==1) makeAccount();
		else if(sel==2) makeSpecialAccount();
	}
	
	
	void makeAccount() {
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		//중복체크 코드 추가---------------------------------
		Account searchedAcc = searchAccById(id);
		if(searchedAcc!=null) {
			System.out.println("계좌번호가 중복됩니다.");
			return;
		}
		//------------------------------------------------
		
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
//			if(accs[i].id.equals(id)) {	//Account의 id가 public이 아닌데 패키지가 다르므로 접근불가
			if(accs[i].getId().equals(id)) {
				return accs[i]; //찾았다면 그걸 가지고 호출부로 간다(바로메소드종료)
			}
		}
		return null; 
	}
	
	
	/*  
	다형성의 장점을 확인:
	<<<상속,업캐스팅(SpecialAccount를 생성하여 Account[] 배열에 담음),오버라이딩>>>을 통해서 
	Account타입 참조변수 acc로 호출하는 deposit(int money)은 자식에서 오버라이딩한 메소드이다 - 다운캐스팅 필요없이 알아서 자식의 오버라이딩메소드를 호출함
	즉 SpecialAccount같은 클래스를 추가하게 될때, 기존에 작성한 메소드 호출코드를 일일이 코드를 변경하지 않아도 된다!
	*/
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
