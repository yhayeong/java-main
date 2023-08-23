package emp;

public class Employee {

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
	
	//인스턴스메소드
	public String info() {
		return String.format("사번:%d, 이름:%s", id, name);
	}
	
	
	
}
