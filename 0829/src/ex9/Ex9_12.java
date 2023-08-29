package ex9;

public class Ex9_12 {
	
	/* 참고
	 		
		<구간 안에서의 랜덤한 정수값을 구하는 공식>
		
		ex. 2~8 사이:
		int r = (int) (Math.random() * (8-2+1)+2); 
		System.out.println(r);
		
		일반화:
		(int) (Math.random()*(큰-작+1))+작
		구간의 min, max를 작, 큰에 넣음
		
	 */
	
	
	public static int getRand(int from, int to) {
		
		//(1)
//		if(from>to) {
//			int tmp = from;
//			from = to;
//			to = tmp;
//		}
//		return (int) ( Math.random()* (to-from+1) ) + from;
		
		//(2)
//		int min = Math.min(from, to);
//		int max = Math.max(from, to);
//		return (int) ( Math.random()* (max-min+1) ) + min;
		
		//(3)
		return (int) ( Math.random()* (Math.abs(from-to)+1) ) + Math.min(from, to);
		
	}
	
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) { //스무번 반복하여 인자로 전달하는 from~to 구간에서 랜덤값을 반환시킨다
			System.out.print(getRand(1, -3)+",");
		}

		
	}//main

}

//문제-출력
//0,-1,1,0,-2,-2,1,1,-3,0,-1,1,1,1,0,-1,1,0,-1,-3,
