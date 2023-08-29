public class WrapperClassTest {
	public static void main(String[] args) {
		
		int num1 = 10;
		Integer num2 = num1; //왼쪽과 오른쪽은 같아야하고, 그게 아닌 경우는 업캐스팅하는 경우인데... 이것은 예외로, 박싱이다
		long lng = num1;     //이 경우와 같은 자동형변환(작->큰)의 일종으로 이해할것
		
		
		int m = 10;
		Integer n = m;  //박싱
		int r = n;		//언박싱
		long l = m;
		
		Object obj = 100; //박싱+업캐스팅
		
		Object[] oarr = new Object[100]; //이런 배열을 만든다면 모든 타입의 객체와 기본자료형까지 담을 수 있는 배열이 된다
	}

}
