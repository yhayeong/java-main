public class StringBufferTest {
	
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder(100);
		sb.append("abcdefg");
		System.out.println(sb.capacity()); //100 
		System.out.println(sb.length()); //7 즉 capacity는 공간의 크기, length()는 sb안의 문자열의 길이를 뜻한다
		
		sb.insert(1, 'P');
		System.out.println(sb + ",길이:" + sb.length()); //aPbcdefg,길이:8
		sb.delete(2, 5); //2인덱스부터 5미포함까지 삭제
		System.out.println(sb + ",길이:" + sb.length());  //aPefg,길이:5
		
		//String의 replace와는 달리 원본을 바꾼다
		sb.replace(0, 2, "#"); //0인덱스부터 2미포함까지
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		sb.setCharAt(2, '*');
		System.out.println(sb);
		
		System.out.println(sb.length());
		sb.setLength(10);
		System.out.println("["+sb+"]"); //남은 공간에는 space가 들어간다
		sb.setLength(2);
		System.out.println("["+sb+"]"); //잘린다
		
	}
	
	
	
	
	
	//String은 불변객체이지만 StringBuffer와 StringBuilder는 가변객체
//	
	
	
	/*
	 
	 StringBuffer(), StringBuffer(int length)  
	  StringBuffer는 기본생성자로 생성시 16문자를 담을 수 있는 메모리를 먼저 확보해두고 넣었다뺐다할수있음
	  
	 
	 동기화는 스레드에서 사용하는 개념
	 여러 스레드에서 하나의 데이터를 동시에 접근할때 
	 한 프로그램프로세스안에서 동시에 여러 기능이 실행되는것이 스레드
	 
	 스레드 두개가 동일한 데이터를쓸때 예를들어서 입금기능과 출금기능이 둘다 쓰는 balance데이터가 어그러질 가능성이있다
	공유 자원이 있을때는 한 작업기능이 끝날때까지 다른 작업하지 않도록 대기시켜야하는데 그것이 동기화이다
	
	스레드기능이 있는 기능(을 담은 클래스)는 보통 동기화관련 메소드가 같이 있다.
	String, 배열, 컬렉션은 스레드의 대상이되므로 동기화가 중요하다
	
	스트링버퍼도 문자열의 집합 스레ㅌ드여러개가 동시에 ㅅ용중이지 항상 체크한다
	
	모든 프로그램이 스레드를 쓰는것이 아니므로 항상 체크한다면 무겁고 효율x
	그러므로 동기화를 빼서 새로 나온 버전이  스트링빌더이다...
	
	
	우리가 사용할떄 스트링빌더와 버퍼는 같으므로 같이 학습한다.
	이왕이면 스트링빌더를 쓴다(더 가벼운)
	동기화가 필요할때만 스트링버퍼를 쓰라고 권장한다
	
	 * */

}
