import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest1 {
	public static void main(String[] args) {
		
		//데이터가 문자단위일때는 문자기반 입출력스트림인 FileReader, FileWriter를 쓰는 것이 훨씬 유리하다
		FileReader fr = null;
		
		//성능을 좋게하기위해 보조스트림 장착
		BufferedReader br = null;
		
		try {
			fr = new FileReader("SocialNews.txt"); //스트림을 생성하여 인자로 넣는 파일에 스트림을 꽂는다
			br = new BufferedReader(fr);
			
			int data;
			//<콘솔에 출력하기>
			//조건식: 읽어서 data에 담고 그게 -1이 아니라면 -> data를 출력해라 
//			while( (data=fr.read()) != -1 ) System.out.print( data ); //한글문자가 제대로 출력되지 않음
//			while( (data=fr.read()) != -1 ) System.out.print( (char) data ); //한글문자가 제대로 출력됨
			
			while( (data=br.read()) != -1 ) System.out.print( (char) data ); //보조스트림장착한 스트림생성하여 사용
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(fr!=null) fr.close();
				if(br!=null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}//main

}

//FileReader: 파일 읽기
//FileWriter: 저장하기(파일복사하기) (자바프로그램 입장에서의 출력에 해당)
//콘솔에 출력하기: FileReader로 읽어서 System.out.println();