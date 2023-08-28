import java.io.IOException;

public class ExceptionTest6 {

	
	static void method1() throws IOException, Exception { //호출부로 예외처리를 위임하겠다
		
		boolean flag = true;
		if(flag) {
			throw new IOException("입출력 예외");
		} else {
			throw new Exception("모든 예외");
		}
	}
	
	public static void main(String[] args) { 
		try {
			method1(); 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("~언제나 수행하는 어떤 마무리 작업~");
		}
		
	}//main
}
