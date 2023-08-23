import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class CompanyMain {
	
	static Employee[] emps = new Employee[100];
	static int empCnt = 0;
	
	public static void enter(Employee emp) {
		emps[empCnt++] = emp;
	}
	
	public static void allEmployeeInfo() {
		for (int i = 0; i < empCnt; i++) {
			System.out.println(emps[i].info()); //emps[i]에 저장될때 Employee타입으로 저장됐으므로 각각의 자식객체 타입들의 info()로 호출되기를 원한다면 오버라이딩해두어야한다
			//(자식만의 것으로 사용하고 싶다면 다운캐스팅해서 사용할 수도 있다(하지만 매번 다운캐스팅하느니 자식클래스에 부모클래스의 메소드를 오버라이딩해두는것이 더 적절)
		}
	}
	
	
	public static void main(String[] args) {
		
		Permanent emp1 = new Permanent(1001, "상부상조", 5000000);
		Sales emp2 = new Sales(1002, "자바조", 4000000, 1000000);
		PartTime emp3 = new PartTime(1003, "커피조", 160, 300000);
				
		enter(emp1); //매개변수로 Employee타입을 받는 enter메소드가 호출되는 순간에 emp1는 업캐스팅되어 Eployee타입 emp에 저장되어 메소드내에서 사용된다
		enter(emp2);
		enter(emp3);
		
		System.out.println(emp1.info());
		System.out.println(emp2.info());
		System.out.println(emp3.info());
		
	}

}
