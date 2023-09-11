package dto;

public class Team {
	
	//필드
	private Integer num; // 최대한 primitive타입 사용을 지양할것
	private String name;
	private String local;
	
	//생성자
	public Team() {}
	public Team(Integer num, String name, String local) {
		this.num = num;
		this.name = name;
		this.local = local;
	}

	//getter, setter
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	//메소드
	@Override
	public String toString() {
		return String.format("팀번호:%d, 팀명:%s, 연고지:%s", num,name,local);
	}	
	
	// 4. 선수등록에서 팀 선택 사용자입력을 위해 사용
	public String shortString() {
		return String.format("%d: %s", num, name);
	}

}
