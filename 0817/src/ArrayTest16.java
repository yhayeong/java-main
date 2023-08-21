import java.util.Scanner;

public class ArrayTest16 {

	public static void main(String[] args) {
		
		
		//정올 파스칼삼각형 문제 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정방행렬의 크기 : "); //5입력시 5x5행렬을 생성
		int size = sc.nextInt();
		int[][] matrix = new int[size][size];
		
		
		matrix[0][0] = 1;
		
		
		//파스칼 코드작성(바로 위와 바로 위의 왼쪽 값을 더한 값을 저장)
		//1행0열부터 시작해야함
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j <= i; j++) { 
				
				//matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1]; //각행의 0열은 왼쪽요소가 없으므로 에러
				
				//j=0일때, 즉 0열에 대한 것은 위의 값만 넣고 왼쪽꺼는 넣지 않아야함
				matrix[i][j] = matrix[i-1][j];
				if(j>0) matrix[i][j] += matrix[i-1][j-1];
			
			}
		}
		
		
		
		//출력문
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <=i; j++) {
				
				System.out.print(String.format("%-4d", matrix[i][j]));
			}
			System.out.println();
		}
		
		
		
		
		
		
	}

}
