import java.util.Scanner;

public class ArrayTest11 {
	
	public static void main(String[] args) {
		
		
		/* 100미만의 양의정수들이 주어진다.
		 * 입력받다가 0이 입력되면 마지막에 입력된 0을 제외하고
		 * 그때까지 입력된 정수의 십의 자리 숫자가 0~9 각각 몇개인지
		 * 작은 수부터 출력하는 프로그램을 작성하시오(10의 자리가 0개인 숫자는 출력하지 않는다.)
		 * 
		 * 입력 : 10 55 3 63 85 61 85 0(종료)
		 * 출력 : 
		 * 0 : 1개
		 * 1 : 1개
		 * 5 : 1개
		 * 6 : 2개
		 * 8 : 2개
		 * */

		
		
		
		//개수를 저장할 배열
		int[] cnt = new int[10]; //예를 들어 10입력시 cnt[1]++되고 3입력시 cnt[0]++되고 61입력시 cnt[6]++ 된다
		int inputNum = 0;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("100 미만의 양의 정수를 반복 입력(종료:0) : ");
		
		
		while(true) {
			
			inputNum = sc.nextInt();
			
			if(inputNum == 0) {
				break;
				
			} else {
				
				int x = inputNum / 10;
				cnt[x]++;
				
			}
		}
		
		
		
		//출력부
		for (int i = 0; i < cnt.length; i++) {
			
			if(cnt[i]>0) System.out.println(String.format("%d : %d개", i, cnt[i]));
		}
		
		
		
	}//main

}
