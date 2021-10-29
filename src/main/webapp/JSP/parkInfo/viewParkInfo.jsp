<%@ page language="java" import="java.util.*, com.face.dto.UserRole, com.face.model.Session, com.face.entity.ParkWebInfo" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/handleParkInfo.js"></script>
	<script type="text/javascript" src="js/handleAttachment.js"></script>
	
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
	                    	<span class="table_title_box">园区信息</span>
	                    </div>
	                </div>
	                <div class="table_content">
						<table width="100%" border="0">
							<%
							ParkWebInfo pWeb = (ParkWebInfo)request.getAttribute("parkInfo");
							%>
  							<tr class="tr_style">
							    <td style="text-align: right;" width="100px;" nowrap="nowrap">园区ID：</td>
							    <td><span class="span_txt4"><%=pWeb.getParkId() %></span></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">名    称：</td>
							    <td><span class="span_txt4"><%=pWeb.getParkName() %></span></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">面积：</td>
							    <td><span class="span_txt4"><%=pWeb.getAreaString() %></span></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">地    址：</td>
							    <td><span class="span_txt4"><%=pWeb.getParkAddr() %></span></td>
						  	</tr>
						  	<tr class="tr_style">
							    <td style="text-align: right;">说    明：</td>
							    <td><span class="span_txt4"><%=pWeb.getParkRemark() %></span></td>
						  	</tr>
						</table>	
					</div>
				</div>		
			</div>
		</div>
	</body>
  
</html>
