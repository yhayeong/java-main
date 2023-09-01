package com.test05;

public class Sales extends Employee implements Bonus {

	public Sales() {}
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	@Override
	public void incentive(int pay) {
		setSalary((int)((double)getSalary() + (double)pay*1.2));
	}

	@Override
	public double tax() {
		return getSalary()*0.13;
	}

}
