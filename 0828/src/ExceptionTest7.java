import java.io.File;

public class ExceptionTest7 {
	public static void main(String[] args) { //RunConfigurations의 Arguments에 넣은 값(text.txt)여기로 들어감
		File f = createFile(args[0]);
		System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
	}
	
	
	static File createFile(String fileName) {
		try {
			if(fileName==null || fileName.length()==0) {
				throw new Exception("파일 이름이 유효하지 않습니다.");
			}
		} catch (Exception e) {
			fileName = "temp.txt";
		} finally {
			File f = new File(fileName);
			createNewFile(f);
			return f;
		}
	}
	
	static void createNewFile(File f) {
		try {
			f.createNewFile();
		} catch (Exception e) {}
	}

}
