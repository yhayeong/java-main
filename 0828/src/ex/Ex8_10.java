package ex;

class Ex8_10 {
	
	public static void main(String[] args) {
		try {
			method1(); //예외 발생!!!
			System.out.println(6); //예외가 발생해서 실행되지 않는다.
		} catch (Exception e) {
			System.out.println(7);
		}
	}

	static void method1() throws Exception {
		try {
			method2();
			System.out.println(1);
		} catch (NullPointerException e) {
			System.out.println(2);
			throw e; //예외를 다시 발생시킨다. 예외 되던지기(re-throwing)
		} catch (Exception e) {
			System.out.println(3);
		} finally {
			System.out.println(4);
		}
		System.out.println(5);
	} // method1()

	
	static void method2() {
		throw new NullPointerException(); //NullPointerException을 발생시킨다.
	}
}


/*
 
1호출
2호출-NPE발생함 호출부로 돌아감
1출력안됨
catch문이 받아서 2출력되고 throw e로 1호출부로 가져가기 전에 finally수행
4출력하고 throw e 던짐
이 던진 에러를 예외처리하지 않으므로(try로 감싸서 처리하지 않음)
1호출부에 예외처리 위임됨
1실행중에 예외발생한것이므로 6출력안됨
catch문이 받음
7출력됨

정답: 출력
2
4
7
  
 * */
