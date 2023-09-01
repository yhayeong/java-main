package com.test06.biz;

import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineBiz implements IVendingMachineBiz {

	private int balance = 50; //현재 잔액
	private Drink[] cartList = new Drink[3]; //구입목록 배열
	private int count = 0; //배열개수
	
	
	
	
	
	@Override
	public void cartDrink(Drink drink) throws Exception {
		/*
		 1) 현재 잔액을 출력한다. ( Sample Run 참조 )
2) 매개변수로 넘겨받은 Drink 타입에 대한 메시지를 출력한다. (실행결과 참조) 
메시지 출력시 Drink 타입의 toString() 메소드를 사용한다.
3) 잔액과 구매가격을 비교하여 부족한 경우에 에러 메시지를 출력한다.
4) 현재 갖고 있는 잔액에서 구매가격만큼 뺀다.
5) 배열에 저장된 개수와 배열의 크기가 같으면, 기존의 배열보다 사이즈가 
3배인 배열을 생성한 후, 기존의 배열 내용을 새로운 배열에 복사하고 
새로운 배열과 기존 배열을 바꾼다.
6) 배열에 구매한 개수만큼 저장하고 count값을 증가시킨다. 
		 * */
		String drinkName = "";
		if(drink instanceof Juice) drinkName+="주스";
		else if(drink instanceof Coffee) drinkName+="커피";
		else if(drink instanceof Coke) drinkName+="코크";
		System.out.println(drinkName + "을/를 구입했습니다.");
		System.out.println("현재 잔액: " + balance + " 원");
		
		if(balance<drink.getPrice()) {
			if(drink instanceof Juice) throw new VendingMachineException(VmError.JUICE);
			else if(drink instanceof Coffee) throw new VendingMachineException(VmError.COFFEE);
			else if(drink instanceof Coke) throw new VendingMachineException(VmError.COKE);
		}
		
		
	}

	@Override
	public void printCart() {
		
	}
	
	
	

	@Override
	public void printDrinkList(Drink[] drinkList) {
		System.out.println("================");
		System.out.println("음료수명\t가격");
		System.out.println("================");
		for (Drink d : drinkList) {
			System.out.println(d);
		}
		System.out.println("----------");
		System.out.println("현재 잔액: " + balance);
	}
	
}
