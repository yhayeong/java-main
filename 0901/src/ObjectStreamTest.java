import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamTest { //1. 객체 자체를 저장하고 읽어오기 / 2.객체를 묶은 리스트도 객체이므로 리스트객체째로 저장하고 읽어오기 가능
	
	//(BufferedTest.java의 )Person이 직렬화를 상속하지 않고 실행하게되면 java.io.NotSerializableException발생
	//class Person implements Serializable {} 해줄것
	//Serializable을 상속한 클래스는 Object로(통으로 한번에) 저장하고 읽을수있다는것...
	
	static void write(List<Person> pers) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("pers.dat"));
			
			//1-1. List에 담기는 Person이 직렬화 객체이므로 Person째로 저장
//			oos.writeInt(pers.size()); //List에 있는 개수 저장
//			
//			for(Person p : pers) {
//				oos.writeObject(p);
//			}
			
			//2-1. ArrayList도 직렬화 객체이므로 이렇게 저장 가능
			oos.writeObject(pers);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	static List<Person> read() {
		
//		List<Person> pers = new ArrayList<>(); //2-2. 
		//2-2.
		List<Person> pers = null;
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("pers.dat"));
			
			//1-2.
//			int count = ois.readInt(); //데이터 개수 읽기
//			
//			for (int i = 0; i < count; i++) {
//				Person p = (Person) (ois.readObject());
//				pers.add(p);
//			}
			
			//2-2. 마찬가지로 리스트 통째로 읽기 가능
			pers = (List<Person>) (ois.readObject());
			
				
		} catch (IOException e) {
			System.out.println("---1");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("-----2");
		} finally {
			try {
				if(ois!=null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("---------3");
			}
		}
		return pers;
	}
	
	
	
	
	
	public static void main(String[] args) {
		/* 직렬화: 객체를 바이트 스트림으로 변환 cf. FileStreamTest.java의 InputStreamReader, OutputStreamWriter
		
		직렬화 : 저장, 전송, 공유가 쉽도록 데이터를 특정 형식으로 변환  JSON.stringify() 
		역직렬화 : 직렬화된 데이터를 (사용을 위해) 원래대로 복원  JSON.parse() 
		 
		 * */
		
//		List<Person> pers = new ArrayList<>();
//		pers.add(new Person("song", 15, 185.3, false));
//		pers.add(new Person("pong", 45, 165.1, true));
//		pers.add(new Person("kong", 55, 155.8, false));
//		write(pers);
		
		List<Person> pers = read();
		for (Person p : pers) {
			System.out.println(p);
		}
		
		
		/* 출력:
		 이름:song, 나이:15, 키:185.300000, 결혼여부:N
		이름:pong, 나이:45, 키:165.100000, 결혼여부:Y
		이름:kong, 나이:55, 키:155.800000, 결혼여부:N
		 * */
		
		
	}//man
}
