import java.io.File;

public class FileTest2 {
	public static void main(String[] args) {
		File f = new File("C:\\yhy\\java_workspace\\java-main\\0831");
		if(!f.exists() || !f.isDirectory()) return; //경로가 존재하지 않거나 경로가 아니라면 리턴
		
		
		//(1) 폴더 아래의 모든 디렉토리와 파일을 다 '문자열로' 가져온다
//		String[] files = f.list();
//		for(String file : files) {
//			System.out.println(file); 
//		}
		
		
		//(2) 파일객체로 생성해서 가져온다
		File[] files = f.listFiles();
		
		int totLength = 0;
		
		for (File file : files) {
			
			totLength += file.length();
			
//			if(file.isDirectory()) {
//				System.out.println("[" + file.getName() + "]"); //디렉토리는 대괄호 붙여서 출력하도록
//			} else {
//				System.out.println(file.getName());
//			}
			
			//한줄로 축약
			System.out.println(file.isDirectory()? "["+file.getName()+"]": file.getName());
		}
		
		System.out.println(totLength);
		
		
		
		
	}
}
