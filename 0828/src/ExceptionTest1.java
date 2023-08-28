
public class ExceptionTest1 {
	public static void main(String[] args) {
//		String str = null; //1
		String str = "";	//2
		System.out.println(str.toString()); 
		//1의 경우 NPE 발생하고(객체가 생성돼있지않는(null)인 str이 toString호출못함) 
		//2의 경우 발생하지 않음(객체는 생성돼있지만 그안에 null밖에 없는것)
	
		
		
	
	/* cf. null과 ""은 메모리 구조가 다르다
	 ""는 힙에 들어가지 않음
	 모든 문자열은 끝에 null을 갖고있고, null을 만날때까지 읽는것임..즉 'a'는 a만 들어가겠지만 "a"는 a와 null을 가지는것
	 그래서 ""는 str은 주소값을 갖고있고, str이 가리키는 주소로 가면 null이 있는것
	 반면 null로 초기화된 str에 주소값이 담겨있는 게 아니라 아예 null인것
	 str을 null로 초기화하게되면, NPE발생가능성이 높아지므로 보통 문자열은 ""로 초기화한다
	 */

		
		
	System.out.println("=======================");
	
	String str2 = null;
	try {
		System.out.println(str2.toString());
	} catch (NullPointerException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println("null입니다.");
	}
	System.out.println("종료");

	
	
	System.out.println("======================");
	
	String str3 = "hong";
	int[] arr = new int[5];
	try {
		System.out.println(str.toString());
		for (int i = 0; i <= arr.length; i++) { //cf. <=가 아니라 <여야 에러 안남
			arr[i] = i*10;
		}
	} catch (NullPointerException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	} catch (ArrayIndexOutOfBoundsException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	System.out.println("종료");
	
	
	
	}//main
}
