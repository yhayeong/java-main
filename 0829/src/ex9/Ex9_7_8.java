package ex9;

public class Ex9_7_8 {
	
	public static boolean contains (String src, String target) {
//		if(src.indexOf(target)>=0) return true; 
//		else return false;
		
//		return src.indexOf(target)>=0;
		
		return src.indexOf(target)!=-1;
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
		
		
		//Ex9_8
		System.out.println(round(3.1415,1)); //3.1
		System.out.println(round(3.1415,2)); //3.14
		System.out.println(round(3.1415,3)); //3.142
		System.out.println(round(3.1415,4)); //3.1415
		System.out.println(round(3.1415,5)); //3.1415
	}
	
	//Ex9_8
	public static double round(double d, int n) {
		
		return Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
		
		//n이 1이면 둘째자리에서 반올림하여 소수점 1자리까지 보여주기 -> 10의 1승을 곱하였다가 반올림후 나눠준다(둘중하나가 double이므로 결과도 double)
		//n이 2이면 셋째자리에서 반올림하여 소수점 2자리까지 보여주기 -> 10의 2승을 곱하였다가 반올림후 나눠준다
		
		//둘째자리까지->100.0 셋째자리까지->1000.0
		
		
		
		//선생님코드
//		double p = Math.pow(10, n);
//		return Math.round(d*p) / p;
		
		
		
	}
}
