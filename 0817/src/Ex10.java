
public class Ex10 {

	public static void main(String[] args) {

		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[',
				']', '{', '}', ';', ':', ',', '.', '/' };
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		
		String src = "abc123";
		String result = "";
		
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		
		for (int i = 0; i < src.length(); i++) {
			
			char ch = src.charAt(i);
			/*
			 * (1) 알맞은 코드를 넣어 완성하시오.
			 */
			
			
			//포인트 : 알파벳도 숫자이면서 연속적이란것을 상기!
			
			//'a' -> abcCode[0] 즉 'a'를 통해서 인덱스넘버 0을 만들어내야함 -> abcCode['a'-'a'] 
			//'1' -> numCode[1] 즉 '1'를 통해서 인덱스넘버1을 만들어내야함 -> '숫자'-'0'=숫자
			
			
			
			
			if('a' <= ch && ch <= 'z') { 
				result += abcCode[ch-'a'];
				
			} else if('0' <= ch && ch <= '9') {
				result += numCode[ch-'0'];
				
			}
			
			
			
		}
		
		
		System.out.println("src:" + src);
		System.out.println("result:" + result);
		
		
		
		
		//10_1 다시 바꾸기 -> 과제
		
		String src2 = "";
		
		for (int i = 0; i < result.length(); i++) {
			
			char ch2 = result.charAt(i);
			
			System.out.println("i=" + i + " " + ch2);
			
		
			for (int j = 0; j < numCode.length; j++) {
				
				if(ch2 == abcCode[i]) {
					src2 += (char)(i+'a');
//					System.out.println("src2: " + src2);
				}
//			else if(ch2 == numCode[i]) {
				else {
					System.out.println("----------");
					src2 += i;
//					System.out.println("src2: " + src2);
				}
			}
			



			
			//result의 추출문자가 알파벳 소문자이면 -> 추출문자가 numCode의 몇번째 인덱스와 일치하는지 확인한다
			
		}
		
		System.out.println("src2 : " + src2);
		
		
	}

}
