package com.kosta.shop;

import java.util.List;

import com.kosta.order.Order;
import com.kosta.product.Goods;

public class Shop { // Service
	
	//구현해야 하는 부분: ApplicationMain.java 오류 없이 작동하도록 필요한 모든 메서드를 구현한다.
	
	
	GoodsDAO goodsDao = null;
	OrderDAO orderDao = null;
	public Shop() {
		goodsDao = new GoodsDAO();
		orderDao = new OrderDAO();
	}
	
	
	// 상품 추가
	public void addProduct(Goods goods) {
		int cnt = goodsDao.insertProduct(goods);
		if(cnt>0) System.out.println(cnt + "개의 상품이 등록되었습니다.");
		else System.out.println("상품 등록 실패");
	}

	// 주문 추가 - 주문테이블에 인서트 & @@@상품테이블 재고량 업데이트, 주문번호를 리턴
	public int order(Order order) {
		
		Goods goods = goodsDao.selectProductByCode(order.getProductCode());
		goods.setStock(order.getAmount());
		int cnt2 = goodsDao.updateProductStock(order.getNo(), goods);
		
		int cnt1 = orderDao.insertOrder(order);
		if(cnt1>0 && cnt2>0) System.out.println(cnt1 + "건의 주문이 추가되었습니다.");
		else System.out.println("주문 추가 실패");
		
		int orderNo = order.getNo();
		return orderNo;
	}
	
	// 상품 정보 조회
	public Goods findProductByCode(String code) {
		Goods goods = goodsDao.selectProductByCode(code);
		if(goods==null) System.out.println("해당 상품이 존재하지 않습니다.");
		return goods;
	}
	
	// 주문 정보 조회
	public Order findOrderByNo(int orderNo) {
		Order order = orderDao.selectOrderByNo(orderNo);
		if(order==null) System.out.println("해당 주문이 존재하지 않습니다.");
		return order;
	}
	
	// 주문 취소 -> select해와서 취소여부를 바꾸고, update호출하여 DB에 반영
	// @@@ 상품테이블 재고량 업데이트
	public Order cancelOrder(int orderNo) {
		Order order = orderDao.selectOrderByNo(orderNo);
		order.setCanceled(true);
		int cnt1 = orderDao.updateCancelOrder(order);

		Goods goods = goodsDao.selectProductByCode(order.getProductCode());
		goods.setStock(goods.getStock() + order.getAmount());
		int cnt2 = goodsDao.updateProductStock(order.getNo(), goods);
		
		if(cnt1>0 && cnt2>0) System.out.println(cnt1 + "건의 주문이 취소되었습니다.");
		else System.out.println("주문 취소 실패");
		return order;
	}
	
	// 전체 상품 정보 출력
	public void printAllProductInfo() {
		List<Goods> productList = goodsDao.selectProductList();
		for (Goods goods : productList) {
			System.out.println(goods);
		}
	}
	
	// 전체 주문 정보 출력
	public void printAllOrderInfo() {
		List<Order> orderList = orderDao.selectOrderList();
		for (Order order : orderList) {
			System.out.println(order);
		}
	}
	
	// 주문 내역
	public void printOrderDetailsByCustomerAndIsCanceled(String name, String status) {
		Boolean isCanceled = false;
		if(status.equals("정상")) isCanceled = false;
		else if(status.equals("취소")) isCanceled = true;
		List<Order> orderList = orderDao.selectOrderByCustomerAndIsCanceled(name, isCanceled);
		
		int orderCnt = orderList.size();
		int totalPrice = 0;
		for (Order order : orderList) {
			Goods goods = goodsDao.selectProductByCode(order.getProductCode());
			totalPrice += goods.getPrice() * order.getAmount();
		}
		
		System.out.println(name + "님의 " + status + "주문 건수는: " + orderCnt + "건이고, " 
		+ status + "주문합계금액은: " + totalPrice + "원 입니다.");
	}
}
