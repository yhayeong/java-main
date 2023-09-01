package ex11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Studentt implements Comparable<Studentt> { // Ex11_8에서 상속
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수
	int classRank; // 반등수

	Studentt(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank //Ex11_8
				+ "," + classRank; //Ex11_9
	}

	@Override
	public int compareTo(Studentt o) {
		// Ex11_8 클래스의 기본정렬을 이름(name)이 아닌 총점(total)을 기준으로 한 내림차순으로 변경
		return o.total - this.total;
	}

} // class Studentt

class ClassTotalComparator implements Comparator<Studentt> { 
	
	public int compare(Studentt o1, Studentt o2) {
		/* Ex11_9
		(1) 알맞은   코드를   넣어   완성하시오.
		*/
		//반별 총점기준 내림차순 비교기
		
		//@일단 반으로 먼저정렬해야?
		
		if(o1.ban==o2.ban) return o2.total-o1.total;
		else return 0;
	} 
}

class BanNoAscending implements Comparator<Studentt> {
	public int compare(Studentt o1, Studentt o2) {
		/* (1) 알맞은 코드를 넣어 완성하시오. */
//		if(o1.ban == o2.ban) {
//			return o1.no - o2.no;
//		}
//		return o1.ban - o2.ban; //앞이 더 크면 양수 앞이 더 작으면 음수 같으면 0

		return o1.ban == o2.ban ? o1.no - o2.no : o1.ban - o2.ban; // 삼항연산자로 축약: 반이 같으면 번호로 정렬, 그렇지않으면 반으로 정렬
//		return o1.ban-o2.ban==0? o1.no-o2.no: o1.ban-o2.ban; //위와 같음
	}
}// BanNoAscending

public class Ex11_7_8 {

	public static void calculateClassRank(List<Studentt> list) {
		// 먼저 반별 총점기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		/*
		 * (2) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다. 
		 * 1.1 반이 달라지면,(ban과 prevBan이 다르면) 이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화한다. 
		 * 1.2 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(classRank)로 한다. 
		 * 1.3 총점이 서로 다르면, 등수(classRank)의 값을 알맞게 계산해서 저장한다. 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야
		 * 한다. (실행결과 참고) 
		 * 1.4 현재 반과 총점과 등수를 이전 반(prevBan), 이전 총점(prevTotal), 이전
		 * 등수(prevRank)에 저장한다.
		 */
		
		for (int i = 0; i < list.size(); i++) {
			Studentt s = list.get(i);
			if(s.ban!=prevBan) {
				prevRank = -1;
				prevTotal = -1;
			}
			if(s.total==prevTotal) s.classRank= prevRank;
			//총점이 서로 다르면?->총점과 이전총점이 같으면의 반대else??
			else s.classRank = i+1;
			//이전에 동점자였다면 ??
			
			prevBan = s.ban;
			prevTotal = s.total;
			prevRank = s.classRank;
		}
	} // public static void calculateClassRank

	
	
	public static void calculateSchoolRank(List<Studentt> list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		/*
		 * (2) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 1. 반복문을 이용해서 list에 저장된 Studentt객체를 하나씩 읽는다. 1.1
		 * 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다. 
		 * 1.2 총점이 서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다. 
		 * 이전에 동점자 였다면, 그 다음 등수는 동점자의 수를
		 * 고려해야한다. (실행결과 참고) 
		 * 1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
		 */

//		Iterator iter = list.iterator();
//		while(iter.hasNext()) {
//			Studentt s = iter.next();
//			if(s.total==prevTotal) s.schoolRank = prevRank;
//			s.schoolRank = list.indexOf(s);  
//			if(s.schoolRank
//		}

		for (int i = 0; i < list.size(); i++) {
			Studentt s = list.get(i);
			if (s.total == prevTotal)
				s.schoolRank = prevRank;
			else { // 1-2
				s.schoolRank = i + 1;

				// @이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해야한다.(???)

			}
			prevTotal = s.total;
			prevRank = s.schoolRank;
		}

	}// calculateSchoolRank메소드

	public static void main(String[] args) {
		ArrayList<Studentt> list = new ArrayList<>();
		list.add(new Studentt("이자바", 2, 1, 70, 90, 70));
		list.add(new Studentt("안자바", 2, 2, 60, 100, 80));
		list.add(new Studentt("홍길동", 1, 3, 100, 100, 100));
		list.add(new Studentt("남궁성", 1, 1, 90, 70, 80));
		list.add(new Studentt("김자바", 1, 2, 80, 80, 90));

//		Collections.sort(list, new BanNoAscending()); 

//		Iterator it = list.iterator();

//		while(it.hasNext()) System.out.println(it.next()); //다음요소가 있는 동안에만 다음요소를 리턴

		System.out.println("-----------Ex11_8");
		/*
		 * 문제: Studenttt클래스의 기본정렬을 이름(name)이 아닌 총점 (total)을 기준으로 한 내림차순으로 변경한 다음, 총점을
		 * 기준으로 각 학생의 전교등수 를 계산하고 전교등수를 기준으로 오름차순 정렬하여 출력하시오.
		 */

		calculateSchoolRank(list);
		Iterator it = list.iterator(); // 이터레이터가 정렬메소드 위에 있으면 안됨

		while (it.hasNext())
			System.out.println(it.next());

	}// main
}
