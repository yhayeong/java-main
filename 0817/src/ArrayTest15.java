import java.util.Scanner;

public class ArrayTest15 {

	public static void main(String[] args) {
		
		/*
		 입력 데이터 수 : 5
		 95
		 .
		 ㅡ
		 ㅡ
		 ㅡ
		 
		 출력
		 최소값 : 60
		 최대값 : 100
		 */
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("입력 데이터 수 : ");
//		int cnt = sc.nextInt();
//		int min = 0, max = 0;
//		
//		
//		for (int i = 0; i < cnt; i++) {
//			
//			int input = sc.nextInt();
//			if(i==0) {//첫입력값을 min,max에 일단 저장
//				min = input;
//				max = input;
//			}
//			if(input<min) min=input; //비교 후 갱신
//			if(input>max) max=input;
//			
//		}
//		
//		System.out.println("최대값 : " + max);
//		System.out.println("최소값 : " + min);
//		
//		sc.close();
		
		
		
		//-----------------------------------------배열을 이용할 필요가 없지만 배열을 이용하는 경우
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 데이터 수 : ");
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		
		//입력값을 배열에 저장
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int min = arr[0];
		int max = arr[0];
		
		
		//최대,최소값 찾기
		for (int i = 1; i < arr.length; i++) {
			
			if(arr[i]<min) min = arr[i];
			if(arr[i]>max) max = arr[i];
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		sc.close();

	}
	
	

}
