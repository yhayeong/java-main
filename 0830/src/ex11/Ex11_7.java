package ex11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Studentt {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Studentt(String name, int ban, int no, int kor, int eng, int math) {
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

} // class Studentt

class BanNoAscending implements Comparator<Studentt> {
	public int compare(Studentt o1, Studentt o2) {
		/*  (1) 알맞은   코드를   넣어   완성하시오. */
//		if(o1.ban == o2.ban) {
//			return o1.no - o2.no;
//		}
//		return o1.ban - o2.ban; //앞이 더 크면 양수 앞이 더 작으면 음수 같으면 0
		
		return o1.ban==o2.ban? o1.no-o2.no: o1.ban-o2.ban; //삼항연산자로 축약: 반이 같으면 번호로 정렬, 그렇지않으면 반으로 정렬
//		return o1.ban-o2.ban==0? o1.no-o2.no: o1.ban-o2.ban; //위와 같음
	}
}// BanNoAscending

public class Ex11_7 {
	public static void main(String[] args) {
		
		ArrayList<Studentt> list = new ArrayList<>();
		list.add(new Studentt("이자바", 2, 1, 70, 90, 70));
		list.add(new Studentt("안자바", 2, 2, 60, 100, 80));
		list.add(new Studentt("홍길동", 1, 3, 100, 100, 100));
		list.add(new Studentt("남궁성", 1, 1, 90, 70, 80));
		list.add(new Studentt("김자바", 1, 2, 80, 80, 90));
		
		Collections.sort(list, new BanNoAscending()); 
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) System.out.println(it.next()); //다음요소가 있는 동안에만 다음요소를 리턴
	}
}
