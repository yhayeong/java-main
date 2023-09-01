package com.test06.biz;

import com.test06.entity.Drink;

public interface IVendingMachineBiz {
	
	abstract void cartDrink(Drink drink) throws Exception;
	abstract void printCart();
	abstract void printDrinkList(Drink[] drinkList);
	
}
