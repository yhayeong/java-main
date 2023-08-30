import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Stack_Queue_VectorTest {
	public static void main(String[] args) {
		
		System.out.println("Stack의 경우=================");
		Stack stack = new Stack();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		stack.add(600); //List를 상속받기때문에 add로도 넣을 수 있음
		
		//100부터 나온다 - List를 상속받기때문에 선입선출되어 출력된다
//		for (Object o : stack) {
//			System.out.println(o);
//		}
		
		//600부터 나온다 - stack처럼 쓰려면 pop으로 해야함(후입선출)
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("Queue의 경우================");
		Queue<String> queue = new LinkedList<>();
		queue.add("Hong");
		queue.offer("Song"); //위와 같다
		queue.offer("Gong"); //위와 같다
		System.out.println(queue.poll()); //삭제하고 삭제한 데이터를 리턴
		System.out.println(queue.remove());  //같은 메소드
		queue.clear(); //비운다
		System.out.println(queue); //컬렉션객체는 toString이 오버라이딩되어있어 내용물이 출력됨
		
		System.out.println("Vector의 경우=================");
		Vector<Integer> vector = new Vector<>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		//Vector에서는 이터레이터가 아니라 Enumeration을 쓴다
		Enumeration<Integer> e = vector.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		System.out.println("ArrayList리스트의 경우==========");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("#### listIterator()는");
		ListIterator<Integer> liter = list.listIterator();
		while(liter.hasNext()) {
			System.out.println(liter.next());
		}
		System.out.println("-----이전요소를 가리킬 수 있다");
		while(liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
		
	}
	
	
	
	
	//Hash알고리즘은 검색에 유리하다
	//ArrayList등은 Hash를 가지지 않는다. 
	
	//cf. 주소값 : 메모리상에 객체가 저장된 위치 / hashCode : 객체를 구분하기위한 정수값
	

}
