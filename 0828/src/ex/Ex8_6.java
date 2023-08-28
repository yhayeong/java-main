package ex;

public class Ex8_6 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println(5);
		}
	}

	static void method1() {
		try {
			method2();
			System.out.println(1);
		} catch (ArithmeticException e) {
			System.out.println(2);
		} finally {
			System.out.println(3);
		}
		System.out.println(4);
	} // method1()

	static void method2() {
		throw new NullPointerException();
	}
}


//실행결과 3 5가 찍힌다
//4가 찍히지 않는다 (예외처리가 안됐으므로 호출부로 예외처리가 넘겨짐)