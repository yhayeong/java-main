class Person2 {
	int age;
	String name;

	Person2() {
		this("none", 0); //코드의 중복을 막기위해 또다른 생성자를 호출할수있다(파라미터 타입이 넣어준대로인) 맨윗줄에 와야함
		// name = "none";
		// age = 0;
	}
	
	Person2(String n, int a) { //호출되는 생성자
		age = a;
		name = n;
	}
	
	Person2(String n) {
		this(n,0);
		// name = n;
		// age = 0;
	}
	
	Person2(int a) {
		this("none",a);
		// name = "none";
		// age = a;
	}
	
	Person2(Person2 p) {
		name = p.name;
		age = p.age;
	}
}


public class ConstructorTest1 {
	public static void main(String[] args) {
		
		Person2 per1 = new Person2();
		per1.name = "고길동";
		per1.age = 30;
		
		Person2 per2 = new Person2("홍길동", 20);
		Person2 per3 = new Person2("구길동");
		Person2 per4 = new Person2(40);
		Person2 per5 = new Person2(per1);
		
		System.out.println(per1.name + ", " + per1.age);
		System.out.println(per2.name + ", " + per2.age);
		System.out.println(per3.name + ", " + per3.age);
		System.out.println(per4.name + ", " + per4.age);
		System.out.println(per5.name + ", " + per5.age);
	}

}
// new에 의해 객체가 힙메모리에 생성된 직후 깂을 초기화하라고 호출되는 것이 생성자이다