
public class Ex4 {

	public static void main(String[] args) {

		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }
		, { 30, 30, 30, 30, 30, 33} };
		int total = 0;
		float average = 0;
		
		//만일 가변배열이라면 평균을 구하기 위해 쓸 값도 따로 집계해주어야한다.
		int count = 0; //칸의 개수를 누적시킬 변수
		
		
		for(int i=0; i<arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
					
			}
			count += arr[i].length; //각 행마다 열의 개수를 누적한다
		}
		
//		average = (float)total / (arr.length * arr[0].length);
		average = (float)total / count; 
		
		
		System.out.println("total=" + total);
		System.out.println("average=" + average);
		
		
		
		
		
		
		
		

	}

}
