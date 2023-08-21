
public class OperTest1 {
	
	public static void main(String[] args) {
		
		int n = 10;
		n++; 		//n = n + 1;
		System.out.println(n);

		++n;		
		System.out.println(n);

		
		int m = 100;
//		System.out.println(++m);  //101
		System.out.println(m++);  //100을 출력하고 m은 101이 된다.
		System.out.println(m); 	  //101
		
		
		int res = ++m;
		System.out.println(res); //res는 102, m은 101
		res = m++; 					//res는 102
		System.out.println(res); //102를 출력
		
		
		//쌤 주석
		//++이 앞에 붙으면 증가된 값을 연산의 결과(이콜 왼쪽)로 준다
		//++이 뒤에 붙으면 증가되기 이전 값을 연산의 결과로 준다.
		
		
	}
}
