package com.test02;

public class Student extends Human {

	//필드
	private String number;
	private String major;
	
	//생성자
	public Student() {}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	//getter, setter
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	//메소드
	@Override
	public String toString() {
//		return String.format("%d\t%d\t%d\t%d\t%s\t%s", name, age, height, weight, number, major);
		return "" + name+" " + age+" " + height+" " + weight+" " + number+" " + major;
	}
	
}
