package com.test04;

public class Cargoplane extends Plane {
	public Cargoplane() {}
	public Cargoplane(String planeName, int fuel) {
		super(planeName, fuel);
	}
	
	
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - distance*5);
	}
	
	@Override
	public String toString() {
		return getPlaneName() + " " + getFuelSize();
	}
	
	
}
