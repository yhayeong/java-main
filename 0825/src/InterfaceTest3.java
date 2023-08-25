interface IClick {
	void iClick();
}

class BasicButton {
	String title;
	IClick iClick; //인터페이스타입의 참조변수가 정의돼있다(이 인터페이스를 상속한 클래스의 인스턴스가 저장될 수 있다)
	void click() {
		System.out.println("(((쏙 들어갔다 나옴)))");
		if(iClick!=null) { //IClick타입 객체(IClick을 상속받은 객체)를 만들어서 멤버에 저장해둔 게 있으면 그 메소드를 호출해준다
			iClick.iClick();
		}
	}
	void addClickEventHandler(IClick iClick) {
		this.iClick = iClick;
	}
	
}
//----------여기까지는 개발자가 제공받은 클래스


//----------개발자:로그인 기능(을 위한 클래스 cf. 자바는 메소드'만' 만들수는 없음)을 만들어서 버튼에 추가해준다
class LoginClick implements IClick {
	@Override
	public void iClick() {
		System.out.println("~~어떤 특정한 로그인 처리~~");
	}
}



public class InterfaceTest3 {
	public static void main(String[] args) {
		
		BasicButton loginBtn = new BasicButton();
		loginBtn.addClickEventHandler(new LoginClick()); 
		loginBtn.click(); 
		
		//1. (로그인기능을 위해 일단)BasicButton인스턴스를 생성해둔다
		//2. (로그인처리기능을 정의해둔)LoginClick인스턴스를 만들어서 1에서 생성해둔 BasicButton타입 인스턴스의 멤버변수에 저장한다
		//3. BasicButton클래스에 정의된 click()메소드를 호출해서 개발자가 쓰고자하는 특정한 기능을 사용할 수 있다
		// + 2에서 개발자가 특정기능을 정의하는 클래스를 만들때 제공된 인터페이스를 상속하여야만 이 인터페이스를 멤버변수에 저장할 수 있다 -> 표준화
		
		
		
		
		/* ----------------------------------------------------------------------------------- 
		 일회성으로 사용할 클래스이므로 익명클래스로 만들어서 바로 생성한 뒤 파라미터로 넘길 수 있다
		 
		 new 부모클래스명() {
		 
		 	
		 }
		 ㄴ--> 익명클래스 또는 내부클래스라고 부른다
		 내부클래스: 클래스안에 작성된 클래스 / 파라미터에 작성된 클래스
		 
		 
		 웹개발에서는 쓸 일이 아예 없지만 안드로이드개발(화면이 있는)에서는 꽤 사용됨
		*/
		BasicButton joinBtn = new BasicButton();
		joinBtn.addClickEventHandler(new IClick() {
			@Override
			public void iClick() {
				System.out.println("~~~어떤 특정한 회원가입 처리~~~");
			}
		});
		joinBtn.click();
		
		
		
	}
}
