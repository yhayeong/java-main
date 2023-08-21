class TClass1 {
	void method1() {
		System.out.println("method1 실행----------------");
		int num1;
		method2(); //같은 클래스내의 메소드들끼리는 서로 호출 가능
		System.out.println("method1 종료----------------");
	}
	void method2() {
		System.out.println("method2 실행--------");
		int num2;
		method3();
		System.out.println("method2 종료--------");
	}
	void method3() {
		System.out.println("method3 실행---");
		int num3;
		System.out.println("method3 종료---");
	}
}
public class ClassTest4 {

	public static void main(String[] args) {

		TClass1 tc = new TClass1();
		tc.method1();
	}

}
