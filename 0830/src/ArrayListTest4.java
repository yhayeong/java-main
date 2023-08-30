import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest4 {
	
	static void print(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList<>(10);
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		print(list1.toArray());
		
		System.out.println(list1); //리스트는 toString이 이미 오버라이딩되어있어서 내용물을 보여준다
		System.out.println(list1.toArray()); //반면 배열은 syso안에 넣으면 배열의 주소값을 보여줌(리스트의 편리한 점)
		
		System.out.println("=====================");
		List list2 = (List) list1.clone();
		System.out.println(list2);
		list2.set(0, 100); ///0인덱스의 요소를 100으로 변경(덮어쓰기)
		System.out.println(list2);
		
		
		System.out.println("===========================================");
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
								//Arrays.asList(파라미터들): 데이터들로 리스트를 만들어줌
		System.out.println(numbers);
		
		//***람다식(매개변수에 함수를 넣는것)
		numbers.removeIf(n->(n%3)==0);
		//numbers중 요소의 하나하나가 n이고 화살표 뒤가 트루가 되는 n을 찾는것이 람다식
		//(n이 함수의 파라미터이고 -> 뒤의 문장이 함수의 바디에 해당)
		System.out.println(numbers);
		
		//cf. ArrayList는 검색에 유리, LinkedList는 삭제삽입에 유리하며 보통 검색할일이 더 많으므로 ArrayList가 더 효율적
		
		
	}
}
