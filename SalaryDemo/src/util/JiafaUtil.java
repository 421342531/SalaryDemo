package util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JiafaUtil {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Iterator<Object> it = 
				JiafaUtil.gongzijiaFunc("剃须刀002|0.5|211|105.5#剃须刀002|0.5|2|1.0#剃须刀002|0.5|22|11.0#").iterator();
		 List<ProductOJ> list=new ArrayList<ProductOJ>();
		
		 while(it.hasNext()) {
			 
			 JSONObject ob = (JSONObject) it.next();
			 System.out.println("ob:"+ob);
			 String name = ob.getString("name");
			 System.out.println("name:"+name);
		 }
	}
	
	public static JSONArray gongzijiaFunc(String saveChars) throws ClassNotFoundException, SQLException {
	
			//String returnStr[] = {"",""};
			System.out.println(" func saveChars:"+saveChars);
			JSONObject jsonObject = new JSONObject(true);
		    
			//剃须刀002|0.5|211|105.5#剃须刀002|0.5|2|1.0#剃须刀002|0.5|22|11.0#
			String arr[]  = saveChars.split("#");
			
			BigDecimal sum = new  BigDecimal("0.00");
			
			ArrayList<ProductOJ> productOjList = new ArrayList<>();
		    for(int i =0 ;i<arr.length;i++) {
		    	String singleInfo = arr[i];//剃须刀002|0.5|211|105.5
		    	System.out.println("singleInfo:"+singleInfo);
		    	String singleArr[] = singleInfo.split("\\|");
		    	
		    	String name = singleArr[0];//产品名字
		    	String price = singleArr[1];//价格
		    	String num = singleArr[2];//数量
		    	String all = singleArr[3];//数量
		    	System.out.println("===="+name+" "+price+" "+num+" "+all);
		    	sum = JiafaFunc(sum.toString(),all);
		    	
		    	ProductOJ oj = new ProductOJ();
		    	oj.setName(name);
		    	oj.setPrice(price);
		    	oj.setNum(num);
		    	oj.setAll(all);
		    	productOjList.add(oj);
		    	
		    }

	    	
	    	JSONArray array = JSONArray.fromObject(productOjList); 
		    System.out.println("array:"+array);
			return array;
		
	}
	

	public static String sumSalaryFunc(String saveChars) throws ClassNotFoundException, SQLException {
	
			System.out.println(" func saveChars:"+saveChars);
			//剃须刀002|0.5|211|105.5#剃须刀002|0.5|2|1.0#剃须刀002|0.5|22|11.0#
			String arr[]  = saveChars.split("#");
			
			BigDecimal sum = new  BigDecimal("0.00");
			
			ArrayList<ProductOJ> productOjList = new ArrayList<>();
		    for(int i =0 ;i<arr.length;i++) {
		    	String singleInfo = arr[i];//剃须刀002|0.5|211|105.5
		    	System.out.println("singleInfo:"+singleInfo);
		    	String singleArr[] = singleInfo.split("\\|");
		    	
		    	String name = singleArr[0];//产品名字
		    	String price = singleArr[1];//价格
		    	String num = singleArr[2];//数量
		    	String all = singleArr[3];//数量
		    	System.out.println("===="+name+" "+price+" "+num+" "+all);
		    	sum = JiafaFunc(sum.toString(),all);
		    	
		    }
			return sum.toString();
	}
	
public static BigDecimal  JiafaFunc(String str1,String str2) {
	BigDecimal bignum1 = new BigDecimal(str1);
	BigDecimal bignum2 = new BigDecimal(str2);
	BigDecimal bignum3 = null;
	
	//加法
	bignum3 =  bignum1.add(bignum2); 	 
//	System.out.println("和 是：" + bignum3);
	return bignum3;
}

}
