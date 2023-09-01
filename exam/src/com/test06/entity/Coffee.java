package com.test06.entity;

public class Coffee extends Drink {
	public static final int COFFEE_PRICE = 100;
	
	public Coffee() {
		super(COFFEE_PRICE);
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%d","커피",COFFEE_PRICE);
	}
}
