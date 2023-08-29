package ex9;

public class Ex9_3 {
	public static void main(String[] args) {
		
		
		//윈도우에서는 디렉토리 표시를 역슬래시로 한다(리눅스는 슬래시) 
		//문자열 안에서의 역슬래시는 이스케이프문자로서의 의미를 가진다
		//문자열 안에서 \t : 탭을 의미, \n : 엔터를 의미

		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 * 
		 * 문제해결방법: 역슬래시(\문자 하나를 큰따옴표 안에서 \\로 표현함)의 인덱스를 찾아서 그 앞뒤를 잘라쓰는 방향
		 */
		
		int idx = fullPath.lastIndexOf("\\");
//		System.out.println(idx);
		
		path = fullPath.substring(0, idx); //0인덱스부터 idx미포함까지
		fileName = fullPath.substring(idx+1); //idx+1인덱스부터 끝까지
		
		System.out.println("fullPath:" + fullPath); //fullPath:c:\jdk1.8\work\PathSeparateTest.java
		System.out.println("path:" + path);			//path:c:\jdk1.8\work
		System.out.println("fileName:" + fileName);	//fileName:PathSeparateTest.java
		
	}

}
