package esc;

public class Ex5 {

	public static void main(String[] args) {
		
	
		
		
		//4-15

		int number = 98789; 
		int tmp = number;
		int result =0; // 변수 number를 거꾸로 변환해서 담을 변수
	

		while(tmp !=0) { 
	
			int su = tmp % 10; //나머지연산자를 통해서 오른쪽부터 잘라낸 수
			result = result * 10 + su; //result의 자릿수를 한자리씩 올리면서 su를 더해준다
			tmp /= 10; //몫을 바꿔주지 않으면 계속 12321을 가지고 연산하는것이므로 몫도 바꿔줄것
			
			System.out.println("result : " + result);
		}
		
		if(number == result)
			System.out.println( number + "는 회문수 입니다."); 
		else
			System.out.println( number + "는 회문수가 아닙니다.");
		
		
		
		
		System.out.println("--------다른방법");
		
		int sq = 4;
		while(tmp != 0) {
		
			result += tmp%10 * (int)(Math.pow(10, sq));
			tmp /= 10;
			sq--;
		
		}
		
		if(number == result)
			System.out.println( number + "는 회문수 입니다."); 
		else
			System.out.println( number + "는 회문수가 아닙니다.");
		
		
//	//문자열 거꾸로 뒤집기 테스트
//		String str = "문자열";
//		StringBuffer sb = new StringBuffer(str);
//
//		String reverseStr = sb.reverse().toString();
//		System.out.println(reverseStr);
		
		
		
		//git test 
		
	}

}
