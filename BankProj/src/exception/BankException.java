package exception;

public class BankException extends Exception {
	
	//필드
	BankError errCode; //이 타입의 변수에는 BankError에 정의된 것들만 들어갈 수 있다
	
	//생성자
	public BankException(String message, BankError errCode) {
		super(message);
		this.errCode = errCode;
	}

	
	//메소드
	@Override
	public String toString() {
		
//		String msg = ""; //errCode에 따라서 정의해둔 문구를 이용하여 (에러)메시지를 만들어서 반환
		String msg = "[[[" +  super.getMessage() + "]]] ";
		
		switch(errCode) {
		case NOID : msg += "계좌번호 오류입니다."; break;
		case EXISTID : msg += "계좌번호가 중복됩니다."; break;
		case LACK : msg += "잔액이 부족합니다."; break;
		case MINUS : msg += "금액입력 오류입니다."; break;
		case MENU : msg += "잘못 선택하셨습니다."; break;
		default : msg += "일반 오류입니다."; break;
		}
		
		return msg;
	}
	
	
	

}
