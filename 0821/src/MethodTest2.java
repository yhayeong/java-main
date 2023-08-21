class Data {
	int x;
}


public class MethodTest2 {

	static void increment(int x) {
		x += 1; //메소드 안에서 선언된 지역변수 x는 호출될때 파라미터로 받은 값(10)으로 초기화된다.
		System.out.println("x : " + x);
	}
	
	static void increment2(Data d) {
		d.x += 1; //넘겨받은 참조변수를 통해 원본의 x를 증가시킴
		System.out.println("======d.x : " + d.x); //11
	}
	
	
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10;
		
		increment(data.x); //같은 클래스 내의 메소드 increment를 호출하면서 data.x에 담긴 값 10을 넘긴다
		//increment() 안의 출력문(메소드내의 지역변수 x출력) 실행되어 11
		
		System.out.println("data.x : " + data.x);
		//메소드 실행 후 돌아와서 출력한  data.x는 여전히 10이다.
		
		increment2(data); //increment2호출하며 주소를 넘긴것(원본)
		System.out.println("=================data.x : " + data.x); //11
		
	}
}
