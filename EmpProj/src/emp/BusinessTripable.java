package emp;

public interface BusinessTripable {
	
	//자식들이 각각 오버라이딩할 메소드로, 출장인센티브를 원래 급여에 반영시켜주는 기능
	void payIncentive(int tripDays);
	//리턴타입 없이 내부적으로 필드와 setter에 접근하는 void메소드

}
