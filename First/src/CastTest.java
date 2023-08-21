
public class CastTest {
	
	public static void main(String[] args) {
		
		byte bt = 10;
//		int i = (int) bt;
		int i = bt; 		 //자동형변환
		
//		byte bt2 = i; 		 //자동형변환 불가
		byte bt2 = (byte)i; // 강제형변환(큰->작은 캐스팅)
		
		float f = i; 			//같은 4바이트라도 실제 데이터 크기는 float가 더 크기때문에 자동형변환됨
		
		double d = 3.14;
		int i2 = (int)d; 		//소수점 잘림
		System.out.println(i2); //3
		
		
		
		//long(8)과 float(4)의 경우만 주의
		long lg = 8;
		float ft = lg; //long -> float 자동형변환됨
		
	}

}
