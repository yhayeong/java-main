package Ex11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Studenttt implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;

	Studenttt(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}


	@Override
	public int compareTo(Object o) {
		if(o instanceof Studenttt==false) return -1;
		Studenttt s = (Studenttt) o;
		return this.name.compareTo(s.name);
	}
	//cf. ArrayListTest2 참고. 
	//String은 Comparable을 구현한 클래스로서 public int compareTo(String anotherS)메소드를 가지고있다
}

public class Ex11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Studenttt("홍길동", 1, 1, 100, 100, 100));
		list.add(new Studenttt("남궁성", 1, 2, 90, 70, 80));
		list.add(new Studenttt("김자바", 1, 3, 80, 80, 90));
		list.add(new Studenttt("이자바", 1, 4, 70, 90, 70));
		list.add(new Studenttt("안자바", 1, 5, 60, 100, 80));
		
		Collections.sort(list);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) System.out.println(it.next());
	}

}
