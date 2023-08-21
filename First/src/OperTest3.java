
public class OperTest3 {
	
	public static void main(String[] args) {
		
		System.out.println(10 / 4); //2.5가 아닌 2가  출력됨 (10도 4도 정수이므로 결과도 정수가 된다)
		
		System.out.println(10 / 4.0); //2.5
		
		System.out.println((float)10 / 4); //2.5
		
		//double과 int의 연산처럼 피연산자 둘 중 큰 double로 바뀐다
		//다만 int보다 작은건 int로 바뀌므로
		//short타입과 short타입의 연산은 int로 바뀌어서 연산된다 
		
		
		int kor = 99, eng = 88, math = 100;
		int total = kor + eng + math;
		double avg = total / 3; //정수끼리의 연산이므로 결과도 정수가 되고 만다.
		System.out.println(avg); //95.0라는 잘못된 값 출력
		
		double avg2 = total / 3.0; //정수와 실수의 연산이므로 실수와 실수의 연산이 되어 결과도 실수가 된다.
		System.out.println(avg2); //95.66666666666667
		
		
		int mod = 10 % 4;
		System.out.println(mod); //2
		
		
		byte a = 10;
		byte b = 20;
//		int c = a + b; //바이트와 바이트의 연산은 인트와 인트의 연산이 되므로 결과도 인트로 받아야한다.
		byte c = (byte)(a+b); //바이트에 담기 위해서 강제형변환을 이용할 수 있음
		
		
		
		int i1 = 1000000;
		int i2 = 2000000;
		long res = i1 * i2; //인트와 인트의 연산이라서 인트로 결과가 만들어지는데 오버플로우가 일어나서 마이너스가 되고만다
		long res2 = i1 * (long)i2; //long과 long의 연산이 된다
		System.out.println(res);	//-1454759936
		System.out.println(res2);	//2000000000000
		
		
//		long i3 = 100000 * 100000; //이 역시 오버플로우가 일어난다
		long i3 = 100000 * 100000L;
		System.out.println(i3); //10000000000
		
		
		
		int i4 = 100000 * 100000 / 100000; //100000 * 100000 연산결과 이미 오버플로우 일어남
		System.out.println(i4); 			//14100
		
		int i5 = 100000 / 100000 * 100000; //오버플로우 일어나지 않음
		System.out.println(i5); 			//100000
		
	}

}
