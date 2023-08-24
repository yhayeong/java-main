package Ex7;


abstract class Unit {
	int x, y;
	abstract void move(int x, int y); //구현부가 없는 추상메소드
	void stop() {} //반드시 오버라이딩할 필요는 없는 부모의 메소드
}

class Marine extends Unit {
	@Override
	void move(int x, int y) { //전달받은 위치로 x,y좌표를 설정
		this.x = x;
		this.y = y;
	}
}

class Tank extends Unit {
	
	boolean mode = false;

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//공격모드를 변환한다(true/false)
	void changeMode() {
		this.mode = !this.mode;
	}
	
	
}

class DropShip extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void load() {}
	void unload() {}
	
}

public class Ex7_17 {
	public static void main(String[] args) {
		
	}
}
