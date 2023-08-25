package item;

//Marine타입을 제외한 Tank, SCV, Zerg만 어떤 기능을 수행하게 하고 싶은데 이들은 같은 부모를 가지지 않는다->이 인터페이스를 상속한다는 공통점을 만들어줌
public interface Repairable {
	
	//[2]
	void fix(); //이렇게 작성하면 Repairable을 상속한 클래스들은 모두 이 메소드를 오버라이딩해야함이 강제된다
	
	
}	
