class TV { //클래스 내 속성(power, channel, size)은 클래스 내 메소드들이 공유하여 사용한다. 
	boolean power;
	int channel;
	int size = 50;
	
	void onOff() {      
		power = !power; //메소드에 소속된 변수가 아닌 클래스에 있는 변수를 사용(iv를 사용)
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	String info() {
		return String.format("size:%d, channel:%d, power:%s", size, channel, (power)?"on":"off");
	}
	
}
public class ClassTest3 {
	
	public static void main(String[] args) {
		TV tv = new TV();
		System.out.println(tv.info());
		
		tv.onOff();
		System.out.println(tv.info());
		
		tv.channelUp();
		tv.channelUp();
		tv.channelDown();
		System.out.println(tv.info());
		
	}
	
	
}
