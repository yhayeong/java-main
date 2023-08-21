import java.util.Iterator;

public class ArrayTest7 {

	public static void main(String[] args) {
		
//		int[][] narr = {
//				{10,20,30,40},
//				{50,60,70,80},
//				{90,100,110,120}
//		};
//		
//		int[][] narr2 = new int[narr.length][narr[0].length+1];
//		
//		for (int i = 0; i < narr.length; i++) {
//			
//			for (int j = 0; j < narr[i].length; j++) {
//				
//				narr2[i][j] = narr[i][j]; //복사
//				narr2[i][narr2[i].length-1] += narr[i][j]; //narr2의 각행의 마지막 열에는 누적해준다(sum변수에 담지 않고 바로 누적해줌)
//			}
//		}
//		
//		
//		// 출력
//		for (int i = 0; i < narr2.length; i++) {
//			for (int j = 0;  j< narr2[i].length; j++) {
//				System.out.print(narr2[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		
		//------------------------------------------아래로도 한줄 확장
		
		int[][] narr = {
				{10,20,30,40},
				{50,60,70,80},
				{90,100,110,120}
		};
		
		int[][] narr2 = new int[narr.length+1][narr[0].length+1];
		
		for (int i = 0; i < narr.length; i++) {
			
			for (int j = 0; j < narr[i].length; j++) {
				
				narr2[i][j] = narr[i][j]; //복사
				narr2[i][narr2[i].length-1] += narr2[i][j]; //narr2의 각행의 마지막 열에는 누적해준다(sum변수에 담지 않고 바로 누적해줌)
				narr2[narr2.length-1][j] += narr2[i][j];
				
				narr2[narr2.length-1][narr2[i].length-1] += narr2[i][j]; // 맨 끝칸에는 모든 칸을 누적시킨다*
				
			}
//			narr2[narr2.length-1][narr2[i].length-1] += narr2[i][narr2[i].length-1]; //이렇게도 됨*
		}
		
		
		// 출력
		for (int i = 0; i < narr2.length; i++) {
			for (int j = 0;  j< narr2[i].length; j++) {
				System.out.print(narr2[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		

	}

}
