import java.util.Scanner;

public class TotTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int select = 0; //입력받은 메뉴번호
		int input = 0; //받은 금액
		int[] coinUnit = new int[] {5000, 1000, 500}; //동전통
		int[] price = {1500, 2500, 2500, 2000, 3000}; //메뉴별 가격
		int coinNum = 0; //동전개수
		
		
		while(true) {
			
			System.out.println("┏━━━━━코스타 카페━━━━┓");
			System.out.println("1. 아메리카노(1500원)");
			System.out.println("2. 카페라떼(2500원)");
			System.out.println("3. 카푸치노(2500원)");
			System.out.println("4. 에스프레소(2000원)");
			System.out.println("5. 카페모카(3000원)");
			System.out.println("┗━━0. 종료━━━━━━━━━━┛");
			System.out.print("*메뉴 번호 선택 > ");
			
			select = sc.nextInt();
			
			
			if(select == 0) break; 
			else if(!(1<=select && select<=5)) System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
			
			
			
			System.out.print("*돈을 넣어주세요 > ");
			input = sc.nextInt();
			
			
			if(input < price[select-1]) {System.out.println("돈이 부족합니다.");}
			
			else { //거스름돈이 발생하는 경우
				
				//거스름돈
				int change = input-price[select-1];
				
				for (int i = 0; i < coinUnit.length; i++) { //동전통을 확인
					
					if(change >= coinUnit[i]) {
						coinNum = change / coinUnit[i];
						change %= coinUnit[i];
//						change -= coinUnit[i] * coinNum; //거슬러줘야하는 잔액을 차감갱신
					} 
					
					System.out.print( coinUnit[i] + "(" + coinNum + ")");
					if(i<coinUnit.length-1) System.out.print(", ");
					
					
				}
				
//				break; //나가지 않으면 계산 후 주문을 다시 받는다.
			}
			System.out.println();
			
		}
		
		
		
		
		
		
		
		
		
		
		//1. 입금이 가격보다 작을 경우 : 돈이 부족합니다.
		//2. 제대로 입력시 잔돈을 500(1), 100(), 50(), 10() 이렇게 출력하고 프로그램 종료
		
		
		
		
		
		
		
		//-----------------------선생님 코드
//		while(true) {
//			
//			System.out.println("┏━━━━━코스타 카페━━━━┓");
//			System.out.println("1. 아메리카노(1500원)");
//			System.out.println("2. 카페라떼(2500원)");
//			System.out.println("3. 카푸치노(2500원)");
//			System.out.println("4. 에스프레소(2000원)");
//			System.out.println("5. 카페모카(3000원)");
//			System.out.println("┗━━0. 종료━━━━━━━━━━┛");
//			System.out.print("*메뉴 번호 선택 > ");
//			
//			select = sc.nextInt();
//			
//			
//			if(select == 0) break; 
//			else if(!(1<=select && select<=5)) System.out.println("없는 메뉴입니다. 다시 입력해주세요.");
//			
//			
//			
//			System.out.print("*돈을 넣어주세요 > ");
//			input = sc.nextInt();
//			
//			if(input<price[select-1]) {
//				System.out.println("돈이 부족합니다.");
//				continue; //뒤는 수행하지 않고 다음회차로 점프 (if-else로 하지 않고 if에서 걸리면 continue로 아예 뒷 코드를 전부 실행하지 않고 다음회차로 가게 할수있음)
//			}
//			
//			//거스름돈 출력부
//			int change = input - price[select-1]; 
//			System.out.println("잔돈은 총 " + change + "입니다.");
//			
//			
//			for(int i=0; i<coinUnit.length; i++) {
//				
//				coinNum = change/coinUnit[i];
//				
//				if(coinNum>0) System.out.print(String.format("%d(%d) ", coinUnit[i], coinNum)); //0개 거스르는 건 출력하지 않게
//				
//				change %= coinUnit[i]; //잔돈 금액 차감갱신
//			}
//			System.out.println();
//		
//		}
		
		
		
		
		
		
	}

}
