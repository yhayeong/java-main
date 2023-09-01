import java.io.File;

public class FileTest1 {
	public static void main(String[] args) {
		File file1 = new File("C:\\yhy\\filename1.txt");
		File file2 = new File("C:\\yhy", "filename2.txt");
		System.out.println(file1.getName()); 		//filename1.txt
		System.out.println(file1.getAbsolutePath()); //C:\yhy\filename1.txt
		System.out.println(file1.getPath()); 		  //C:\yhy\filename1.txt
		
		
		System.out.println(File.pathSeparator); 
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		//출력결과 순서대로 ; ; \ \
		
	}
}
