public class ExceptionTest4 {

//	public static void method1() {
//		String str = null;
//		try {
//			System.out.println(str.toString());
//		} catch(NullPointerException e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public static void main(String[] args) {
//		method1();
//		System.out.println("main의 나머지 처리...");
//		//main입장에선 정상처리로 간주하고 나머지 처리를 하는것
//	}
	
	
	public static void method1() throws Exception { //(3-2)
		String str = null;

		//(2)
		System.out.println(str.toString());

		
		//(3-1) 이렇게하기도함
		try {
			System.out.println(str.toString());
		} catch(NullPointerException e) {
			System.out.println("method1에서 1차 예외처리");
			throw e;
			//(3-2) 새로운 예외를 넘길 수도 있다
//			throw new Exception("예외 새로 생성해서 넘겨줄 수도 있음");
		}
	}
	
	public static void main(String[] args) {
		//(2)예외를 항상 발생한 메드에서 처리할 필요 없이 호출한쪽에서 처리할 수 있다!
		//호출한 곳으로 예외처리를 위임 -> 장점: 모든 메소드를 다 예외처리하는것은 비효율적이다
		try {
			method1();
//		} catch(NullPointerException e) { //(2)
		} catch(Exception e) { //(3-2)
			System.out.println(e.getMessage());
		}
		System.out.println("main의 나머지 처리...");
		
		
		
		
	}//main
	
}
