package com.test01;

public class TestMain01 {
	public static void main(String[] args) {
		
		int[][] array = {
							{ 12, 41, 36 ,56,21 }, 
							{ 82, 10, 12 ,61,45 }, 
							{ 14, 16, 18 ,78 ,65 }, 
							{ 45, 26, 72, 23, 34 }
						};
		
		double total = 0.0;
		double average = 0.0;
		
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				total += array[i][j];
				count++;
			}
		}
		
		average = total / count;
		
		System.out.println("합 계 : " + total);
		System.out.println("평 균 : " + average);
		
		//합 계 : 767.0
		//평 균 : 38.35
		
	}
}
