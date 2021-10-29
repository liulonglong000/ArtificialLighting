<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基于智能手机的温室环境监测与补光控制系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<link href="css/greenhouse.css" type="text/css" rel="stylesheet"/>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/globalFun.js"></script>
	<script type="text/javascript" src="js/zDialog.js"></script>
	<script type="text/javascript" src="js/handleLogin.js"></script>
  </head>
  
	<body>
		<input type="hidden" id="basePathId" value="<%=basePath%>">
		
		<div class="login_content_bg">
	    	<div class="login_bg">
		        <div class="login_box_bg">
		        	<form id="form1" name="form1" method="post" action="">
		        		<span class="system_name">系统登录</span><br>
		        		<input id="userId" name="userName" onfocus="clearPromptName(this);" onblur="resetPromptName(this);" type="text" value="用户账号" class="login_pos"/><br>		                
		                <input id="showPwdId" name="password" onfocus="clearPromptPw(this);" type="text" value="登录密码" class="login_pos" />
		                <input id="pwdId" name="password" type="password" onblur="resetPromptPw(this);" value="" class="login_pos" style="display: none;"/><br>
		                
		                <a href="javascript:;" onclick="toCheckLoginInfo();" class="login_btn" style="margin-right:10px; margin-left: 105px;margin-top: 20px;">登&nbsp;&nbsp;&nbsp;录</a>
		                <a href="javascript:;" onclick="toResetLoginInfo();" class="login_btn" style="margin-top: 20px;">重&nbsp;&nbsp;&nbsp;置</a>
		        	</form>
		        </div>
			</div>
		</div>
		
		<%@ include file="JSP/GlobalFooter.jsp"%>
	</body>
	
</html>