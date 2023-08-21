
public class Ex9 {

	public static void main(String[] args) {

		char[][] star = { { '*', '*', ' ', ' ', ' ' }, 
							{ '*', '*', ' ', ' ', ' ' }, 
							{ '*', '*', '*', '*', '*' },
							{ '*', '*', '*', '*', '*' } }; //4행 5열
		
		
		//90도 회전시
//		0,0 -> 0,3 
//		0,1 -> 1,3
//		0,2 -> 2,3
//		0,3 -> 3,3
//		
//		1,0 -> 0,2 
//		1,1 -> 1,2
//		1,2 -> 2,2
//		1,3 -> 3,2
//		
//		패턴 찾기
		//행은 기존배열의 열 -> result[j][] = star[][j]
		//열은 3-행 -> 기존배열의 행의 길이-1  - 새배열의 행의 길이 -> result[][star.length-1 -i] = star[i][]
		

		
		
		
		char[][] result = new char[star[0].length][star.length]; //5행 4열의 새 배열
		
		//기존배열 출력
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		//새 배열
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				/*
				 * (1) 알맞은 코드를 넣어 완성하시오.
				 */
				
//				result[j][3-i] = star[i][j];
				result[j][star.length-1 -i] = star[i][j];
				
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}

}
