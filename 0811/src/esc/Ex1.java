package esc;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식 
		 * 2. char형 변수 ch가 공백이나 탭이 아닐 때 true인
		 * 조건식 
		 * 3. char형 변수 ch가 ‘x' 또는 ’X'일 때 true인 조건식 
		 * 4. char형 변수 ch가 숫자(‘0’~‘9’)일 때
		 * true인 조건식 
		 * 5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식 
		 * 6. int형 변수 year가 400으로
		 * 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인 조건식 
		 * 7. boolean형 변수 powerOn가
		 * false일 때 true인 조건식 
		 * 8. 문자열 참조변수 str이 “yes”일 때 true인 조건식
		 */
		int x = 10;
		if(x>10 && x<20) {}
		
		char ch = ' ';
		if(!(ch == ' ' || ch == '\t')) {} //공백이거나 탭인 경우가 아닌 경우
		if(ch!=' ' && ch!='\t') {} //공백이 아니면서 탭이 아닌경우
		
		if(ch =='x' || ch=='X') {}
		
		if('0'<=ch && ch <= '9') {}
		
		if(65<=ch && ch <= 90 || 97 <= ch && ch <= 122) {}
		if('A'<=ch && ch <= 'Z' || 'a' <= ch && ch <= 'z') {}
			//65~90, 97~122
		
		int year = 2023;
		if(year%400==0 || year%4==0 && year%100!=0) {} //윤달
		
		boolean powerOn = false;
		if(!powerOn) {}
		
		String str = "no";
//		if(str=="yes") { System.out.println("예.");}
		if(str.equals("no")) { System.out.println("아니오.");}
		
		
		
		
		
		
	}

}
