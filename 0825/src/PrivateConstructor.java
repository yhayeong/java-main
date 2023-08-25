
//<싱글톤 객체>
class MyArray {
	
	private int[] arr = new int[10];
	private static MyArray myArray; //스태틱이어야하는 이유 1.유일해야해서 2.스태틱메소드에서사용할수있어야해서
	
	
	//클래스 외부에서는 객체 생성 불가능
	private MyArray() {}
	
	//외부에서 쓸수있는 -> public, 객체생성없이 쓸수있는 -> static
	public static MyArray getMyArrayReference() {
		
//		return new MyArray(); //매번 객체를 생성하므로 싱글톤x
		
		if(myArray==null) myArray = new MyArray();
		return myArray;
		//이미 생성돼있는게 없는 경우에만 딱한번 생성하여 그 인스턴스를 공용하겠다
	}
	
	
	
	public void setData(int idx, int data) {
		arr[idx] = data;
	}
	
	public int getData(int idx) {
		return arr[idx];
	}
}//MyArray


public class PrivateConstructor {
	public static void main(String[] args) {
		
//		MyArray myArr = new MyArray(); //생성자가 private인 클래스의 객체 생성 불가
		
		MyArray myArr1 = MyArray.getMyArrayReference();
		MyArray myArr2 = MyArray.getMyArrayReference();
		
		System.out.println(myArr1==myArr2); //true
		
		myArr1.setData(0, 100);
		System.out.println(myArr2.getData(0)); //100
		
		
	}
}



/* 싱글톤 패턴 : 
 
 싱글톤 객체란 생성자를 private으로 만듦으로써 '내부적으로' '단 하나의' 객체만 생성하여 공유하는 객체이다. 
 
 private생성자 => 외부에서 생성 불가
 객체 생성해주는 static메소드 => 객체 생성 없이 바로 사용 가능한 메소드

 
 
 
 
*/
