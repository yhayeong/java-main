package esc;

public class ArrayEx1 {

	public static void main(String[] args) {

		// 5-1.

		int[] arr1[]; //2차원 배열 선언 이렇게도 가능
		int[] arr2 = {1,2,3,}; //마지막의 쉼표 ','는 있어도 상관없다...?
		
		System.out.println(arr2.length); //3
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ",");
		}
		
		
		
//		int[] arr3 = new int[5];
//		int[] arr4 = new int[5]{1,2,3,4,5};
//		int arr5[5];
//		int[] arr6[] = new int[3][];

		
		
		
		
		
		// 5-2. arrr[3].length의 값

		int[][] arrr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10 }, { 20, 20, 20, 20 }, { 30, 30 } // <<<<<<<<<<<<<<<arrr[3]
		};

		System.out.println(arrr[3].length); // 2

		
		
		
		
		
		// 5-3.
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		System.out.println("sum=" + sum);

		
		
		
		
		
		// 5-4. 2차원 배열 arry에 담긴 모든 값의 총합과 평균 ***

		int[][] arry = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };

		int total = 0;
		float average = 0;

		for (int i = 0; i < arry.length; i++) {

			for (int j = 0; j < arry[i].length; j++) {
				total += arry[i][j];
			}
		}
		

//		average = (float) total / arry.length +

		System.out.println("total=" + total);
//		System.out.println("average="+average);

		
		
		
		
		
		
		
		
		// 5-5. 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는
		
		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ball3 = new int[3];
		
		
		// 배열 ballArr의 임의의 요소 2개를 골라서 위치를 바꾼다. 20번 반복
		
		for (int x = 0; x < 20; x++) {
			int i = (int) (Math.random() * ballArr.length); //랜덤한인덱스넘버 0~배열길이-1
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;

			 tmp = ballArr[i];
			 ballArr[i] = ballArr[j];
			 ballArr[j] = tmp;
			 
		}
		
		
		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		
		for(int i=0; i<ball3.length; i++) {
			ball3[i] = ballArr[i];
		}
		
		
		
		for (int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i] + ",");
		}
		System.out.println();

		
		
		//5-6.
		//850을 500원으로 나눠서 몫이 1임을 확인한다 그것은 500원짜리의 개수
		//500원을 뺀 나머지 거스름돈 350원을 100원으로 나누면 그 몫은 100원짜리 개수
		//즉 몫(해당동전개수)과 남은잔돈을 이용하면서 남은돈이 0이 되면 끝내기
		//반복문을 이용하기 위해 500,100,50,10을 배열에 넣은것임.
		
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money="+money); 
		
		int cnt = 0;
		
		for(int i=0; i<coinUnit.length; i++) {
			if(money > coinUnit[i]) {
				cnt = money / coinUnit[i]; 	//500, 100, 50, 10원짜리 동전개수	
				money -= coinUnit[i] * cnt; //남은 잔돈
				System.out.println(coinUnit[i] + "원 : " + cnt);
			} 
			
		}
		
		
		
	}

}
