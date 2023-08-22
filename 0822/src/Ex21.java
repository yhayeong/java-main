class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff() {
		// (1) isPowerOn의 값이 true면 false , false 로 면 true로 바꾼다.
		isPowerOn=!isPowerOn; 
	}

	void volumeUp() {
		// (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1증가시킨다.
		volume = (volume<MAX_VOLUME)? ++volume: MAX_VOLUME; 
		/* volume++하게되면 왼쪽의 volume에는 이전 값을 대입하게 되므로 예상과 다른 결과가 나온다.(++ 연산자 로직 이해)
		 * 만일 volume+1을 하게되면 이전 값을 대입하는 volume++과는 다르기 때문에 의도한대로의 결과가 나오게된다. */
		
//		if(volume<MAX_VOLUME) volume++;
	}

	void volumeDown() {
		// (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1감소시킨다.
		volume = (volume>MIN_VOLUME)? --volume: MIN_VOLUME;
//		if(volume>MIN_VOLUME) volume--;
	}

	void channelUp() {
		// (4) channel의 값을 1증가시킨다.
		// 만일 channel이 MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다
		channel = (channel==MAX_CHANNEL)? MIN_CHANNEL: ++channel; 
//		if(channel==MAX_CHANNEL) channel = MIN_CHANNEL;
//		channel++;
	}

	void channelDown() {
		// (5) channel의 값을 1감소시킨다.
		// 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
		channel = (channel==MIN_CHANNEL)? MAX_CHANNEL: --channel; 
//		if(channel==MIN_CHANNEL) channel = MAX_CHANNEL;
//		channel--;
	}
}

public class Ex21 {

	public static void main(String[] args) {
		MyTv t = new MyTv();
		
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:" + t.channel + ",   VOL:" + t.volume);
		
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:" + t.channel + ",   VOL:" + t.volume);
		
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:" + t.channel + ",   VOL:" + t.volume);
		
	}
	
	/*
	 	CH:100,   VOL:0 
		CH:99,   VOL:0 
		CH:100,   VOL:100
	 */
}
