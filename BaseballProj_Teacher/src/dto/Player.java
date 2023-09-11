package dto;

public class Player {
	
	//필드
	private Integer num;
	private String name;
	private Integer backnum;
	private Integer teamnum;
	private String teamname; // toString에서 사용할 팀 이름 (테이블의 컬럼으로는 존재하지 않지만)

	//생성자
	public Player() {}
	public Player(Integer num, String name, Integer backnum, Integer teamnum, String teamname) {
		this.num = num;
		this.name = name;
		this.backnum = backnum;
		this.teamnum = teamnum;
		this.teamname = teamname;
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
	public Integer getBacknum() {
		return backnum;
	}
	public void setBacknum(Integer backnum) {
		this.backnum = backnum;
	}
	public Integer getTeamnum() {
		return teamnum;
	}
	public void setTeamnum(Integer teamnum) {
		this.teamnum = teamnum;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	
	
	//메소드
	@Override
	public String toString() {
		return String.format("선수번호:%d, 선수명:%s, 등번호:%d, 소속팀:%s"
											, num,name,backnum,teamname);
	}
}
