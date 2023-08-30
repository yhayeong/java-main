package acc;

import java.util.Scanner;

import exception.BankError;
import exception.BankException;

public class Account {
	String id;
	String name;
	int balance;
	
	public Account() {}
	public Account(String id, String name, int money) {
		this.id = id;
		this.name = name;
		this.balance = money;
	}
	
	@Override
	public String toString() {
		return String.format("계좌번호:%s, 이름:%s, 잔액:%d", id, name, balance);
	}
	
	public void deposit(int money) throws BankException {
		if(money<=0) {
			throw new BankException("입금금액오류", BankError.MINUS);
		}
		balance += money;
		System.out.println("*" + money + "원을 입금하셨습니다.");
	}
	
	public void withdraw(int money) throws BankException {  //이 withdraw를 호출하는 호출부는 Bank의 withdraw메소드이다
		//Bank의 withdraw에서도 예외처리코드가 없으면서 메소드선언부에 throw BankException으로 위임처리하고있기 때문에 결국 main에서 예외처리하게된다.
		if(balance < money) {
			throw new BankException("잔액부족오류", BankError.LACK);
		} else if(money<0) {
			throw new BankException("출금금액오류", BankError.MINUS);
		}
		
		balance -= money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	
}

