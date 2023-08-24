package Ex7;

public class Ex7_18 {

	/*
	 * (1) action메서드를 작성하시오.
	 */
	static void action(Robot anyRobot) {
		//(1-2)자식에만 있는 메소드를 사용하려면 자식타입으로 다운캐스팅해야하는데, 형변환이 적절할지 유효성체크를 먼저 해주어야한다
		if(anyRobot instanceof DanceRobot) ((DanceRobot) anyRobot).dance();
		else if(anyRobot instanceof SingRobot) ((SingRobot) anyRobot).sing();
		else if(anyRobot instanceof DrawRobot) ((DrawRobot)anyRobot).draw();
		
		//이렇게 나눠서 작성해도 된다
		//DrawRobot drawRobot = (DrawRobot)anyRobot;
		//drawRobot.draw(); 
	}
	
	public static void main(String[] args) {
		
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		
		for (int i = 0; i < arr.length; i++)
			action(arr[i]); 
		//(1-1)action메소드는 Robot타입으로 인자를 받아서 Robot의 자식들이 가지고있는 (오버라이딩한x 자식 고유의)메소드를 호출해주어야한다
	
	} // main
}


class Robot {}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}

}


/* 문제 : 출력결과
춤을 춥니다. 
노래를 합니다. 
그림을 그립니다.
 */