<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Map"
    import="java.util.HashMap"
    import ="com.alibaba.fastjson.JSON"
	import ="com.alibaba.fastjson.JSONObject"
	import ="java.util.Iterator"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>169号</title>
</head>
<body > 
<%
JSONObject jsonObject  =(JSONObject)request.getAttribute("data");
System.out.println("jsonObject="+jsonObject);

%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/echarts.min.js"></script>
<script type="text/javascript">

//判断是否是数字
function Number(val) {
　　if (parseFloat(val).toString() == "NaN") {
　　　　
　　　　return false;
　　} else {
　　　　return true;
　　}
}

function queryProducts_xxx(){
	console.log("start to query products");
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/QueryProductsServlet",
		data:{"id":'123'}, 
		success:function(data) {
			console.log(data);
		}
		});
}
function selectProduct(name,price){//取得当前点击索引
	
	document.getElementById("selectProductName").value =name;
	document.getElementById("inputSingle").value =price;
	document.getElementById("inputNum").value='';
}

function sumAll(){
	var name = document.getElementById("selectProductName").value;
	var price = document.getElementById("inputSingle").value;
	var num = document.getElementById("inputNum").value;
	if(!Number(num)){
		alert('数量输入错误，请确认！');
	}
	
	console.log(' post name :'+name +' price:'+price+' num:'+num);
	
	var all ;
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/ChenfaServlet",
		data:{"price":price,'num':num }, 
		success:function(data) {
			all = data;
			console.log(all);
			var tr = document.createElement("tr");
			var td1 = document.createElement("td");
			var td2	 = document.createElement("td");
			var td3	 = document.createElement("td");
			var td4	 = document.createElement("td");
			td1.innerHTML=name;//price;
			td2.innerHTML=price;//num;
			td3.innerHTML=num;//all;
			td4.innerHTML=all;
			document.getElementById("tableMainSum").appendChild(tr);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
		}
		});
}

</script>
<div style='font-size:30px;'>请选择产品名：
<!--show products start -->
<center>
<table id="tableMain" border="1px" cellspacing="0" width="80%"  >
 <thread>
	<tr id =tableThread>
		<td >序号</td>
		<td >产品名</td>
		<td colspan = "4"  >单价</td>
		<td >点击选择产品</td>
	</tr>
</thread>
<% 
	int index = 0;
	Iterator iter = jsonObject.entrySet().iterator();
	while (iter.hasNext()) {
    	Map.Entry entry = (Map.Entry) iter.next();
    	System.out.println(entry.getKey().toString());
    	System.out.println(entry.getValue().toString());
%>
<tbody>
	<tr>
	<td><%= ++index %></td>
    <td ><%=entry.getKey().toString()%> </td>
	<td colspan = "4"><%= entry.getValue().toString()%> </td>
	<td id= "" onClick="selectProduct('<%=entry.getKey().toString()%>','<%=entry.getValue().toString()%>');" >选择</td>
	</tr>
</tbody>
<%} %>
</table>
</center>
<br>
     
 <div>选择的产品是：
<input  id="selectProductName"
		 style="width:30%;height:100px;font-size:30px;" />
</div>
<br>
 
 <!-- show products end -->
<div>单价：
<input  placeholder="请输入单价" id="inputSingle"
		 style="width:30%;height:100px;font-size:30px;" />
</div>
<br>
		 
<div>总件数：
<input  placeholder="请输入总件数" id="inputNum"
		 style="width:30%;height:100px;font-size:30px;" />	
</div>

<br>
<button id ="huangdanButton" type="button" onClick="sumAll()" 
						style="width: 20%;height:50px;font-size:30px;">添加
</button>
<br>
<br>

<center>
<table id="tableMainSum" border="1px" cellspacing="0" width="80%"  >
 <thread>
	<tr id =tableThread>
		<td >产品名</td>
		<td >单价</td>
	    <td >数量</td>
		<td >总价</td>
	</tr>
</thread>
</table>
</center>
<br>

<div id ="suoyougongzi"></div>

</body>
</html>