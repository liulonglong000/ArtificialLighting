<%@ page language="java" import="java.util.*, com.face.model.Session" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
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
  
	<body bgColor='#ffffff'>
		<div class="system_top_box">
			<div class="system_top_left_box">
		    </div>
		    <div class="system_top_right_box">
		    	<p class="top_user_text">您好，
		    	<%
				Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
				if (sessionInfo != null) {								
				%>
	        	<%=sessionInfo.getUserIdString() %>
				<%
				}
				%>，欢迎使用该系统！ </p>
		        <p class="top_user_text" style="margin:0;">
		        	<a href="javascript:;" onclick="gotoLogout();" class="out_btn">退出系统</a> 
		        </p>
		    </div>
		</div>
	</body>

</html>
