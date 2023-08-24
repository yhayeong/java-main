package shape;

public class Triangle extends Shape {
	
	//필드
	//(1)
	private Point p1;
	private Point p2;
	private Point p3;
	//(2)
//	private Point p1 = new Point();
//	private Point p2 = new Point();
//	private Point p3 = new Point();
	
	//생성자
//	public Triangle() {}
	public Triangle() {
		super("black");
		this.p1 = new Point();
		this.p2 = new Point();
		this.p3 = new Point();
	}
	public Triangle(String color, Point p1, Point p2, Point p3) {
		super(color);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public Triangle(String color, int x1, int y1, int x2, int y2, int x3, int y3) {
		super(color);
		//(1')
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x3, y3);
		//(2')
//		this.p1.setX(x1);
//		this.p1.setY(y1);
//		this.p2.setX(x2);
//		this.p2.setY(y2);
//		this.p3.setX(x3);
//		this.p3.setY(y3);
	}
	
	//getter, setter
	public Point getP1() {
		return p1;
	}
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	public Point getP3() {
		return p3;
	}
	public void setP3(Point p3) {
		this.p3 = p3;
	}

	//인스턴스메소드
	@Override
	public void draw() {
//		System.out.println(String.format("[삼각형:색(%s), 점1(%d,%d), 점2(%d,%d), 점3(%d,%d)]"
//			, this.getColor(), this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY()));
		System.out.println(String.format("[삼각형:색(%s), 점1(%s), 점2(%s), 점3(%s)]"
				, this.getColor(), this.p1.info(), this.p2.info(), this.p3.info()));
	}
	
	
	
}
