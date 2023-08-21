package ex6;

public class Ex3_4_5 {

	public static void main(String[] args) {
		
		Student st = new Student();
		st.name = "홍길동";
		st.ban = 1;
		st.no = 1;
		st.kor = 100;
		st.eng = 60;
		st.math = 76;
		
		System.out.println("이름 : " + st.name);
		System.out.println("총점 : " + st.getTotal());
		System.out.println("평균 : " + st.getAverage());
		
		System.out.println(st.info());
		
	}
}


class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		
		float avg = getTotal() / 3.0f;
		
//		avg = Math.round(avg);
		//Math.round함수는 소수점 첫째자리에서 반올림하여 int를 만들기 때문에 
		//소수점 두번째자리에서 반올림하려면 10을 곱한채로 반올림한뒤 다시 10으로 나눈다
		
		return Math.round(avg*10) / 10.0f;
		
	}
	
	String info() {
		
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+ getTotal() + "," + getAverage();
	}
}
