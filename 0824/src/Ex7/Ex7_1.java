package Ex7;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM]; //각 요소에 null이 저장된 배열이 생성됨

	SutdaDeck() {
		/*
		 * (1) 배열 SutdaCard를 적절히 초기화 하시오.
		 */
		
		//#1 방식
//		for (int i = 0; i < CARD_NUM; i++) {
//			if(i<10) cards[i] = new SutdaCard(i+1,false);   //0~9인덱스까지는 1~10/모두 kwang=false 조합으로 채우며 카드를 생성
//			else cards[i] = new SutdaCard(i-9, false); 		//10~19인덱스부터는 1~10/모두 kwang=true 조합으로 채우며 카드를 생성
//		}
//		
//		//0~9인덱스에 해당하는 카드들만
//		for (int j = 0; j < 10; j++) {
//			//숫자 1, 3, 8의 경우에는 둘중 하나만 kwang = true
//			if(cards[j].num==1||cards[j].num==3||cards[j].num==8)
//				cards[j].isKwang = true;
//		}
//		
//		for (int i = 0; i < CARD_NUM; i++) {
//			if(i<10) cards[i] = new SutdaCard(i+1,false);   //0~9인덱스까지는 1~10/모두 kwang=false 조합으로 채우며 카드를 생성
//			else cards[i] = new SutdaCard(i-9, false); 		//10~19인덱스부터는 1~10/모두 kwang=true 조합으로 채우며 카드를 생성
//		}
		
		//#2 방식
//		//0~9인덱스에 해당하는 카드들만
//		for (int j = 0; j < 10; j++) {
//			//인덱스1,3,8의 경우에는 둘중 하나만 kwang = true
//			if(j+1==1 ||j+1==3 || j+1==8)
//				cards[j] = new SutdaCard(j+1, true);
//			else cards[j] = new SutdaCard(j+1, false);
//		}
//		//10~19인덱스에 해당하는 카드들은
//		for (int i = 10; i < CARD_NUM; i++) {
//			cards[i] = new SutdaCard(i+1, false);
//		}
		
		//#3 선생님 코드
		int length = CARD_NUM/2;
		for (int i = 0; i < length; i++) {
			if((i+1)==1 || (i+1)==3 || (i+1)==8) { 				//1,3,8인 카드의 경우
				cards[i] = new SutdaCard(i+1, true);
			} else { 											//나머지 경우
				cards[i] = new SutdaCard(i+1, false);
			}
			cards[10+i] = new SutdaCard(i+1, false);			
		}
		//i=0부터 i=CARD_NUM/2의 횟수(카드 수의 반)만큼 돌면서 1회차:0번째와 10번째, 2회차:1번째와 11번째...이렇게 카드 두개씩 완성한다 
		
	}//SutdaDeck기본생성자
	
	
	
	
	//Ex7_2 작성
	//배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random()사용)
	void shuffle() {
		for (int i = 0; i < 1000; i++) { 						 //***천번반복해서 랜덤1인덱스의 카드와 랜덤2인덱스의 카드를 교환한다
			int randIdx1 = (int)(Math.random() * cards.length); //***cards의 길이인 수 범위 안에서 랜덤한 정수 생성
			int randIdx2 = (int)(Math.random() * cards.length);
			SutdaCard tmp = cards[randIdx1];   
			cards[randIdx1] = cards[randIdx2];
			cards[randIdx2] = tmp;
		}
	}
	
	//배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
	SutdaCard pick(int index) {
		SutdaCard pickedCard = cards[index];
		return pickedCard;
	}
	
	//배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random()사용)
	SutdaCard pick() {
		int randIdx = (int)(Math.random() * cards.length);
		SutdaCard pickedCard = cards[randIdx];
		return pickedCard;
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

// info()대신 Object클래스의 toString()을 오버라이딩했다. 
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Ex7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
	}
}
