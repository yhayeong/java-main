
public class Ex11 {

	public static void main(String[] args) {

		int[][] score = { { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 } };
		int[][] result = new int[score.length+1][score[0].length+1];
		
		for (int i = 0; i < score.length; i++) {
			
			for (int j = 0; j < score[i].length; j++) {
				/*
				 * (1) 알맞은 코드를 넣어 완성하시오.
				 */
				result[i][j] = score[i][j];
				
				////각행의 마지막 열
				result[i][result[i].length-1] += score[i][j]; 
				
				//새로운 배열의 마지막행
				result[result.length-1][j] += score[i][j];
				
				//맨끝칸
				
				
			}
		}
		
		
		//출력
		for (int i = 0; i < result.length; i++) {
			
			for (int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}

	}

}
