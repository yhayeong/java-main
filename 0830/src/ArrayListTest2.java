import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Account {
	String name;
	int balance;
	Account() {}
	Account(String name, int balance) {
		this.name=name;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return String.format("계좌번호:%s, 잔액:%d",name,balance);
	}
}

class NameCompare implements Comparator<Account> { //비교기
	@Override
	public int compare(Account o1, Account o2) {
		return o1.name.compareTo(o2.name);
//		return o2.name.compareTo(o1.name); //<2>
	}
	//반환값이 양수이면 바꾼다, 음수나 0이면 안바꾼다
	//des로 하고싶으면 거꾸로 <2>
}


public class ArrayListTest2 {
	public static void main(String[] args) {
		List<Account> accs = new ArrayList<>();
		accs.add(new Account("홍길동", 100));
		accs.add(new Account("고길동", 300));
		accs.add(new Account("박길동", 200));
		
		Collections.sort(accs, new NameCompare());
		//비교하는 메소드(를담은클래스)를 Comparator(비교기)를 상속하면서 만들어서 그걸 두번째 인자로 넣게되면
		//정렬대상 리스트의 요소가 Comparable을 상속하지 않은 객체더라도 정렬할 수 있다
		
		
		
		//출력하기
//		for (Account acc : accs) {
//			System.out.println(acc);
//		}
		
//		for (int i = 0; i < accs.size(); i++) { //list의 길이는 size()
//			System.out.println(accs.get(i));
//		}
		
		//반복문 안에서 리스트의 요소를 삭제하게되면 리스트의 길이가 바뀌게 되어 for문의 accs.size()가 변하여서 인덱스로 인한 문제가 발생한다
		//이터레이터를 쓴다면 중간에 삭제되어도 문제 생기지 않음
		
		//정리하자면 list의 요소를 조회출력만 하고싶다면 향상for문 사용, 반복문안에서 삭제한다면 이터레이터 사용이 권장된다
		Iterator<Account> iter = accs.iterator();
		while(iter.hasNext()) {				
			System.out.println(iter.next());
		}
		System.out.println("------");
		accs.get(0);
		
	}
}
