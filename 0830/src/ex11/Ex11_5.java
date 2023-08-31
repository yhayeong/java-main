package ex11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Human implements Comparable {
	String ssn;
	String name;
	int age;
	String address;
	public Human(String ssn, String name, int age, String address) {
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("%s, %s, %d, %s", ssn, name, age, address);
	}
	
	//클래스가 Comparable<Human>을 상속 -> name이라는 멤버에 접근하기 위해 다운캐스팅할 필요가 없어짐
//	@Override
//	public int compareTo(Human o) {
//		return this.name.compareTo(o.name);
//	}
	
	//클래스가 Comparable을 상속
	@Override
	public int compareTo(Object o) {
		if(o instanceof Human==false) return -1; 
		Human h = (Human) o;
		return this.name.compareTo(h.name);
	}
	
	//cf. ArrayListTest2 참고. 
	//String은 Comparable을 구현한 클래스로서 public int compareTo(String anotherS)메소드를 가지고있다
}


public class Ex11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Human("990201-1234567", "홍길동", 24, "서울시 금천구"));
		list.add(new Human("901101-1234568", "남궁성", 33, "서울시 강남구"));
		list.add(new Human("921201-2234561", "김자바", 31, "서울시 서초구"));
		list.add(new Human("930901-2234562", "이자바", 30, "서울시 관악구"));
		list.add(new Human("940801-2234563", "안자바", 29, "서울시 마포구"));
		
		Collections.sort(list);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) System.out.println(it.next());
		
		
	}

}
