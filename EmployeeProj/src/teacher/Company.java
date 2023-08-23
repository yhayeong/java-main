package teacher;

public class Company {

	Employee[] emps = new Employee[100];
	int empCnt; 
	
	//입사
	void enter(Employee emp) {
		emps[empCnt++] = emp; //배열에 저장하고 사원수 증가시킴
	}
	
	//보너스주기-사원을 찾아서 사원 클래스의 메소드를 사용
	void setBonus(int id, int money) {
		Employee emp = null;
		for (int i = 0; i < empCnt; i++) {
			if(emps[i].id==id) {
				emp = emps[i];
				break;
				//사번으로 직원목록에서 찾았다면 변수에 담고 종료
			}
		}
		if(emp==null) {
			System.out.println("해당 사번이 없습니다.");
			return;
		}
		emp.payBonus(money);
	}
	
	void allEmployeeInfo() { //직원목록만큼 돌면서 사원클래스의 메소드 사용
		for (int i = 0; i < empCnt; i++) {
			System.out.println(emps[i].info());
		}
	}
	
	int getTotalPay() {
		int tot = 0;
		//직원목록만큼 돌면서 사원클래스의 메소드 사용하여 반환받은 사원별페이를 누적저장
		for (int i = 0; i < empCnt; i++) {
			tot += emps[i].getPay();
		}
		return tot;
	}
	
	public static void main(String[] args) {
		
		//Company클래스의 main메소드가 Company클래스의 인스턴스메소드를 사용하기 위해서는 객체생성하여 참조변수를 이용해야함
		Company com = new Company();
		
		//직원을 생성한다
		Employee emp1 = new Employee(10001, "일길동", "홍보부", 5000000);
		Employee emp2 = new Employee(10002, "이길동", "총부부", 6000000);
		Employee emp3 = new Employee(10003, "삼길동", "개발부", 8000000);
		
		//입사시킨다
		com.enter(emp1);
		com.enter(emp2);
		com.enter(emp3);
		
		//특정사원에게 보너스 지급
		com.setBonus(10003, 1000000);
		
		//모든직원정보출력
		com.allEmployeeInfo();
		
		//전사원 총급여액 출력
		System.out.println("총급여액 : " + com.getTotalPay());
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
