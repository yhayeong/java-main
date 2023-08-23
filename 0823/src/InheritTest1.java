class Person {
	int age;
	String name;
	Person() {}
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	String info() {
		return "이름:" + name + ", 나이:" + age;
	}
	
	
}


class Student extends Person {
	
	String major;
	int grade;
	
	@Override
	String info() {
		return super.info() + ", 전공:" + major + ", 학년:" + grade; 
		//부모의 것과 나의 것의 이름이 겹치는 경우에 super를 통해서 구별하므로 겹치는이름이 없다면 super빼도 됨
		
	}
		
	Student() {}
	Student(String name, int age, String major, int grade) {
		super(name, age);
		this.major = major;
		this.grade = grade;
	}
}



public class InheritTest1 {
	public static void main(String[] args) {
		Student stud1 = new Student(); 
		stud1.name = "열심히";
		stud1.age = 20;
		stud1.major = "산업공학";
		stud1.grade = 2;
		System.out.println(stud1.info());
		
		Student stud2 = new Student("돈많은", 40, "금융", 3);
		System.out.println(stud2.info());
		
		Person per1 = new Person();
		per1.name = "내로남불";
		per1.age = 30;
//		per1.major = "얌체과"; //부모는 자식의 멤버 사용 불가능
//		per1.grade = 3;
		System.out.println(per1.info());
	}
}




























