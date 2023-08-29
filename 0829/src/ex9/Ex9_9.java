package ex9;

public class Ex9_9 {

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " ->   " 
									+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2    3  4\t5)" + " -> "
									+ delChar("(1 2   3  4\t5)", " \t"));
	}
	
	public static String delChar(String src, String delCh) {
		
//		StringBuilder sb = new StringBuilder(src);
//		for (int i = 0; i < sb.length();) {
//			char ch = sb.charAt(i);
//			
//			for (int j = 0; j < delCh.length(); j++) {
//				if(ch==delCh.charAt(j)) {
//					sb.deleteCharAt(i); //deleteCharAt하게되면 전체길이가-1되어서 인덱스가 달라짐을 주의
//				}
//				else i++;
//			}
//		}
//		return new String(sb);
//		//공백 제거 안됨->인덱스관리못해서

		
		StringBuilder sb = new StringBuilder(src);
	    for (int i = 0; i < sb.length(); ) { //***특정한 경우에만 i++을 수행한다
	        char ch = sb.charAt(i);
	        
	        if (delCh.indexOf(ch) != -1) { //sb의 i번째 문자가 delCh에 있으면 sb에서 그 문자를 삭제하고
	            sb.deleteCharAt(i);
	        } else {
	            i++; //그렇지않으면(sb의 i번째 문자가 delCh에 없으면 i를 증가시킨다)
	        }
	    }
		return sb.toString();
		
		
		//(1)빈문자열생성한뒤 src를 한 문자씩 뽑아서 문자열delCh에서 그 문자를 찾을 수 없다면(indexOf사용) StringBuilder에 넣어서 완성한다
//		StringBuilder sb = new StringBuilder(src.length()); 
//		for (int i = 0; i < src.length(); i++) {
//			char ch = src.charAt(i);
//			if(delCh.indexOf(ch) < 0) sb.append(ch);
//		}
//		return sb.toString();
		
	      
	    //(2)새로운 str을 만들고 delCh의 길이만큼 반복하면서 문자열delCh의 문자들을 빈문자열로 대체한다
//	    String newStr = new String(src);
//	    for (int i = 0; i < delCh.length(); i++) {
//	    	newStr = newStr.replace(String.valueOf(delCh.charAt(i)), "");
//		}
//	    return newStr;
	    
			
	}//메소드
		
		
		
}
