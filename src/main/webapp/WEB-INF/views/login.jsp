<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pintuer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/pintuer.js"></script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<%
			String userName="";
			String passWord="";
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie c : cookies) {
					if(c.getName().equals("name")){
						userName = c.getValue();
					}else if(c.getName().equals("psw")){
						passWord = c.getValue();
					}
				}
			}
		%>
				
				<form action="${pageContext.request.contextPath}/login_submit.do"
					method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="user_name"
										placeholder="登录账号" value="<%=userName%>" data-validate="required:请填写账号" />
									<!-- 											jquery判断机制  菜鸟 -->
									<span class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" value="<%=passWord%>" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
						</div>
						
						<div id=login>
								<input type="checkbox" name="autoLogin" value="true" checked="checked"><span
								style="color: gray">保存信息</span><br />
							</div>
							
						<div>${error}</div>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录">
								
						</div>
					</div>
				</form>
				<form action="${pageContext.request.contextPath}/user/addFormUser.do"
					method="post">
					<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="注册用户"><br> 	
						</div>
						</form>
				<%-- <a href="${pageContext.request.contextPath}/user/addFormUser.do"
								class="button button-block bg-main text-big input-big">注册</a> --%>
			</div>
		</div>
	</div>

</body>
</html>