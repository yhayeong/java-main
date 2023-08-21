class MyMath {
	static int add(int x, int y) {
		int result = x + y; //지역변수는 메소드 호출될때 stack영역에 생성된다.
		return result;
	}
	static int multi(int x, int y) {
		int result = x * y;
		return result;
	}
	
}
public class MethodTest1 {

	public static void main(String[] args) {
//		MyMath mm = new MyMath(); //static메소드는 객체 생성 없이 사용가능
//		int res = mm.add(10, 20);
		int res = MyMath.add(10, 20);
		System.out.println(res);
		res = MyMath.multi(10,40);
		System.out.println(res);
	}

}
