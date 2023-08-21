
public class ContinueTest1 {
	public static void main(String[] args) {
//		continue를 만나면 이후의 문장은 스킵하고 다음 회차로(증감식으로) 이동
		
		int sum = 0;
		
		for(int i=1; i<=10; i++) {
//			if(i%2==0) sum += i; //i가 짝수이면 더한다... 아래와 같이 쓸수도 있다
			
			if(i%2!=0) continue;
			sum += i;
			
		}
		System.out.println(sum);
		System.out.println(2+4+6+8+10);
		
		
		
		//특정수의 배수이면 스킵
		for(int i=1; i<=10; i++) {

			if(i%4==0 || i%7==0) continue;
			sum += i;
		}
		System.out.println(sum);
		
		
		
		for(int dan=2; dan<=9; dan++) {
			
			for(int su=1; su<=9; su++) {
				
				if(su>5) break;
				
				System.out.println(dan + " * " + su + " = " + (dan * su));
			}
			System.out.println(); //한줄띄움
		}
		//결과 : 구구단 9까지 5곱하기까지만 나온다
		
	}
	
	
	
}
