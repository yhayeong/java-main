import java.util.Arrays;

public class ClassTest5 {

	public static void main(String[] args) {
//		Account acc1 = new Account();
//		acc1.id = "10001";
//		acc1.name = "고길동";
//		acc1.balance = 100000;
//		
//		System.out.println(acc1.info());
//		
//		acc1.deposit(10000); //예금하기
//		System.out.println(acc1.info());
//		
//		acc1.withdraw(20000); //인출하기
//		System.out.println(acc1.info());
		
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
	
}



class Account {
	
	String id;
	String name;
	int balance;
	
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
}



class Bank {
	
	Account[] accs = new Account[100];
	int accCnt; //개설계좌개수
	
	void makeAccount(String id, String name, int money) {
		
		//전달인자로 계좌 생성
		Account acc = new Account();
		acc.id = id;
		acc.name = name;
		acc.balance = money;
		
		//생성된객체의 주소를 배열에 넣는다 
		accs[accCnt] = acc; //cf. 배열의길이는 인덱스 역할도 한다
		//개설계좌수 증가
		accCnt++;
		
//		accs[accCnt++] = acc; //0번째에 넣고서 accCnt는 1이 되는것
		
		System.out.println("<신규 개설계좌 정보>" + acc.info());
	}
	
	
	void allAccountInfo() {
		System.out.println("개설계좌수: " + accCnt);
		
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accs[i].info());
		}
	}
	
	
	//특정 계좌 조회
	void accountInfo(String id) {
		
		//해당계좌번호가 있는 경우 정보 출력
		for (int i = 0; i < accCnt; i++) {
			if(accs[i].id.equals(id)) {
				System.out.println(accs[i].info()); 
				return;
			} else { //해당계좌번호가 없는 경우 안내문 출력
				System.out.println("조회 불가:해당계좌가 존재하지 않습니다."); 
				return; 
			}
		}
	}
	

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
	
	//패키지 오류
	//노트북에서 수정후 커밋앤 푸시
	
	//로컬 newbranch1에서 커밋
	//깃허브 계정 변경 후 커밋
	
	
}

