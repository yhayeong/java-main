package shape;

public abstract class Shape {
	
	//필드
	private String color;
	
	//생성자
	public Shape() {}
	public Shape(String color) {
		this.color = color;
	}
	
	//getter, setter
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//추상메소드
	public abstract void draw();
	
}
