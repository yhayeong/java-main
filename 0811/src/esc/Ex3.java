package esc;

public class Ex3 {

	public static void main(String[] args) {
		
		//[4-7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 
		//코드를 완성하라. (1)에 알맞은 코드를 넣으시오.
		int value = (int)  (Math.random() * 6)   + 1;
		System.out.println("value : " + value);
		
		
		
//		[4-8]  방정식 2x+4y=10의 모든 해를 구하시오. 단, x와 y는 정수이고 각각의 범위는 
//				0<=x<=10, 0<=y<=10 이다.
		
		for(int x=0; x<=10; x++) {
			
			for(int y=0; y<=10; y++) {
				
				if(2*x + 4*y == 10) System.out.println("x: " + x + ", y: " + y);
				
			}
		}
		
		
		/*
		 [4-9] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코 
드를 완성하라. 만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되 
어야 한다.
		 * */
		
		String str = "12345";
		int sum = 0;
		
		for(int i=0; i < str.length(); i++) { 
			
			//'1'은 1과 다르다
			int num = str.charAt(i) - '0'; //char -> int로 변환하기
//			int num = str.charAt(i) - 48;
//			int num = Character.getNumericValue(str.charAt(i)); 
			sum += num;
			
		}
		System.out.println("sum="+sum);
		
		
		
		//4-10
		int num = 12345;
		int sum2 = 0; 
		
		for(;;) {
			if(num == 0) break;
			sum2 += num % 10;
			num /= 10;
		}
		
		System.out.println("sum2="+sum2);
		
		
		
		
		//4-11 피보나치 수열
		// 첫 두 숫자를 1, 1로 한다. 1과 1부터 
//		시작하는 피보나치수열의 10번째 수는 무엇인지 계산
		
		int num1 = 1;
		int num2 = 1;
		int num3 = 0; // 세번째 값 
		System.out.print(num1+","+num2); 
		
		
		for (int i = 0 ; i < 8 ; i++ ) { //앞의 두 수를 만들어뒀으므로 8
			num3 = num1 + num2;
			System.out.print(","+num2); 

			num1 = num2;
			num2 = num3;
			
		}
		System.out.print(","+num3);
		
		//답 확인 필요
		
		
	
		
 
	}

}
