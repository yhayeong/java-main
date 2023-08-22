class Employee {
	int id;
	String name;
	String dept;
	int salary;
	
	Employee() {}
	Employee(int id, String name, String dept, int salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
}


public class Company {
	
	Employee[] empList = new Employee[100];
	int empCnt; //(배열에 저장완료된) 직원수
	
	void enter(Employee e) {
		empList[empCnt++] = e; //전달인자e를 0인덱스에 넣고 empCnt는 1이된다 (1인덱스에 넣고 empCnt는 2가 된다)
	}
	
	void setBonus(int id, int bonus) {
		Employee searchedEmp = null;
		for (int i = 0; i < empCnt; i++) { //배열길이만큼 반복하면 ENP발생(값이 null로 채워진 인덱스들이 있기 때문)
			if(id==empList[i].id) { 
				searchedEmp = empList[i]; //해당 아이디로 찾은 직원
				searchedEmp.salary += bonus;
				break; //찾았다면 더이상 찾지 않고 반복문 종료
			}
			System.out.println("해당 사번이 없습니다."); //break로 나가는 if문에 한번도 걸리지 않았다는것은 일치하는 아이디가 없다는것
		}
	}
	
	void allEmployeeInfo() {
		System.out.println("----직원목록----");
		System.out.println(empCnt + "명의 직원이 있습니다");
		
		if(empCnt>0) {
			for (int i = 0; i < empCnt; i++) {
				System.out.println(String.format("사번:%d, 이름:%s, 부서:%s, 급여:%d", empList[i].id, empList[i].name, empList[i].dept, empList[i].salary));
			}
		}
		
		System.out.println("--------------");
	}
	
	int getTotalPay() {
		int total = 0;
		if(empCnt==0) {
			return total;
		} else {
			for (int i = 0; i < empCnt; i++) {
				total += empList[i].salary;
			}
			return total;
		}
	}
	
	
	public static void main(String[] args) {
		
		Company com = new Company();
		
		Employee emp1 = new Employee(10001, "홍길동", "홍보부", 5000000);
		Employee emp2 = new Employee(10002, "고길동", "총무부", 3500000);
		Employee emp3 = new Employee(10003, "하길동", "개발부", 4000000);
		
		com.enter(emp1);
		com.enter(emp2);
		com.enter(emp3);
		com.setBonus(10001, 1000000);
		
		com.allEmployeeInfo();
		System.out.println("총급여액: " + com.getTotalPay());
		
	}
	
}
