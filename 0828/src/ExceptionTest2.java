
public class ExceptionTest2 {
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50,60};
		int[] arr2 = {2,4,6,0,10};
		
		try {
			for (int i = 0; i < arr1.length; i++) {
				System.out.print(arr1[i]/arr2[i]); //0로 나누는 회차 때문에 예외발생
			}
		} catch (ArithmeticException e) {
			System.out.println("--------------------");
			e.printStackTrace(); 					//->java.lang.ArithmeticException: / by zero
			System.out.println("--------------------");
			System.out.println(e.getMessage()); 	//-> / by zero
		}
		System.out.println("종료");
		
		System.out.println("==================================================");
		
		
		
		//0으로 나누기때문에 발생하는 에러를 '어떻게'처리할것인가 - 그 회차를 제외할것인가(아래) 아예 종료할것인가(위의경우)
		
		//전자
		int tot = 0;	//-> sum(arr1[i]/arr2[i])
		double avg = 0; //-> tot/개수
		int count = arr1.length;
		
		for (int i = 0; i < arr1.length; i++) {
			
			try {
				tot += arr1[i] / arr2[i];
				
			} catch (ArithmeticException e) {
				count--; //avg를 구하기 위해 나눌 수 '카운트'에서 예외가 발생한 경우는 빼주는 처리
			} catch (ArrayIndexOutOfBoundsException e) {
				count--;
			}	
//			  catch (RuntimeException e) { //발생한 예외들의 처리가 동일할 경우 부모예외로 한번에 처리(그러나 예외별로 분리하여 적절한 처리를 해주는것이 좋다)
//				count--;
//			}
			
		}
		System.out.println(tot);
		System.out.println(tot/(double)count);
		System.out.println("프로그램 종료");
		
		
		
		
	}//main
	
	//보통 try안의 try-catch보다는 catch안의 try-catch가 많음
	//catch로 받았는데 거기서 또 예외 발생가능성을 고려하여 처리
	

}
