class Person {
	String name;
	int age;
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public String info() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}


public class ToStringTest {
	public static void main(String[] args) {
		Person p = new Person("hong", 30);
		String str = "!!!" + p; //문자열이 아닌것에 문자열을 더했다...근데 p는 toString이 자동호출됨
		//즉 Object변수가 문자열이 와야하는 자리에 오거나 문자열과 더해지면 toString이 자동으로 호출된다
		System.out.println(str);
		
		System.out.println(p.info());
		System.out.println(p.toString());
		System.out.println(p); //위와 같다
		
	}

}
