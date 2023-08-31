package ex11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

class Student implements Comparable<Student> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student(String name, int ban, int no, int kor, int eng, int math) {
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

	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}
} // class Student

public class Ex11_6 {

	static int getGroupCount(TreeSet<Student> tset, int from, int to) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		SortedSet<Student> subSet = tset.subSet(new Student("",1,1,from,from,from), new Student("",1,9,to,to,to));
													//subSet(from부터, to미포함까지)
		return subSet.size();
		
		
		//***국영수의 평균이 from과 to 사이에 속한 학생들의 수이므로 아래처럼 구할 수도 있다. 하지만 위와 같이 푸는 것이 더 효율적임. 
		//TreeSet생성시점에 비교기를 넣어서 생성했는데 그 비교기의 내용(내부클래스)이 평균을 가지고 비교하게끔 되어있으므로 이미 평균으로 오름차순정렬되어 들어가있음.
//		int cnt = 0;
//		for (Student s : tset) {
//			if(from<=s.getAverage()&&s.getAverage()<to) cnt++;
//		}
//		return cnt;
		
	}

	public static void main(String[] args) {
		
		//기본생성자로 생성: TreeSet(), 매개변수가있는생성자로 생성: TreeSet(비교기객체) TreeSet은 비교가능한 객체만 저장되며, 저장시점부터 정렬된다
		
		TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				/*
				 * (2) 알맞은 코드를 넣어 완성하시오.
				 */
				
				//원래 compare함수는 앞에것이 크면 1 같으면 0 뒤의것이크면 -1을 리턴하도록 되어있다. (오름차순) (내림차순은 o2 - o1로 작성하면됨)
				//그런데 float인 평균값으로 할때 int로 계산하게되면 소수점아래가 절삭되므로 주의하여 명확하게 비교하여서 1/0/-1이 리턴되도록 해야함
				
				if(o1.getAverage()>o2.getAverage()) return 1;
				else if(o1.getAverage()<o2.getAverage()) return -1;
				else return 0;
				
				//한편 총점로 비교하면 (float이라서 int로 캐스팅될때 소수점아래가 절삭되어 0이 되버리는) 문제 발생하지 않으므로 이렇게 비교할 수도 있음
//				return o1.getTotal() - o2.getTotal();
			}
		});
		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("김자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("안자바", 1, 5, 60, 100, 80));
		Iterator<Student> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69]   :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79]   :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89]   :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100]   :" + getGroupCount(set, 90, 101));
	}
}
