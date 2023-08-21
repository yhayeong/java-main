
public class ArrayTest5 {
	
	public static void main(String[] args) {
		
		//3행4열의 2차원배열 선언하기
		int[][] narr2 = new int[][] {
			{1,2,3,4}, {5,6,7,8}, {9,10,11,12}
		};
		
		
		int[][] narr3 = new int[3][4]; //2차원배열
		int[][] narr4 = new int[3][];	//가변배열
		
		System.out.println(narr3[0].length);
//		System.out.println(narr4[0].length); //npe(안쪽배열이 할당이 되지 않았으므로 null로 초기화된 상태라서 참조시 npe)
		
		
		narr4[0] = new int[] {1,2,3,4,5};
		narr4[1] = new int[] {10,20};
		
		System.out.println(narr4[0].length);
//		System.out.println(narr4[2].length); //npe
		
		
	}

}
