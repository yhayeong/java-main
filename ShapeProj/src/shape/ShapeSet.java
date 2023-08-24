package shape;

public class ShapeSet { //Company와 유사한 클래스
	
	//필드
	private Shape[] shapes = new Shape[100];
	private int count;
	
	//인스턴스메소드
	public void add(Shape s) { //Circle, Triangle, Rectangle타입을 모두 받아 저장하기 위해 Shape타입을 매개변수로 지정
		shapes[count++] = s;
	}
	
	
	public void allShapeDraw() {
		for (int i = 0; i < count; i++) {
			shapes[i].draw(); //Shape타입의 참조변수를 통해 접근한 draw()는 자식클래스에서 각각 오버라이딩한 메소드이다(다형성)
		}
	}
	

}
