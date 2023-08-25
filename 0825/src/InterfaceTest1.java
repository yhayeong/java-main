interface Fightable {
	void fight();
}

abstract class Unit {
	public abstract void move();
}

class Fighter extends Unit implements Fightable {

	@Override
	public void fight() {}

	@Override
	public void move() {}
	
}



public class InterfaceTest1 {
	public static void main(String[] args) {
		Fightable fighter = new Fighter(); //업캐스팅
		fighter.fight();
//		fighter.move();	 //클래스 업캐스팅의 경우와 마찬가지로 부모타입의 참조변수로 자식에만 있는 메소드를 호출할 수 없다
		
		
	}
}
