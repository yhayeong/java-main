
class Car {
	
	Engine engine = new Engine(); //전역변수(중에서 인스턴스변수)
	
}

public class Test {
	public static void main(String[] args) {
		
		Car car = new Car(); //지역변수

		//참조변수->지역변수(스택)/전역변수(힙) 
	}
}
