class Shape {
	String color;
	void draw() {
		System.out.println("Shape의 draw()");
	}
}

class Circle extends Shape {
	int x;
	int y;
	int r;
	@Override
	void draw() {
		System.out.println("Shape의 draw()를 오버라이딩한 Circle의 draw()");
	}
	
}



public class PolinoTest1 {
	
	public static void main(String[] args) {
		Circle c = new Circle(); //기존
		c.color = "red";
		c.x = 10;
		c.draw();
		
		System.out.println("=============================================================");
		
		Shape s = new Circle(); //upcasting 자식객체를 생성하면서 그 주소를 부모타입 참조변수에 넣는거
		s.color = "blue";
//		s.x = 20;
		s.draw();
		//부모타입의 참조변수를 통해서 메소드 호출시 오버라이딩한 자식의 메소드가 호출된다
		//이것이 다형성
		
		//다형성의 조건 : 상속, 업캐스팅, 오버라이딩
	}
}
