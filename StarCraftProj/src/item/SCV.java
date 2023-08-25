package item;

public class SCV extends GroundUnit implements Repairable { //힐러같은앤데 Marine은 못고쳐준다
	
	public SCV () {
		super(60);
	}
	
//SCV는 고쳐줄 수 있는 타입의 객체만 고쳐주는 repair기능을 만들기
	
//[1] Repairable에 추상메소드 void fix()를 정의해두지 않고 사용
	
//고쳐줄수있는 타입이라는 그룹을 "Repairable인터페이스를 상속받는그룹"으로 만든다
/*
	public void repair(Repairable r) {
		if(r instanceof Unit) { 
			Unit unit = (Unit)r;
			unit.healthPoint = unit.MAX_HP; //대상의 healthPoint를 MAX_HP로 다시 채워준다
		}
	}
	
	//Repairable타입과 Unit타입은 관계가 없다. 그러므로 Repairable타입을 통해 Unit의 멤버에 접근 불가하다
	//따라서 참조변수를 캐스팅해야하는데 그때 캐스팅가능여부를 꼭 체크해주어야한다
	//(Repairable을 상속한 클래스가 Unit클래스의 자손이 아닐수도 있기 때문에 체크하지 않으면 실행시 에러를 보장할수없다)
*/	
	
	
	
	
	//[2] Repairable 인터페이스의 추상메소드 void fix()를 자식들이 각각 오버라이딩하게함
	@Override
	public void fix() {
		this.healthPoint = (int)(this.MAX_HP * 0.8);
	}
	
	public void repair(Repairable r) {
		r.fix();
	}


}
