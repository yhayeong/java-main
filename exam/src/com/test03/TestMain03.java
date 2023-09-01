package com.test03;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestMain03 {
	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		
		StringTokenizer st = new StringTokenizer(str, ",");

		List<String> list = new ArrayList<>();
		double tot = 0.0;
		int cnt = 0;
		
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			list.add(tmp);
			tot += Double.parseDouble(tmp);
			cnt++;
		}
		
		//소수점 3자리까지 표현하기
		
//		System.out.println("합 계 : " + Math.round(tot * 1000.0) / 1000.0);
//		System.out.println("평 균 : " + Math.round((tot / cnt) * 1000.0) / 1000.0);
		
		System.out.println(String.format("합 계: %.3f", tot));
		System.out.println(String.format("평 균: %.3f", tot/cnt));
				
	}
}
