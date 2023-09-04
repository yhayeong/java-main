package com.test06.entity;

public class Juice extends Drink {
	public static final int JUICE_PRICE = 200;
	
	public Juice() {
		super(JUICE_PRICE);
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%d","주스",JUICE_PRICE);
	}
}
