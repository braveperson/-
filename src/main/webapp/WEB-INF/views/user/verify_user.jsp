<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册用户</title>
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
    <form action="${pageContext.request.contextPath}/user/verifyUser.do"  method="post"  onsubmit="return check()">
    	<input type="hidden" name="user_id" value="${user.user_id}"/>
    	用户名:<input type="text" name="user_name" value="${user.user_name}" id="name" /><br>
    	<input type="hidden" name="password" value="${user.password}" id="number"/><br>
    	
    	状&nbsp态：<select name="state">
				<option value="1">未通过</option>
				<option value="2">通过</option>
			</select>
			<br> 
    	角&nbsp色：<select name="roleName">
    		<c:forEach items="${lists}" var="role">
				<option>${role.role_name}</option>
			</c:forEach>
		</select>
		 	<br> 
			
    		<input type="submit" value="提交"/>${message}
    </form>
  </body>
</html>
