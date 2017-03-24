<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加功能模块</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
  	<script>
  		function check(){
  			var user = $("#name").val();//获取表单元素值
  			var number = $("#number").val();
  			var age = $("#age").val();
  			if(user == "" || number =="" || age == ""){
  				$("#msg").text("模块名和描述不能为空!");
  				return false;
  			}else{
  				return true;
  			}
  		}
  	</script>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/safety/addModule.do"  method="post"  onsubmit="return check()">
    	
    	模块名:<input type="text" name="module_name" id="name" /><br>
    	描&nbsp述:<input type="text" name="description" id="number"/><br>
    		<input type="submit" value="添加"/>${message}
    </form>
  </body>
</html>
