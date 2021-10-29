<%@ page language="java" import="java.util.*, com.face.entity.GreenhouseInfo, java.net.URLEncoder, com.face.model.Session, com.face.dto.UserRole" pageEncoding="UTF-8"%>
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
		        	<%
		        	if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
		        	%>
		        	<a href="gatewayJsp/webQueryPark">园区监控</a>
		        	<span class="crumb_txt" style="width:25px; margin-left: 5px;">=></span>
		        	<a href="gatewayJsp/webQueryGatewayOfPark?parkId=<%=request.getAttribute("parkId") %>" style="margin-left: 5px;"><%=request.getAttribute("parkName") %></a>
		            <span class="crumb_txt" style="width:400px; margin-left: 5px;">=> <%=request.getAttribute("gwName") %></span>	
		            <%
		            } else if (userType.equals(UserRole.ROLE_PARK_ADMIN)) {
		            %>	            
		     <%--        <a href="gatewayJsp/webQueryGateway?userId=<%=sessionInfo.getUserIdString() %>">网关监控</a>
		            <span class="crumb_txt" style="width:400px; margin-left: 5px;">=> <%=request.getAttribute("gwName") %></span> --%>
		            <span class="crumb_txt" style="width:400px;">温室监控</span>
		            <%
		            } else if (userType.equals(UserRole.ROLE_PARK_USER)) {
		            %>	            		            
		            <span class="crumb_txt" style="width:400px;">温室监控</span>
		            <%
		            }
		            %>	            
		        </div>
		    </div>		  
		    
		    <ul class="gw_list">
    			<%
               	@SuppressWarnings("unchecked")
				List<GreenhouseInfo> listInfo = (List<GreenhouseInfo>)request.getAttribute("ghList");
				if (listInfo != null) {
               	for (GreenhouseInfo info : listInfo) {                		
               	%>                	
              		<li>  
              			<div class="gw_absolute">
              				<div class="gw_pic">
              					<%
              					String picPath = info.getPicPath();
              					if (picPath.length() > 0) { 
              					%>
	              				<img alt="获取图像失败" src="downloadFile/downloadFile?inputPath=<%=picPath%>"/>
	              				<%
	              				} else {
	              				%>
	              				<img alt="获取图像失败" src="downloadFile/downloadFile?inputPath=IGCS_DEFAULT_GH.png"/>
	              				<%
	              				}
	              				%>
	              			</div>
	              			<div class="gw_name">
	              				<a href="gatewayJsp/webGetGhNodesData?ghId=<%=info.getGreenhouseId() %>" class="hide"><%=info.getGreenhouseName() %> </a>
	              			</div>
	              			<div class="gw_desp">
	              				<span><%=info.getGreenhouseAddr() %></span>
	              			</div>	
	              			<%-- <div class="gw_user">
	              				<span><%=info.getStatus() %></span>
	              			</div>
	              			<div class="gw_time">
	              				<span><%=info.getLastConnectTime() %></span>
	              			</div> --%>
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