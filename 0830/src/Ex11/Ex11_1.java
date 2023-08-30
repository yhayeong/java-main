package Ex11;

import java.util.ArrayList;

public class Ex11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		//문제의 포인트 : ArrayList는 중복허용됨을 주의
		
		kyo.addAll(list1);
		kyo.retainAll(list2);
		
		//차: list1에는 속하지만 list2에는 속하지 않는 요소들만 있는 집합
		cha.addAll(list1);
		cha.removeAll(list2);
		
		hap.addAll(cha);
		hap.addAll(list2);
		
		//차 없이 합 구하기
//		hap.addAll(list1);
//		hap.removeAll(kyo); //중복하여 들어간 요소를 제거 (이 문장을 밑으로 내리면 두번씩 들어간 요소를 하나씩 남기지 않고 해당되면 다 지움)
//		hap.addAll(list2);
		
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}
