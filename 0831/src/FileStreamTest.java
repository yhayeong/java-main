import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
	public static void main(String[] args) {
		/*
		 스트림은 자바프로그램의 입장에서 데이터를 읽고 쓰기 위한 통로를 말하며 빨대와 유사한 개념이다(데이터를 넣거나 뽑기위해서 빨대를 꽂아야함)
		 다만 입력빨대와 출력빨대는 각각 따로 사용해야한다 (스트림은 단방향) 
		
		<1>
		 스트림을 나누는 기준
		 1. 입력용 vs 출력용 
		 2. 문자Char vs 바이트 단위
		 3. 1차 vs 2차(보조스트림)
		
 		바이트기반 스트림 - InputStream, OutputStream (Stream 용어 사용하는것은 바이트기반임)
		문자기반 스트림 - Reader, Writer
		
		<2>
		입/출력 스트림은 한 쌍으로 사용해야함
		(예를 들어 FileOutputStream으로 쓴것은 FileInputStream으로 읽어야함) 
		
		<3>
		명명이 특이한 것:
		InputStreamReader, OutputStreamWriter - 문자 보조스트림
		바이트단위에 꽂아서 문자단위로 변환할때 사용
		바이트단위의 데이터에 꽂아서 메소드를 사용할때 문자위주로,... 문자단위로 사용
		
		바이트 1차스트림에 꽂아서 문자단위로 다룰 수 있도록하는 중간 어댑터 역할을 한다
		
		cf. 직렬화: 객체를 바이트 스트림으로 변환
		
		직렬화 : 저장, 전송, 공유가 쉽도록 데이터를 특정 형식으로 변환  JSON.stringify() 
		역직렬화 : 직렬화된 데이터를 (사용을 위해) 원래대로 복원  JSON.parse() 
		
		
		 */
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		FileInputStream fisJPG = null;
		FileOutputStream fosJPG = null;
		
		try {
			//<1-1> 1차스트림 객체 생성
			fis = new FileInputStream("news.txt");
			System.out.println("fis-----------");
			fos = new FileOutputStream("news_copy.txt");
			System.out.println("fos-----------");
			
			//<4-1> 보조스트림 객체 생성 (보조스트림을 생성하고 1차스트림에 장착)
			bis = new BufferedInputStream(fis); 
			bos = new BufferedOutputStream(fos);
			
			
			//<1-2> Cat.jpg로도 해보기
//			fisJPG = new FileInputStream("Cat.jpg");
//			System.out.println("fisJPG----------");
//			fosJPG = new FileOutputStream("Cat_copy.jpg");
//			System.out.println("fosJPG----------");
			
			//<2-1> 2번 코드가 없다면 news_copy.txt는 생성되지만 파일의 내용이 복사되지 않음
//			int data;
//			while((data=fis.read())!=-1) fos.write(data);
			//모든 파일은 끝이라는 표시로 마지막에 -1이 들어있다. 조건식은 -1, 즉 끝이 아니라면 데이터를 출력하라는뜻
			
			//<2-2>
			byte[] buff = new byte[1024];
			int length;
//			while((length=fis.read(buff))>0) fos.write(buff, 0, length); //***주의: read로 읽어온 길이length만큼만 write하게해야함
			while((length=bis.read(buff))>0) bos.write(buff, 0, length); //<4-2> 보조스트림이 장착된 스트림을 사용하기
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
				try {
//					if(fis!=null) fis.close();
//					if(fos!=null) fos.close();
					
					if(bis!=null) bis.close();
					if(bos!=null) bos.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
		
		
		
		
		
		
	}//main
}
