class MyClass {
	
	int num; 			//인스턴스변수 - new하면서생성되므로
	static int snum;   //클래스변수 - 소속이클래스이므로
	
	void setNum(int n) { //매개변수
 		
	}
}


public class VariableTest1 {

	public static void main(String[] args) {

		int n; 						//지역변수
		MyClass mc = new MyClass(); //이렇게 new로 객체 생성되는 시점에 MyClass의 멤버인 num이라는 인스턴스변수가 메모리에 생성된다. (그전에는 정의된것에 불과)
		
//		System.out.println(n); //iv는 초기화하지 않고 사용시 에러
		System.out.println(mc.num); //new로 객체생성될때 초기값으로 초기화되므로 사용가능
		
		
	}

}
