class Person {
	String name;
	int age;
	
	String info() {
		return String.format("이름 : %s 나이 : %d", name, age);
	}
}


public class ClassTest2 {

	public static void main(String[] args) {
		
		Person per1 = new Person();
		
		per1.name="유하영";
		per1.age=28;
		
		System.out.println(per1.info());
		
		Person[] parr = new Person[5];
		//다섯개의 객체를 생성한 것이 아님
		
		parr[0] = new Person();
		parr[1] = new Person();
		parr[2] = new Person();
		parr[3] = new Person();
		parr[4] = new Person();
		//이렇게 해야만 다섯개의 객체가 생성된것임
		
		// cf. 모든 레퍼런스(주소를 가진 변수)는 메모리상 4바이트로 같다
		
		
		
		
	}
}
