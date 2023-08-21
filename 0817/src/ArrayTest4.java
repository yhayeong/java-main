
public class ArrayTest4 {
	
	public static void main(String[] args) { //간단한 응용
		
		String hex = "13A0C";
		String[] binary = new String[] {
				"0000", "0001", "0010", "0011", //0,1,2,3
				"0100", "0101", "0110", "0111", //4,5,6,7
				"1000", "1001", "1010", "1011", //8,9,A, B
				"1100", "1101", "1110", "1111"  //C, D, E, F
		};
		
		String result = "";
		
		
		//출력결과
		//hex : 13A0C
		//binary : 00010011101000001100 만들기
		
		
		//'0' -> "0000"인 binary[0]로 만들기 -> binary['0'-'0']
		//'1' -> "0001"인 binary[1]로 만들기 -> binary['1'-'0']
		
		//'A' -> "1010"인 binary[10]으로 만들기 -> binary[9 + ('A'-'A') + 1 괄호 안이 0
		//'B' -> "1011"인 binary[11]으로 만들기 -> binary[9 + ('B'-'A') + 1 괄호 안이 1
		//'F' -> "1111"인 binary[15]으로 만들기 -> binary[9 + ('F'-'A') + 1 괄호 안이 5
		
		
		
		
		for(int i=0; i<hex.length(); i++) {
			
			char ch = hex.charAt(i);
			
			if('0'<=ch && ch<='9') {
				
				result += binary[ch-'0'];
			} else {
				result += binary[9+ch-'A'+1];
			}
		}
		
		System.out.println("hex : " + hex);
		System.out.println("binary : " + result);
		
		
	}

}
