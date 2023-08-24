package Ex7;

//과제 Ex7_22~23

abstract class Shape {
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}//Shape

class Point {
	int x;
	int y;

	Point() { 
		this(0,0);
	}

	Point(int x, int y) { 
		this.x=x;
		this.y=y;
	}
	
	public String toString() { 
		return "("+x+","+y+")";
	}
}//point



//문제: Shape클래스를 조상으로하는 Circle클래스와 Rectangle클래스를 작성하시오.   
//생성자도 각 클래스에 맞게 적절히 추가해야한다.

class Circle extends Shape {
	//필드
	double r;
	
	//생성자
	public Circle() {
		//부모의 기본생성자가 자동호출된다
//		super();
		this.r = 10;
	}
	public Circle(Point p) {
		super(p); //부모의 매개변수가 있는 생성자를 이용하여 초기화
		this.r = 10;
	}
	public Circle(Point p, double r) {
		super(p);
		this.r = r;
	}


	//메소드
	@Override
	double calcArea() { //도형의 면적 계산해서 반환하는 조상의 메소드를 오버라이딩해야함
		
		//원의 면적: pi * r^2
		//Math.pow(대상숫자,지수) : 입출력 모두 double인 스태틱 메소드
		
		//반올림하여 소수점 둘째자리까지 보여주기
		double area = Math.PI * Math.pow(this.r,2);
		//(1) 100.0을 곱해서 반올림한뒤 다시 100.0으로 나누기
//		double areaAfterRound = Math.round(area * 100.0) / 100.0;
		
		//(2)String.format을 활용한 방법
		double areaAfterRound = Double.parseDouble(String.format("%.2f", area));
		
		return areaAfterRound;
		
	}
	
	
	public String info() {
		return "Circle [반지름:" + r + ", 중심점:" + this.p.toString() + ", 넓이:" + this.calcArea() +"]";
	}
	
	



	
}//Circle

class Rectangle extends Shape {
	//필드
	double width; 
	double height;
//	Point pos; //(1)시작점 변수 선언(새로 선언하지 않고 부모에게 상속받은 p를 사용해도 된다)
	
	//생성자
	public Rectangle() {
//		super();
		this.width = 10;
		this.height = 10;
	}
	public Rectangle(Point p) {
		//(1)
//		this();
//		pos = p;
		
		//(2)
//		super(p);
//		this(); //컴파일 에러: Constructor call must be the first statement in a constructor
		
		//(3)
		super(p);
		this.width = 20;
		this.height = 20; //아니면 필드에서 먼저 명시적초기화한다
	}
	public Rectangle(Point p, double width, double height) {
		//(1)
//		pos = p;
//		this.width = width;
//		this.height = height;
		
		//(2)
		super(p);
		this.width = width;
		this.height = height;
	}
	
	//메소드
	@Override
	double calcArea() {
		double area = this.width * this.height;
		
		//소수점 둘째자리까지 반올림하여 반환한다 (둘째자리까지->100.0 셋째자리까지->1000.0)
		//(1) 100.0을 곱해서 반올림한뒤 다시 100.0으로 나누기
		double areaAfterRound = Math.round(area*100.0) / 100.0; //곱하고 나눠줄때 100, 1000과 같은 int로 곱하지 않도록 주의
		
		//(2)String.format을 활용한 방법
//		double areaAfterRound = Double.parseDouble(String.format("%.2f", area));
		return areaAfterRound;
		
	}
	
	@Override
	public String toString() {
//		return "Rectangle [시작점:" + this.pos + ", 너비:" + width + ", 높이:" + height + ", 넓이:" + this.calcArea() + "]";
		return "Rectangle [시작점:" + this.p + ", 너비:" + width + ", 높이:" + height + ", 넓이:" + this.calcArea() +"]";
	}
}//Rectangle





public class Ex7_22_23 {

	public static void main(String[] args) {
		
		Shape s1 = new Circle(); //반지름 10.0, 포인트0,0인 원을 생성하고 Shape타입에 넣는다 (업캐스팅)
		if(s1 instanceof Circle) {
			Circle c1 = (Circle) s1;
			System.out.println(c1.info());
		}
		
		Shape s2 = new Circle(new Point(5,5)); //반지름 10.0, 포인트5,5인 원을 생성하고 Shape타입에 넣는다
		if(s2 instanceof Circle) {
			System.out.println(((Circle)s2).info());
		}
		
		Circle c3 = new Circle(new Point(6,10), 4); //자동으로 4->4.0 int->double로 형변환되며 생성된다
		System.out.println(c3.info());
		
		Rectangle rec1 = new Rectangle(); //시작점0,0 너비10, 높이10인 원을 생성한다
		System.out.println(rec1.toString()); //toString()을 오버라이딩하기 전에는 주소값 반환하므로 오버라이딩하여 사용
		
		Rectangle rec2 = new Rectangle(new Point(8, 3)); //시작점8,8 너비10, 높이10인 직사각형을 생성한다
		System.out.println(rec2.toString());
		
		Rectangle rec3 = new Rectangle(new Point(-7,0), 5.62, 30.2); //시작점-7,0 너비5.62, 높이30.2인 
		System.out.println(rec3.toString());
		
		
		//넓이만 출력한다
		System.out.println("s1의 넓이:" + s1.calcArea()); //calcArea()는 모든 자식들이 오버라이딩했으므로 (유효성체크+)다운캐스팅 필요 없음 
		System.out.println("rec3의 넓이:" + rec3.calcArea());
		//(유효성체크+)다운캐스팅은 자식에만 있는 멤버를 부모 타입의 참조변수로 사용해야할때 필요한 일
		
		
		//Shape의 getPosition, setPosition 메소드를 활용하기
		System.out.println("s2의 중심점: " + s2.getPosition()); 
		System.out.println("rec3의 시작점: " + rec3.getPosition());
		//(오버라이딩하지 않은)부모에게 상속받은 메소드를 사용하는데, 메소드가 반환하는 Point는 자식의 멤버->다형성
		
	}
}
