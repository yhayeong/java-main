import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
	String name;
	int age;
	double height;
	boolean married;
	Person(String name, int age, double height, boolean married) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.married = married;
	}
	@Override
	public String toString() {
		return String.format("이름:%s, 나이:%d, 키:%f, 결혼여부:%s", name, age, height, (married?"Y":"N"));
	}
}

public class DataStreamTest1 {

	static void write(Person p) {
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("person.bin");
			dos = new DataOutputStream(fos); //보조스트림 만들어서 꽂음
			dos.writeUTF(p.name);
			dos.writeInt(p.age);
			dos.writeDouble(p.height);
			dos.writeBoolean(p.married);
			
			System.out.println("----------오류없이 파일 생성(데이터 저장)------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos!=null) dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//하나를 write하는 write메소드
	
	static Person read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		Person p = null;
		
		try {
			fis = new FileInputStream("person.bin");
			dis = new DataInputStream(fis);
			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble(); 
			boolean married = dis.readBoolean();
			p = new Person(name, age, height, married);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis!=null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return p;
		
	}//read메소드
	
	
	
	static void write(List<Person> pers) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			//
			fos = new FileOutputStream("person.bin");
			dos = new DataOutputStream(fos); //보조스트림 만들어서 꽂음
			
			
			dos.writeInt(pers.size()); //맨 앞에 List에 있는 인원수를 저장한다 (출력read할때 사용하기 위해)
									//(저장할때는 몇개가 저장되어야하는지 알지만 read할때는 몇개를 읽어야하는지 알수없으므로)
			for(Person p: pers) {
				dos.writeUTF(p.name);
				dos.writeInt(p.age);
				dos.writeDouble(p.height);
				dos.writeBoolean(p.married);
			}
			System.out.println("----------오류없이 파일 생성(데이터 저장)------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos!=null) dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//<2-2>write메소드 오버로딩
	
	static List<Person> readList() {
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		List<Person> pers = new ArrayList<>();
		
		try {
			fis = new FileInputStream("person.bin");
			dis = new DataInputStream(fis);
			
			int count = dis.readInt(); //write할때 맨 앞에 저장해둔 인원수를 읽어오기
			
			for(int i=0; i<count; i++) { //인원수만큼 반복하여 데이터를 읽는다
				String name = dis.readUTF();
				int age = dis.readInt();
				double height = dis.readDouble(); 
				boolean married = dis.readBoolean();
				pers.add(new Person(name, age, height, married)); //읽어온 데이터로 Person객체 만들어서 list에 담는다
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis!=null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return pers;
	}//<2-2>readList메소드
	
	
	
	public static void main(String[] args) {
		/*
	 	DataInputStream, DataOutputStream은 기본형 단위로 읽고 쓰는 보조스트림이다
	 	Byte나 Char단위가 아니라 (변수에 담긴)데이터 자체의 타입으로 읽고 쓸 수 있으므로 프로그램 안에서 매우 유용하다
	 		 
	 	writeUTF로 쓴것은 readUTF로 읽어야...다른 타입도 마찬가지
	 	
		 */
		
		//쓰기==저장하기==Person파일 생성됨
//		Person p1 = new Person("hong", 35, 175.3, false);
//		write(p1);
		
		//읽기==가져오기
//		Person p = read();
//		System.out.println(p); //이름:hong, 나이:35, 키:175.300000, 결혼여부:N
		
		
		
		//<2-1>하나가 아니라 여러개라면
		
//		List<Person> pers = new ArrayList<>();
//		pers.add(new Person("song", 15, 185.3, false));
//		pers.add(new Person("pong", 45, 165.1, true));
//		pers.add(new Person("kong", 55, 155.8, false));
//		
//		write(pers);
		
		List<Person> pers = readList();
		for (Person p : pers) {
			System.out.println(p);
		}
		
	}//main
	
}//class








