<%@ page language="java" import="java.util.*, com.face.entity.UserInfo, com.face.dto.UserRole, com.face.model.Session" pageEncoding="UTF-8"%>
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
		<div class="sys_right_content_box">
	    	<div class="right_content">			             
			    <div class="content_border" style="margin-bottom:16px;">
	            	<div class="table_title">
	                	<div class="table_content">		                    	
	                    	<%
				    		if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
				    		%>	
	                    	<span class="table_title_box">园区管理员信息</span>
	                    	<%
			      			} else if (userType.equals(UserRole.ROLE_PARK_ADMIN)) {
			      			%>
			      			<span class="table_title_box">园区工作人员信息</span>
			      			<%
							}
						    %>
	                    </div>
	                </div>
	                <div class="table_content">
	                	<table width="100%" border="0">
	  						<tr class="tr_style">
	    						<td nowrap="nowrap">序号</td>
	    						<td>用户名</td>
	                            <td nowrap="nowrap">姓名</td>
	                            <td>手机号码</td>
	                            <td>创建时间</td> 
	                            <%
					    		if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
					    		%>
	                            <td>所属园区</td>  
	                            <%
								}
							    %>
	                            <td>操作</td> 
	  						</tr>
	  						
	  						<%
	  						@SuppressWarnings("unchecked")
			               	List<UserInfo> lstInfo = (List<UserInfo>)request.getAttribute("uList");
							int nId = 1;
	                		if (lstInfo != null) {
	                		for (UserInfo entity : lstInfo) {   
			               	%>
	  						<tr class="tr_style">
	    						<td><%=nId%><%nId++;%></td>
	    						<td style="text-align: left;" nowrap="nowrap"><%=entity.getUserId() %></td>
				                <td style="text-align: left;" nowrap="nowrap"><%=entity.getUserName() %></td>
				                <td nowrap="nowrap"><%=entity.getPhoneNo() %></td>
				                <td nowrap="nowrap"><%=entity.getAddTime() %></td>
				                <%
					    		if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
					    		%>
				                <td style="text-align: left;" nowrap="nowrap"><%=entity.getParkInfo() %></td>
				                <%
								}
							    %>
	                            <td nowrap="nowrap">
	                            	<a href="javascript:void(0)" onclick="toResetUserPwd('<%=entity.getUserId() %>');" >密码重置</a>
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