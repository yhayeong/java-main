package com.test06.biz;

import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineBiz implements IVendingMachineBiz {

	private int balance = 1000; //현재 잔액
	private Drink[] cartList = new Drink[3]; //구입목록 배열
	private int count = 0; //배열개수
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}	
	
	
	//메뉴 입력 => 2,3,4
	@Override
	public void cartDrink(Drink drink) {
		String drinkName = "";
		if(drink instanceof Juice) drinkName = "쥬스";
		else if(drink instanceof Coffee) drinkName = "커피";
		else if(drink instanceof Coke) drinkName = "코크";
		
		if(balance<drink.getPrice()) {
			System.out.println("잔액이 부족하여 " + drinkName + " 구매 불가능합니다.");
		} else {
			setBalance(balance-drink.getPrice());
			System.out.print(drinkName + "를 구입했습니다.");
			System.out.println(" 현재 잔액: " + balance + " 원\n");
			
			//구입목록 배열에 저장
			if(cartList.length == count) {
				Drink[] tmpCartList = new Drink[cartList.length * 3];
				System.arraycopy(cartList, 0, tmpCartList, 0, count);
				cartList = tmpCartList;
			}
			cartList[count++] = drink;
		}
	}

	
	//메뉴 입력 => 5
	@Override
	public void printCart() {
		int juiceCnt = 0;
		int coffeeCnt = 0;
		int cokeCnt = 0;
		int totalPay = 0;

		for (Drink drink : cartList) {
			if(drink instanceof Juice) {
				juiceCnt++;
				totalPay += drink.getPrice();
			} else if(drink instanceof Coffee) {
				coffeeCnt++;
				totalPay += drink.getPrice();
			} else if(drink instanceof Coke) {
				cokeCnt++;
				totalPay += drink.getPrice();
			}
		}

		System.out.println("=====음료수 구입 목록=====");
		System.out.println("쥬스 : " + juiceCnt + " 개");
		System.out.println("커피 : " + coffeeCnt + " 개");
		System.out.println("코크 : " + cokeCnt + " 개");
		System.out.println("=======================");
		System.out.println("사용 금액: " + totalPay);
		System.out.println("남은 금액: " + balance + "\n");
		
	}
	
	
	

	//메뉴 입력 => 1
	@Override
	public void printDrinkList(Drink[] drinkList) {
		System.out.println("================");
		System.out.println("음료수명\t가격");
		System.out.println("================");
		for (Drink d : drinkList) System.out.println(d);
		System.out.println("----------");
		System.out.println("현재 잔액: " + balance + "\n");
	}
	
}
