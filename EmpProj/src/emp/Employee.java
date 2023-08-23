package emp;

public abstract class Employee { //추상메소드(미완성메소드)가 하나라도 있는 클래스는 추상클래스(미완성클래스)

	//필드
	private int id;
	private String name;
	
	//생성자
	public Employee() {}
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//getter, setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//메소드
	public String info() {
		return String.format("사번:%d, 이름:%s", id, name);
	}
	
	
	
//	public int getPay() {
//		return 0; //부모는 id,name만 가지므로 이 메소드가 필요하지 않지만, 자식이 오버라이딩해서 사용하게 하려고 만들어둔 메소드이다
//		//부모타입 참조변수 = new 자식객체;했을때 이 참조변수로 호출하는 getPay()는 자식쪽에서 오버라이딩한 메소드이다. -> 다형성!
//	}
	public abstract int getPay();
	//이 클래스객체는 필요 없지만 자식을 위해 만들어두는 메소드이고, 이 클래스를 상속하는 자식은 반드시 이 메소드를 구현해야한다고 강제하는것
	//좀더 명확하게 의미를 부여하며 설계하는일
	
}
