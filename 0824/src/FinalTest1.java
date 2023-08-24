class TempClass {
	
	
	//필드
//	final int x = 10; 
	//인스턴스변수이면서 상수인 경우에는 이렇게 명시적 초기화하는것보다 생성자에서 초기화하는것이 더 적절
	
	final int x; 
	//인스턴스변수에 final을 붙여 선언하는 것의 의미는 인스턴스마다 서로 다른 값을 가지면서 상수화(변경금지)시키겠다는 것으로
	//변경불가한 하나의 변수를 생성하여 공용하겠다는 final스태틱변수와 다른 의미를 가진다
	//final int x; ---> 생성된 각각의 객체들이 각자의 변경되지 않는 x값(서로 다른)을 가지고있겠다는 뜻
	//따라서 final 인스턴스 변수는 명시적 초기화보다 생성자에서 (매개변수로 받은 값을 가지고) 초기화하는것이 더 적절하다
	
	static final int sx = 100;
	//모든 객체들이 공유하는 스태틱변수이면서 변경 불가한 static final 변수는 명시적 초기화하는것이 옳다
	
	
	//생성자
	TempClass() {
		this(0); //cf.자기자신의 매개변수가 있는 생성자를 호출
	}
	
	TempClass(int x) {
		this.x=x;
//		sx=x; //final스태틱변수는 생성자에서 초기화할 수 없다
	}
	
	
//	void method(int x) {
//		this.x=x;
//	}
	//final인스턴스변수라서 변경불가하므로 이 메소드는 컴파일에러
	
	
	
	//정리:
	//final인스턴스변수와 final스태틱변수는 그 용도가 다르다
	//인스턴스들마다 다른 값으로 초기화시키겠지만 변경불가하도록 만들겠다-> 파이널 인스턴스 변수
	//인스턴스들끼리 공유하는데 변경불가하도록 만들겠다 -> 파이널 스태틱 변수
	
	
	
	
/* Ex7_14 참고

class SutdaCard {

	final int NUM;
	final boolean IS_KWANG; 
	
	SutdaCard() {
		this(1, true); 
	}
	SutdaCard(int num, boolean isKwang) { 
		this.NUM = num;
		this.IS_KWANG = isKwang; 
	}  
	
	..생략..
}

여기서의 NUM, IS_KWANG이 인스턴스마다 각각 다른 값을 가지면서 변경 금지하는 경우에 해당한다
그렇게 하기 위해 final 인스턴스 변수(상수)로 선언해두고 생성자를 통해서 초기화한다
*/
	
	
	
	
}


public class FinalTest1 {

	public static void main(String[] args) {
		
		final int n;
		n = 10; 				//(명시적 초기화부터)처음하는 초기화로 인식해준다
//		n = 20; 				//값 변경 불가
		System.out.println(n);
		
	}
}




/*
 final을 클래스에 붙이면 상속금지
 final을 메소드에 붙이면 오버라이딩 금지
 final을 변수에 붙이면 변경 금지 
 */