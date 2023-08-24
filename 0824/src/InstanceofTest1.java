
public class InstanceofTest1 {
	
	public static void main(String[] args) {
		Base b1 = new Base(); //cf. 같은 패키지내에 Base, Derived 클래스가 있으므로 생성 가능한것
		Base b2 = new Derived();
		
		if(b1 instanceof Base) { //b1이 가리키는 인스턴스가 Base타입의 인스턴스인지를 체크
			System.out.println("b1 is Base instance"); 		//출력됨
		}
		if(b1 instanceof Derived) {
			System.out.println("b1 is Derived instance"); 	//출력안됨
		}
		if(b2 instanceof Base) {
			System.out.println("b2 is Base instance"); 		//출력됨(부모의 인스턴스이기도 하기 때문)
		}
		if(b2 instanceof Derived) {
			System.out.println("b2 is Derived instance"); 	//출력됨
		}
	}
}
