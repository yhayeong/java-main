package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnect {
	// 연결객체 생성 메소드
	public static Connection getConnecton() {
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
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
