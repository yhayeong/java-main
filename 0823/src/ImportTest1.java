import java.util.Date;

import pac.MyClass;

public class ImportTest1 {

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		
		mc.date1 = new Date(1234567);
	}
}

//(1)
//같은 패키지에 있는 클래스끼리는 public이 필요가 없다 (public이 붙어있지 않아도 가져다 사용 가능)
//어디서든 갖다 쓸수있기위해서는 클래스에 public을 붙이고
//생성자에도 public을 붙여야한다(자동생성되는 기본생성자에는 public이 붙어있다)

//(2)
//MyClass의 date1변수에도 public이 없다면 가져다 사용할 수 없다.