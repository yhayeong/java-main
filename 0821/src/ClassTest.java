public class ClassTest { //main함수가 있는 클래스는 public이 붙어있어야한다.

	public static void main(String[] args) {
	
		Student stu1 = new Student();
		// new는 주소를 반환하고 그 주소가 stu1이라는 참조변수에 담기게된다
		
		stu1.name = "홍길동";
		stu1.address = "서울시 금천구";
		stu1.grade = 4;
		stu1.num = 10001;
		
		System.out.println(stu1.name);
		stu1.info();
		
		
	}

}

//public class Test {} //하나의 자바 파일에는 public class가 하나만 있어야한다.