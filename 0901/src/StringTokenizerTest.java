import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		
//(1)		
//		StringTokenizer st = new StringTokenizer("apple banana orange");
//	
//		//반복문을 통해 스페이스로 구분하여 자른 문자열(토큰)을 하나하나 가져온다
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
		
		
		
//(2) 생성자에 두번째 인자로 구분자를 줄수있다(구분자 유형을 여러개 지정할수있다는것이 String의 split메소드와 비교했을때의 장점)
		StringTokenizer st = new StringTokenizer("apple#banana$orange", "#$", true);
		
		System.out.println("남아있는개수: " + st.countTokens()); 
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("남아있는개수: " + st.countTokens()); 
		
		
//(3) 세번째 인자로 true/false
//기본은 false이고 true를 주면 
//구분자도 하나의 데이터(토큰)로 간주한다
		
		
		/* 출력결과
		  
		남아있는개수: 5
		apple
		#
		banana
		$
		orange
		남아있는개수: 0
		*/
		
		
	}//main

}
