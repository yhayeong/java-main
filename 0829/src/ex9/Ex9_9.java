package ex9;

public class Ex9_9 {

	public static void main(String[] args) {
		System.out.println("(1!2@@@@3^^^^4~5)" + "->" + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2    3  4\t5)" + "->" + delChar("(1 2   3  4\t5)", " \t"));
	}
	
	public static String delChar(String src, String delCh) {
		
		StringBuilder sb = new StringBuilder(src);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			
			for (int j = 0; j < delCh.length();j++) {
				if(ch==delCh.charAt(j)) {
					sb.deleteCharAt(i); //deleteCharAt하게되면 전체길이가-1되어서 인덱스가 달라짐을 주의
					i--; //인덱스가 달라짐을 고려해줘야한다 sb 길이가 줄기 때문에 인덱스도 하나 앞으로 땡겨야함
				}
			}
		}
		return new String(sb);

		//(1)
//		StringBuilder sb = new StringBuilder(src);
//	    for (int i = 0; i < sb.length(); ) { //***증감식을 비워두고 특정한 경우에만 i를 바꾼다
//	        char ch = sb.charAt(i);
//	        
//	        if (delCh.indexOf(ch) != -1) { //sb의 i번째 문자가 delCh에 있으면 sb에서 그 문자를 삭제한다->sb의 길이가 바뀌므로 i가 변하지 않고 다음에 있던 요소를 가리키게된다
//	            sb.deleteCharAt(i);
//	        } else {
//	            i++; //sb의 i번째 문자가 delCh에 없으면 i를 증가시킨다(다음 문자를 가리킨다)
//	        }
//	    }
//		return sb.toString();
		
		
		//(2)빈문자열생성한뒤 src를 한 문자씩 뽑아서 문자열delCh에서 그 문자를 찾을 수 없다면(indexOf사용) StringBuilder에 넣어서 완성한다
//		StringBuilder sb = new StringBuilder(src.length()); 
//		for (int i = 0; i < src.length(); i++) {
//			char ch = src.charAt(i);
//			if(delCh.indexOf(ch) < 0) sb.append(ch);
//		}
//		return sb.toString();
		
	      
	    //(3)새로운 str을 만들고 delCh의 길이만큼 반복하면서 문자열delCh의 문자들을 빈문자열로 대체한다
//	    String newStr = new String(src);
//	    for (int i = 0; i < delCh.length(); i++) {
//	    	newStr = newStr.replace(String.valueOf(delCh.charAt(i)), "");
//		}
//	    return newStr;
		
		
		//선생님 코드
//		StringBuilder sb = new StringBuilder(src); //가변객체인 SB여야 delete메소드 사용가능하므로 SB로 만듦
//		for (int i = 0; i < delCh.length(); i++) {
//			int idx = 0;
//			while(true) {
//				idx = sb.indexOf( delCh.charAt(i) + "", idx); //String과는 달리 SB의 indexOf는 매개변수 타입으로 char가 없으므로 문자열화하여 idx찾아낸다
//				if(idx<0) break;								//두번째 인자를 주게되면 찾을시작인덱스를 주는것
//				sb.deleteCharAt(idx); 
//			}
//		}
//		return sb.toString();
	    
			
	}//메소드
		
		
		
}
