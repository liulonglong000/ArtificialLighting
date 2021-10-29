<%@ page language="java" import="java.util.*, com.face.entity.ParkWebInfo, java.net.URLEncoder, com.face.model.Session" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
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
	<script type="text/javascript" src="js/handleUserInfo.js"></script>
	
	<%
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {	
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	String userType = sessionInfo.getRoleName();
	%>
  </head>
  
  	<body style="background-color: white; padding-bottom: 10px;">
		<div class="layout_content_box_right box_style" style="margin-top:28px;">    		
		    <div class="title_box_bg">
		        <div class="title_box1">
		            <span class="crumb_txt" style="width:400px;">园区监控</span>		            
		        </div>
		    </div>		  
		    
		    <ul class="park_list">
    			<%
               	@SuppressWarnings("unchecked")
				List<ParkWebInfo> listInfo = (List<ParkWebInfo>)request.getAttribute("pList");
				if (listInfo != null) {
               	for (ParkWebInfo info : listInfo) {                		
               	%>                	
              		<li>  
              			<div class="park_absolute">
              				<div class="park_pic">
              					<%
              					String picPath = info.getPicPath();
              					if (picPath.length() > 0) { 
              					%>
	              				<img alt="获取图像失败" src="downloadFile/downloadFile?inputPath=<%=picPath %>"/>
	              				<%
	              				} else {
	              				%>
	              				<img alt="获取图像失败" src="downloadFile/downloadFile?inputPath=IGCS_DEFAULT_PARK.png"/>
	              				<%
	              				}
	              				%>
	              			</div>
	              			<div class="park_name">
	              				<a href="gatewayJsp/webQueryGatewayOfPark?parkId=<%=info.getParkId() %>" class="hide"><%=info.getParkName() %> </a>
	              			</div>
	              			<div class="park_desp">
	              				<span><%=info.getInfo() %></span>
	              			</div>	
	              			<div class="park_area">
	              				<span>占地面积<%=info.getAreaString() %></span>
	              			</div>	
	              			<div class="park_user">
	              				<span><%=info.getUserName() %></span>
	              			</div>
	              			<div class="park_time">
	              				<span><%=info.getAddTime() %></span>
	              			</div>
              			</div>
              		</li>
               	<%
               	}
               	}
               	%>	
    		</ul>  
    		
    		<div class="div_h10"></div>		    
		    <div class="div_h10"></div>
		</div>
	</body>
</html>