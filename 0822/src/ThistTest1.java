class Account {
	//인스턴스변수
	String id;
	String name;
	int balance;
	
	Account() {}
	Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		//this에는 new로 인해 생성된 객체의 주소(p1이나 p2 등등)가 자동으로 삽입된다.
	}
	
	String info() { //인스턴스메소드가 인스턴스변수를 공유하여 가져다 사용하는것에 해당
		return "계좌번호:"+this.id+",이름:"+this.name+",잔액:"+this.balance;
		//this를 안붙여도 되는 경우임. 동명의 지역변수를 선언하지 않았으므로 인스턴스변수라는것을 명확히 지정하지 않아도 됨
	}
}


public class ThistTest1 {
	public static void main(String[] args) {
		Account acc1 = new Account("10001", "홍길동", 100000);
	}

}
