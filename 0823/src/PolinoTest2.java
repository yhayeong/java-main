class AA {
	int a;
	void methodA() {} 
	void method() {} //1
	
	void info() {
		System.out.println(getPay());
	}
	int getPay() {
		return 0;
	}
}

class BB extends AA {
	int b;
	void methodB() {}
	void method() {} //2
	
	@Override
	int getPay() {
		return 100;
	}
}


public class PolinoTest2 {

	public static void main(String[] args) {
		AA obj = new BB();
		obj.methodA();
//		obj.methodB(); //호출불가 : 타입이 부모이기 때문에 부모클래스에 없는 자식클래스의 메소드 호출 불가
		
		obj.method(); //1이 아니라 2가 호출된다 -> 다형성!
		obj.a = 10;
		
//		obj.b = 20; //부모클래스에 없는 자식클래스의 변수에 접근 불가
		
		obj.info(); //상속받은 info()에서 호출하는 getPay()는 자식의 오버라이딩한 메소드이다 -> 다형성!
		
	}
}


//자식객체를 부모 변수에 넣을 경우, 부모에는 없는 자식의 변수나 메소드는 사용 불가
//단, 오버라이딩했을 경우 부모 변수로 자식의 메소드(오버라이딩한)를 호출할 수 있다
