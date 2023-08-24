class Car {
	String color;
	int door;
	void drive() {
		System.out.println("drive, Brrrr~");
	}
	void stop() {
		System.out.println("stop!!");
	}
}

//소방차
class FireEngine extends Car {
	void water() {
		System.out.println("Water<<<<<<<");
	}
}

//구급차
class Ambulance extends Car {
	void siren() {
		System.out.println("siren~~~~!!!!!!");
	}
}



public class PolinoTest4 {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.water();
		fe.drive();
		fe.stop();
		
		Car car = fe; //업캐스팅
//		car.water();  //Car타입의 참조변수로 FireEngine에만 있는 메소드를 사용할 수 없다
		//다시 다운캐스팅해야 사용할수 있는데 (바로 다운캐스팅시 혹시모를 에러를 컴파일러 단계에서 알수없으므로 타당성 체크 필요
		
		if(car instanceof FireEngine) {
			((FireEngine) car).water(); 
		}
		//car가 FireEngine의 인스턴스를 보관중이라면 다운캐스팅하여 FireEngine의 메소드를 사용하도록함
		
		
		Car car2 = new Ambulance();
//		((FireEngine)car2).water(); //에러가 날수밖에 없는데 컴파일 단계에서 알수 없음
		if(car2 instanceof FireEngine) {
			((FireEngine) car2).water(); 
		} //if문에서 걸러주기 때문에 다운캐스팅이 부적절하다고하더라도 실행시 오류가 나지 않음을 보장할 수 있다
		
		
	}
}
