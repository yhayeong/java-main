package ex9;

public class Ex9_11 {
	public static void main(String[] args) {
		
		//클래스 우클릭후 RunAs>RunConfiguration의 Arguments에 두 수를 스페이스바를 구분자로 하여 삽입한다
		int from = 0;
		int to = 0;
		
		try {
			if(args.length!=2) throw new Exception("두개의 정수만을 입력해 주세요.");
		
			from = Integer.parseInt(args[0]);
			to = Integer.parseInt(args[1]);
			//구구단 출력에 쓸 (단의 범위) from과 to에 삽입한 인자인 문자열배열의 0번째와 1번째를 넣는데 int로 변환해야함
		
		
		/* 추가적으로 고려해야할것: 
		 1. 숫자를 두개만 받아야함 -처리완료
		 2. 2부터 9사이의 정수만 유효 -처리완료
		 3. 두 인자를 넣었을때 앞수가 뒷수보다 더 클수도 있음 -처리완료
		 */
			
			
			if(!(2<=from && from <=9 && 2<=to && to<=9)) throw new Exception("단의 수로 2와 9 사이의 정수값을 입력해주세요.");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("프로그램이 종료됩니다.");
			
			System.exit(0); //이 문장이 없다면 catch블럭이 받으면서 프로그램이 비정상종료되지 않고 예외처리를 해줌으로써 catch문 이후의 문장이 계속 실행되게된다.
			//이 문장 없이 예외발생시 프로그램 종료되도록 하고싶다면 이후 문장들 전부 try문 안에 넣으면 된다(예외발생한 문장에서 catch문으로 점프하게되면서 catch문 밖의 수행문이 없으므로)
		}
		
		if(from==to) System.out.println("서로 다른 두 수를 입력해 주세요.");
		else if(from>to) {
			int tmp = from;
			from = to;
			to = tmp;
		}
		
		for (int i = from; i <= to; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i +"*"+ j +"=" +i*j);
			}
			System.out.println();
		}
	}//main

}
