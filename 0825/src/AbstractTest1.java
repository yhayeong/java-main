abstract class Player {
	int currentPos;
	public Player() {
		currentPos = 0;
	}
	abstract void play(int pos);
	abstract void stop();
	
	void play() {
		System.out.println("부모가 정의한 추상메소드가 아닌 play()---->>>");
		play(currentPos); //메소드내에서 추상메소드를 부르는 코드를 작성하면 여기서 부르는 메소드가 자식이 반드시 오버라이딩했을 메소드가 호출된다
	}	
	//자식은 반드시 void play(int pos)와 void stop()을 구현하도록 강제되었을 것이기 때문에
	//자식이 상속받아 가지고 있을 void play() 안에서 void play(int pos)가 호출되는 것이 가능한것
}


class DPlayer extends Player {

	@Override
	void play(int pos) {
		System.out.println("자식이 오버라이딩한 play(int pos)");
	}

	@Override
	void stop() {
		System.out.println("자식이 오버라이딩한 stop()");
	}
}


public class AbstractTest1 {
	
	public static void main(String[] args) {
		
		DPlayer dp = new DPlayer();
		dp.play();
		dp.stop();
		
		System.out.println("===========업캐스팅");
		Player Player = new DPlayer(); //업캐스팅
		dp.play(); //자식이 상속받은 (오버라이딩x 부모에만 정의해둔) 메소드가 호출됨
		dp.stop();
		
		
		/*
		 (업캐스팅하여 자식인스턴스주소를 저장한)부모참조타입으로 부모에만 정의돼있는 메소드를 호출했을때
		 그 메소드 안에서 호출되는 메소드는 '자식의' 오버라이딩한 메소드임 -> 다형성
		 
		 그런데 오버라이딩을 안해뒀다면 이러한 다형성을 보장할 수 없게되므로
		 
		 바로 여기서 부모클래스를 추상클래스로 만드는 일의 의미가 있다(자식의 오버라이딩을 강제해두는것)
		 */
	}
}
