package Ex7;

public class Ex7_2 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0)); //특정 인덱스의 카드 뽑기 메소드인 pick(int index) 호출
		System.out.println(deck.pick());  //랜덤한 카드 뽑기 메소드인 pick() 호출
		
		
		deck.shuffle();						
		
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");		//섞은 뒤 카드덱 출력
														
		
		System.out.println();
		System.out.println(deck.pick(0));				//섞인 카드덱의 0번째 카드 뽑기
	}
}
