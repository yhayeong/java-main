
public class StringPlus {

	public static void main(String[] args) {
		//연산자
//		int v1 = 10;
//		int v2 = 20;
		int v1 = 10, v2 = 20;
		
		int res = v1 + v2;
		System.out.println(res);
		
		String str1 = "abc";
		String str2 = "def";
		String sres = str1 + str2 + res;
		System.out.println(sres);
		
		String seven1 = "7";
		char seven2 = '7';
		int seven3 = 7;
		
		System.out.println(seven1 + seven2 + seven3); 	//777
		System.out.println(seven2 + seven3); 			//62 -> '7'의 아스키 코드 값이 55임을 알 수 있다
		System.out.println(seven2 + seven3 + seven1); 	//627
		System.out.println(7+7+"7");					//147
		System.out.println(7+7+'7');					//69
		
		

	}
}
