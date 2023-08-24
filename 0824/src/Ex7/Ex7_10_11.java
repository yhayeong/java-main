package Ex7;


//0822_Ex21 참고 (ch6)
class MyTv2 {
	//클래스 밖에서 읽고 쓸수 없도록 접근제한자 붙이기
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	private int prevChannel = 0; //Ex7_11 이전채널
	
	//getter
	public boolean isPowerOn() {
		return isPowerOn;
	}
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	
	//setter
	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = !isPowerOn;  //isPowerOn의 값이 true면 false , false 로 면 true로 바꾼다.
	}
	public void setChannel(int channel) { 
		prevChannel = this.channel; 
		this.channel = channel;
		//수행내용: 기존채널을 이전채널변수에 저장해두고 입력받은 채널로 현재채널을 덮어쓴다
		//주의: 채널 바꾸는 이 메소드는 gotoPrevChannel() 메소드를 위해서 
		//현재 채널을 지정한 채널로 바꾸기 전에 prevChannel에 따로 보관해두어야한다 (첫문장이 필요한 이유)
	}
	public void setVolume(int volume) {
		this.volume = volume;
		//이전 볼륨은 따로 저장해둘 필요가 없다(가져다 쓰는 일이 없기 때문)
	}
	
	
	//Ex7_11 메소드
	//현재 채널을 바로 이전 채널로 변경한다. (이전채널을 저장할 변수 선언 필요)
    public void gotoPrevChannel() {
    	//(1방식)
    	//this.channel과 prevChannel을 교환
    	int tempChannel = this.channel;
    	this.channel = prevChannel;
    	prevChannel = tempChannel;
    	
    	//(2방식)
//    	setChannel(prevChannel); //채널을 바꿀때마다 prevChannel에 새로 저장된 바로이전채널을 사용한다
    }

}

public class Ex7_10_11 {

	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		
		t.setVolume(20);
		System.out.println("VOL:" + t.getVolume());
	}

}
