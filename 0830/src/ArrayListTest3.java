import java.util.ArrayList;
import java.util.List;

public class ArrayListTest3 {
	
	static void print(List<Integer> list) {
		for (Integer num : list) {
			System.out.print(num + ",");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10);
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		
		List<Integer> list2 = list1.subList(1, 4);  //4,2,0
		print(list1);
		print(list2);
		System.out.println(list1.containsAll(list2)); //true (list1이 list2를 전부 포함하는지)
		
		System.out.println("=======================");
		
		list1.retainAll(list2); //list1에서 list2와 같은것만 남기고 나머진 삭제
		print(list1);
		
		list1.add(0, 6); //0인덱스에 6을 삽입
		print(list1);
		
		list1.set(0, 7); //0인덱스에 7로 변경(덮어쓰기)
		print(list1);
				
		System.out.println("=======================");
				
		list1.add(0, 7); 
		print(list1);
		
		list1.remove(0); //0인덱스의 요소 삭제
//		print(list1);
		
		list1.remove(new Integer(7)); //7인 요소 삭제 - 처음 만난것만 삭제됨
		print(list1);
				
	}
}
