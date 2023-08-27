interface Fightable {
	void fight();
}

interface Helping {
	void help();
}

abstract class Unit {
	public abstract void move();
}

class Fighter extends Unit implements Fightable {
	@Override
	public void fight() { System.out.println("Fighter의 fight() 호출"); }

	@Override
	public void move() { System.out.println("Fighter의 move() 호출"); }
}

class Helper extends Unit implements Helping {
	@Override
	public void help() { System.out.println("Helper의 help() 호출"); }

	@Override
	public void move() { System.out.println("Helper의 move() 호출"); }
}

class Comber extends Unit implements Fightable, Helping { //3개 다 상속한 Comber클래스
	@Override
	public void help() { System.out.println("Comber의 help() 호출"); }

	@Override
	public void fight() { System.out.println("Comber의 fight() 호출"); }

	@Override
	public void move() { System.out.println("Comber의 move() 호출"); }
}


public class InterfaceTest1 {
	public static void main(String[] args) {
		
//<업캐스팅>
		
		Fighter fighter = new Fighter();
		Fightable f1 = fighter; 
		Unit f2 = fighter;
		Object f3 = fighter;
		
		f1.fight();
//		f1.move();	 //부모타입의 참조변수로 자식에만 있는 메소드를 호출할 수 없다
		
		
		Helper helper = new Helper();
		Helping h1 = helper;
		Unit h2 = helper;
		Object h3 = helper;
		
		
		Comber comber = new Comber();
		Fightable c1 = comber;
		Helping c2 = comber;
		Unit c3 = comber;
		Object c4 = comber;
		
	
		
		method1(fighter);
		method1(comber);
//		method1(helper); //이 문장만 error나도록 하려면 method1의 매개변수로 (Helper만 상속하지않은)Fightable변수를 받도록 선언한다
		
//		method2(fighter);
		method2(comber);
		method2(helper);
		
		method3(fighter);
		method3(comber);
		method3(helper);
		
		
		System.out.println("++++++++++++++++++++++++++++++"); //각각 자식타입이 매개변수에 Unit타입으로 업캐스팅돼서 들어간다
		methodUniversal(fighter); //Fighter의 fight() 호출
		methodUniversal(helper); //Helper의 help() 호출
		methodUniversal(comber); //Comber의 fight() 호출
		System.out.println("+++++++++++++++++++++++++++++++++++++++++"); //Unit타입으로 업캐스팅해둔 부모타입 참조변수를 넣은것
		methodUniversal(f2); //Fighter의 fight() 호출
		methodUniversal(h2); //Helper의 help() 호출
		methodUniversal(c3); //Comber의 fight() 호출
		
		//같은 메소드를 호출했는데 다른 결과가 나온다 -> '다형성'이라는 개념
		
	}//main
	
	
	static void method1(Fightable unit) {
		unit.fight();
	}
	static void method2(Helping unit) {
		unit.help();
	}
	static void method3(Unit unit) {
		unit.move();
	}
	
	
	static void methodUniversal(Unit unit) {
		if(unit instanceof Fightable) {
			((Fightable) unit).fight();
		} else if(unit instanceof Helping) {
			((Helping)unit).help();
		} else {
			((Comber)unit).move();
		}
	}
	
	
	/*
	 다중상속의 장점 :
	  부모가 서로 다른 클래스끼리의 관계를 만들고싶을때 
	  인터페이스를 껍데기로만 만들어두고 그것을 상속했는지 여부를 통해서 특정 클래스들을 한 그룹으로 취급하여 다룰 수 있게 된다
	  
	 
	 부모가 다른 클래스A와 클래스B를 임의로 그룹화하는 방법으로 인터페이스를 사용하는 것
	 (->어떤 메소드f를 이들만 사용할 수 있게하기 위해서)
	 추상메소드f를 가지는 인터페이스F를 만들어둔다
	 클래스A,B는 인터페이스F를 상속하고, 클래스C는 그러지 않는다면 
	 클래스A,B는 인터페이스F타입을 통해서 메소드f를 사용할 수 있다. (클래스C는 불가)
	 
	 인터페이스는 이런것을 가능하게 하는 도구이다
	*/
	
	
}//InterfaceTest1


