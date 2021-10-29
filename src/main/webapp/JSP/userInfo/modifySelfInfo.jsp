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
	<script type="text/javascript" src="js/handleAttachment.js"></script>
	
	<%
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {	
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	%>

  </head>
  
	<body style="background-color: white; padding-bottom: 10px;" onload="getSelInfoFromServer('<%=sessionInfo.getUserIdString() %>')">
		<div class="sys_right_content_box">
	    	<div class="right_content">
	        	<div class="content_border">
	            	<div class="table_title">
	                	<div class="table_content">
	                    	<span class="table_title_box">个人基本信息</span>
	                    </div>
	                </div>
	                <div class="table_content">
	                <form id="fileForm" method="post" enctype="multipart/form-data">
	                	<input type="hidden" id="tokenId" name="token" value="<%=sessionInfo.getToken() %>">	                	
	                	<input type="hidden" id="userIdId" name="userId" value="<%=sessionInfo.getUserIdString() %>">
						<table width="100%" border="0">
  							<tr class="tr_style">
							    <td style="text-align: right;" width="100px;" nowrap="nowrap">账号：</td>
							    <td><span class="span_txt4"><%=sessionInfo.getUserIdString() %></span></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">账号类型：</td>
							    <td><span class="span_txt4"><%=sessionInfo.getRoleName() %></span></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">姓名：</td>
							    <td><input class="input_txt4" id="userRealNameId" name="userRealName" type="text" value="" maxlength="8"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">手机号码：</td>
							    <td><input class="input_txt4" id="userMobileId" name="userMobile" type="text" value="" maxlength="11"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">头像：</td>
							    <td style="text-align:left; padding: 12px;">
							    	<input type="hidden" id="picSrcFileId" name="picSrcFile" value="">
						    		<div id="pisHasId" style="display: none;">
						    			<div class="ghs_pic">
						    				<img id="picShowId" alt="" src=""/>
						    			</div>
						    			<div class="ghs_del">
						    				<div class="ghs_del_space"></div>
						    				<a href="javascript:;" onClick="clearFile('picSelId');">删除</a>
						 				</div>
						    		</div>		
						    		<div id="pisNoneId">    		
							    		<p class="txt_style1">待上传图片（不大于100MB，建议大小200*200像素），支持的类型有（.jpg,.bmp,.png）</p>
							    		<p style="margin-bottom: 10px;">						    			
						 					<input type='file' id='picSelId' name='picSel' onchange="onSelectPic(this);" 
						 							accept=".jpg,.bmp,.png" style="width: 500px;"/>					 					
					 					</p>
				 					</div>
							    </td>
						  	</tr>
							<tr>
	    						<td colspan="2">
	                            	<div class="radio_box" style="height:40px; margin:20px 0 20px 20px;">
	                                	<a href="javascript:;" onclick="toSaveUserInfo();" class="btn_box">保存修改</a>
	                                </div>
	                            </td>
	  						</tr>
						</table>	
					</form>
					</div>
				</div>		
			</div>
		</div>
	</body>
  
</html>
