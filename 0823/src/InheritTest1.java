class Person {
	int age;
	String name;
	Person() {}
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	String info() {
		return "이름:" + age + ", 나이:" + age;
	}
	
	
}


class Student extends Person {
	
	String major;
	int grade;
	@Override
	String info() {
		return super.info();
	}
	
//	Student(String name, int age) {
//		this.name = name; //부모것도 내거니까 this.name은 Person 상속으로 인해 가지고있는 필드 name이다
//		this.age = age;
//		
//	}
	
	
	
	
	
}


public class InheritTest1 {
	public static void main(String[] args) {
		Student stud1 = new Student(); 
		stud1.name = "열심히";
		stud1.age = 20;
		stud1.major = "산업공학";
		stud1.grade = 2;
		System.out.println(stud1.info());
		
		Person per1 = new Person();
		per1.name = "내로남불";
		per1.age = 30;
//		per1.major = "얌체과"; //부모는 자식의 멤버 사용 불가능
//		per1.grade = 3;
		System.out.println(per1.info());
	}
}




























