
public class ShapeSet { //Company와 유사한 클래스
	
	//필드
	private Shape[] shapes = new Shape[100];
	private int count;
	
	//인스턴스메소드
	public void add(Shape s) {
		shapes[count++] = s;
	}
	
	
	public void allShapeDraw() {
		for (int i = 0; i < count; i++) {
			shapes[i].allShapeDraw();
		}
	}
	

}
