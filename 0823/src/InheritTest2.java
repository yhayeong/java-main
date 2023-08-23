class Base {
	int bnum;
	
	void methodA() {System.out.println("------1");}
	void methodB() {System.out.println("------2");}
}


class Derived extends Base {
	int dnum;
	void methodB() {System.out.println("------3");}
	void methodC() {
		System.out.println("------4");
		methodA(); //상속된 부모의메소드 호출 가능
	}
}

public class InheritTest2 {
	public static void main(String[] args) {
		Base b = new Base();
		b.bnum = 10;
		b.methodA();
		b.methodB();
		
		System.out.println("***");
		
		Derived d = new Derived();
		d.bnum=20;
		d.dnum=30;
		d.methodA(); //1
		d.methodB(); //3 오버라이딩한 자기자신의메소드 (부모꺼x)
		d.methodC(); //4
	}
}


//오버라이딩 : 
//(1) 상속을 전제로 함 (리턴타입, 메소드명, 매개변수로 이루어진 선언부가 같아야함)
//(2) 부모의메소드가 protect라면 자식은 protected, public만 가능 (접근제한자 자식을 더 좁게 할수 없음)
//(2) 부모의메소드보다 많은 예외를 선언할 수 없음