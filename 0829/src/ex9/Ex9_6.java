package ex9;

import java.util.Arrays;

public class Ex9_6 { 
	public static String fillZero(String src, int length) {
		/*
		 * (1) fillZero메서드를 작성하시오. 
		 * 1. src가 널이거나 src.length()가 length와 같으면 src를 그대로 반환한다.
		 * 2. length의 값이 0보다 같거나 작으면 빈 문자열("")을 반환한다. 
		 * 3. src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환한다. 
		 * 4. 길이가 length인 char배열을 생성한다. 
		 * 5. 4에서 생성한 char배열을 '0'으로 채운다.
		 * 6. src에서 문자배열을 뽑아내서 4에서 생성한 배열에 복사한다. 
		 * 7. 4에서 생성한 배열로 String을 생성해서 반환한다.
		 */
		
		if(src==null || src.length()==length) return src;
		else if(length<=0) return "";
		else if(src.length()>length) return src.substring(length);
		char[] arr = new char[length];
		for (int i = 0; i < arr.length; i++) arr[i]='0';
//		for (char c : arr) c = '0'; //결과가 약간 다름
		//6.
		System.arraycopy(src.toCharArray(), 0, arr, length-src.length(), src.length()); //이 문장 이해하기
		//src로만든문자배열,0인덱스부터,새문자배열,새문자배열의끝에서원본문자열길이를뺀시작위치에서부터,원본길이만큼
		
		//7.
		return new String(arr);  //문자배열을 문자열로 만들어서 리턴
		
	}

	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10)); //0000012345
		System.out.println("------");
		System.out.println(fillZero(src, -1)); //빈문자열
		System.out.println("------");
		System.out.println(fillZero(src, 3)); //45
		System.out.println("------");
		
	}
}

//문제-출력
//0000012345 
//123