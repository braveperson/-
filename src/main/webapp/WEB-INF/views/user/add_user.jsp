<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script>
	function check() {
		var user = $("#name").val();//获取表单元素值
		var number = $("#number").val();
		var num = $("#num").val();  
		/* var user=document.getElementById("name").value;
		var number=document.getElementById("number").value;
		var num=document.getElementById("num").value; */ 
		if (user == "" || number == "" || num == "") {
			$("#msg").text("用户和密码、确认密码不能为空!");
			return false;
		} else if(number != num){
			$("#msg").text("您输入的密码不一致！");
			return false;
		}else{
			return true;	
		}
	}
	/*点击事件在元素中调用*/
/* 	function sub(){
		alert('html元素中调用事件!');
	} */
</script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/user/addUser.do"
		method="post" onsubmit="return check()">

		用户&nbsp名:<input type="text" name="user_name" id="name" /><br>
		密&nbsp&nbsp码:<input type="password" name="password" id="number" /><br>
		确认密码:<input type="password" name="pwd" id="num" /><br> 
		<input type="hidden" name="state" value="1" /><br> 
		<input type="submit" value="提交注册" onclick="sub()"/>
		<span style='color:red'>${message}</span>
		<span id="msg" style='color:red;font-size:12px'></span><br>
		<span style='color:bule;font-size:25px'>${mess}</span>
	</form>
</body>
</html>
