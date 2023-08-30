import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(100);
		tset.add(50);
		tset.add(30);
		tset.add(150);
		System.out.println(tset);
		//Integer는 Comparable을 상속받은 타입이므로 정렬잘됨
		//TreeSet은 정렬기준에 따라서 알아서 정렬돼서 저장됨
		
		
		
		System.out.println("------------");
//		TreeSet<Person> tPset = new TreeSet<>(); //<1>
		
		//<2> TreeSet을 생성하면서 인자로 커스텀비교기를 넣어줌
		//<1>, <2> 둘다있으면 <2>가 우선순위가 더 높음
		TreeSet<Person> tPset = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age-o2.age; //앞이크면1 같으면0 뒤가크면-1(오른쪽이 나보다 크도록 교환작업해서 오름차순정렬이되게됨) (내림차순하려면 o2.age-o1.age하면됨)
				
//				if(o1.age()>o2.age) return 1;
//				else if(o1.age<o2.age) return -1;
//				else return 0;
				//이것을 위는 간단하게 쓴 것
			}
		});
		tPset.add(new Person("hong", 20));
		tPset.add(new Person("song", 10));
		tPset.add(new Person("gong", 50));
		tPset.add(new Person("pong", 80));
		System.out.println(tPset);
		//<1> Person을 Comparable를 상속하여 compareTo를 오버라이딩해서 비교기준을 데이터로 정해주었기때문에 정렬됨
		
		System.out.println("--------------------------------------");
		SortedSet<Person> subList = tPset.subSet(new Person("", 20), new Person("", 60)); //from부터 to(미포함)한 범위의 요소를 리턴
		System.out.println(subList);
		
	}
}
