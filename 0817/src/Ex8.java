
public class Ex8 {

	public static void main(String[] args) { //1의 개수, 2의 개수, 3의 개수, 4의 개수만큼 별찍기

		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		
		
		for (int i = 0; i < answer.length; i++) { //i=0,1,2,3,....
			/* (1) 알맞은 코드를 넣어 완성하시오. */
			
 
			if(answer[i] ==1) counter[0]++;
			else if(answer[i] ==2) counter[1]++;
			else if(answer[i] ==3) counter[2]++;
			else if(answer[i] ==4) counter[3]++;
		
			//패턴을 이용해 압축한 코드
			counter[answer[i]-1]++;

		}
		
		
		//별찍기
		for (int i = 0; i < counter.length; i++) {
			/*
			 * (2) 알맞은 코드를 넣어 완성하시오.
			 */
			System.out.print(counter[i]);
			
			for (int j = 0; j < counter[i]; j++) {
				System.out.print("*");
			}
			
			
			
			System.out.println();
			
		}

	}

}
