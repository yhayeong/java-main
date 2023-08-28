package ex;

class UnsupportedFunctionException extends RuntimeException {
	//필드
	private final int ERR_CODE;
	
	//생성자
	public UnsupportedFunctionException(String msg, int errCode) {
		super(msg);
		this.ERR_CODE = errCode;
	}
	public UnsupportedFunctionException(String msg) {
		super(msg);
		ERR_CODE = 100;
//		this(msg, 100); //한줄로 축약
	}
	
	
	//메소드
	public int getErrorCode() {
		return ERR_CODE;
	}
	@Override
	public String getMessage() {
		return "[" + ERR_CODE + "]"+ super.getMessage();
	}
}

public class Ex8_9 {
	
	public static void main(String[] args) {
		
		
		//(1) RuntimeException상속받게 예외를 만들었으므로 컴파일에러 나지 않고 실행시에 런타임예외 발생
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100);
		
		//(2) 이 예외클래스를 만들때 Exception을 상속받도록하여 만들면 컴파일에러 발생함-반드시 try-catch로 감싸야 실행시켜볼수있음
//		try {
//			throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100); //여기에 맞는 생성자가 예외클래스에 있어야함
//		} catch (UnsupportedFunctionException e) {
//			System.out.println(e.getMessage()); //[100]지원하지 않는 기능입니다. (비정상종료를 막는 예외처리 완료)
//
//		}
	}

}


//사용자 선언 예외 클래스를 만들때
//컴파일시 걸려서 필수로 예외처리해야 적절한 경우엔 Exception상속받게하고
//아니라면 RuntimeException상속받게한다
