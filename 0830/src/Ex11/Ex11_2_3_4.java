package Ex11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Ex11_2_3_4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		HashSet<Integer> set = new HashSet<>(list); // 2637(중복x 순서x)
		TreeSet<Integer> tset = new TreeSet<>(set); // 2367(정렬)
		Stack<Integer> stack = new Stack<>();
		stack.addAll(tset); // 2367(선입선출)
		while (!stack.empty())
			System.out.println(stack.pop());
		// pop순서: 7632

		// cf. 만일 for문에서 하나씩 출력하는 식으로 한다면 선입선출x 리스트처럼 저장순서대로 나온다
		// 또한 pop(꺼내기)수행 이후 요소출력시 아무것도 나오지 않지만 반대로 요소출력후 pop해보면 나온다
//		System.out.println("==============");
//		for (Object o : stack) {
//			System.out.print(o + ","); //2,3,6,7,
//		}

		/*
		 * Ex11_3
		 * 
		 * ArrayList는 특정번째를 찾아가는 검색에 유리.(cf. 특정데이터를 검색하는것에 유리한것은 Hash) 
		 * 저장과 삭제할때 불리(이유:하나씩 밀거나 땡겨야함)
		 * 
		 * 정답은 a 해설: 배열의 중간에 새로운 요소를 추가 또는 삭제하는 것은 다른 요소들을 이동시켜 야하기 때문에 배열을 새로 생성하는 것보다는
		 * 적지만 역시 비용이 많이 드는 작업이다. 특히 배열의 첫 번째 요소를 삭제하면, 빈자리를 채우기 위해 나머지 모든 요소들을 이 동시켜야
		 * 하기 때문에 많은 비용이 든다.
		 * 
		 * Ex11_4
		 * 
		 * 정답은 중간요소: 6(5인덱스) 
		 * 이중(double-앞으로도갈수있음) 원형 연결리스트에서는 마지막 요소에 접 하기 위해서는 첫 번째 요소에서 한 번만 이동하면 된다.
		 * (첫번째요소와 마지막요소의 위치는 첫요소와 연결됨. 중간은 연결연결해서 찾아가야하므로 제일 느림)
		 */

	}
}
