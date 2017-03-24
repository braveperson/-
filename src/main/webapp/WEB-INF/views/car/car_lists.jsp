<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Jstl管理员列表</title>
<%--因为mystyle.css在css文件中,所以写成href="../css/mystyle.css"--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css"></link>

</head>
	

<body>
	<div>
		<form action="${pageContext.request.contextPath}/car/find.do" method="post">
			<select name="type">
				<option value="carNums">车牌号</option>
				<option value="carOwnner">车主</option>
				<option value="telePhone">电话</option>
			</select>
			<input type="text" name="keyword"/>
			<input type="submit" value="查询"/>
		</form>
	</div>
	 <hr/>

	<br>
	<h1 align="center">车辆会员表</h1>
	<hr> 
	
	<table>
		<tr>
			<th>车牌</th>
			<th>车主</th>
			<th>电话</th>
			<th>颜色</th>
			<th>厂家</th>
			<th>备注</th>
			<th colspan="2">操作</th>
		</tr>

		<c:forEach items="${lists}" var="car">
			<tr>
				<td><c:out value="${car.carNums}" /></td>
				<td><c:out value="${car.carOwnner}" /></td>
				<td><c:out value="${car.telePhone}" /></td>
				<td><c:out value="${car.color}" /></td>
				<td><c:out value="${car.factory}" /></td>
				<td><c:out value="${car.remarks}" /></td>

				<td><a href="${pageContext.request.contextPath}/car/find.do?number=${car.carNums}">修改</a></td>
				<td><a href="${pageContext.request.contextPath}/car/delete.do?id=${car.id}">删除</a></td>
			</tr>
		</c:forEach>
		
		
	</table>
	<br>
	<div align="center">${url}</div>
</body>
</html>

