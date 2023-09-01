package com.test05;

public class Secretary extends Employee implements Bonus {

	public Secretary() {}
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	
	//세금
	@Override
	public double tax() {
		return getSalary()*0.1;
	}
	//인센티브
	@Override
	public void incentive(int pay) {
		setSalary((int)((double)getSalary() + (double)pay*0.8));
	}
	
}
