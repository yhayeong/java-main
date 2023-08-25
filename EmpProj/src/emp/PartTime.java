package emp;

public class PartTime extends Employee implements BusinessTripable {
	
	//필드
	private int time;
	private int payPerTime;
	
	//생성자
	public PartTime() {}
	public PartTime(int id, String name, int time, int payPerTime) {
		super(id, name);
		this.time = time;
		this.payPerTime = payPerTime;
	}
	
	//getter, setter
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPayPerTime() {
		return payPerTime;
	}
	public void setPayPerTime(int payPerTime) {
		this.payPerTime = payPerTime;
	}
	
	//인스턴스메소드
	public int getPay() {
		return getTime() * getPayPerTime(); 
	}
	
	
	@Override
	public String info() {
		return super.info() + ", 급여:" + this.getPay();
	}
	
	//부모인터페이스의 메소드를 오버라이딩
	@Override
	public void payIncentive(int tripDays) {
		setTime(getTime()+tripDays*24); //payPerTime에 곱해지는 time을 변경해주는 setter 호출
	}

}
