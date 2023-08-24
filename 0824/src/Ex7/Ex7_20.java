package Ex7;

class Parent {
	int x = 100;

	void method() {
		System.out.println("Parent   Method");
	}
}

class Child extends Parent {
	int x = 200;

	void method() {
		System.out.println("Child   Method");
	}
}

public class Ex7_20 {
	public static void main(String[] args) {
		Parent p = new Child(); //업캐스팅
		Child c = new Child();
		
		System.out.println("p.x   =   " + p.x); //100
		//변수는 타입에 의존한다
		//변수는 오버라이딩에 해당하지 않는다
		//자식에도 x가 있지만 부모타입p를 통해 접근한 x는 부모의 멤버x이다
		
		p.method(); //자식에서 오버라이딩한 메소드 호출됨
		System.out.println("c.x   =   " + c.x); //자식의 멤버x
		
		c.method(); //자식에서 오버라이딩한 메소드
	}
}


/* 
해설:
메서드의 경우 조상 클래스의 메서드를 자손의 클래스에서 오버라이딩한 경우에도 참조변 
수의 타입에 관계없이 항상 실제 인스턴스의 메서드(오버라이딩된 메서드)가 호출되지만, 
멤버변수의 경우 참조변수의 타입에 따라 달라진다.
 */