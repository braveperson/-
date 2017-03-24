<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Jstl模块列表</title>
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
	<a href="${pageContext.request.contextPath}/safety/formAddRole.do">添加角色</a>
	<!-- <div id="e">
		<h1>表格设计</h1>
		<p>
			<b>注:</b> a:hover 必须在 a:link 和 a:visited 之后，需要严格按顺序才能看到效果
		</p>
		<p>注: a:active 必须在 a:hover 之后。</p>
	</div>
	<hr /> -->

	<br>
	<h1 align="center">模块列表</h1>
	<hr>

	<table>
		<tr>

			<th>角色id</th>
			<th>角色名</th>
			<th>角色描述</th>

			<th colspan="3">操作</th>
		</tr>

		<c:forEach items="${lists}" var="role">

			<tr>
				<%-- 	<td>
					<c:if test="${student.picurl == ''}">
						<img src="${pageContext.request.contextPath}/images/y.jpg" width="60px" height="50px"/>
					</c:if>
					
					<c:if test="${student.picurl != ''}">
				<!--应用上下文路径:${pageContext.request.contextPath} -->
						<img src="${pageContext.request.contextPath}${student.picurl}" width="60px" height="50px"/>
					</c:if>
				</td> --%>
				<td><c:out value="${role.role_id}" /></td>
				<td><c:out value="${role.role_name}" /></td>
				<td><c:out value="${role.description}" /></td>

				<%-- 	<td><c:if test="${student.sex == true}">男</c:if> <c:if
						test="${student.sex == false}">女</c:if></td> --%>

				<td><a
					href="${pageContext.request.contextPath}/safety/listRoleFunction.do?role_id=${role.role_id}">角色功能</a></td>
				<td><a
					href="${pageContext.request.contextPath}/safety/getRole.do?role_id=${role.role_id}">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath}/safety/deleteRole.do?role_id=${role.role_id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>

