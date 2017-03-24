<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
  	<script>
  		function check(){
  			var user = $("#name").val();//获取表单元素值
  			var number = $("#number").val();
  			var carnum = $("#carnum").val();
  			
  			$("#error").css("display", "none");
  			var mobile = $.trim($("#number").val());
  			var isMobile = /^(((13[0-9]{1})||(15[0-9]{1})||(18[0-9]{1})||(17[0-9]{1})||(14[0-9]{1}))+\d{8})$/;  
  	        var isPhone = /^(?:(?:0\d{2,3})-)?(?:\d{7,8})(-(?:\d{3,}))?$/;  
  	        var error = "<label id=\"error\" class=\"validate_input_error\">请正确填写电话号码，例如:13511111111或010-11111111</label>"; 
  			
  	        if(user == "" || number ==""){
  				$("#msg").text("车主、电话和车牌、颜色、厂商不能为空!");
  				return false;
  			}else if(!isNaN(carnum)){//!isNaN(carnum)判断是否是全数字
  				$("#msg").text("请正确填写车牌号，如：川A.11111");
  				return false;
  				
  			}else if (mobile.substring(0, 1) == 1) { //如果以1开头则验证手机号码 
  				if (!isMobile.test(mobile) && mobile.length != 11) {    
  	            	$("#number").after(error);
  	            	$("#number").focus(); 
  	                return false;  
  	            }  
  	        }else if (mobile.substring(0, 1) == 0) {//如果为0开头则验证固定电话号码    
  	            if (!isPhone.test(mobile)) {  
  	            	$("#number").after(error);
  	            	$("#number").focus(); 
  	                return false;  
  	            }  
  	        }else { //否则全部不通过   
  	        	$("#number").after(error);
  	        	$("#number").focus(); 
  	            return false;  
  	        } 
  				return true;
  		}
  	</script>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/car/add.do" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return check()">
    	车牌:<input type="text" name="carNums" id="carnum"/><br>
    	车主:<input type="text" name="carOwnner" id="name"/><br>
    	电话:<input type="text" name="telePhone" id="number"/><br>
    	颜色:<input type="text" name="color" id="name"/><br>
    	厂家:<input type="text" name="factory" id="name"/><br>
    	备注:<input type="text" name="remarks" id="a"/><br>
    	<span id="msg" style="color:red;font-size:15px">${error}</span>
    		<input type="submit" value="添加"/>${message}
    </form>
  </body>
</html>
