import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class CompanyMain {
	
	
	public static void main(String[] args) {
		
		Company com = new Company();
		
		Permanent emp1 = new Permanent(1001, "상부상조", 5000000);
		Sales emp2 = new Sales(1002, "자바조", 4000000, 1000000);
		PartTime emp3 = new PartTime(1003, "커피조", 160, 300000);
				
		com.enter(emp1); //매개변수로 Employee타입을 받는 enter메소드가 호출되는 순간에 emp1는 업캐스팅되어 Eployee타입 emp에 저장되어 메소드내에서 사용된다
		com.enter(emp2);
		com.enter(emp3);
		
		com.allEmployeeInfo();
		System.out.println("총급여액: " + com.getTotalPay());
		
	}

}


/*
사번:1001, 이름:상부상조, 급여:5000000
사번:1002, 이름:자바조, 급여:5000000
사번:1003, 이름:커피조, 급여:48000000
총급여액: 58000000
 */
