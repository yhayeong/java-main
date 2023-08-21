public class ArrayTest6 {

	public static void main(String[] args) {
		
		int[][] narr = {
				{10,20,30,40},
				{50,60,70,80},
				{90,100,110,120, 9}
		};
		
		//배열의 모든 요소의 합을 구하기
		
		int sum = 0;

		
		for (int i = 0; i < narr.length; i++) {
			
			for (int j = 0; j < narr[i].length; j++) {
				
				sum += narr[i][j];
			}
		}
		System.out.println(sum); //789
		
		
		

		
		
		
		
		
		
		
		
	}

}
