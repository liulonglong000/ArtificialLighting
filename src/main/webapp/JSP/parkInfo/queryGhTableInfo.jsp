<%@ page language="java" import="java.util.*, com.face.entity.UserInfo, com.face.dto.UserRole, com.face.model.Session, com.face.entity.GreenhouseInfo" pageEncoding="UTF-8"%>
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
		<div class="sys_right_content_box">
	    	<div class="right_content">			             
			    <div class="content_border" style="margin-bottom:16px;">
	            	<div class="table_title">
	                	<div class="table_content">		
	                    	<span class="table_title_box">温室信息</span>
	                    </div>
	                </div>
	                <div class="table_content">
	                	<table width="100%" border="0">
	  						<tr class="tr_style">
	    						<td nowrap="nowrap">序号</td>
	    						<td nowrap="nowrap">温室ID</td>
	                            <td nowrap="nowrap">名称</td>
	                            <td nowrap="nowrap">位置</td>
	                            <td nowrap="nowrap">网关</td> 
	                            <td nowrap="nowrap">说明</td>
	                            <td nowrap="nowrap">录入时间</td>    
	                            <td nowrap="nowrap">操作</td> 
	  						</tr>
	  						
	  						<%
	  						@SuppressWarnings("unchecked")
			               	List<GreenhouseInfo> listInfo = (List<GreenhouseInfo>)request.getAttribute("ghList");
							int nId = 1;
	                		if (listInfo != null) {
	                		for (GreenhouseInfo entity : listInfo) {   
			               	%>
	  						<tr class="tr_style">
	    						<td><%=nId%><%nId++;%></td>
	    						<td nowrap="nowrap"><%=entity.getGreenhouseId() %></td>
				                <td nowrap="nowrap"><%=entity.getGreenhouseName() %></td>
				                <td style="text-align: left;" nowrap="nowrap"><%=entity.getGreenhouseAddr() %></td>
				                <td nowrap="nowrap"><%=entity.getGatewayId() %>  <%=entity.getGatewayName() %></td>
				                <td style="text-align: left;" nowrap="nowrap"><%=entity.getRemark() %></td>
				                <td nowrap="nowrap"><%=entity.getInDate() %></td>
	                            <td nowrap="nowrap">
	                            	<a href="gatewayJsp/webGetGhInfo?ghId=<%=entity.getGreenhouseId() %>">修改</a>
	                            	  |  <a href="gatewayJsp/webQueryNode?ghId=<%=entity.getGreenhouseId() %>">节点查询</a>
	                            </td>
	  						</tr>
	  						<%
	  							}
	  						}
	  						%>  								
						</table>
	                </div>
	            </div>	
	        </div>
	    </div>
	</body>
</html>