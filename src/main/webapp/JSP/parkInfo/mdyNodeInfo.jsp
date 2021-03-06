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
	
	NodeWebInfo gwInfo = (NodeWebInfo)request.getAttribute("nodeInfo");
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
	                	<input type="hidden" id="nodeIdId" name="nodeId" value="<%=gwInfo.getNodeId() %>"/>
	                	<input type="hidden" id="gwIdId" name="gwId" value="<%=gwInfo.getGwId() %>"/>
	                	<input type="hidden" id="ghIdId" name="ghId" value="<%=gwInfo.getGhId() %>"/>
						<table width="100%" border="0">							
						  	<tr class="tr_style">
							    <td style="text-align: right; width: 160px;">???    ??????</td>
							    <td><input class="input_txt5" id="nodeNameId" name="nodeName" type="text" value="<%=gwInfo.getNodeName() %>" maxlength="255"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td><input class="input_txt5" id="nodeAddrId" name="nodeAddr" type="text" value="<%=gwInfo.getNodeAddr() %>" maxlength="255"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">????????????(??????)???</td>
							    <td><input class="input_txt5" id="frquencyId" name="frquency" onkeyup="value=value.replace(/[^\d]/g,'')" onBlur="limitInputForInt(this, '??????');"  style="ime-mode:Disabled;" type="text" value="<%=gwInfo.getFrequencyData() %>"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td><input class="input_txt5" id="nodeRemarkId" name="nodeRemark" type="text" value="<%=gwInfo.getRemark() %>" maxlength="255"/></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">???    ??????</td>
							    <td style="text-align:left; padding: 12px;">
							    	<input type="hidden" id="picSrcFileId" name="picSrcFile" value="<%=gwInfo.getPicPath() %>">
							    	<%
							    	if (gwInfo.getPicPath().length() > 0) {
							    	%>
						    		<div id="pisHasId">
						    			<div class="ghs_pic">
						    				<img id="picShowId" alt="" src="downloadFile/downloadFile?inputPath=<%=gwInfo.getPicPath() %>"/>
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
	                                	<a href="javascript:;" onclick="toSaveNodeInfo();" class="btn_box">???&nbsp;&nbsp;&nbsp;???</a>
	                                	<a href="gatewayJsp/webQueryNode?ghId=<%=gwInfo.getGhId() %>" class="btn_box">???&nbsp;&nbsp;&nbsp;???</a>
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
