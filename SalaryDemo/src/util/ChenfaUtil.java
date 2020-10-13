package util;

import java.math.BigDecimal;

public class ChenfaUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChenfaUtil.chenFaFunc("1.1111","100");
		
	}
	
	
	
	public static String chenFaFunc(String price,String num) {
		
		
		BigDecimal bignum1 = new BigDecimal(price); 
		BigDecimal bignum2 = new BigDecimal(num);
		BigDecimal bignum3 = null; 
		//乘法 
		bignum3 = bignum1.multiply(bignum2); 
		System.out.println("积  是：" + bignum3); 
		
		return bignum3.toString();
	}

}
