
public class ClassTest5 {

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.makeAccount("10001", "고길둉", 100000);
		bank.makeAccount("10002", "김길둉", 200000);
		
		System.out.println("-------------");
		bank.allAccountInfo();
		
		System.out.println("\n\n==============과제");
		bank.accountInfo("10001"); //해당 계좌번호를 가진 계좌의 정보를 출력하는 메소드
		
		System.out.println("-------------해당계좌에 입금 후 계좌조회");
		bank.deposit("10001", 10000); 
		bank.accountInfo("10001");
		
		System.out.println("-------------해당계좌에 출금 후 계좌조회");
		bank.withdraw("10001", 5000);
		bank.accountInfo("10001");
		
	}
	
}//ClassTest5



class Account {
	
	String id;
	String name;
	int balance;
	
	Account() {}
	Account(String id, String name, int money) {
		this.id = id;
		this.name = name;
		this.balance = money;
	}
	
	String info() {
		return String.format("계좌번호:%s, 이름:%s, 잔액:%d", id, name, balance);
	}
	
	//1. 예금 메소드
//	int deposit(int money) {
//		System.out.println("*" + money + "원을 입금하셨습니다.");
//		return balance += money;
//	}
	void deposit(int money) {
		System.out.println("*" + money + "원을 입금하셨습니다.");
		balance += money;
	}
	//balance만 바꿔주고 꼭 return할 필요 없음 (호출부를 보면 받아서 사용하기위한 변수가 없이 호출만 하고있음)
	
	
	//2. 인출 메소드
	void withdraw(int money) {
		
		if(balance>=money) {
			System.out.println("*" + money + "원을 출금하셨습니다.");
			balance -= money;
		}
	}
	
}//Account




class Bank {
	
	Account[] accs = new Account[100];
	int accCnt; //개설된계좌개수
	
	
	void makeAccount(String id, String name, int money) {
		Account acc = new Account(id, name, money);
		
		accs[accCnt] = acc; //생성된객체의 주소를 배열에 넣는다 cf. 배열의길이는 인덱스 역할도 한다
		accCnt++; //개설계좌수 증가
//		accs[accCnt++] = acc; //0번째에 넣고서 accCnt는 1이 되는것
		
		System.out.println("<신규 개설계좌 정보>" + acc.info());
	}
	
	
	void allAccountInfo() {
		System.out.println("개설계좌수: " + accCnt);
		
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accs[i].info());
		}
	}
	
	
	//특정 계좌 조회-직접풀이
	void accountInfo(String id) {
		
		//해당계좌번호가 있는 경우 정보 출력
		for (int i = 0; i < accCnt; i++) { //주의:accs.length로 하면 안된다(배열의 나머지칸들은 null로 채워져있음)
			if(accs[i].id.equals(id)) {
				System.out.println(accs[i].info()); 
				return;
			} else { //해당계좌번호가 없는 경우 안내문 출력
				System.out.println("조회 불가:해당계좌가 존재하지 않습니다."); 
				return; 
			}
		}
	}
	
	//특정 계좌 조회-선생님코드(1)
//	void accountInfo2(String id) {
//		Account acc = null;
//		for (int i = 0; i < accCnt; i++) {
//			if(accs[i].id.equals(id)) {
//				acc = accs[i]; //찾으면 acc에 그 계좌를 담는다
//				break;
//			}
//		}
//		if(acc==null) { //못찾음==여전히 null 이라면
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
//		System.out.println(acc.info()); //찾았다면 if에 안걸리고 이후 문장인 이 명령어가 수행됨
//	}
	
	
	//선생님(2)-계좌를 검색하는 공통코드를 메소드로 분리하여 사용---------------
	Account searchAccById(String id) {
		for (int i = 0; i < accCnt; i++) {
			if(accs[i].id.equals(id)) {
				return accs[i]; //찾았다면 그걸 가지고 호출부로 간다(바로메소드종료)
			}
		}
		return null;
	}
	
	void accountInfo3(String id) {
		Account acc = searchAccById(id);
		if(acc == null ) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		System.out.println(acc.info());
	}
	
	void deposit2(String id, int money) {
		Account acc = searchAccById(id);
		if(acc == null ) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		acc.deposit(money);
	}
	void withdraw2(String id, int money) {
		Account acc = searchAccById(id);
		if(acc == null ) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		acc.withdraw(money);
	}
	//---------------------------------------------------------------
	

	void deposit(String id, int money) {
		
		for (int i = 0; i < accCnt; i++) {
			if(accs[i].id.equals(id)) {
				accs[i].deposit(money);
				return;
			} else { 
				System.out.println("입금불가:해당계좌가 존재하지 않습니다."); 
				return;
			}
		}
		
		System.out.println(money + "원 입금완료!");
	}
	
	void withdraw(String id, int money) {
		
		for (int i = 0; i < accCnt; i++) {
			if(accs[i].id.equals(id)) {
				accs[i].withdraw(money);
				return;
			} else { 
				System.out.println("출금불가:해당계좌가 존재하지 않습니다."); 
				return;
			}
		}
		
		System.out.println(money + "원 출금완료!");
	}
	
	
	
	
	

	
	
}//Bank

//클론 후 수정하여 push

