package acc;

public class SpecialAccount_Teacher extends Account {
	
	String grade = "Normal"; //아래 setGrade메소드의 케이스들에 해당하지 않으면 Normal로 초기화되게함
	double interest = 0.01; //이자율도 기본값 Normal등급이 가져야할 이자율로 초기화해준다
	
	public String getGrade() {
		return grade;
	}
	
	
	public void setGrade(String grade) { //등급과 이자율을 함께 초기화해주는 메소드
		//if문의 조건식에서 OR하는 것과 같은 로직을 구현하기 위해서 케이스문을 이렇게 쓸수있다
		switch(grade) {
		case"V":
		case"v": this.grade="VIP"; this.interest = 0.04; break; 
		case"G":
		case"g": this.grade="Gold"; this.interest = 0.03; break;
		case"S":
		case"s": this.grade="Silver"; this.interest = 0.02; break;
		case"N":
		case"n": this.grade="Normal"; this.interest = 0.01; break;
		}
	}
	
	public SpecialAccount_Teacher() {}
	public SpecialAccount_Teacher(String id, String name, int money, String grade) {
		super(id, name, money);
		setGrade(grade); //등급과 이자율을 함께 초기화하는 인스턴스메소드 호출
	}


	@Override
	public void deposit(int money) {
		super.deposit((int)(Math.round(money+money*interest)));
	}


	@Override
	public String info() {
		return super.info() + ", 등급:" + grade;
	}
	
}
