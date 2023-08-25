package acc;

public class SpecialAccount extends Account {
	String[] gradeList = {"VIP", "Gold", "Silver", "Normal"}; //등급 유형 관리
	double[] bonusPercent = {0.04, 0.03, 0.02, 0.01};		  //등급별 이율 관리
	String grade;
	
	public SpecialAccount() {}
	public SpecialAccount(String id, String name, int money, String grade) {
		super(id, name, money);
		
//		if(grade.equals("V")) this.grade = "VIP";
//		else if(grade.equals("G")) this.grade = "Gold";
//		else if(grade.equals("S")) this.grade = "Silver";
//		else if(grade.equals("N")) this.grade = "Normal";
		
//		switch(grade) {
//		case "V" : this.grade = "VIP"; break;
//		case "G" : this.grade = "Gold"; break;
//		case "S" : this.grade = "Silver"; break;
//		case "N" : this.grade = "Normal"; break;
//		}
		
		switch(grade) {
		case "V" : this.grade = gradeList[0]; break;
		case "G" : this.grade = gradeList[1]; break;
		case "S" : this.grade = gradeList[2]; break;
		case "N" : this.grade = gradeList[3]; break;
		}
	}
	
	@Override
	public String info() {
		return super.info() + ", 등급:" + this.grade;
	}
	@Override
	public void deposit(int money) {
		
		int previousBalance = this.balance;
		switch(this.grade) {
		case "VIP" : balance += money*1.04; break;
		case "Gold" : balance += money*1.03; break;
		case "Silver" : balance += money*1.02; break;
		case "Normal" : balance += money*1.01; break;
		}
		System.out.println("*" + money + "원을 입금하셨고, " + (this.balance-previousBalance-money) + "를 이자로 지급받으셨습니다.");
		
//		super.deposit(money);
//		switch(this.grade) {
//		case "VIP" : balance += money*0.04; break;
//		case "Gold" : balance += money*0.03; break;
//		case "Silver" : balance += money*0.02; break;
//		case "Normal" : balance += money*0.01; break;
//		}
		
//		super.deposit(money);
//		if(this.grade.equals(gradeList[0])) balance += money*bonusPercent[0];
//		else if(this.grade.equals(gradeList[1])) balance += money*bonusPercent[1];
//		else if(this.grade.equals(gradeList[2])) balance += money*bonusPercent[2];
//		else if(this.grade.equals(gradeList[3])) balance += money*bonusPercent[3];
		
	}
}
