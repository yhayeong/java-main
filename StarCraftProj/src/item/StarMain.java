package item;

public class StarMain {
	public static void main(String[] args) {
		
		Tank tank = new Tank();
		SCV scv = new SCV();
		Zerg zerg = new Zerg();
		Marine marine = new Marine();
		
		scv.repair(tank); //Tank타입은 MAX_HP의 90%로 수리되고
		scv.repair(scv);	//80%
		scv.repair(zerg);	//100%
//		scv.repair(marine); //이 문장만 error가 나게 하고 싶은데 위 세 객체의 공통분모가 없다(부모가 다양하므로)->인터페이스를 사용해야함(공통그룹으로 만들기)
		
		
		
		
		
	}
}
