package emp;

public class PartTime extends Employee {
	
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
	

}
