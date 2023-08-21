
public class OperTest2 {
	
	public static void main(String[] args) {
		
		int i = -10;
		i = +i; 
		System.out.println(i); //-10
		
		i = -i; 				//부호 반전 (i에 -1을 곱하는것)
		System.out.println(i); //10
		
		
		boolean power = false;
		power = !power;
		System.out.println(power); //true

		
		//비트변환 연산자
		int j = 10;
		System.out.println(j);
		j = ~j; 
		System.out.println(j); //-11
		/* 10을 2진수로 바꿔서 0과 1을 뒤집는다 (1의 보수)
		 * 2의 보수는 1의 보수에 +1을 한것 
		 * 맨앞 비트는 부호를 나타내는데 0이 아닌 1 -> 마이너스임
		 * ---> -11
		 * */
		
		
	}

}
