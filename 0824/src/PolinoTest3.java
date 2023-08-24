class Base {
	void method() {
		System.out.println("Base 메소드 호출됨...");
	}
}

class Derived extends Base {
	int y;
	void method() { 				//오버라이딩
		System.out.println("Derived 메소드 호출됨...");
	}
}

public class PolinoTest3 {
	
	public static void main(String[] args) {
		Base base = new Derived(); //업캐스팅
		base.method(); 			   //Derived 메소드 호출됨... -> 다형성
		
		/*
		굳이 자식객체를 생성하여 부모타입의 참조변수를 통해 접근하려는 이유는
		보통 객체를 하나가 아니라 여럿 생성하여 관리하기 때문에
		배열에 저장해서 사용하기 위해서임
		
		상속관계를 잘 만들면 
		변경사항이 생겼을때 수정할 양이 적어서 유지보수가 쉬워진다
		
		디자인패턴 
		클래스는 다중상속이 안되지만 인터페이스는 가능하다
		*/
		
		
//		base1.y = 20; 					//base1이 부모인 Base타입 참조변수기 때문에 자식인 Derived클래스의 멤버에 접근불가
		
		Derived derived = (Derived) base; //다운캐스팅
		derived.y = 20;
		
		
		//한편 다운캐스팅은 컴파일러가 문제여부를 보장해주지 않기 때문에 개발자가 (다운캐스팅시 문제 없는게 맞을지) 체크한 뒤에 다운캐스팅해야함
		//(정리:다운캐스팅 전에 타당성 체크를 해주어야함)
		if(derived instanceof Derived) {
			//Base base = new Derived();의 경우 base는 조건식의 결과 true
			//Base base = new Base();의 경우 base는 조건식의 결과가 false (이 케이스에서 타당성체크 없이 base.y=30; 실행시 에러 발생하지만 컴파일단계에서 알수 없다-타당성체크가 필요한 이유)
			
			//이렇게 체크 후에 다운캐스팅 하도록 한다
			derived = (Derived) base;
			
			//다운캐스팅해서 자식클래스의 멤버에 접근해서 사용
			derived.y = 30;
		}
		
	}
}
