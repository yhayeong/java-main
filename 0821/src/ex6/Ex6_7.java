package ex6;

public class Ex6_7 {
	
	//두 점의 거리를 계산하는 Static 메소드
	//static메소드이므로 인스턴스변수를 사용하지 않는다. 그러므로 사용될때 모든인자를 넣어줘야한다
	static double getDistance(int x, int y, int x1, int y1) {
		//cf. 공식 : (x - x1)^2 + (y - y1)^2 의 제곱근 
		
		double distance = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
		return distance;
	}
	
	
	
	public static void main(String[] args) {
		//static메소드인 getDistance 호출
		System.out.println(getDistance(1, 1, 2, 2));
		
		//non-static메소드인 getDistance 호출
		MyPoint pos1 = new MyPoint();
		pos1.x=1;
		pos1.y=1;
		System.out.println(pos1.getDistance(2, 2));
		
		MyPoint pos2 = new MyPoint();
		pos2.x=2;
		pos2.y=2;
		System.out.println(pos1.getDistance(pos2));
	}

}


class MyPoint {
	int x;
	int y;
	
	//두 점의 거리를 계산하는 인스턴스 메소드
	//인스턴스 변수를 공유하여 사용
	double getDistance(int x1, int y1) { 
		double distance = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
		return distance;
	}
	
	double getDistance(MyPoint pos) {
		double distance = Math.sqrt((x-pos.x)*(x-pos.x)+(y-pos.y)*(y-pos.y));
		return distance;
	}
	
	//동기화 테스트
	//동기화 테스트222222
	
	
	
}
