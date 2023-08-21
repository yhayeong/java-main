
public class ArrayTest3 {
	// 배열의 활용 예제2 Ex7

	public static void main(String[] args) {
		
		char[] hex = new char[] {'C', 'A', 'F', 'E', '2', '0', '2', '3'};
		String[] binary = new String[] {
				"0000", "0001", "0010", "0011", //0,1,2,3
				"0100", "0101", "0110", "0111", //4,5,6,7
				"1000", "1001", "1010", "1011", //8,9,A, B
				"1100", "1101", "1110", "1111"  //C, D, E, F
		};
		
		//풀이 과정
		//'0' -> 0000 (binary[0]에 해당) '숫자'->숫자로 만들려면 '0'을 뺀다
		//'1' -> 0001 (binary[1])
		//'9' -> 1001 (binary[9])
		//'A' -> 1010 (binary[10])  //9 + 'A' - 'A' + 1 = 10나온다
		//'F' -> 1111 (binary[15]) 'F' - 'A' = 69 - 65 = 4   //69 - 65 + 1 하면 5임을 이용
															//9 + 'F' - 'A' + 1 이러한 패턴을 찾아낸다
		
		String result = "";
		
		for(int i=0; i<hex.length; i++) {
			
			char ch = hex[i];
			if('0' <= ch && ch <= '9') {
				//숫자로된 문자라면
				result += binary[ch - '0'];
				
			} else {
				
				result += binary[9 + ch - 'A' + 1];
			}
			
		}
		
		System.out.println("hex : " + new String(hex)); //char배열을 스트링으로 바꿔준다
		System.out.println("binary : " + result);
		
		
		
		
		
		
	}

}
