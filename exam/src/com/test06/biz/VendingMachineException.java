package com.test06.biz;

import com.test06.entity.Drink;

public class VendingMachineException extends Exception {
	
	VmError errCode;
	
	public VendingMachineException(VmError errCode) {
//		super(message);
		this.errCode = errCode;
	}
	
	@Override
	public String toString() {
		String message = "";
		switch (errCode) {
		case MENU : message += "메뉴값을 확인후 다시 입력하세요"; break;
		case JUICE : message += "잔액이 부족하여 쥬스 구매 불가능합니다."; break;
		case COFFEE : message += "잔액이 부족하여 커피 구매 불가능합니다."; break;
		case COKE : message += "잔액이 부족하여 코크 구매 불가능합니다."; break;
		default : message += "일반 오류입니다."; break;
		}
		return message;
	}
}
