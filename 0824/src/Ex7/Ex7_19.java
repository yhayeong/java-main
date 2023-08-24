package Ex7;

public class Ex7_19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new TV());
		b.buy(new Computer());
		b.buy(new TV());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}


//buy메소드가 add메소드를 호출한다


class Buyer {
	
	int money = 1000;
	
	Product[] cart = new Product[3]; //구입한 제품을 저장하기 위한 배열
	int i = 0; 						  //Product배열 cart에 사용될 인덱스 (배열에 저장된 물건 수)
	
	
	void buy(Product p) {
		/*
		 (1) 아래의 로직에 맞게 코드를 작성하시오.
			1.1 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다.
			1.2 가진 돈이 충분하면, 제품의 가격을 가진 돈에서 빼고
			1.3 장바구니에 구입한 물건을 담는다.(add메서드 호출) 
		 */
		
		if(money<p.price) {
//			System.out.println("잔액이 부족하여 " + p.toString() + "을 살 수 없습니다");
			System.out.println("잔액이 부족하여 " + p + "을/를 살 수 없습니다"); 
			return;
		}
		money -= p.price;
		add(p);
		
	}//buy메소드

	
	void add(Product p)   { 
		/*
		(2) 아래의 로직에 맞게 코드를 작성하시오.
			1.1 i의 값이 장바구니의 크기보다 같거나 크면
			1.1.1 기존의장바구니보다 2배 큰 새로운 배열을 생성한다.
			1.1.2 기존의장바구니의 내용을 새로운 배열에 복사한다.
			1.1.3 새로운장바구니와 기존의 장바구니를 바꾼다.
			1.2 물건을 장바구니cart에 저장한다. 그리고 i의 값을 1 증가시킨다
		*/
		
		if(i>=cart.length) {
			Product[] newCart = new Product[cart.length*2];
			System.arraycopy(cart, 0, newCart, 0, cart.length); //기존배열의,몇번째부터,새로만든배열에,몇번째부터,몇개까지
			cart = newCart;
		}
		cart[i++]=p;
	} //add메소드
	
	
	void summary()    {
		/*
		(3) 아래의 로직에 맞게 코드를 작성하시오.
			1.1 장바구니에 담긴 물건들의 목록을 만들어 출력한다.
			1.2 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다.
			1.3 물건을 사고 남은 금액(money)를 출력한다. 
		*/
		
//		System.out.print("구입한 물건:");
//		for (Product p : cart) {
//			System.out.println(p.toString() + ",");
//		}
		
		//선생님 코드
		String proList = "";
		int totamt = 0;
		
		for (int k = 0; k < i; k++) { //배열에 저장된 요소 수만큼만 반복 수행
			proList += cart[k] + ",";
			totamt += cart[k].price;
		}
//		for (int i = 0; i < cart.length; i++) { //배열의 길이만큼 반복하는데
//			if(cart[i]==null) break;			//null인 요소를 만나면 반복 종료
//			proList += cart[i] + ",";
//			totamt += cart[i].price;
//		}
		
		System.out.println("구입한 물건:" + proList);
		System.out.println("사용한 금액:" + totamt);
		System.out.println("남은 금액:" + money);
	}//summary()
	
	
}//Buyer클래스


class Product {
	int price;
	
	Product(int price) {
		this.price = price;
	}
}

class TV extends Product {

	TV() { super(100); } //부모의 기본생성자는 없고, TV의 기본생성자는 부모의 매개변수가 있는 생성자를 호출하여 초기화해야함
	public String toString() { return "Tv"; }
	
}

class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer"; }
}

class Audio extends Product {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
}




/* 문제:출력
잔액이   부족하여   Computer을/를   살수   없습니다.
구입한   물건:Tv,Computer,Tv,Audio,Computer,Computer, 
사용한   금액:850
남은   금액:150 
*/
