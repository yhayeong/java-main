import java.util.Scanner;

public class TotTest2 {
	
	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		
		int select = 0; //입력받은 메뉴번호
		int input = 0; //받은 금액
		
		int[] coinUnit = {5000, 1000, 500}; //동전통
		int[] price = {1500, 2500, 2500, 2000, 3000}; //메뉴별 가격
		int coinNum = 0; //동전개수
		
		String[] menu = {"아메리카노", "카페라떼", "카푸치노", "에스프레소", "카페모카"};
		
		int[] order = new int[10]; //넉넉하게 주문번호가 저장될 배열을 만듦 (1,2,3,4,5 같은 메뉴번호들이 저장된다)
		int ordCnt = 0; //주문메뉴 수
	
		
	
		while(true) {
			
			System.out.println("┏━━━━━코스타 카페━━━━┓");
			for (int i = 0; i < menu.length; i++) {
				System.out.println(String.format("%d. %s(%d원)", i+1, menu[i], price[i]));
			}
			System.out.println("┗━━0. 계산━━━━━━━━━━┛"); //계산하기로 바꿈
			System.out.print("*메뉴 번호 선택 > ");
			
			select = sc.nextInt();

			
			
			
			//계산하기 선택시(계산하기 선택하지 않은 경우는 계속 메뉴를 보여주고 입력받음)
			if(select == 0) { 
				
				int totalPrice = 0;
				
				//1. 주문내역 보여주기 
				System.out.println("=====주문내역=====");
				
				for (int i = 0; i < ordCnt; i++) {
					System.out.print( menu[order[i]-1] + ", "); //1,3,5저장된메뉴번호 -> 0,2,4인덱스 메뉴
					totalPrice += price[order[i]-1]; 
				}
				System.out.println();
				
				
				//2. 돈 받기 
				System.out.print("*돈을 넣어주세요 > ");
				input = sc.nextInt();
				
				
				
				//3. 적게 내면 안내문 출력 
				if(input<totalPrice) {
					System.out.println("돈이 부족합니다.");
					
					
				} else {
					//4. 맞게 내면 잔돈 주기
					int change = totalPrice-input;
					System.out.println("받으실 잔돈은 " + change + "입니다.");
					
					for (int i = 0; i < coinUnit.length; i++) {
						if(change/coinUnit[i]!=0) {
							System.out.println(String.format("%d원(%d개) ", coinUnit[i], change/coinUnit[i]));
						}
						change %= coinUnit[i];
					}
					break; //계산 끝나면 프로그램 종료(무한반복이 종료되는 유일한 경로)
					
				}

			}//if계산하기
			
			
			order[ordCnt++] = select;
			
			
		}//while
			
			
	} //main
		


} //class
