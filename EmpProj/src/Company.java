import emp.Employee;

public class Company {
	Employee[] emps = new Employee[100];
	int empCnt = 0;
	
	public void enter(Employee emp) {
		emps[empCnt++] = emp;
	}
	
	public void allEmployeeInfo() {
		for (int i = 0; i < empCnt; i++) {
			System.out.println(emps[i].info()); //emps[i]에 저장될때 Employee타입으로 저장됐으므로 각각의 자식객g체 타입들의 info()로 호출되기를 원한다면 오버라이딩해두어야한다
		}
	}
	
	public int getTotalPay() {
		int tot = 0;
		for (int i = 0; i < empCnt; i++) {
			tot += emps[i].getPay(); //부모인 Employee로 담긴 emps[i]들의 getPay()를 호출했으나 자식타입들이 각각 오버라이딩한 getPay()가 호출된다
		}
		return tot;
	}
}
