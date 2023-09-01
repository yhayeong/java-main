package com.test05;

import java.util.HashMap;
import java.util.Set;

public class Company {
	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<>();
		map.put(1, new Secretary("홍길동", 1, "Secretary", 800));
		map.put(2, new Sales("이순신", 2, "Sales", 1200));
		
		
		
		//@출력문 정렬 맞추기
		System.out.println("\n\n\nname      department    salary\n---------------------------");
		for(int key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		
		System.out.println("\n\n\n인센티브100지급");
		for (Employee e : map.values()) {
			if(e instanceof Secretary) {
				((Secretary) e).incentive(100);
			} else if(e instanceof Sales) {
				((Sales) e).incentive(100);
			}
		}
		
		
		System.out.println("\n\n\nname      department    salary    tax\n--------------------------------------");
		for (Employee e : map.values()) {
			System.out.println(e + String.format("   %.2f", e.tax()));
			
		}
		
		
	}
}
