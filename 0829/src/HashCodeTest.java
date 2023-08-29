import java.util.HashSet;

class Person {
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//데이터(name, age)가 같으면 같은 해쉬코드를 반환하게끔 오버라이딩
	@Override
	public int hashCode() {
		return name.hashCode() + age; //cf. 같은 int값과 Integer값은 해쉬코드가 같다
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person==false) return false;
		Person p = (Person)obj;
		return name.equals(p.name)&&age==p.age;
	}
	
	@Override
	public String toString() {
		return name + ", " + age;
	}
}


public class HashCodeTest {
	public static void main(String[] args) {
		String str1 = "hong";
		String str2 = "hong";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//데이터의 내용에 따라 같은 해쉬코드를 만들어내도록 String 클래스에 오버라이딩돼있다
		
		Person p1 = new Person("hong", 23);
		Person p2 = new Person("hong", 23);
		System.out.println(p1.hashCode()); //오버라이딩 전 758529971 후 3208471
		System.out.println(p2.hashCode()); //오버라이딩 전 2104457164 후 3208471
		
		
		//cf.
		System.out.println(((Integer)30).hashCode()); //30
		
		System.out.println("--------------------------------");
		
		HashSet hs = new HashSet();
		hs.add(10);
		hs.add(10);
		hs.add(p1);
		hs.add(p2); 
		for (Object object : hs) {
			System.out.println(object);
		}
		
		
		//Set은 수학에서 집합과 같다(중복데이터 저장x) 기본자료형데이터의 경우 동일한 데이터는 들어가지않지만 
		//내부적으로 같은 객체인지 여부를 판별하는 데에 equals와 hashCode를 사용하므로
		//사용자정의클래스를 만들어 같은객체기준을 안의 데이터값으로 나누고자하는 경우에는 hashCode와 equals오버라이딩이 필요하다
		//그렇지 않으면 주소값만 갖고 비교하므로 내부 데이터인 name과 age가 모두 동일한 p1, p2의 경우에도 다른 객체로 인지하게된다
		
		
	}//main
}
