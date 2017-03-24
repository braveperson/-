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
	
		<h1>通过用户名学生属性</h1>
		<div align="center">
			<a href="welcom.jsp">返回主界面</a>
			<a href="studentShow.jsp">返回上一级</a>
		</div>
		<%--  <%=request.getContextPath() %> 获取根路径 --%>
		<form action="${pageContext.request.contextPath}/car/update.do" method="post"  onsubmit="return check()">
			<%--  type="hidden" 隐藏表单界面 --%>
			<input id="user" type="hidden" name="carNums" value="${car.carNums}" /><br/>
			<input type="hidden" name="id" value="${car.id}" /><br/>
			<input type="hidden" name="carOwnner" value="${car.carOwnner}"/><br/>
			电话:<input id="num" type="text" name="telePhone" value="${car.telePhone}"/><br/>
			颜色:<input id="num" type="text" name="color" value="${car.color}"/><br/>
			厂家:<input id="num" type="text" name="factory" value="${car.factory}"/><br/>
			备注:<input type="text" name="remarks" value="${car.remarks}"/><br/>
			
			<input type="submit" value="提交">
			<span id="msg"></span>
		</form>
	</body>
	<div class="copy-rights">
		<p>版权地址:Copyright &copy; 2016.viktor All rights reserved.</p>
	</div>
</html>

