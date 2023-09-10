package dto;

public class Team {
	
	//필드
	private Integer num; // 최대한 primitive타입 사용을 지양할것
	private String name;
	private String local;
	
	//생성자
	public Team() {}
	//*** 2. TeamDAO의 selectTeam에서 사용하는 생성자 - DB에서 조회한 컬럼값으로 Team객체를 생성한다
	public Team(Integer num, String name, String local) {
		this.num = num;
		this.name = name;
		this.local = local;
	}
	//*** 1. Service의 regTeam()에서 사용하는 생성자 - num은 사용자 입력을 받지 않음
	public Team(String name, String local) {
		this.num = null;
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
	
	
	/*
	 
	 CREATE TABLE team (
		num INT AUTO_INCREMENT PRIMARY KEY,
		NAME VARCHAR(100) NOT NULL,
		LOCAL VARCHAR(100)
	 );

	 
	 cf. 필드는 컬럼명과 동일하게 작성하면서 필드명에 카멜표기법을 지양해야 좋다
	 
	 컬럼명
	 team_num -> ORM이 알아서 자동으로 자바의 카멜표기법을 따른 teamNum로 변환하여 필드를 찾아감
	 team_of_num -> 이경우엔 teamOfNum을 찾아갈 수 있지만
	 team_a_num -> 이경우엔 teamANum이 되면서 실패


	 * */

}
