package pac;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class MyClass {
	Scanner sc = new Scanner(System.in);
	
	public Date date1; //(2)public을 붙이지 않으면 다른패키지의 클래스에서 사용할 수 없다
	java.sql.Date date2;
	//다른 패키지의 동명의 클래스를 사용할때는 하나는 임포트해서 쓰고 하나는 풀네임을 쓴다
	
	FileReader fr;
	FileWriter fw;
	//한 패키지의 여러 클래스들을 임포트할때는 패키지.* 로 축약할 수 있다
	
	public MyClass(){}
	//(1)
	//자동생성된 기본생성자는 public임
	//명시적으로 작성할때 public을 붙이지 않으면 다른 패키지의 클래스에서 MyClass 객체를 생성할때 오류 발생
	
	
}
