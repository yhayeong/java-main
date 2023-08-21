import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest8 {
	public static void main(String[] args) {
		
		int n=10;
		int m=n;
		
		int[] narr1 = {1,2,3,4};
//		int[] narr2 = narr1; //얕은복사

		int[] narr2 = new int[4];
		System.arraycopy(narr1, 0, narr2, 0, narr1.length); //깊은복사
		
		narr2[0] = 100;
		
		System.out.println("----원본 배열");
		for (int i = 0; i < narr1.length; i++) {
			System.out.print(narr1[i] + ",");
		}
		
		System.out.println("\n----복사한 배열");
		for (int i = 0; i < narr2.length; i++) {
			System.out.print(narr2[i] + ",");
		}
		System.out.println();
		
		
		
		//1. 얕은 복사(새 리모컨 만들기)
		//포인트 : int[] narr2 = narr1;는 배열요소들을 각각 복사한것이 아니라 narr1에 할당돼있던 주소값을 복사하는것이므로
		//narr2은 narr1과 똑같은 하나의 배열을 가리킨다. 
		
		
		
		
		
		//2. 깊은 복사(복제)
		//(1) System.arraycopy(원본배열, 시작포인트, 복사본배열, 시작포인트, 원본의몇번째인덱스까지복사);
		//(2) Arrays.copyOf
		//(3) 배열.clone()
		
		System.out.println("----배열.clone()으로 배열 복제하기");
		int[] sarr = {1,2,3,4,5};
//		int[] darr = sarr.clone();
		int[] darr = Arrays.copyOf(sarr, sarr.length); //Arrays.copyOf를 이용할 수도 있다.(사용빈도높)
		darr[0] = 1000;
		
		for (int i = 0; i < sarr.length; i++) {
			System.out.print(sarr[i] + ",");
		}
		System.out.println();
		
		for (int i = 0; i < darr.length; i++) {
			System.out.print(darr[i] + ",");
		}
		System.out.println();


	}

}
