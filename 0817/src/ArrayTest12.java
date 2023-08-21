import java.util.Iterator;
import java.util.Scanner;

public class ArrayTest12 {

	public static void main(String[] args) { //정올 문제 혼자 풀었을때
		

		
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
		

		int[][] scores = new int[4][4]; 
		String[] subject = {"국어", "영어", "수학"};
		int avg = 0;
		
		//저장시키는 입력부
		for (int i = 0; i < 3; i++) { //i번째 학생
			System.out.println(String.format("<%d번째 학생의 점수>", i+1));
			
			
			for (int j = 0; j < 3; j++) { //국,영,수
				
				System.out.print(String.format("%s:", subject[j]));
				
				scores[i][j] = sc.nextInt();
				scores[i][scores[i].length-1] += scores[i][j]; //각 행의 끝 열에는 (해당 행의 앞의 값들을)누적해준다
				scores[scores.length-1][j] += scores[i][j]; //마지막행의 각 열에는 평균값을 넣어야한다. 일단 누적해두기
			}
		}
		
		//배열의 마지막행의 각 열을 평균값으로 수정하기->새로운 반복문
		//
		
		
		
		
		
		//출력부
		//배열을 출력한다
		for (int i = 0; i < scores.length; i++) {
			
			if(i<scores.length-1) System.out.print(String.format("%d번\t", i+1));
			else System.out.print("평균");
			
			for (int j = 0; j < scores[0].length; j++) {
				
				System.out.print(String.format("%d", scores[i][j]));
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		/* ArrayTest7참고.. 
		 for (int i = 0; i < narr.length; i++) {
			
			for (int j = 0; j < narr[i].length; j++) {
				
				narr2[i][j] = narr[i][j]; //복사
				narr2[i][narr2[i].length-1] += narr2[i][j]; //narr2의 각행의 마지막 열에는 누적해준다(sum변수에 담지 않고 바로 누적해줌)
				narr2[narr2.length-1][j] += narr2[i][j];
				
				narr2[narr2.length-1][narr2[i].length-1] += narr2[i][j]; // 맨 끝칸에는 모든 칸을 누적시킨다*
				
			}
//			narr2[narr2.length-1][narr2[i].length-1] += narr2[i][narr2[i].length-1]; //이렇게도 됨*
		}
		
		 * */
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
	}

}
