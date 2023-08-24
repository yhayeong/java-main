package shape;

public class Rectangle extends Shape {
	
	//필드
	private Point startPos;
	private int width;
	private int height;
	
	//생성자
//	public Rectangle() {}
	public Rectangle() {
		super("black");
		startPos = new Point();
	}
	public Rectangle(String color, int spX, int spY, int width, int height) {
		super(color);
		this.startPos = new Point(spX, spY);
		this.width = width;
		this.height = height;
	}
	public Rectangle(String color, Point startPos, int width, int height) {
		super(color);
		this.startPos = startPos;
		this.width = width;
		this.height = height;
	}
	
	//getter, setter
	public Point getStartPos() {
		return startPos;
	}
	public void setStartPos(Point startPos) {
		this.startPos = startPos;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	//인스턴스메소드
	@Override
	public void draw() {
//		System.out.println(String.format("[사각형:색(%s), 시작점(%d,%d), 너비(%d), 높이(%d)]"
//				, this.getColor(), this.startPos.getX(), this.startPos.getY(), this.width, this.height));
		System.out.println(String.format("[사각형:색(%s), 시작점(%s), 너비(%d), 높이(%d)]"
				, this.getColor(), this.startPos.info(), this.getWidth(), this.getHeight()));
	}
	
	
}
