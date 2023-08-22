
public class Ex22 {

	// isNumber메소드 작성-static메소드인 main에서 바로 갖다 쓰고 있으므로 static메소드여야함
	
	static boolean isNumber(String str) {
		
		if(str==null || str.length()==0) return false;
		//같은것들 str=="" || str==null || str.equals("") || str.length()==0
		
		for (int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			
			if(!('0'<=ch && ch<='9')) return false; //하나라도 0~9사이가 아닌것이 걸리는 순간 false를 리턴하며 종료
		}
		
		//중간에 리턴되지 않았다는 것은 모든 ch가 숫자라는 것이다
		return true;
	}
	
	//다른방식
//	static boolean isNumber(String str) {
//		boolean flag = true;
//		for (int j = 0; j < str.length(); j++) {
//			char ch = str.charAt(j);
//			
//			if(!('0'<=ch && ch<='9')) {
//				flag = false;
//				break;
//			} //하나라도 0과9사이의 값이 아니라면 flag에 false를 저장하고 반복문을 빠져나온다(반드시 break가 필요함)
//		}
//		return flag;
//	}
	
	

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는   숫자입니까?   " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는   숫자입니까?   " + isNumber(str));
	}
}
