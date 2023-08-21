
public class ArrayTest13 {

	public static void main(String[] args) {
		
		//정올 <4>배열2-자가진단7 #570 문제
		
	
		int[][] arr = new int[5][5];
		
		//0행의 모든 열은 1로 초기화
		for (int i = 0; i < arr[0].length; i++) {
			
			arr[0][i] = 1;
			
			//각 행의 0열은 모두 1로 초기화
			arr[i][0] = 1;
		}
		
		
		
		//1행1열부터
		//각 칸에는 왼쪽칸의값+윗칸의값을 저장한다
		for (int i=1;  i<arr.length; i++) {
			
			
			for (int j = 1; j < arr[i].length; j++) {
				
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
			
		}
		
		
		//출력부
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		System.out.println("-------------------------------------");
		//다른 풀이법 : 출력하지 않을, 왼쪽으로 한 열을 추가하면 첫행 제외 1행부터는 0열의 값이 0으로 초기화되어있을것임 이것을 이용한다
		
		//1. 5x6 배열 생성
		int[][] arr2 = new int[5][6];
		
		//2. 0행을 1로 초기화한다
		for (int i = 0; i < arr2[0].length; i++) {
			arr2[0][i] = 1;
		}
		
		//3. 1행1열부터는 규칙을 적용하여 값을 저장한다
		for (int i = 1; i < arr2.length; i++) {
			for (int j = 1; j < arr2[i].length; j++) {
				arr2[i][j] = arr2[i][j-1] + arr2[i-1][j];
			}
		}
		
		//4. 0열을 제외하고 출력한다
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 1; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
		

	}

}
