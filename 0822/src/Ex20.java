public class Ex20 {

	static int[] shuffle(int[] arr) {
		
		//응용-복제하여 섞기
//		int[] newArr = arr.clone();
		int[] newArr = new int[arr.length];
		System.arraycopy(arr, 0, newArr, 0, arr.length); //원본 배열, 시작점, 사본 배열, 시작점, 길이

		for (int i = 0; i < 100; i++) {
			int index1 = (int)(Math.random() * newArr.length); //arr.length는 9이고 결과는 0~8까지 나올것
			int index2 = (int)(Math.random() * newArr.length);
			int temp = newArr[index1];
			newArr[index1] = newArr[index2];
			newArr[index2] = temp;
		}
		return newArr;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original); //shuffle은 스태틱메소드 안에서 사용되고 있으므로 인스턴스메소드일수 없고 스태틱메소드여야함
		System.out.println(java.util.Arrays.toString(result));
		
		//배열이 같은 주소값을 비교(원본을 섞었는지 여부)
		System.out.println(original == result);
	}

}
