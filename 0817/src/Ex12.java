
public class Ex12 {
	
	public static void main(String[] args) {
		
		//3m짜리 우물의 바닥에 달팽이가 있다. 
		//달팽이는 낮동안 55cm를 올라올 수 있다.
		//하지만 날이 지면 잠을 자야 한다.
		//자는 동안 3cm를 미끄러져 내려온다.
		//달팽이가 우물 밖으로 나오는 데 몇 일이 걸릴까?
		//0일은 없고 잠을 안자도 하루로 치는 것에 주의, 반복문과 조건문을 이용하여 프로그램을 작성하시오
		
		
		int woomul = 300;
		int speed = 55 -3;
		int day = 0;
		

		while(true) {
			
			woomul -= speed;
			day++;
			
			if(woomul <= 0) {
				break;
			}
		}
		System.out.println("day : " + day); //6
		
		System.out.println("조금다르게===========================");
		
		while(true) {
			
			woomul = speed * day;
			
			if(woomul > 300) {
				break;
			}
			
			day++;
			
		}
		
		System.out.println("day : " + day); //6
		
		
		
		System.out.println("쌤 코드===========================");
		
		int depth  = 3*100, height = 0;//height:올라간 높이
		
		final int up = 55;
		final int down = 3;
		int days = 1; //0으로 초기화한다면 days++;한 다음에 if(depth <= height) break;체크해야한다 (순서 주의)
		
		while(true) {
			
			height += up;
			
			if(depth <= height) break;
			days++;
			
			height -= down;
			
		}
		System.out.println("days : " + days); //6
		
		
		
	}

}
