class Person {
	int age;
	String name;
}

class Number {
	int inum;
	static int snum;
	
	void imethod() {
		inum = 10;
		snum++; //(1)인스턴스메소드에서는 (이미생성돼있을)스태틱변수를 당연히 사용가능하겠지만
		
		imethod2();
		smethod2();
	}
	
	void imethod2() {
	}
	
	static void smethod() {
		snum=100;
//		inum=10; //(1')스태틱메소드에서는 인스턴스변수를 사용하지 못한다(호출시점에 iv가 메모리에 없을수도 있으므로-iv는 동적으로 생성되니까)
		
		smethod2();
//		imethod(); //(1'')마찬가지로 스태틱메소드에서 인스턴스메소드 호출 불가능
	}
	
	static void smethod2() {
	}
	//(1정리) 스태틱메소드에서는 인스턴스멤버에 접근할 수 없다
}


public class StaticTest1 {
	
	public static void main(String[] args) {
		Person per = null; 
		per = new Person(); //new하는 시점에 동적으로 메모리에 생성됨...
		System.out.println(per.age); //위 문장 없이 실행시 NPE발생
		
		//----------------------------------------------------------
		
		System.out.println(Number.snum); //클래스(static)변수인 snum은 객체생성하지 않은채로도 접근가능(프로그램 시작시 이미 메모리에 생성되어있게되기 때문)
//		System.out.println(Number.inum); //인스턴스변수인 inum은 객체 생성해야 사용가능
		Number.smethod();//스태틱변수처럼 스태틱메소드도 마찬가지로 객체생성하지 않고도 호출가능
//		Number.imethod();//인스턴스메소드도 마찬가지로 객체생성후 레퍼런스를 통해서 호출해야함
		
		Number n = new Number();
		System.out.println(n.inum);
		System.out.println(n.snum); //클래스(static)변수를 레퍼런스를 통해서 접근하는것도 가능하지만 클래스명으로 접근하는것이 권장됨
		n.imethod();
		n.smethod();
	}

}
