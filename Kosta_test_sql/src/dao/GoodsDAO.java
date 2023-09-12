package dao;

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
	
	// 상품 추가
	public int insertProduct(Goods goods) {
		int cnt = 0;
		Connection conn = DBConnect.getConnecton();
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
		DBConnect.close(conn);
		return cnt;
	}
	
	
	// 상품 정보 조회
	public Goods selectProductByCode(String code) {
		Goods goods = null;
		Connection conn = DBConnect.getConnecton();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM GOODS WHERE CODE=?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				String rCode = rs.getString(1);
				String rName = rs.getString(2);
				Integer rPrice = rs.getInt(3);
				Integer rStock = rs.getInt(4);
				String rCategory = rs.getString(5);
//				goods = new Goods(rName, rPrice, rStock, rCategory);
				goods = new Goods(rCode, rName, rPrice, rStock, rCategory);
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
		DBConnect.close(conn);
		return goods;
	}
	
	// 전체 상품 정보 출력
	public List<Goods> selectProductList() {
		List<Goods> productList = new ArrayList<>();
		Connection conn = DBConnect.getConnecton();
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
		DBConnect.close(conn);
		return productList;
	}
	
	
	// 주문추가, 주문취소시 상품테이블의 재고량 업데이트
/*	1트에 작성한것
//	public int updateProductStock(int orderNo, Goods goods) {
	public int updateProductStock(Goods goods) {
		int cnt = 0;
		Connection conn = DBConnect.getConnecton();
		PreparedStatement pstmt = null;
//		String sql = " UPDATE goods SET stock=? WHERE (SELECT productcode FROM `order` WHERE NO=?)";
		String sql = " UPDATE goods SET stock=? WHERE CODE=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getStock());
//			pstmt.setInt(2, orderNo);
			pstmt.setString(2, goods.getCode());
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
		DBConnect.close(conn);
		return cnt;
	}
*/	
	
	public int updateProductStock(String productCode, int amount) { // 두번째 인자가 주문추가시에는 음수, 주문취소시에는 양수
		int cnt = 0;
		Connection conn = DBConnect.getConnecton();
		PreparedStatement pstmt = null;
		String sql = "UPDATE GOODS SET STOCK=STOCK+? WHERE CODE=?"; // *** SET 컬럼명 = 컬럼명+?
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setString(2, productCode);
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
		DBConnect.close(conn);
		return cnt;
	}
	
	
	
	
}
