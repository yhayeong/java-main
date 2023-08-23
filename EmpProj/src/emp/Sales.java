package emp;

public class Sales extends Permanent {

	//필드
	private int incentive;
	
	//생성자
	public Sales() {}
	public Sales(int id, String name, int salary, int money) {
		super(id, name, salary);
		this.incentive = money;
	}
	
	//getter, setter
	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	
	//인스턴스메소드
	@Override
	public int getPay() {
		return super.getPay() + getIncentive();
	}
	
	
	
	
	//getInfo() 메소드를 오버라이딩하지 않고 main에서 호출했을때
	
	//즉 부모에게서 상속된 메소드가 호출됐을때
	//getInfo()는 자식의 메소드로서 호출된다
	
	//그래서 getInfo()안의 getPay()로 반환되는 급여는 호출하는 자식인스턴스가 가진 값이다 
	//---> 다형성
	
}
