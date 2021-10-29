<%@ page language="java" import="java.util.*, com.face.dto.UserRole, com.face.model.Session" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/handleParkInfo.js"></script>
	<script type="text/javascript" src="js/handleMenu.js"></script>
	
	<%
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {	
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	String userType = sessionInfo.getRoleName();
	%>

  </head>
  
	<body style="background-color: white; padding-bottom: 10px;" onload="checkParkExist('<%=userType%>', '<%=sessionInfo.getUserIdString()%>', 'addUserInfoId');">
		<input type="hidden" id="basePathId" value="<%=basePath%>">
		<input type="hidden" id="parkId" value="">
		<div class="sys_right_content_box">
	    	<div class="right_content">
	        	<div class="content_border">
	            	<div class="table_title">
	                	<div class="table_content">
	                		<%
				    		if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
				    		%>	
	                    	<span class="table_title_box">添加园区管理员</span>
	                    	<%
			      			} else if (userType.equals(UserRole.ROLE_PARK_ADMIN)) {
			      			%>
			      			<span class="table_title_box">添加园区工作人员</span>
			      			<%
							}
						    %>
	                    </div>
	                </div>
	                <div class="table_content">
						<table width="100%" border="0">  												  	
						  	<tr class="tr_style">
							    <td style="text-align: right;" width="100px;" nowrap="nowrap">用户名：</td>
							    <td><input class="input_txt4" id="userNameId" name="userName" type="text" value="" maxlength="8"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">姓名：</td>
							    <td><input class="input_txt4" id="userRealNameId" name="userRealName" type="text" value="" maxlength="8"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">密码：</td>
							    <td><input class="input_txt4" id="newPasswordId" name="newPassword" type="password" value="" maxlength="16"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">确认密码：</td>
							    <td><input class="input_txt4" id="newPassword2Id" name="newPassword2" type="password" value="" maxlength="16"/></td>
						  	</tr>
							<tr>
	    						<td colspan="2">
	                            	<div class="radio_box" style="height:40px; margin:20px 0 20px 20px;">
	                                	<a href="javascript:;" onclick="toAddUserInfo('<%=sessionInfo.getUserIdString() %>', '<%=UserRole.getChild(sessionInfo.getRoleName()) %>');" class="btn_box">添&nbsp;&nbsp;&nbsp;加</a>
	                                    <a href="javascript:;" onclick="toResetUserInfo();" class="btn_box">重&nbsp;&nbsp;&nbsp;置</a>
	                                </div>
	                            </td>
	  						</tr>
						</table>	
					</div>
				</div>
			</div>			
		</div>
	</body>
	
</html>
