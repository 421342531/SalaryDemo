<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Map"
    import="java.util.HashMap"
	import ="net.sf.json.JSONObject"
	import ="java.util.Iterator"
	import ="net.sf.json.JSONArray"
	import ="util.ProductOJ"
	import ="java.util.ArrayList"
	import ="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>169号-确认页面</title>
</head>
<body > 
<%
	JSONArray jsonArray = (JSONArray)request.getAttribute("data");
	System.out.println("jsonArray:"+jsonArray);
	String  sumSalary = (String)request.getAttribute("sumSalary");
	Iterator<Object> it = jsonArray.iterator();
%>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/echarts.min.js"></script>
<script type="text/javascript">
function goBack(){
	history.go(-1);
}

function insertSalary(){
	var jsonArray = '<%=jsonArray%>';
	var sumSalary = '<%=sumSalary%>';
	console.log('jsonArray+sumSalary:'+jsonArray+' + '+sumSalary);	
	document.insertSalaryForm.jsonArray.value = jsonArray;
	document.insertSalaryForm.sumSalary.value = sumSalary;
	document.insertSalaryForm.submit();

}
window.onload = function() {
    var btn = document.getElementById('backButton');
    btn.onmouseover = function() {
        this.style.backgroundColor = '';
        this.style.color = 'black';
    }
    btn.onmouseout = function() {
        this.style.backgroundColor = '#3370ff';
        this.style.color = '#fff';
    }
    
    var btn1 = document.getElementById('huangdanButton');
    btn1.onmouseover = function() {
        this.style.backgroundColor = '';
        this.style.color = 'black';
    }
    btn1.onmouseout = function() {
        this.style.backgroundColor = '#3370ff';
        this.style.color = '#fff';
    }
    
}

</script>
<style>
#tableThread{
	background-color:#00BFFF;
},
#backButton{
	background-color: #3370ff;
    color: #f7f8fe;
    border-color: #3370ff;
}
</style>

<br>
<table id="tableMain" border="1px" cellspacing="0" width="95%"  >
 <thread>
	<tr id ="tableThread" style ="font-weight:bold;" >
		<td style="font-size:25px;" >序号</td>
		<td style="font-size:25px;">产品名</td>
		<td style="font-size:25px;">单价(元)</td>
		<td style="font-size:25px;">数量(件)</td>
		<td style="font-size:25px;">总价(元)</td>
	</tr>
</thread>
<% 
	int index = 0;
	while(it.hasNext()) {
			 JSONObject ob = (JSONObject) it.next();
			 System.out.println("ob:"+ob);
			 String name = ob.getString("name");
			 String all = ob.getString("all");
			 String num = ob.getString("num");
			 String price = ob.getString("price");
%>
<tbody>

   <%if(index%2==0?true:false){ %>
   		<tr>
   <% }else{%>
   		<tr style="background-color:#FAEBD7;">
   		
   <%} %>
	<td class="info" style="font-size:25px;"><%= ++index %></td>
    <td class="info" style="font-size:25px;"><%=name%></td>
	<td class="info" style="font-size:25px;"><%=price%> 元</td> 
	<td class="info" style="font-size:25px;"><%=num%> </td>
	<td class="info" style="font-size:25px;"><%=all%> 元 </td>
	</tr>
</tbody>
<%} %>
<tbody>
	<tr>
	<td></td>
    <td></td>
	<td></td> 
	<td></td>
	<td style="font-size:25px;background-color:#87CEFA;">共计：<%=sumSalary%>元</td>
	</tr>
</tbody>
</table>
<br>
  <br>
  <!-- 
 <button id ="huangdanButton" type="button" onClick="insertSalary()" 
			style="color: #f7f8fe;width: 90%;height:50px;font-size:30px;background-color: #3370ff;border-color: #3370ff;">录入数据库
</button>
   -->
  <br>
  <br>
  <button id ="backButton" type="button" onClick="goBack()" 
						style="color: #f7f8fe;width: 90%;height:50px;font-size:30px;background-color: #3370ff;border-color: #3370ff;">返回首页
</button>


 
<form name="insertSalaryForm" action ="InsertSalaryServlet" method ="post">
	<input  type="hidden"  name="jsonArray" >
	<input  type="hidden"  name="sumSalary" >
</form>
</body>
</html>