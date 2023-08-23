package teacher;

public class Employee {
	
	int id;
	String name;
	String department;
	int salary;
	int bonus;
	
	public Employee() {} //생성자에 public 붙임

	public Employee(int id, String name, String department, int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public void payBonus(int money) { //인스턴스메소드에 public 붙임
		bonus += money;
	}
	
	public String info() {
		return "사번:"+id+",이름:"+name+",부서:"+department+",급여:"+getPay();
	}
	
	public int getPay() {
		return salary + bonus;
	}

}
