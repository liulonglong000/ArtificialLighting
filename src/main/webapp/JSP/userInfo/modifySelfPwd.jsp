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
	<script type="text/javascript" src="js/handleUserInfo.js"></script>
	
	<%
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {	
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	%>

  </head>
  
	<body style="background-color: white; padding-bottom: 10px;">
		<div class="sys_right_content_box">
	    	<div class="right_content">
	        	<div class="content_border">
	            	<div class="table_title">
	                	<div class="table_content">
	                    	<span class="table_title_box">修改密码</span>
	                    </div>
	                </div>
	                <div class="table_content">
						<table width="100%" border="0">
  							<tr class="tr_style">
							    <td style="text-align: right;" width="100px;" nowrap="nowrap">旧密码：</td>
							    <td><input class="input_txt4" id="oldPasswordId" name="oldPassword" type="password" value="" maxlength="16"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">新密码：</td>
							    <td><input class="input_txt4" id="newPasswordId" name="newPassword" type="password" value="" maxlength="16"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">确认密码：</td>
							    <td><input class="input_txt4" id="newPassword2Id" name="newPassword2" type="password" value="" maxlength="16"/></td>
						  	</tr>
							<tr>
	    						<td colspan="2">
	                            	<div class="radio_box" style="height:40px; margin:20px 0 20px 20px;">
	                                	<a href="javascript:;" onclick="toSaveSelfPwd('<%=sessionInfo.getUserIdString() %>');" class="btn_box">保存修改</a>
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
