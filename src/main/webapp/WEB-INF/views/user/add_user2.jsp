<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>注册用户</title>

<!-- <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script> -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
	$(function(){
		$("#reform").validate({
			 //同级最后项不加，
			 rules: {
				 user_name: "required",//表单name值，不是选择器 
			       password: {
			        required: true,//必须输入的字段
			        rangelength:[5,10] 
			      },
			      pwd: {
			    	   required: true, 
			    	   rangelength:[5,10] , 
			    	    equalTo: "#number" 
			      } 
			}  ,
			 messages:{
				 user_name: "用户名不能为空",			    
			      password: {
			    	  required: "密码不能为空",
			        	rangelength: "验证密码长度必须在5-10"
			      },
			      pwd: {
			    	   required: "验证密码不能为空",  
			    	   rangelength: "验证密码长度必须在5-10",
			    	   equalTo: "验证密码不相符"
			 		}	
			 }  
		});//表单验证
		
		
		$(".chcke").blur (function(){	
			var username = $("#name").val();
			var phone = $("#phone").val();
			
			 $.ajax({	
				url:"<%=request.getContextPath()%>/user/addUser.do",
				data:"name1="+username,
				//+"&phone="+phone,
				type:"post",
				dataType:"json",
				success:function(result){
					/* var a = result.mas;
					alert("msg aaaa"+a);  */
					var msg=result["mas"];
					
					if(msg=="no"){	
					
						$("#mss").empty();//清空用户已存在提示，提示只显示一次
						$("#mss").append("用户已存在");
					}
					
				},
				 error:function(xhr,status,error){
						alert("error "+error);
					 }
			}); 
		});  
	});
</script>
</head>

<body>

				
	<form id="reform" action="${pageContext.request.contextPath}/user/registerUser.do"
		method="post">								
		用户&nbsp名:<input type="text" name="user_name" id="name"  class="chcke"/><span id="mss" style='color:red;font-size:12px'></span><br>
		电话号码：<input type="text" name="tile" id="phone"  class="chcke"/><br>
		密&nbsp&nbsp码:<input type="password" name="password" id="number" /><br>
		确认密码:<input type="password" name="pwd" id="num" /><br> 
		<input type="hidden" name="state" value="1" /><br> 
		<input type="submit" value="添加" onclick="sub()"/>
	
		<span id="msg" style='color:red;font-size:12px'>${message}</span><br>
		<span style='color:bule;font-size:25px' >${mess}</span>
	</form>
</body>
</html>
