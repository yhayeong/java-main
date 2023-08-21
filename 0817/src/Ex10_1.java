import java.util.Arrays;
import java.util.Iterator;

public class Ex10_1 {

	public static void main(String[] args) { // result -> src 복호화하기

		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[',
				']', '{', '}', ';', ':', ',', '.', '/' };

		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String result = "`~!wer";
		String src = "";

		for (int i = 0; i < result.length(); i++) { //result의 문자 하나하나씩

			char ch = result.charAt(i);
			System.out.println(i + "번째 추출한 문자 " + ch);

//			if ('a' <= ch && ch <= 'z') {
//
//				for (int j = 0; j < numCode.length; j++) { //numCode 안의 요소들과 비교(numCode의 길이만큼)
//
//					if (ch == numCode[j])
//						src += j;
//				}
//
//			} else {
//
//				for (int k = 0;k < abcCode.length; k++) {
//
//					if (ch == abcCode[k])
//						src += (char)(k + 'a');
//				}
//			}
			
			
//			선생님 풀이--------------------------------------------------
			
			int index = -1; 
			//왜 반복문 안에서 -1로 초기화하냐면 못찾았을 경우에도 j=0회차는 무조건 실행되었으므로, index=j가 되므로 0인덱스요소로 복호화하게된다...따라서 -1로 초기화해줘야한다.
			if(ch>='a' && ch <= 'z') {
				
				
				for(int j=0; j < numCode.length; j++) {
					if(ch == numCode[j]) {
						index = j;
						break;
					}
				}
				
				if(index!=-1) src += (char)('0' + index); // char + int는 int가 되므로 char로 변형시켜야함
				
				
			} else {
				
				
				for(int j=0; j < abcCode.length; j++) {
					if(ch == abcCode[j]) {
						index = j;
						break;
					}
				}
				if(index!=-1) src += (char)('a' + index);
			}
			//=--------------------------------------------------------
			
			
			
			
			

		}

		System.out.println("src : " + src);

	}

}
