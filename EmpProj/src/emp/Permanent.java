package emp;

public class Permanent extends Employee {
	
	//필드
	private int salary;
	
	//생성자
	public Permanent( ) {}
	public Permanent(int id, String name, int salary) {
		super(id, name);
		this.salary = salary;
	}
	
	//getter, setter
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//인스턴스메소드
	public int getPay() {
		return getSalary();
	}
	@Override
	public String info() {
		return super.info() + ", 급여:" + this.getPay();
	}
	
	
}
