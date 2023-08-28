public class ExceptionTest3 {
	public static void main(String[] args) {
		
		try {
			throw new Exception("예외 발생!"); //예외를 생성해서 발생시킨다
			
		} catch (Exception e) {
			e.printStackTrace();				//java.lang.Exception: 예외 발생!
			System.out.println(e.getMessage()); //예외 발생!
		}
		
		System.out.println("======================================");
		
		/*
		 예외클래스를 만들어서 상속하여 예외코드 발생시 예외 던져주고 처리하는 식으로 예외처리하는 것의 장점(<-> if문으로 처리) : 
		 수정사항이 발생했을 경우 유지보수가 쉽다 
		 
		 cf. 메소드 선언부 끝에 붙이는 throws : 호출한 곳에 예외를 위임한다
		 * */
		
		
	}//main

}
