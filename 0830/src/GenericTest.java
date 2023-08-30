class Data<T> { // Data의 타입이 Integer(int)가 될지 String이 될지 Person이 될지 등등 미정일때 이렇게 적어준다(new로 생성할때 타입을 정해서 생성)
	T data;
	void setData(T data) { //setter의 매개변수도 T타입일것이고
		this.data = data;
	}
	T getData() { //getter의 리턴타입도 T일것이므로 이렇게 적어준다
		return data;
	}
}
public class GenericTest {
	public static void main(String[] args) {
		Data<String> data1 = new Data<>();
		data1.setData("hong");
		String str = data1.getData();
		System.out.println(str); //hong
		
		Data<Integer> data2 = new Data<>();
		data2.setData(123);
		int num = data2.getData();
		System.out.println(num); //123
		
		Data<Person> data3 = new Data<>();
		data3.setData(new Person("james", 30));
		Person p1 = data3.getData();
		System.out.println(p1); //Person클래스에 오버라이딩한 toString대로 james,30 출력
		
//		data4 = data2; //타입이 달라 대입 불가능
		//다른 타입으로 생성된 제너릭 객체는 동일한 클래스가 아니며 상속관계도 아니다
		
		Data<Person> data4 = new Data<>();
		data4 = data3;
		//같은 타입으로 생성된 제네릭 객체는 동일한 클래스이다
		
	}
}
