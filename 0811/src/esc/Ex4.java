package esc;

public class Ex4 {
	
	public static void main(String[] args) {
		
		//4-12 구구단

		
		//메모
		//3중 for문 손으로 색깔로 무엇을 변하게 하는지 표시해보기
		
		
		
		//답안코드
		for (int i = 1 ; i <= 9 ; i++) {
			for (int j = 1; j <= 3; j++) { 
				int x = j+1+(i-1)/3*3; 
				int y = i%3==0? 3 : i%3 ;
				
				if(x > 9) 
					break;
				
				System.out.print(x+"*"+y+"="+x*y+"\t");
			}
			System.out.println();
			if(i%3==0) System.out.println(); // 
		}
		
		
		//패턴찾을수있는지가 관건
		/*
		 * 
		 * x=단, y=수

		 i=1
		 j=1:x=2, j=2:x=3, j=3:x=4
		 j=1:y=1, j=2:y=1, j=3:y=1
		 //2*1=2
		 //3*1=3
		 //4*1=4

		 i=2
		 j=1:x=2, j=2:x=3, j=3:x=4
		 j=1:y=2, j=2:y=2, j=3:y=2
		 
		 
		 i=3
		 j=1:x=2, j=2:x=3, j=3:x=4
		 j=1:y=3, j=2:y=3, j=3:y=3
		 
		 
		 i=4
		 j=1:x=5, j=2:x=6, j=3:x=7
		 j=1:y=1, j=2:y=1, j=3:y=1
		 
		 i=5
		 j=1:x=5, j=2:x=6, j=3:x=7
		 j=1:y=2, j=2:y=2, j=3:y=2
		 
		 i=6
		 j=1:x=5, j=2:x=6, j=3:x=7
		 j=1:y=3, j=2:y=3, j=3:y=3
		 
		 
		 //i와 j를 사용하여 x를 만들어내야함
		 		   j=1,2,3
		 i=1,2,3 : x=2,3,4  
		 i=4,5,6 : x=5,6,7
		 i=7,8,9 : x=8,9,10 
		 
		 
		 -> x = j +  1 * (i-1)/ 3*3
		 i가 1일때는 무조건  j+ 뒤가 0이 됨
		 2,3일때도 j+ 뒤가 0이 되는 이유는 int나누기 int라서 0.xxx는 소수점 아래가 절삭되기 때문임
		 
		 i가 4,5,6일때는 {1,2,3}+    1 * ({4,5,6}-1) / 3 * 3
		 						//+뒤로 4가 되어야
		 i가 7,8,9일때는 {1,2,3}+    1 * ({7,8,9}-1) / 3 * 3
		 						//+뒤로 6이 되어야
		 
		 
		 
		 
		 i=1,4,7 -> y=1 
		 i=2,5,8 -> y=2
		 i=3,6,9 -> y=3
		 
		 y= i%3 == 0? 3 : i%3;
		 
		 * */
		
		
		
		
		
		
		
		
	
		System.out.println("==============");
		
		//4-13 
		
		String value = "12o34"; 
		char ch = ' ';
		boolean isNumber = true;
		
		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를 
		// 하나씩 읽어서 검사한다.
		
		for(int i=0; i < value.length() ;i++) { 
			 ch = value.charAt(i);
			 
			 if(!('0'<=ch && ch <= '9')) {
				 isNumber = false;
				 break;
			 }
					 
		}
		
		if (isNumber) {
			System.out.println(value+"는 숫자입니다."); 
			
		} else {
			System.out.println(value+"는 숫자가 아닙니다."); 
		}
		
		
		
		
		//4-14
		
		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;          // 사용자입력을 저장할 공간
		int count = 0;          // 시도횟수를 세기위한 변수
		
		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용 
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 :"); 
			input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.
			
			
			if(!(0< input && input <100)) {
				System.out.println("1과 100사이의 값을 입력해야합니다.");
			} else {
				
				if(answer == input) {
					System.out.println("맞췄습니다!\n랜덤한 정답은 " + answer + "이었습니다.");
					System.out.println("최종 시도 횟수는 " + count + "입니다.");
					break;
				} else if(input < answer) {
					System.out.println("입력수는 정답보다 작습니다.");
					System.out.println("현재 시도 횟수는 " + count + "입니다.");
				} else {
					System.out.println("입력수는 정답보다 큽니다.");
					System.out.println("현재 시도 횟수는 " + count + "입니다.");
				}
			}
		
			
		
		} while(true); // 무한반복문
		
		
		
		
		
	}

}
