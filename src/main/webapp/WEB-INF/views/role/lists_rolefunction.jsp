<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="cn.scxh.carmangger.model.Function"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Jstl模块列表</title>
<%--因为mystyle.css在css文件中,所以写成href="../css/mystyle.css"--%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mystyle.css"></link>

<script>
	function selectAll(form, elementName) {
		for (var i = 0; i < form.elements.length; i++) {
			var e = form.elements[i];
			if (e.name == elementName) {
				e.checked = form.chkall.checked;
			}
		}
	}
</script>
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

	<form id="form1" name="form1" method="post"
		action="${pageContext.request.contextPath}/safety/submitUpdateRoleFunction.do">
		<table width="100%" border="0" cellpadding="2" cellspacing="2"
			bgcolor="#cccccc">
			<tr>
				<td width="4%"><label> <input name="chkall"
						type="checkbox" id="chkall" value=""
						onclick="javascript:selectAll(form1,'selectId')" />
				</label></td>
				<!-- <td width="24%"><div align="center">模块</div></td> -->
				<td width="38%"><div align="center">功能id</div></td>
				<td width="38%"><div align="center">功能</div></td>
				<td width="34%"><div align="center">功能描述</div></td>
			</tr>
			<%
				String color = "";
				int c = 1;
			%>

			<%
				List<Function> allLists = (List<Function>) request.getAttribute("AllFunctionLists");
				for (Function function : allLists) {
			%>
				<%
					if (c == 1) {
							color = "#ffffff";
							c = 0;
						} else {
							color = "#f5f5f5";
							c = 1;
						}
				%>
	
				<tr>
					<%
						int z = 0;
						List<Function> lists = (List<Function>) request.getAttribute("RolefunctionLists");
						for (Function f : lists) {
							if (f.getFunction_id() == function.getFunction_id()) {
								z = 1;
							}
						}
					%>
	
					<%
						if (z == 1) {
					%>
					<td bgcolor="<%=color%>"><input name="selectId" type="checkbox"
						value="<%=function.getFunction_id() %>" checked="checked" /></td>
					<%
						} else {
					%>
					<td bgcolor="<%=color%>"><input name="selectId" type="checkbox"
						value="<%=function.getFunction_id() %>" /></td>
					<%
						}
					%>
	
					<%-- <td bgcolor="<%=color%>"><div align="center">${x.module.name}</div></td> --%>
					<td bgcolor="<%=color%>"><div align="center"><%=function.getFunction_id() %></div></td>
					<td bgcolor="<%=color%>"><div align="center"><%=function.getFunction_code() %></div></td>
					<td bgcolor="<%=color%>" style="word-break: break-all;"><%=function.getDescription() %></td>
				</tr>

			<%
				}
			%>
			<tr>
				<td>&nbsp;<input type="hidden" name="role_id" value="${role_id}"></td>
				<td colspan="3"><input name="submit1" type="submit" value="提交" />
					<input name="submit2" type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>

</body>
</html>

