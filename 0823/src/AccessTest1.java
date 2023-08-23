class Number {
	//1) default 멤버
	int dnum; 
	void dmethod() {
		System.out.println(pnum);
	} 
	
	//2) private 멤버
	private int pnum; 
	private void pmethod() {
		System.out.println(pnum);
	}
	//private 변수는 같은 클래스내의 메소드에서만 사용한다
	
	//3) public 멤버
	public int pubNum;
	public void pubMethod() {}
	public int getDnum() {
		return dnum;
	}
	
	
	//getter
	public int getPnum() {
		return pnum;
	}
	
	//setter
	public void setPnum(int data) {
		pnum = data; 
	}
	
	
}

public class AccessTest1 {
	
	public static void main(String[] args) {
		
		Number n1 = new Number();
		n1.dnum = 10; //같은 패키지에 있는 클래스객체의 default 멤버에 접근 가능
		n1.dmethod(); 
		
//		n1.pnum = 100; //다른 클래스의 private 멤버에 접근 불가
//		n1.pmethod();
		n1.getPnum();
		n1.setPnum(100);
		
		n1.pubNum = 200; //다른 클래스의 public 멤버는 어디서든 접근 가능
		n1.pubMethod();
		
	}
}



//private, public은 클래스보다는 메소드와 변수 레벨에서 의미가 있다
//public 변수는 권장되지 않고 변수는 privat/default로 만든 뒤 getter, setter를 통해 접근되도록 하는 것이 권장된다