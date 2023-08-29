class MyButton {
	String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	void click() {
		System.out.println("(쏙 들어갔다 나옴)");
	}
}


class LoginButton extends MyButton {
	@Override
	void click() {
		super.click();
		System.out.println("로그인 처리");
	}
}



public class InterfaceTest2 {
	public static void main(String[] args) {
		
//		MyButton loginBtn = new MyButton();
		MyButton loginBtn = new LoginButton();
		loginBtn.setTitle("로그인");
		loginBtn.click();
		
	}
}


/* 
 이렇게 
 각각의 버튼 처리를 위해서 MyButton을 매번 상속해서 사용하는 형태는 비효율적이다
 -> 인터페이스를 이벤트함수로 사용하는 방법인 InterfaceTest3
 * */
