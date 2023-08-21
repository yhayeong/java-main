
public class ArrayTest2 {

	public static void main(String[] args) {

		
		//로또 다른방식 : 서로 다른 값으로만 6개 (1~45사이의 정수) 채워지도록 만들기
		
		//***로직 설계 : 6배열을 만들어서 뽑힌랜덤수를 넣는다. 그런데 뽑은수가 기존에 넣은 수들 중 같은 수가 있다면 저장하지 않는다.
		
		
		int[] ball = new int[6];
		int cnt = 0; //선택된 볼의 개수
		boolean isSame = false;
		
		
		while(true) {
			
			isSame = false;
			
			int randBall = (int) (Math.random()*45) +1; //1~45 사이의 랜덤한 수

			
			//그동안 쌓인 배열의 요소 하나하나를 randBall과 같은지 비교하여 같은수가 있다면 빠져나와 계속 while문 수행
			for(int i=0; i<cnt; i++) {
				
				if(ball[i] == randBall) {
					isSame = true;
					break;
				}
			} 
			
			if(isSame == false) { // 두 수가 같지 않다면 랜덤수를 저장
				ball[cnt++] = randBall;
			}
			if(cnt==6) break;
			
		}
		
		for(int i=0; i<ball.length; i++) {
			System.out.print(ball[i] + ",");
		}
		 
		
		
		
		
	}

}
