package ex11;

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
		
		//교: list1의 요소를 저장하고 "그중에서 list2와 일치하는 요소만 남기고 삭제"
		kyo.addAll(list1);
		kyo.retainAll(list2);
		
		//차: list1에는 속하지만 list2에는 속하지 않는 요소들만 있는 집합
		cha.addAll(list1);
		cha.removeAll(list2);
		
		//합: list1의 list2에 대한 차 + list2
		hap.addAll(cha);
		hap.addAll(list2);
		
		//합: list1 -list2 +list2
//		hap.addAll(list1);
//		hap.removeAll(list2);
//		hap.addAll(list2);
		
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}
