package ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex8_8 {
	public   static   void   main(String[]   args) {
		
		//1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer= (int)(Math.random() * 100) + 1;
		int input = 0;       //사용자입력을 저장할 공간
		int count = 0;       //시도횟수를 세기 위한 변수
		
		do   {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : "); 
			
//			input = new Scanner(System.in).nextInt(); 
			
			//문제 : 예외처리를 해서 숫자가 아닌 값을 입력했을 때는 다시 입력을 받도록 보완하라.
			
			try {
				input = new Scanner(System.in).nextInt(); 
			} catch(InputMismatchException e) {
				System.out.println("유효하지 않은 값을 입력하셨습니다."); 
				continue; //이후의 문장을 수행하지 않고 다음 반복 회차로 가게한다 (input이 잘못됐으면 input을 가지고 수행하지 말아야함)
			}
			
			
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요."); 
			} else if(answer < input) {
				System.out.println("더 작은 수를 입력하세요."); 
			} else {
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 " + count + "번 입니다."); 
				break; //do-while문을 벗어난다
			}
		} while(true); //무한반복문 
	
	} // end of main
}
// end of class HighLow
