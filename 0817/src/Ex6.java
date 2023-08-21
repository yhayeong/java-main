
public class Ex6 {
	
	public static void main(String[] args) {
		
		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다. 
		int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money="+money); 
		
		int count = 0; //동전의 개수
		int change = 0; //줘야하는 금액
		
		for(int i=0;i<coinUnit.length;i++) {
			
			count = money / coinUnit[i];
//			money = money % coinUnit[i]; //남은 금액으로 갱신하여 저장
			money -= coinUnit[i] * count;
			
			System.out.print(coinUnit[i] + "원 : " + count);
			System.out.println("개");
		}
		
		
		
		
		
	}

}
