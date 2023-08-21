package ex6;

class SutdaCard {
	int num = 1;
	boolean isKwang = true;
	
	String info() {
//		return "" + num + (isKwang?"K":"");
		return String.format("%d%s", num, (isKwang)?"K":"");
	}
}

public class Ex1_2 {

	public static void main(String[] args) {
		
		SutdaCard card1 = new SutdaCard();
		
		SutdaCard card2 = new SutdaCard();
		card2.num = 3;
		card2.isKwang = false;
		
		System.out.println(card1.info()); //3
		System.out.println(card2.info()); //1K
	}

}
