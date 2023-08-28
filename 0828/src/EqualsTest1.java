import java.util.jar.Attributes.Name;

//cf. 복소수란 실수부와 허수부가 같은 값을 의미한다
class Complex {
	
	int real;		 //실수부
	int imaginary;   //허수부
	
	public Complex(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Complex==false) return false;
		
//		return this.real==obj.real && this.imaginary==obj.imaginary; //Object타입 참조변수로 자식Complex에만 있는 멤버에 접근불가하므로 다운캐스팅 필요
		
		Complex com = (Complex)obj;
		return this.real==com.real && this.imaginary==com.imaginary;
	}
	
	@Override
	public String toString() {
		return this.real + "+" + this.imaginary + "i";
	}
}


public class EqualsTest1 {
	public static void main(String[] args) {
		Complex c1 = new Complex(3, 5);
		Complex c2 = new Complex(3, 5);
		Complex c3 = new Complex(5, 3);
		
		System.out.println(c1.equals(c2)); //true이고
		System.out.println(c1.equals(c3)); //false가 나오도록 오버라이딩하기
		System.out.println(c1); 			//3+5i(복소수 표기법)로 출력되도록 toString을 오버라이딩하기
		System.out.println(c3);			 	//5+3i
		
	}
}
