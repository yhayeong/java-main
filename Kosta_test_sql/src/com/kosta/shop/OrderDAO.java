package com.kosta.shop;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kosta.order.Order;

public class OrderDAO {
	
	// 연결객체 생성 메소드
	public Connection getConnecton() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(
							db.getProperty("url"),
							db.getProperty("user"),
							db.getProperty("password"));
		} catch (Exception e) {;
			e.printStackTrace();
		}
		return conn;
	}
	//연결객체 닫는 메소드
	public void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 주문 추가
	public int insertOrder(Order order) {
		int cnt = 0;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO `ORDER` (no, customer, productcode, amount) VALUES (?,?,?,?)"; //no, customer, productCode, amount
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getNo());
			pstmt.setString(2, order.getCustomer());
			pstmt.setString(3, order.getProductCode());
			pstmt.setInt(4, order.getAmount());
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return cnt;
	}
	
	
	// 주문 정보 조회
	public Order selectOrderByNo(int no) {
		Order order = null;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM `ORDER` WHERE NO=?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				Integer rNo = rs.getInt(1);
				String rCustomer = rs.getString(2);
				String rProductCode = rs.getString(3);
				Integer rAmount = rs.getInt(4);
				Boolean rIsCanceled= rs.getBoolean(5);
				order = new Order(rNo, rCustomer, rProductCode, rAmount, rIsCanceled);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return order;
	}
	
	
	// 주문 취소 -> 취소여부필드값이 변한 order객체를 인자로 받아 업데이트한다
	public int updateCancelOrder(Order order) {
		int cnt = 0;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "UPDATE `ORDER` SET ISCANCELED=? WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, order.isCanceled());
			pstmt.setInt(2, order.getNo());
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return cnt;
	}

	
	// 전체 주문 정보 출력
	public List<Order> selectOrderList() {
		List<Order> orderList = new ArrayList<>();
		Connection conn = getConnecton();
		Statement stmt = null;
		String sql = "SELECT * FROM ORDER";
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNo = rs.getInt(1);
					String rCustomer = rs.getString(2);
					String rProductCode = rs.getString(3);
					Integer rAmount = rs.getInt(4);
					Boolean rIsCanceled= rs.getBoolean(5);
					orderList.add(new Order(rNo, rCustomer, rProductCode, rAmount, rIsCanceled));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		close(conn);
		return orderList;
	}
	
	// 주문 내역 (고객명과 취소여부)
	public List<Order> selectOrderByCustomerAndIsCanceled(String name, Boolean isCanceled) {
		List<Order> orderList = new ArrayList<>();
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
//		String sql = "SELECT O.*, G.* FROM `ORDER` O JOIN GOODS ON (O.PRODUCTCODE = G.CODE) "
//					+ "WHERE O.CUSTOMER=? AND O.ISCANCELED=?";
		String sql = "SELECT * FROM `ORDER` WHERE CUSTOMER=? AND ISCANCELED=?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setBoolean(2, isCanceled);
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Integer rNo = rs.getInt(1);
					String rCustomer = rs.getString(2);
					String rProductCode = rs.getString(3);
					Integer rAmount = rs.getInt(4);
					Boolean rIsCanceled= rs.getBoolean(5);
					orderList.add(new Order(rNo, rCustomer, rProductCode, rAmount, rIsCanceled));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return orderList;
	}
	
}
