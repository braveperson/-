<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改学生操作</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css"></link>
		<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript">
			function check(){
				var number = $("#nums").val(); //获取表单元素值
				if(number==""){
					$("#msg").text("一些属性不能为空!");
					return false;
				}else{
					return true;
				}
			}
		</script>
		
	</head>
	<body>
	
		
		<div align="center">
			<a href="welcom.jsp">返回主界面</a>
			<a href="studentShow.jsp">返回上一级</a>
		</div>
		<%--  <%=request.getContextPath() %> 获取根路径 --%>
		<form action="${pageContext.request.contextPath}/user/updateUser.do" method="post"  onsubmit="return check()">
			<%--  type="hidden" 隐藏表单界面 --%>
			<input type="hidden" name="user_id" value="${user.user_id}" /><br/>
			<input id="num" type="hidden" name="user_name" value="${user.user_name}"/><br/>
			密&nbsp码:<input id="num" type="password" name="password" value="${user.password}"/><br/>
			<input id="num" type="hidden" name="password" value="${user.state}"/><br/>
			<input type="submit" value="提交">
			<span id="msg"></span>
		</form>
	</body>
	<div class="copy-rights">
		<p>版权地址:Copyright &copy; 2016.viktor All rights reserved.</p>
	</div>
</html>

