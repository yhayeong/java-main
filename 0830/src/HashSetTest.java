import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Integer> hset = new HashSet<>(Arrays.asList(111,22,3,3,3,444,5,5,5));
//		HashSet<Integer> hset = new HashSet<>();
//		hset.add(234);
//		hset.add(14);
//		hset.add(45);
//		hset.add(8);
//		hset.add(11);
//		hset.add(11);
		//1. 차례대로 들어가지 않음 ->Hash의 특징 (내부적으로, 자바가 제공하는 Hash함수를 통해서 들어가는 위치가 정해지기때문)
		//2. 중복허용x ->Set의 특징
		
		for (Integer h : hset) {
			System.out.print(h + ",");
		}
		
		System.out.println("-------------");
		
		HashSet<Person> accHset = new HashSet<>();
		accHset.add(new Person("홍길동", 23));
		accHset.add(new Person("홍길동", 60));
		accHset.add(new Person("고길동", 11)); //1
		accHset.add(new Person("고길동", 11)); //2
		accHset.add(new Person("이길동", 90));
		
		//Set이 중복데이터를 걸러낼때 판단할 수 있는 '같은 객체'의 기준을 만들어주어야한다 (Set은 내부적으로 같은 객체인지 여부를 판별하는 데에 equals와 hashCode를 사용)
		//ArrayListTest1.java에... cf. 0829/src/HashCodeTest.java

		//name과 age가 둘다 같으면 같은 객체로 판단하도록 equals메소드
		//name과 age가 둘다 같으면 같은 해쉬코드를 리턴하는 hashCode메소드
		//가 되도록 오버라이딩해야 1만 저장되고 2는 저장되지 않는다 
		//오버라이딩하지 않은 equals,hashCode는 주소값을 가지고 비교하므로 데이터의 내용이 같아도 다른 객체로 인지한다
		
		for (Person p : accHset) {
			System.out.println(p);
		}
		
	}
}
