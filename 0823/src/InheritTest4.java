class A {
	A() {}
	A(int m) {}
}

class B extends A {
	B() {} //여기에는 super()가 숨겨져있다 - 부모의 기본생성자는 자동호출되므로
}

//------------------------------------------------------------------

class C {
	C(int m) {}
}

class D extends C{
	D(int m) {
		super(m);
	}
}


public class InheritTest4 {
	public static void main(String[] args) {
		
	}
}

