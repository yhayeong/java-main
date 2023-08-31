

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceStreamTest {
	public static void main(String[] args) {
		
		//두개의 파일을 Read읽어서 하나의 파일로 Write하기
		
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		
		FileOutputStream fos = null;
		SequenceInputStream sis = null;
		
		//Vector는 파일을 2개가 아니라 여러개를 읽어서 합치고 싶을때 사용하기 좋음 - 시퀀스인풋스트림의 매개변수로 넣어줄것
		Vector<InputStream> v = new Vector<>();
		
		
		/* cf. 시퀀스인풋스트림의 생성자
		 * 
		public SequenceInputStream(InputStream s1, InputStream s2) {
	        Vector<InputStream> v = new Vector<>(2);
	        v.addElement(s1);
	        v.addElement(s2);
	        e = v.elements();
	        peekNextStream();
	    }
	    
	    public SequenceInputStream(Enumeration<? extends InputStream> e) {
	        this.e = e;
	        peekNextStream();
    	}
		*/
		
		
		
		try {
//			fis1 = new FileInputStream("news.txt");
//			fis2 = new FileInputStream("SocialNews.txt");
//			sis = new SequenceInputStream(fis1, fis2);
			
			v.add(new FileInputStream("news.txt"));
			v.add(new FileInputStream("SocialNews.txt"));
			sis = new SequenceInputStream(v.elements());
			
			fos = new FileOutputStream("total.txt");
			
			byte[] buff = new byte[1024];
			int length = 0;
			while((length=sis.read(buff))>0) fos.write(buff, 0, length);
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
				try {
					if(sis!=null)sis.close();
					if(fos!=null) fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}//main

}
