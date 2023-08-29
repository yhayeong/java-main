import java.util.Arrays;

public class StringTest1 {
	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "a";
		str1 = "b";
		
		int n = 10;
		n = 20;
		
		//"Sting은 불변객체"
		//상수영역에 a\0 가 들어가고 변수str1가 그 주소를 가리키게된다. 변수str1에 문자열b를 대입시 b\0을 새로 만들고 변수str1가 그 주소를 가리키도록 변경됨
		//immutable데이터 형태란 이렇듯 메모리에 할당된 데이터를 변경시키지 않는것을 말한다 (int n의 경우 mutable데이터)
		
		//str2의 경우, 상수영역에 이미 저장된 문자열a이 있는 경우 이미 있는 데이터의 주소를 str2에 대입한다.
		
		
		
		String s1 = null; //s1에 null을 대입 (주소가 없음)
		String s2 = ""; 	//s2가 가리키는 상수영역에 null로 할당돼있음 (null을 가리키는 주소를 가짐)
							//문자열은 항상 맨 끝에 null을 가진다. 빈문자열은 null(2바이트)을 가지는것.
		char c = ' '; 		//char에는 공백 하나라도 필요함
		
		
		String s3 = new String("abc");
		char[] carr = {'a', 'b', 'c'};
		String s4 = new String(carr);
		System.out.println(s3==s4); //false
		System.out.println(s3.equals(s4)); //true
		
		
		
		//StringBuffer, StringBuilder -> mutable이라서 계속 데이터를 뒤로 이어붙여서 사용할 수 있다
		StringBuffer sb = new StringBuffer("abc");
		String s5 = new String(sb);
		System.out.println(s5.contains("c"));
		
		
		String[] files = {"test.txt", "temp.hwp", "backup.txt", "paint.png"};
		for (int i = 0; i < files.length; i++) {
			if(!files[i].endsWith(".txt")) System.out.println(files[i] + "는 txt파일이 아닙니다.");
		}
		
		String h1 = "Hello";
		System.out.println(h1.equalsIgnoreCase("hello"));
		
		System.out.println(h1.indexOf('e')); //1
		System.out.println(h1.indexOf("e")); //1
		System.out.println(h1.indexOf("q")); //없으면 -1반환
		String h2 = "HelloWWWorldHello";
		int idx2 = h2.lastIndexOf("Hello"); 
		System.out.println(idx2); //뒤에서부터 10번째 인덱스
		
		String h4 = h2.replace("W", "G");
		System.out.println(h2); //그대로임 String은 immutable이기 때문에 바뀌지않음
		System.out.println(h4); //바뀐것은 따로 생성된 문자열임 (HelloGGGorldHello)
		
		String h5 = "banana";
		System.out.println(h5.replaceFirst("a", "A")); //bAnana
		System.out.println(h5.replace("a", "A")); //bAnAnA
		
		String fruitStr = "apple#banana#pineapple#melon#strawberry";
		String[] fruitArr = fruitStr.split("#");
		String[] fruitArr2 = fruitStr.split("#",3); //3개가 되도록 쪼개어 배열에 담음
		System.out.println(Arrays.toString(fruitArr));
		System.out.println(Arrays.toString(fruitArr2));
		
		String fr = fruitStr.substring(3, 6); //3인덱스부터 6미포함까지
		System.out.println(fr); //le#
		
		int sidx = fruitStr.indexOf("pineapple");
		int eidx = sidx + "pineapple".length();
		String pine = fruitStr.substring(sidx, eidx);
		System.out.println(sidx + "," + eidx + "," + pine);
		
		String str3 = "   Hello   ";
		System.out.println("[" + str3 + "]");		 //[Hello   ]
		System.out.println("[" + str3.trim()+ "]");  //[Hello]
		
		String str4 = String.valueOf(123); //int->String
		System.out.println(str4.length()); //3
		String str5 = 123 + ""; 			//이것이 더 잘쓰임 
		
		Point p = new Point(10, 10);
		String pstr = String.valueOf(p); //p.toString이 아니라 p만 써도 Point의 toString을 자동호출한뒤 그것을 String으로 변환하게됨
		String pstr2 = "" + p; 
		System.out.println(pstr + "///" + pstr2); //10, 10///10, 10
		
		int num = Integer.valueOf(str4); //String->int
		System.out.println(num+100); 	  //223
		
		
	}

}
