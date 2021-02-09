

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
<title>宇宙中心169号   </title>
</head>
<style>
#tableThread{
	background-color:#FFF8EE;
},
#salaryButton{
   
},
#tableheader{
	border:none;
},
#trcontent{
	background-color:#FFF;
},
#tdcontent{
	color:#006be3;
},
.input_css{
	color: #383838;
    background: #fff;
    outline: none;
    border: 1px solid #d1d1d1;
}
.input_css:hover { border:solid 4px #c00;}
.input_css:focus { border:solid 33px #c00;}
</style>
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
	document.getElementById("tableMainSum").removeAttribute("hidden");;
	
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
			 var echkbox=document.createElement("input");
					echkbox.setAttribute("type","checkbox");
					  echkbox.setAttribute("name","checkBoxList");
					 	echkbox.setAttribute("checked","checked");
					 		echkbox.setAttribute("value",name+"|"+price+"|"+num+"|"+all);
					 	 		td1.appendChild(echkbox);
					 	 		td1.appendChild(document.createTextNode(name)); 
			var td2	 = document.createElement("td");
			var td3	 = document.createElement("td");
			var td4	 = document.createElement("td");
		//	td1.innerHTML=name;//产品名;
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



$("selectProductKK").click(function(){
  	 document.getElementById("selectProductName").value =name;
	document.getElementById("inputSingle").value =price;
	document.getElementById("inputNum").value=''; 
});

function calSingle(index,name,price){

  var id_price = "price"+index;
  var priceVar =document.getElementById(id_price); //单价--00
  var single_price = priceVar.innerText;//单价
  
  var id_num = "num"+index;
  var single_num = document.getElementById(id_num).value;
  document.getElementById(id_num).style.backgroundColor = '#33CCFF';
  
  if(!Number(single_num)){
		alert('第 '+index+' 行数量输入错误，请确认！');
		document.getElementById(id_num).value=''; 
		 document.getElementById(id_num).style.backgroundColor = '';
		 var singleAll = "singleAll"+index;
		 document.getElementById(singleAll).style.backgroundColor = '';
		 document.getElementById(singleAll).innerText = '';
	}
	
	
	//开始计算
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/ChenfaServlet",
		data:{"price":single_price,'num':single_num }, 
		success:function(data) {
			//all = data;
		
			console.log('single_price:'+single_price+' single_num:'+single_num+' data:'+data);
			var singleAll = "singleAll"+index;
			console.log('singleAll:'+singleAll);
			document.getElementById(singleAll).style.backgroundColor = '#33CCFF';
			document.getElementById(singleAll).innerText=data; 
		}
		});
};

function jisuangongziFunc(){
		
		
		var tab=document.getElementsByTagName("table")[0];
		var saveCharacter='';
		for(var  i = 1;i< tab.rows.length;i++){
		
			var id_name ="name"+i;
			var id_price="price"+i;
			var id_num="num"+i;
			var id_all="singleAll"+i;
			
			 
			 
			var all = document.getElementById(id_all).innerText;
			var name =  document.getElementById(id_name).innerText;
			var price =  document.getElementById(id_price).innerText;
			var num =  document.getElementById(id_num).value;
			
			if(num!=''){
				if(all==''){
				 alert('第 '+i+' 行请确认！');
				 return false;
				}
			}
			
			if(all!=''){
				console.log("alllll:="+all+" "+name+" "+price+" "+num+" ");
				// 剃须刀002|0.5|211|105.5#剃须刀002|0.5|2|1.0#剃须刀002|0.5|22|11.0#
				saveCharacter +=	name+'|'+price+'|'+num+'|'+all+"#";
			}
			console.log('saveCharacter:'+saveCharacter);
		
		}
		if(saveCharacter == ""){
			alert("请至少选择一条记录!");
			return;
		}
		console.log("saveCharacter:"+saveCharacter);
		document.jisuangongziForm.saveCharacter.value = saveCharacter;
		document.jisuangongziForm.submit(); 
}

window.onload = function() {
    var btn = document.getElementById('salaryButton');
    btn.onmouseover = function() {
        this.style.backgroundColor = '';
        this.style.color = 'black';
    }
    btn.onmouseout = function() {
        this.style.backgroundColor = '#3370ff';
        this.style.color = '#fff';
    }
}
</script>
<div style='font-size:30px;'>
<!--show products start -->
<center>
<table id="tableheader" border="1px" cellspacing="0" width="80%"  >
 <thread>
	<tr id ="tableThread">
		<td >序号</td>
		<td >产品名</td>
		<td >单价(元)</td> 
		<td id="selectblue" >请输入数量(件)</td>
		<td>总金额(元)</td>
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
	<tr  >
	<td class="selectProductKK"><%= ++index %></td> 
    <td class="selectProductKK" id="name<%=index%>"><%=entry.getKey().toString()%> </td>
	<td class="selectProductKK"  id="price<%=index%>"><%= entry.getValue().toString()%> </td>
	<td class="selectProductKK"    >
		 <input class="input_css" style="width:90%;height:30px;font-size:30px;" id="num<%=index%>"
			onblur="calSingle('<%=index%>','<%=entry.getKey().toString()%>','<%=entry.getValue().toString()%>');"
			></td>
	<td id="singleAll<%=index%>"></td>
	</tr>
</tbody>
<%} %>
</table>
</center>
<br>
<div id ="suoyougongzi"></div>
<center>
	<button id ="salaryButton" type="button" onClick="jisuangongziFunc()" 
		οnmοusemοve="red();" οnmοuseοut="black();"	
		 style="color: #f7f8fe;width: 90%;height:50px;font-size:30px;background-color: #3370ff;border-color: #3370ff;"
			>计算总工资
	</button>   
</center>  
<br>
<form name="jisuangongziForm" action ="JisuangongziServlet" method ="post">
	<input  type="hidden"  name="saveCharacter" >
</form>
</body>
</html>