<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Jstl用户列表</title>
<%--因为mystyle.css在css文件中,所以写成href="../css/mystyle.css"--%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mystyle.css"></link>

</head>
<%--不用过滤器方式一：user登录信息的用户名是否为空   为空就跳到登录界面 <%
	String user = (String)session.getAttribute("user");
   response.getWriter().println(user);
    if(user == null){//判断登录状态
    	response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
--%>
<%--不用过滤器方式二:1.把方式一的判断写到check_login.jsp,需要判断的页面都(include)来包含它。不能用跳转，用转发
					2.获取路径时不能用request.getContextPath() +  用.因为session时间过期,request失效
	 
	<jsp:include page="./check_login.jsp"/>--%>

<body>
	
	

	<br>
	<h1 align="center">模块列表</h1>
	<hr>

	<table>
		<tr>

			<th>用户id</th>
			<th>用户名</th>
			<th>用户状态</th>

			<th colspan="3">操作</th>
		</tr>

		<c:forEach items="${lists}" var="user">

			 <tr>
				
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				
				

				<td><c:if test="${user.state == 1}">未通过</c:if>
				<c:if test="${user.state == 2}">通过</c:if></td>

				 <td><a
					href="${pageContext.request.contextPath}/user/verify_user.do?user_id=${user.user_id}">审核用户</a></td>
				<td><a
					href="${pageContext.request.contextPath}/user/getUser.do?user_id=${user.user_id}">修改密码</a></td>
				<td><a
					href="${pageContext.request.contextPath}/user/deleteUser.do?user_id=${user.user_id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

