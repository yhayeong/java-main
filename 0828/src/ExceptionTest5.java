
public class ExceptionTest5 {
	
	public static void main(String[] args) {
//		String nstr = "123o";
//		int n = Integer.parseInt(nstr); //java.lang.NumberFormatException
		
		
		String nstr = "123o";
		try {
			int n = Integer.parseInt(nstr); 
		} catch (NumberFormatException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("종료");
		
	}

}
