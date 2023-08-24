package shape;

public class Circle extends Shape {
	
	//필드
//	Point center; //(1) 참조변수만 선언 후에
	int radius;
	
	//(2) 포함 객체 생성 후에
	Point center = new Point();	 
	
	
	//생성자
	public Circle() {} 					//(2')
//	public Circle() { 				   	//(1')
//		super("black");
//		center = new Point();
//	}
	
	public Circle(String color, int x, int y, int radius) {
		super(color);
//		this.center = new Point(x, y); //(1') 생성자 안에서 포함 객체 생성하며 초기화
		this.center.setX(x); 		   //(2') 이 생성자가 아니라 기본생성자가 생성해둔 객체의 필드값 초기화
		this.center.setY(y);
		this.radius = radius;
	}
	public Circle(String color, Point center, int radius) {
		super(color);
		this.center = center;
		this.radius = radius;
	}
	
	//getter, setter
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	//인스턴스메소드
	@Override
	public void draw() {
//		System.out.println(String.format("[원:색(%s), 중심점(%d,%d), 반지름(%d)]"
//										, this.getColor(), this.center.getX(), this.center.getY(), this.radius));
		System.out.println(String.format("[원:색(%s), 중심점(%s), 반지름(%d)]"
				, this.getColor(), this.center.info(), this.radius));
		
	}
	
	

}
