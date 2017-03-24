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
		<form action="${pageContext.request.contextPath}/safety/updateFunction.do" method="post"  onsubmit="return check()">
			<%--  type="hidden" 隐藏表单界面 --%>
			<input type="hidden" name="function_id" value="${function.function_id}" /><br/>
			功能编码:<input id="num" type="text" name="function_code" value="${function.function_code}"/><br/>
			描&nbsp&nbsp述:<input id="num" type="text" name="description" value="${function.description}"/><br/>
			
			
			<input type="submit" value="提交">
			<span id="msg"></span>
		</form>
	</body>
	<div class="copy-rights">
		<p>版权地址:Copyright &copy; 2016.viktor All rights reserved.</p>
	</div>
</html>

