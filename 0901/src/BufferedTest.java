import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
}//Person




public class BufferedTest {
	
	//<1> 파일 쓰기
	static void write(Person p) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("per.txt");
			bw = new BufferedWriter(fw); //보조스트림 장착
			
			String perStr = p.getName()+","+p.getAge()+","+p.getHeight()+",";
			perStr += p.isMarried()? "Y" : "N";
			
			bw.write(perStr);
			bw.newLine(); //BufferedWriter를 장착하면 라인단위 조작이 가능하다
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//write메소드
	
	static Person read() {
		Person per = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("per.txt");
			br = new BufferedReader(fr);
			
			String perStr = br.readLine(); //컴마와 함께 다 이어붙어있는 문자열이 리턴됨 hong,30,178.5,Y
			String[] perProp = perStr.split(",");
			
			String name = perProp[0];
			int age = Integer.parseInt(perProp[1]);
			double height = Double.parseDouble(perProp[2]);
//			boolean married = perProp[3].charAt(0)=='Y'? true: false;
			boolean married = perProp[3].equals("Y")? true: false;
			per = new Person(name, age, height, married);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return per;
	}

	
	
	public static void main(String[] args) {
		/*
		 원하는 저장형식:
		 hong,30,178.5,Y
		 song,25,173.5,N
		 gong,35,158.2,Y
		 
		 이렇게 저장하고 라인 단위(String) 로 읽어오기
		 그다음 split메소드를 통해서 name과 age와 height와 married를 잘라서 String배열로 만들기  
		 그러러면 String이 아닌 age, height, married를 문자열화해야함
		 
		 * */
		
		Person p1 = new Person("hong", 30, 178.5, false);
		Person p2 = new Person("song", 25, 173.5, true);
		Person p3 = new Person("gong", 35, 158.2, false);
		
		write(p1);
		write(p2);
		write(p3);
		
		
		
		
	}//main
}
