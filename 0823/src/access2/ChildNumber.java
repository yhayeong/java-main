package access2;

import access1.Number;

public class ChildNumber extends Number {
	
	void cmethod() {
		
//		System.out.println(pnum);
		//자식이라 하더라도 부모의 private 멤버에 접근 불가
		
//		System.out.println(dnum);
		//자식이라 하더라도 부모와 패키지가 다르면 default 멤버에 접근 불가
		
		System.out.println(pubNum);
		//public은 어디서든 접근 가능
		
		System.out.println(proNum);
		//패키지가 다르더라도 자식이라면 부모의 protected 멤버에 접근 가능
	}

}
