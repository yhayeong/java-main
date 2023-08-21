import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("거스름돈 : ");
		int money = sc.nextInt();
		
		System.out.println("money=" + money);
		
		int[] coinUnit = { 500, 100, 50, 10 }; // 동전의 단위
		int[] coin = { 5, 5, 5, 5 }; // 단위별 동전의 개수
		
		for (int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0; //각 동전을 몇개를 줄 것인지가 저장됨

			
			coinNum = money / coinUnit[i];
			
			if(coin[i] >= coinNum) { //갖고있는 동전 개수로 충분할때는
				coin[i] -= coinNum;   //남은 동전 수 : 줘야하는 개수를 빼준다
			} else { 
				coinNum = coin[i]; 	//개수가 모자란 경우에는 줄 개수는 갖고있는 동전 개수가 되고
				coin[i] = 0;		//남은 동전 수는 0으로 갱신한다
			}
			
			//삼항연산자 사용시
//			coinNum = money / coinUnit[i] < coin[i]? money/coinUnit[i] : coin[i];
			
			money -= coinUnit[i] * coinNum; //남은 금액 계속 갱신
			
			
			System.out.println(coinUnit[i] + "원: " + coinNum + "개");
		}
		
		if (money > 0) { //갖고 있는 10원짜리까지 전부 주고도 줄 금액이 남아있으면
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0); // 프로그램을 종료한다.
		}
		
		System.out.println("=남은 동전의 개수 =");
		
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원:" + coin[i]);
		}

	}

}
