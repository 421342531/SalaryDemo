package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class QueryProductsUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}
	
	
public static JSONObject queryProductsFunc() throws ClassNotFoundException, SQLException {
	JSONObject jsonObject = new JSONObject(true);
	//---
	Class.forName("com.mysql.cj.jdbc.Driver");
 	System.out.println("Success loading Mysql Driver!");
	Connection connect = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/mysql","root","nbcb,111");
	Map<String ,String >  map =new HashMap<>();
	String sql_queryStartTime =
 			"select product_name ,product_price from salary_products_info order by product_name";
	PreparedStatement pstmt = null;
	pstmt = connect.prepareStatement(sql_queryStartTime);
	ResultSet rs ;
	rs = pstmt.executeQuery(); 
	while(rs.next()) {
		String product_name = rs.getString("product_name");
		String product_price = rs.getString("product_price"); 
		
		System.out.println("sql:"+product_name+" "+product_price);
		jsonObject.put(product_name, product_price);
	}
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
