package ex9;

public class Ex9_4_5 {
	static void printGraph(int[] dataArr, char ch) {
		/*
		 * (1) printGraph메서드를 작성하시오.
		 * 
		 * 이 메소드는 주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력한다.
		 */

		for (int i = 0; i < dataArr.length; i++) {
			int cnt = dataArr[i];
			for (int j = 0; j < cnt; j++) {
				System.out.print(ch);
			}
			System.out.println(cnt);
		}
		
//		for (int i : dataArr) {
//			for (int j = 0; j < i; j++) {
//				System.out.print(ch);
//			}
//			System.out.println(i);
//		}
	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
		
		
		//Ex9_5
		System.out.println(count("12345AB12AB345AB","AB")); 
		System.out.println(count("12345","AB"));
	}

	//주어진 문자열에 찾으려는 문자열이 총 몇번 나오는지 세는 메소드
	public static int count(String src, String target) {
		int count = 0; // 찾아낸 횟수
		int pos = 0; // 찾기 시작할 위치
		/*
		 * (1) 반복문을 사용해서 아래의 과정을 반복한다. 
		 * 1. src에서 target을 pos의 위치부터 찾는다. 
		 * 2. 찾으면 count의 값을 1 증가 시키고, pos의 값을 target.length만큼 증가시킨다. 
		 * 3. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
		 */

		//문제해결방향: 찾을때마다 count를 1씩 증가시켜가면서 -1이 나올때까지 반복하는것
		
		
		/* indexOf(찾을대상,시작점)
		(    		검색범위   )
			( 		검색범위   )
			     (   검색범위  )
		*/
		
		while(true) {
			pos = src.indexOf(target, pos); //target을 pos부터 찾아서 시작인덱스를 반환 (처음에 pos는 0)
			
			//찾았으면 == indexOf메소드로 인해 반환된 인덱스가 -1이 아니면
			if(pos!=-1) {
				count++; //찾아낸횟수 갱신
				pos += target.length(); //검색위치(범위)를 조정
			} else if(pos==-1) {
				return count;
			}
		}
		
		
		//선생님 코드
//		while(true) {
//			pos = src.indexOf(target, pos);
//			if(pos<0) break;
//			count++;
//			pos += target.length();
//		}
//		return count;
		
	}
	

}
