package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


public class InsertSalaryInfoUtil {
	

	public static void main(String[] args) throws ClassNotFoundException, Exception {
	
	//	System.out.println(InsertSalaryInfoUtil.getNowTime());
		
		//InsertSalaryInfoUtil.recordSalaryInfo("123312","231");
		
		
		System.out.println(InsertSalaryInfoUtil.getMac());
	}

	public static String recordSalaryInfo(String saveCharacter,String sum) throws ClassNotFoundException, Exception {
		//日期 记录 总额 mac 地址
		Class.forName("com.mysql.cj.jdbc.Driver");
	 	System.out.println("Success loading Mysql Driver!");
	 	Connection connect = DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/mysql","root","nbcb,111");
		Statement statement =connect.createStatement();
		String sql_insert=
				"insert into salary_log(worker_salarydate,worker_salaryinfo,worker_salarysum,worker_macaddress)"
				+ "values('"+getNowTime()+"','"+saveCharacter+"','"+sum+"','"+""+"')";
				int rr = statement.executeUpdate(sql_insert);// 更新成功条数 1为更新成功，0未更新
		statement.close();
	    System.out.println("记录日志成功！");
	    return "";
	}
	
	 public static String getMac(){
		 String mac="";
		  try {
		  Process p = Runtime.getRuntime().exec("arp -n");
		   InputStreamReader ir = new InputStreamReader(p.getInputStream());
		   LineNumberReader input = new LineNumberReader(ir);
		   p.waitFor();
		   boolean flag = true;
		   String ipStr = "("+"127.0.0.1"+")";
		   while(flag) {
		    String str = input.readLine();
		    if (str != null) {
		     if (str.indexOf(ipStr) > 1) {
		      int temp = str.indexOf("at");
		      mac = str.substring(
		      temp + 3, temp + 20);
		      break;
		     }
		    } else
		    flag = false;
		   }
		  } catch (IOException | InterruptedException e) {
		   e.printStackTrace(System.out);
		  }
		  return mac;
		 }

	public static String getNowTime() {
		
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss");
		System.out.println("time now:"+df.format(date));
		return df.format(date);
	}
	
	
	public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-real-ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
}
	static String getMacAddrByIp(String ip) {
	    String macAddr = null;
	    try {
	        Process process = Runtime.getRuntime().exec("nbtstat -a " + ip);
	        BufferedReader br = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));
	        Pattern pattern = Pattern.compile("([A-F0-9]{2}-){5}[A-F0-9]{2}");
	        Matcher matcher;
	        for (String strLine = br.readLine(); strLine != null;
	             strLine = br.readLine()) {
	            matcher = pattern.matcher(strLine);
	            if (matcher.find()) {
	                macAddr = matcher.group();
	                break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println(macAddr);
	    return macAddr;
	}


}
