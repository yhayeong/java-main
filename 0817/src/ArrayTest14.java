import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayTest14 {

	public static void main(String[] args) {

		/*
			입력 데이터 수 : 5
			95
			100
			85
			77
			60
			
			출력(오름차순 정렬)
			60 77 85 95 100
		 */
		
		
		
		
		
		//입력 수를 받아서 그 크기만큼의 배열을 만드는것
		//배열크기만큼 반복하여 입력받아서 저장한다
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 데이터 수 : ");
		int size = sc.nextInt();
		
		
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = sc.nextInt();
		}
		
		
		
		//정렬 수행
		//(1)순차 정렬(1인덱스에 해당하는 값부터 왼쪽것들과 비교하고 자기가 더 작으면 교환)
//		for (int i = 1; i < arr.length; i++) {
//			for (int j = 0; j < i; j++) {
//				
//				int tmp = 0;
//				if(arr[i]<arr[j]) { //부등호를 반대로하면 내림차순
//					tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
//				}
//			}
//		}
		
		

		
		//(2)버블정렬(역삼각형모양)
		for (int i = 0; i < arr.length-1; i++) { //회차
			
			for (int j = 0; j < arr.length-i-1; j++) { //맨 끝에꺼는 오른쪽값이 없으므로 비교수행x
				
				//현재값보다 오른쪽이 더 작으면 교환(맨끝에 최대값이 남게 됨)
				int temp = 0;
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			} 

		
		}
		
		
		
		
		//***정렬 알고리즘 중 가장 잘 쓰이는 것은 퀵 정렬이지만 어렵다
		
		
		
		
		
		//출력부
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		
		
		
		
		
	}

}
