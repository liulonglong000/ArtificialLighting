<%@ page language="java" import="java.util.*, com.face.dto.UserRole, com.face.model.Session, com.face.entity.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/handleAttachment.js"></script>
	
	<%
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {	
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	String userType = sessionInfo.getRoleName();
	
	GatewayInfo gwInfo = (GatewayInfo)request.getAttribute("gwInfo");
	%>

  </head>
  
	<body style="background-color: white; padding-bottom: 10px;">
		<input type="hidden" id="basePathId" value="<%=basePath%>">
		<input type="hidden" id="parkId" value="">
		<div class="sys_right_content_box">
	    	<div class="right_content">
	        	<div class="content_border">
	            	<div class="table_title">
	                	<div class="table_content">
	                    	<span class="table_title_box">??????????????????</span>
	                    </div>
	                </div>
	                <div class="table_content">
	                <form id="fileForm" method="post" enctype="multipart/form-data">
	                	<input type="hidden" id="tokenId" name="token" value="<%=sessionInfo.getToken() %>">	                	
	                	<input type="hidden" id="userIdId" name="userId" value="<%=sessionInfo.getUserIdString() %>">
						<table width="100%" border="0">
						  	<tr class="tr_style">
							    <td style="text-align: right;" width="100px;" nowrap="nowrap">??????ID???</td>
							    <td>
							    	<span class="span_txt4"><%=gwInfo.getGatewayId() %></span>
							    	<input type="hidden" id="gatewayIdId" name="gatewayId" value="<%=gwInfo.getGatewayId() %>"/>
							    </td>							    
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td><input class="input_txt5" id="gatewayNameId" name="gatewayName" type="text" value="<%=gwInfo.getGatewayName() %>" maxlength="255"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td><input class="input_txt5" id="gatewayAddressId" name="gatewayAddress" type="text" value="<%=gwInfo.getGatewayAddr() %>" maxlength="255"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td><input class="input_txt5" id="gatewayRemarkId" name="gatewayRemark" type="text" value="<%=gwInfo.getRemark() %>" maxlength="255"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td style="text-align:left; padding: 12px;">
							    	<input type="hidden" id="picSrcFileId" name="picSrcFile" value="<%=gwInfo.getGatewayPic() %>">
							    	<%
							    	if (gwInfo.getGatewayPic().length() > 0) {
							    	%>
						    		<div id="pisHasId">
						    			<div class="ghs_pic">
						    				<img id="picShowId" alt="" src="downloadFile/downloadFile?inputPath=<%=gwInfo.getGatewayPic() %>"/>
						    			</div>
						    			<div class="ghs_del">
						    				<div class="ghs_del_space"></div>
						    				<a href="javascript:;" onClick="clearFile('picSelId');">??????</a>
						 				</div>
						    		</div>		
						    		<div id="pisNoneId" style="display: none;">    		
							    		<p class="txt_style1">???????????????????????????100MB???????????????200*200?????????????????????????????????.jpg,.bmp,.png???</p>
							    		<p style="margin-bottom: 10px;">						    			
						 					<input type='file' id='picSelId' name='picSel' onchange="onSelectPic(this);" 
						 							accept=".jpg,.bmp,.png" style="width: 500px;"/>					 					
					 					</p>
				 					</div>
				 					<%
				 					} else {
				 					%>
				 					<div id="pisHasId" style="display: none;">
						    			<div class="ghs_pic">
						    				<img id="picShowId" alt="" src=""/>
						    			</div>
						    			<div class="ghs_del">
						    				<div class="ghs_del_space"></div>
						    				<a href="javascript:;" onClick="clearFile('picSelId');">??????</a>
						 				</div>
						    		</div>		
						    		<div id="pisNoneId">    		
							    		<p class="txt_style1">???????????????????????????100MB???????????????200*200?????????????????????????????????.jpg,.bmp,.png???</p>
							    		<p style="margin-bottom: 10px;">						    			
						 					<input type='file' id='picSelId' name='picSel' onchange="onSelectPic(this);" 
						 							accept=".jpg,.bmp,.png" style="width: 500px;"/>					 					
					 					</p>
				 					</div>
				 					<%
				 					}
				 					%>
							    </td>
						  	</tr>
							<tr>
	    						<td colspan="2">
	                            	<div class="radio_box" style="height:40px; margin:20px 0 20px 20px;">
	                                	<a href="javascript:;" onclick="toSaveGatewayInfo('gateway/mdyGatewayInfo', '???????????????????????????', false);" class="btn_box">???&nbsp;&nbsp;&nbsp;???</a>
	                                	<a href="gatewayJsp/webQueryGwTable?userId=<%=sessionInfo.getUserIdString() %>" class="btn_box">???&nbsp;&nbsp;&nbsp;???</a>
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
