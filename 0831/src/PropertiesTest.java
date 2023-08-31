import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {

		// 파일입출력 스트림 개념을 함께 학습

		//<1> 파일 생성하기

		Properties prop = new Properties();
		prop.setProperty("name", "hong gil dong");
		prop.setProperty("age", "30");
		prop.setProperty("height", "178.5");
		prop.setProperty("weight", "77");

		try {
			prop.store(new FileOutputStream("profile.properties"), "profileeee");
			System.out.println("파일생성 완료");

			prop.storeToXML(new FileOutputStream("profile.xml"), "profileeee");
			System.out.println("파일생성 완료...");

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//<2> 파일 읽어오기

		Properties prop1 = new Properties();
		Properties prop2 = new Properties();
		Properties prop3 = new Properties();

		try {
			prop1.load(new FileInputStream("profile.properties"));
			prop2.loadFromXML(new FileInputStream("profile.xml"));
			prop3.load(new FileInputStream("setting.txt"));
			System.out.println(prop1);
			System.out.println(prop2);
			System.out.println(prop3);

			System.out.println("------------");
			System.out.println(prop3.getProperty("title")); // news
			System.out.println(prop3.getProperty("content")); // economic

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// main
}
