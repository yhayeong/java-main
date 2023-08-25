import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class CompanyMain {
	
	
	public static void main(String[] args) {
		
		Company com = new Company();
		
		Permanent emp1 = new Permanent(1001, "상부상조", 5000000);
		Sales emp2 = new Sales(1002, "자바조", 4000000, 1000000);
		PartTime emp3 = new PartTime(1003, "커피조", 160, 30000);
				
		com.enter(emp1); //매개변수로 Employee타입을 받는 enter메소드가 호출되는 순간에 emp1는 업캐스팅되어 Eployee타입 emp에 저장되어 메소드내에서 사용된다
		com.enter(emp2);
		com.enter(emp3);
		
		com.allEmployeeInfo();
		System.out.println("총급여액: " + com.getTotalPay());
		
		
		//----------------0825 과제
		
//		com.regBusinessTrip(emp1,1); //Permanent인스턴스는 출장불가능하게할것
		com.regBusinessTrip(emp2,2);  //Sales 출장가능, 하루당 300000원을 incentive로 지급할것
		com.regBusinessTrip(emp3,1);  //PartTime 출장가능, (출장시간(1일24시간) * payPerTime)원을 incentive로 지급할것
		
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
/* 0825 과제-출력하기
사번:1001, 이름:상부상조, 급여:5000000
사번:1002, 이름:자바조, 급여:5600000
사번:1003, 이름:커피조, 급여:5520000
총급여액: 1612000
 */
