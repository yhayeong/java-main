class MyNumber {
	
	int num; //클래스내 변수는 클래스내 메소드들이 공유한다. 
	void func1(int n) {
		int number = n;
		num = number;
	}
	void func2(int n) {
		int number = n;
		num = number;
	}
}


class MyMath2 {
	int x, y;
	int add() { //클래스내 변수를 클래스내 메소드들이 공유한다.
		return x+y;
	}
	int multi() {
		return x*y;
	}
}

public class VariableTest2 {

	public static void main(String[] args) {
		
		MyNumber mn = new MyNumber();
		System.out.println(mn.num); //초기값 0
		mn.func1(10); //10
		System.out.println(mn.num); //10
		mn.func2(20);
		System.out.println(mn.num); //20
		
		
		MyMath2 mm = new MyMath2();
		mm.x = 10;
		mm.y = 20;
		System.out.println(mm.add());
		System.out.println(mm.multi());
	}


}
