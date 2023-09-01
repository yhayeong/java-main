import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

import acc.Account; //Bank와 다른 패키지에 있는 Account클래스 사용
import acc.SpecialAccount_Teacher;
import exception.BankError;
import exception.BankException;

public class Bank {
	/* 
	 <스트림 추가>
	 count를 맨앞에 저장한다
	 일반계좌일때 n 특수계좌일때 s를 구분자로 각 Account앞에 붙인다
	 
	 예를들어
	 10001  hong  만원 
	 10002  park  이만원  V
	 10003  song  삼만원  
	 라면
	 3 N10001hong10000 S10002park20000V N10003song30000 (가독성을 위해 띄어쓰기했을뿐)
		
	 또한
	 저장시점은 0번으로 정상종료될때 저장되도록할것
	 읽기시점은 사용자입장에서 프로그램시작되자마자 읽어서 TreeMap에 들어가는것이 적절하다
	 
	 read모드일때 파일이 없으면 예외발생하고 write모드면 예외발생하지않음
	 그러므로 read모드에서 파일이 없는 경우에 대한 예외처리가 필요
	 Bank에서 Read, Write하는것이 적절할것 (Account에서 하는것보다)
	*/
	
	
	
	Map<String, Account> accs = new TreeMap<>(); //Tree->정렬되면서 저장됨
	
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
		
		if(accs.containsKey(id)) throw new BankException("중복계좌", BankError.EXISTID);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		accs.put(id, new Account(id,name,money));
	}
	
	
	void makeSpecialAccount() throws BankException {
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		if(accs.containsKey(id)) throw new BankException("중복계좌", BankError.EXISTID);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP-V, Gold-G, Silver-S, Normal-N) : ");
		String grade = sc.nextLine().toUpperCase();
		
		accs.put(id, new SpecialAccount_Teacher(id,name,money,grade));
//		accs.put(id, new SpecialAccount(id,name,money,grade));
	}
	
	
//*** searchAccById메소드가 필요없으므로 삭제 (Map의 containsKey메소드를 사용하면 되므로)
	
	
	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		if(!accs.containsKey(id)) throw new BankException("계좌오류", BankError.NOID);
		
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account acc = accs.get(id);
		acc.deposit(money);
	}
	
	void withdraw() throws BankException {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		if(!accs.containsKey(id)) throw new BankException("계좌오류", BankError.NOID);
		
		System.out.print("출금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		
		//한줄로 축약
		accs.get(id).withdraw(money);
	}
	
	void accountInfo() throws BankException {
		System.out.print("계좌번호 : ");
		String id = sc.nextLine();
		
		if(!accs.containsKey(id)) throw new BankException("계좌오류", BankError.NOID);
		System.out.println(accs.get(id));
	}
	
	void allAccountInfo() {
		System.out.println("[전체 계좌 조회]");
		System.out.println("개설계좌수: " + accs.size());
		
		//HashMap, TreeMap에 저장된 것들은 인덱스가 없고, 벨류를 하나씩 읽기 위해서는 꼭 get(키)를 써야하므로 일반for문 사용불가
//		for (int i = 0; i < accs.size(); i++) {
//			Account acc = (Account) accs.values();
//			System.out.println(acc);
//		}
		
		for(Account acc : accs.values()) { //향상 for문
			System.out.println(acc);
		}
		
		//반복자(이터레이터) 이용하여 출력하기
//		Iterator<Account> iter = accs.values().iterator(); //accs.values()의 결과인 벨류가 Account 인스턴스 하나이므로
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
	}
	
	
	//<1. 파일에 데이터 저장하기>
	public void store_b() { // b:바이너리
		DataOutputStream dao = null;
		
		try {
			dao = new DataOutputStream(new FileOutputStream("accs.bin")); //스트림꽂기(이제 데이터 저장(쓰기) 가능)

			dao.writeInt(accs.size()); //count를 맨앞에 저장(쓰기)
			
			for (Account acc : accs.values()) {
				//일반계좌는n 특별계좌는s로 구분값 넣어서 저장
				if(acc instanceof SpecialAccount_Teacher) dao.writeChar('S');
				else dao.writeChar('N');
				
				dao.writeUTF(acc.getId());
				dao.writeUTF(acc.getName());
				dao.writeInt(acc.getBalance());
				if(acc instanceof SpecialAccount_Teacher) {
					SpecialAccount_Teacher sacc = (SpecialAccount_Teacher) acc;
					dao.writeUTF(sacc.getGrade().charAt(0)+"");
					
//					dao.writeUTF(((SpecialAccount_Teacher)acc).getGrade().charAt(0)+""); //특별계좌일때만 등급을 저장
					//특별계좌면 다운캐스팅해서 등급에 접근해서 넣는다 (특별계좌 아니라면 if문 안들어옴)
				}
			}//for문
			
		} catch (IOException e) {
			System.out.println("----파일 예외발생");
			e.printStackTrace();
		} finally {
			try {
				if(dao!=null) dao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//store_b메소드
	
	
	
	//<2. 파일 읽어오기> 
	public void load_b() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("accs.bin"));
			
			int count = dis.readInt(); //저장수
			for (int i = 0; i < count; i++) {
				char sect = dis.readChar(); //특별계좌인지일반계좌인지를 구분하는 구분자
				String id = dis.readUTF();
				String name = dis.readUTF();
				int balance = dis.readInt();

				if(sect=='S') {
					String grade = dis.readUTF();
					accs.put(id,  new SpecialAccount_Teacher(id,name,balance,grade));
				}
				else {
					accs.put(id,  new Account(id,name,balance));
				}
			}//for문
			
		} catch (IOException e) {
			System.out.println("-------accs.bin이 생성되어있지 않음");
			e.printStackTrace();
			
			/*
			 프로그램 시작시에에 읽을 대상인 accs.bin이 없는 경우에 발생하는 에러는 정상적
			 
			 read시에 에러났던 다른 이유:
			 write할때 writeInt로 한것을 read할때 readInt로 하지 않는것과 같은 실수 때문
			*/
			
		} finally {
			try {
				if(dis!=null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//load_b메소드
	
	
	//<3. BufferedWriter, BufferedReader이용하기> (t는 text의미)
	public void store_t() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("accs.txt"));

			//트리맵에 벨류들만 저장하기
			for (Account acc : accs.values()) {
				String accStr = acc.getId();
				accStr += ","+acc.getName();
				accStr += ","+acc.getBalance();
				if(acc instanceof SpecialAccount_Teacher) {
					accStr += ","+((SpecialAccount_Teacher) acc).getGrade().charAt(0)+"";
				}
				bw.write(accStr);
				bw.newLine();

				//cf. 이렇게 저장한 것을 읽을때는 split(",")했을때 배열사이즈가 3이면 일반계좌, 4이면 특별계좌임
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		}
	}//store_t메소드
	
	public void load_t() {
		BufferedReader br = null;
		try {
//			br = new BufferedReader(new FileReader("accs.txt"));
			br = new BufferedReader(new FileReader("c:\\test\\accs.txt"));

			String accStr = null;
			while((accStr=br.readLine())!=null) { //더 읽을게 없으면 null을 반환하므로 조건식은 '읽을것이 있는동안'을 뜻함
				
//				/* <4. StringTokenizer 사용하여 자르기>-----------------------------------
				StringTokenizer st = new StringTokenizer(accStr,",");
				String id = st.nextToken();
				String name = st.nextToken();
				int balance = Integer.parseInt(st.nextToken());
				if(st.countTokens()!=0) {
					String grade = st.nextToken();
					accs.put(id, new SpecialAccount_Teacher(id, name, balance, grade));
				} else {
					accs.put(id, new Account(id, name, balance));
				}
//				-----------------------------------------------------------------------*/
				
				/*
				String[] accProp = accStr.split(",");
				String id = accProp[0];
				String name = accProp[1];
				int balance = Integer.parseInt(accProp[2]);
				if(accProp.length==4) {
					String grade = accProp[3];
					accs.put(id, new SpecialAccount_Teacher(id,name,balance,grade));
				} else {
					accs.put(id, new Account(id,name,balance));
				}
				*/ 
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		}
		
	}//load_t메소드
	
	
	public static void main(String[] args) { 
	
		Bank bank = new Bank();
		
//		bank.load_b();
		//2-2. 파일 읽기 메소드 호출시점: 반복문 안에 있으면 안되고 프로그램 실행하자마자 딱 한번 호출돼야할것
		//파일쓰기메소드store는 프로그램을 나갈때 딱 한번만 저장하고, 파일읽기메소드load는 다른 메뉴로 갈때 파일을 다시 불러오면 안되는 점을 주의
		
		//3.
		bank.load_t();
		
		
		int sel;
		
		while(true) {
			try {
				sel = bank.menu();
				if(sel==0) {
					//1-2. 프로그램이 정상종료되는 시점에 파일에 데이터를 저장한다
//					bank.store_b();
					//3.
					bank.store_t();
					break;
				}
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
