class Parent{
	int n;
	//기본생성자
	Parent() {
		System.out.println("Parent() 호출");
	}
	//매개변수가 있는 생성자
	Parent(int n) {
		this.n = n;
		System.out.println("Parent(int n) 호출");
	}
}

class Child extends Parent {
	int m;
	Child() {
		super(10);
		System.out.println("Child() 호출");
	}
	Child(int n, int m) {
		super(n); //파라미터로 받은 값을 부모의멤버를 초기화시키는데에 써야하므로 super(n)을 호출
		this.m = m;
		System.out.println("전달인자를 받아서 상속받은 변수를 초기화시킬 목적에서 부모의 기본생성자가 아닌 다른 생성자를 지정하여 호출할 수 있다");
	}
}


public class InheritTest3 {
	public static void main(String[] args) {
		Child c1 = new Child(); //객체생성시 부모(기본)생성자->자식생성자 순으로 호출되는것을 확인
		System.out.println("--------------------------------------------------------");
		Child c2 = new Child(20, 30);
	}
}


//super(매개변수) 즉 부모의생성자를 호출하는 것의 의미는
//부모의 기본생성자가 아닌 부모의 다른 생성자를 호출시키고 싶을때 사용한다
//부모의 기본생성자는 자동으로 먼저 호출되기 때문

