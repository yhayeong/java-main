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

import com.kosta.product.Goods;

public class GoodsDAO {
	
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
	
	// 상품 추가
	public int insertProduct(Goods goods) {
		int cnt = 0;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO GOODS VALUES (?,?,?,?,?)"; //code, name, stock, price, category
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getCode());
			pstmt.setString(2, goods.getName());
			pstmt.setInt(3, goods.getPrice());
			pstmt.setInt(4, goods.getStock());
			pstmt.setString(5, goods.getCategory());
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
	
	
	// 상품 정보 조회
	public Goods selectProductByCode(String code) {
		Goods goods = null;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM GOODS WHERE CODE=?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				String rName = rs.getString(2);
				Integer rPrice = rs.getInt(3);
				Integer rStock = rs.getInt(4);
				String rCategory = rs.getString(5);
				goods = new Goods(rName, rPrice, rStock, rCategory);
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
		return goods;
	}
	
	// 전체 상품 정보 출력
	public List<Goods> selectProductList() {
		List<Goods> productList = new ArrayList<>();
		Connection conn = getConnecton();
		Statement stmt = null;
		String sql = "SELECT * FROM GOODS";
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs!=null) {
				while(rs.next()) {
					String rName = rs.getString("NAME"); 
					Integer rPrice = rs.getInt("PRICE");
					Integer rStock = rs.getInt("STOCK");
					String rCategory = rs.getString("CATEGORY"); 
					productList.add(new Goods(rName, rPrice, rStock, rCategory));
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
		return productList;
	}
	
	
	// 주문추가, 주문취소시 상품테이블의 재고량 업데이트
	public int updateProductStock(int orderNo, Goods goods) {
		int cnt = 0;
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		String sql = " UPDATE goods SET stock=? WHERE (SELECT productcode FROM order WHERE NO=?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getStock());
			pstmt.setInt(2, orderNo);
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
	
	
	
	
}
