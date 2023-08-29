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
	
	//두개의 내용물이 같은 경우에 true를 반환하도록 equals메소드를 오버라이딩해서 사용하기 
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person == false) return false; //갖고온 파라미터의 타입이 Person이 아니면 바로 false를 반환한다. 내용물 데이터를 비교할 필요도 없음
		
		Person p = (Person)obj;
		return name.equals(p.name) && age==p.age;
	}
}


public class ToStringTest {
	public static void main(String[] args) {
		Person p1 = new Person("hong", 30);
		Person p2 = new Person("hong", 30);
		String str = "!!!" + p1; //문자열이 아닌것에 문자열을 더했다...근데 p는 toString이 자동호출됨
		//즉 Object변수가 문자열이 와야하는 자리에 오거나 문자열과 더해지면 toString이 자동으로 호출된다
		System.out.println(str);
		
		System.out.println(p1.info());
		System.out.println(p1.toString());
		System.out.println(p1); //위와 같다
		
		System.out.println("-----------------------");
		System.out.println(p1.getClass()); //class Person
		System.out.println(p1.getClass().getName()); //Person
		System.out.println(p1.hashCode()); //758529971
		System.out.println(p1.toString()); //Person [name=hong, age=30]
		
		System.out.println(p1==p2); //false(주소값비교)
		System.out.println(p1.equals(p2)); //오버라이딩하기 이전에는 false였다가 오버라이딩후에는 true
		
		
		/*
		 cf. 해시코드의 쓰임 :
		 컬렉션 중 트리셋/트리맵의 특징은 데이터를 순서 상관없이 넣었을때 자동정렬됨
		 문자열이나 정수형은 되지만
		 사용자정의형은 안됨(정렬기준을 모르기때문)
		 그리고 동일한 데이터는 못들어가게돼있음(중복을 거르는 기준이 equals도 같고 hashcode도 같은 경우에 동일한것으로 간주하게돼있음)
		 즉 사용자정의 클래스를 넣는 경우엔 해시코들 오버라이딩해야함
		 
		 
		 
		 Object클래스의 메소드들 중 
		 protected Object clone() : 필요시 상속받아서 오버라이딩해 쓰라는것
		 
		 
		 * */
		
	}

}
