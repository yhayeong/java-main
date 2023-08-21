import java.util.Scanner;

public class ArrayTest12_Answer {

	public static void main(String[] args) { //선생님 코드


		/* 학생 3명의 국어, 영어, 수학 점수를 입력받아 학생별 총점과 과목별 평균을 아래와 같이 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력부
		 * <1번째 학생의 점수>
		 * 국어 : 95
		 * 영어 : 100
		 * 수학 : 88
		 * <2번째 ``>
		 * 생략
		 * <3번째>
		 * 생략
		 * 
		 * 
		 * 
		 *  출력부
		 *  	국어 영어 수학 총점
		 *  1번  95  100  88  283
		 *  2번
		 *  3번 
		 *  평균 82  86   89   (빈칸)
		 *  */
		
		
		
		Scanner sc = new Scanner(System.in);
		String[] subject = {"국어", "영어", "수학"};
		int[][] scores = new int[4][4]; 

		
		//입력부
		for (int i = 0; i < scores.length-1; i++) { //i번째 학생
			System.out.println(String.format("<%d번째 학생의 점수>", i+1));
			
			
			for (int j = 0; j < scores[i].length-1; j++) { //국,영,수
				
				System.out.print(String.format("%s:", subject[j]));
				
				scores[i][j] = sc.nextInt();
				scores[i][scores[i].length-1] += scores[i][j]; //각 행의 끝 열에는 (해당 행의 앞의 값들을)누적해준다
				scores[scores.length-1][j] += scores[i][j]; //마지막행의 각 열에는 평균값을 넣어야한다. 일단 누적해두기

			}
			
			

			
			
		}//바깥for문
		
		//과목별 평균이 저장돼야하는 마지막 행의 경우 각 열에 평균값을 덮어씌워준다
		for(int i=0; i<scores[0].length-1; i++) {
			scores[scores.length-1][i] /= 3; //각 열에 원래가진값(총합)을 3으로 나눈 값으로 덮어씌운다
		}

		
		
		//출력부
		//배열을 출력한다
		System.out.println("\t국어\t영어\t수학\t총점");
		for (int i = 0; i < scores.length; i++) {
			
			if(i==scores.length-1) System.out.print("평균\t");
			else System.out.print(i+1+"번\t");
			
			for (int j = 0; j < scores[i].length; j++) {
				
				if(scores[i][j]!=0) {
					System.out.print(scores[i][j]);
				}
				System.out.print("\t");
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
