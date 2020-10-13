package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;

public class QueryProductsUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}
	
	
public static JSONObject queryProductsFunc() throws ClassNotFoundException, SQLException {
		
	
		JSONObject jsonObject = new JSONObject(true);
		
			String name = "剃须刀001";
			String price = "0.4";
			jsonObject.put(name, price);
			
			String name1 = "剃须刀002";
			String price1 = "0.5";
			jsonObject.put(name1, price1);
			
			String name2 = "剃须刀003";
			String price2 = "1.0";
			jsonObject.put(name2, price2);
			
			System.out.println("result:"+jsonObject);
		return jsonObject;
		
	}
	
public static JSONObject showLogFunc_bak() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	 	System.out.println("Success loading Mysql Driver!");
		Connection connect = DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/mysql","root","nbcb,111");
		String sql_queryStartTime =
	 			"select time,type from time_control_log t order by time  desc";
		PreparedStatement pstmt = null;
		pstmt = connect.prepareStatement(sql_queryStartTime);
		ResultSet rs ;
		rs = pstmt.executeQuery(); 
		JSONObject jsonObject = new JSONObject(true);
		while(rs.next()) {
			String time = rs.getString("time");
			String type = rs.getString("type");
			jsonObject.put(time, type);
		}
		return jsonObject;
		
	}

}
