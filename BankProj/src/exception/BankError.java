package exception;

//Enum은 열거형이라고 불리며, 서로 연관된 상수들의 집합을 의미 
//기본형 상수값을 타입으로 만드는것(초기화 가능한 상수값들을 미리 정해두는것)
public enum BankError {
	NOID, EXISTID, LACK, MINUS, MENU
	
	//다른 클래스에서 선언할때 BankError be1; 이런식으로 함
	//public static final BankError NOID = new BankError();
	//public static final BankError EXISTED = new BankError();
	//이런것이 내부적으로 생략돼있는것...
}
