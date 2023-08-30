import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> { //Comparable을 상속받기: sort메소드의 매개변수로 들어갈 수 있는 클래스로 만들어주는것
	String name;								//Integer, String은 다 Comparable<Integer>, Comparable<String>을 상속받고있다
	int age;
	
	Person() {}
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + "," + age;
	}
	
	@Override
	public int compareTo(Person o) {
		return age - o.age; //앞이 크면 양수, 뒤가 크면 음수, 같으면 0
//		return name.compareTo(o.name); //가나다 알파벳 순으로 됨
	}
	//Collections.sort(리스트)는 내부적으로 compareTo메소드를 호출하여 반환값이 양수면 asc정렬 음수면 des정렬하게 되어있다
	
}


public class ArrayListTest1 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add(100); //Integer로 박싱 -> Object로 업캐스팅되어 들어간다
		
		int n = (int) list1.get(0); //Object를 int에 넣기 위해서는 다운캐스팅 필요
		//cf. Integer <-> int 끼리는 박싱과 언박싱이 자동으로 일어나므로 서로 집어넣을수있다
		
		ArrayList list2 = new ArrayList();
		list2.add(new Person());
		Person p1 = (Person) list2.get(0); //오른쪽은 Object이므로 왼쪽에 대입하기 위해서 다운캐스팅이 필요하다...매번 불편
		

		//그래서 아래와 같이 제네릭을 쓰는 것이 보편화되어있다
		ArrayList<Person> pList = new ArrayList<>();
		pList.add(new Person());
		Person p2 = pList.get(0);
		
		
		//-------------------------------------------------------------
		
		ArrayList<Integer> intList1 = new ArrayList<>();
		intList1.add(3);
		intList1.add(1);
		intList1.add(2);
		intList1.add(5);
		intList1.add(4);
		ArrayList<Integer> intList2 = new ArrayList<>(intList1);
		
		printList(intList1);  
		printList(intList2);  //위와 내용이 동일한 리스트임을 확인함
		
		
		
		
//		ArrayList<Integer> subList = intList1.subList(2, 4); //메소드의 리턴타입이 List임
		List<Integer> subList = intList1.subList(2, 4); //2인덱스부터 4미포함까지 
		printList(subList); 
		
		
		
		
		Collections.sort(intList1); //Collections의 sort메소드는 원본을 정렬한다 
		printList(intList1);
		
		ArrayList<Person> perList = new ArrayList<>();
		perList.add(new Person("hong", 30));
		perList.add(new Person("song", 20));
		perList.add(new Person("gong", 25));
		
		System.out.println("----- 정렬전");
		printObjectList(perList); 
		System.out.println("----- 정렬후");
		Collections.sort(perList); 
			//Person클래스가 Compareable을 상속받아서 sort메소드를 오버라이딩하여 정렬기준을 정해두기
		printObjectList(perList); //정렬기준 #1에 따라서 20->25->30순으로 정렬됨을 확인 
		
		
		
		
		//cf.
		//Collections.sort( 컴페어러블을 상속받은 리스트 );
		//Collections.sort( 리스트, 비교기준메소드(를담은클래스)를만들어서넣음 );
		
//		요약하면:
//
//			Collections.sort(yourList)를 사용하여 리스트를 자연 순서대로 정렬할 수 있습니다.
//			Collections.sort(yourList, customComparator)를 사용하여 사용자 정의 비교 규칙에 따라 리스트를 정렬할 수 있습니다.
//			기억해주세요, 정렬 과정은 반복적으로 비교 결과를 사용하여 원하는 순서대로 요소들을 정렬하는 것입니다.
//		
//		
		
	}//main
	
	
	//출력용 메소드
	static void printList(List<Integer> list) {
		for (Integer num : list) {
			System.out.print(num + ", ");
		}
		System.out.println();
	}
	
	static void printObjectList(List<Person> list) {
		for (Person p : list) {
			System.out.println(p.toString());
		}
	}
	
}





