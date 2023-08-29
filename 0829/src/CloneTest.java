class Point implements Cloneable { //이걸 상속해야만 내부적으로 CloneNotSu~ 발생안하도록 하는 인터페이스임
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return this.x + ", " + this.y;
	}
	
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
//(2)클론에 붙은 예외
	//자식은 부모의 예외의 일부만 가지거나 그대로 가지거나 
	//자식의 오버라이딩 메소드에서 thorws하지않고 내부적으로 처리해줄숟잇다
	// 클로너블이라는 인ㄴ터ㅔㅍ이스를 상속한 애만 클론이 가능함
	//
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {}
		return obj;
	}
	
	
	//<3> 다른 방법으로, 부모의 것을 오버라이딩하는것이 아니라 나만의 clone메소드를 새로 만들면서 그 안에서 내부적으로 부ㅡ모의 clone을 호출하고 반환타입을 Point로 해주면
	//main에서 다운캐스팅할 필요가 없을것ㅇ...
	
	
	//이렇게 java.lang패키지의 Object클래스의 메소드로 이콜 해쉬 ㅅ투스트링 클론 네가지 봄
//그다음 Stringㅋ를ㄹ새스
	
	
}


public class CloneTest {
	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		Object obj = p.clone();
		//(1) 부모의 메소드가 protected이기 때문에 오버라이딩하지 않고는 클래스외부에서 갖다 쓸 수 없다Object는 java.lang패키지에 있으므로...
		//다만 Point는 Object의 자식이다. Protected는 패키ㅈ;가 달라도 자식이면 사용가능
		//오버라이딩면서 public으로 하기
		
		
		Point cp = (Point)obj;
		System.out.println(p);
		System.out.println(cp);
		System.out.println(p.hashCode());
		System.out.println(cp.hashCode());
		
		
	}

}
