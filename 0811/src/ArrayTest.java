
public class ArrayTest {

	public static void main(String[] args) {

		//배열의 초기화 방법들
		
		int[] narr = new int[] {1,2,3,4,5}; 

		int[] narr2 = {1,2,3,4,5}; 
		
		int[] narr1;
		narr1 = new int[] {1,2,3,4,5}; 
		
		
		
//		int[] narr3;
//		narr3 = {1,2,3,4,5};
		//이건 안된다 (배열 선언문과 초기화문을 따로 쓰려면 new를 생략할 수 없다는 것)
	
		
		
		
		
		
		
		
		//로또 번호 랜덤 뽑기
		int[] ball = new int[45];
		
		for(int i=0; i<45; i++) {
			ball[i] = i + 1; //1부터 45까지를 순서대로 저장하기
		}
		
		
		//배열의 첫번째 요소와 임의의인덱스 요소를 서로 교환하면서 섞는다
		for(int i=0; i<1000; i++) {
			
			int idx1 = (int)(Math.random() * 45); //0~44 사이의 랜덤한 인덱스 넘버를 사용하기 위함
			int idx2 = (int)(Math.random() * 45); 
			
			int temp = ball[idx1];
			ball[idx1] = ball[idx2];
			ball[idx2] = temp;

		}
		
		for(int i=0; i<6; i++) {
		
			System.out.print(ball[i]);
			
			if(i!=5) System.out.print(", ");
			
		}
		
		
	
		
		
		
		
		//0.0 <= Math.random() < 1.0
		//0.0 * 45 <= Math.random() *45 < 1.0 * 45
		//0 <= (int) (Math.random() *45) < 45
		
		
		
		
		

		
		
		
		
		
		
		
		
	}

}
