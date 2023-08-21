package esc;

public class Ex2 {

	public static void main(String[] args) {

//		[4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		
		int sum = 0;
		for(int i=1; i<20; i++) {
//			if(i%2==0 || i%3==0) continue;
//			sum += i;
			
			if(!(i%2==0 || i%3==0)) {
				sum += i;
			}
			//이렇게도 가능
		}
		System.out.println(sum);
		
		
		
//		[4-3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				sum += j; //i=1일때 j=1 i=2일때 j=1,2 i=3일때 j=1,2,3... 
//				System.out.print("*");
			}
//			System.out.println();
		}
		System.out.println(sum);
		
		
		
//		[4-4] 1+(-2)+3+(-4)+...  과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 
//		100이상이 되는지 구하시오.
		
		int sum2 = 0; 
		int num = 0;
		
//		while(true) {
//			++num;
//			if(num%2==0) num *= -1;
//			sum2 += num;
//			
//			if(sum2>=100) break;
//		}
//		System.out.println("바꾸기 전 sum2 : " + sum2 + ", num : " + num); 
		
		
			//옳게 바꾸면
		while(true) {
		    ++num;
		    
		    if(num % 2 == 0) sum -= num;  
		    else sum2 += num; 
		    
		    if(sum2 >= 100) {
		        break;
		    }
		}
		
		System.out.println("옳게바꾼 후 sum2 : " + sum2 + ", num : " + num);

		
		//선생님
		// 변수 초기화
//		int sum = 0;
//		int i = 1;
//
//		// 루프 시작
//		for (i = 1; ; i++) {
//		    // 현재 숫자 i가 짝수인지 홀수인지에 따라 숫자를 합계에 더하거나 빼는 부분
//		    sum += (i % 2 == 0) ? -i : i;
//
//		    // 합계가 100 이상이 되었는지 확인
//		    if (sum >= 100) {
//		        break;  // 조건이 충족되면 루프 종료
//		    }
//		}
//
//		// 최종 합계와 i의 값을 출력
//		System.out.println("sum : " + sum + ", i : " + i);
		
		

		//5번문제
		//for문을 while문으로 바꾸는 방법
		//초기식은 while문 밖으로 빼고 증감식은 while문 안의 맨끝으로 뺀다. 즉 조건식만 남긴다.
		int i=0;
		while(i<=10) {
			
			int j=0; 
			while(j<=i) {
				System.out.print("*");
				j++;		
			}	
			
			System.out.println(); 
			i++;
		}
		
		
		//6번문제 - 주사위 두개를 던져서 눈의 합이 6이 되는 모든 경우의 수를 출력하기 
		for(int k=1; k<=6; k++) {
			for(int j=1; j<=6; j++) {
				
				if(k+j ==6) {
					System.out.println(String.format("(%d, %d)", k, j));
				}
			}
		}

	
		
		
		
		
	}

}
