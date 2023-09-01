package com.test06;

import java.util.Scanner;

import com.test06.biz.VendingMachineBiz;
import com.test06.biz.VendingMachineException;
import com.test06.biz.VmError;
import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		VendingMachineBiz vm = new VendingMachineBiz();
		Drink[] drinkList = {new Coffee(), new Juice(), new Coke()};
		
		MENU:
		while(true) {
			try {
				printMenu();
				System.out.print("메뉴 입력 => ");
				int sel = Integer.parseInt(sc.nextLine());
				switch (sel) {
				case 1: vm.printDrinkList(drinkList); break;
				case 2: vm.cartDrink(drinkList[1]); break;
				case 3: vm.cartDrink(drinkList[0]); break;
				case 4: vm.cartDrink(drinkList[2]); break;
				case 5:
				case 9: System.out.println("프로그램 종료"); break MENU;
				default: throw new VendingMachineException(VmError.MENU);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void printMenu() {
		System.out.println("==========================");
		System.out.println("[음료수 자판기 관리 시스템]");
		System.out.println("==========================");
		System.out.println("1.전체 음료수 및 잔액 보기");
		System.out.println("2.쥬스 구입하기 ( 200 원 )");
		System.out.println("3.커피 구입하기 ( 100 원 )");
		System.out.println("4.코크 구입하기 ( 50 원 )");
		System.out.println("5.구입한 음료수 목록 보기");
		System.out.println("9.종료");
		System.out.println("\n\n==========================\n");

	}
}
