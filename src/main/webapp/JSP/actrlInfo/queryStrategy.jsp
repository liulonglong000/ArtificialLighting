<%@ page language="java" import="java.util.*, com.face.entity.*, com.face.model.Session, com.face.dto.UserRole" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/handleGreenHouse.js"></script>
	<script type="text/javascript" src="js/handleAutoControl.js"></script>
	
	<script src="js/Highcharts/highcharts.js"></script>
	<script src="js/Highcharts/modules/exporting.js"></script>
	
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
  		<input type="hidden" id="basePathId" value="<%=basePath%>">
  		<input type="hidden" id="userIdId" name="userId" value="<%=sessionInfo.getUserIdString() %>">
		<div class="layout_content_box_right box_style" style="margin-top:28px; min-height:200px;">    		
		    <div class="title_box_bg">
		        <%@ include file="../parkInfo/GlobalGhRetPath.jsp"%>
		        
		        <input type="hidden" id="greenHouseFilterId" value="<%=request.getAttribute("ghId") %>">
		        <input type="hidden" id="gatewayFilterId" value="<%=request.getAttribute("gwId") %>">
		        
		        <% int navId = 3; %>
    			<%@ include file="../GlobalNav.jsp"%>   
    			
    			<a href="javascript:void(0)" onclick="toAddStrategy();" style="float: right; margin: 10px;">添加策略</a> 			
		    </div>
		    
		    <div class="table_content">
               	<table width="100%" border="0">
					<tr class="tr_style">
 						<td nowrap="nowrap">序号</td>
                        <td>策略</td>
                        <td nowrap="nowrap">创建者</td> 
                        <td nowrap="nowrap">修改时间</td>   
                        <td nowrap="nowrap">操作</td> 
					</tr>
 						
 					<%
 					@SuppressWarnings("unchecked")
          			List<StrategyInfo> lst = (List<StrategyInfo>)request.getAttribute("strategyList"); 
          			if (lst != null) {
          				int nId = 1;
      					for (StrategyInfo entity : lst) {  
	               	%>
 					<tr class="tr_style">
   						<td><%=nId%><%nId++;%></td>
		                <td style="text-align: left;"><%=entity.getRemarkString() %></td>
		                <td nowrap="nowrap"><%=entity.getUserName() %></td>
		                <td nowrap="nowrap"><%=entity.getMdyTimeString() %></td>
                        <td nowrap="nowrap">
                           	<a href="javascript:void(0)" onclick="toMdyStrategy('<%= entity.getBaseInfo().getStrategyId()%>', 
                           	'<%= entity.getBaseInfo().getThresholdGroupId1()%>', '<%= entity.getBaseInfo().getThresholdGroupId2()%>', 
                           	'<%= entity.getBaseInfo().getThresholdGroupId3()%>', '<%= entity.getBaseInfo().getOperateGroupId()%>',
                           	'<%= entity.getBaseInfo().getExcutionStartTime().getHours()%>', '<%= entity.getBaseInfo().getExcutionStartTime().getMinutes()%>', 
                           	'<%= entity.getBaseInfo().getExcutionEndTime().getHours()%>', '<%= entity.getBaseInfo().getExcutionEndTime().getMinutes()%>');">修改策略</a>
                           	  |  <a href="javascript:void(0)" onclick="toDelStrategy('<%= entity.getBaseInfo().getStrategyId()%>');">删除策略</a>
                        </td>
                    <%
                        }
					}
					%>  	
					</tr>												
				</table>
             </div>		   
      	</div>
      	
      	
      	<div id="thresholdDivId" class="content_border" style="display: none; margin: 20px;">  
      		<input type="hidden" id="getDatasId" value="0">     	     	    	
			<div class="table_content">
				<table width="100%" border="0">  
					<tr class="tr_style">
					    <td style="text-align: right; width: 70px;">阈值组：</td>
					    <td>
					    	<select id="tgId1" class="select_item" style="width:100%; margin-left: 0px;">
								<option value="-1">-----请选择-----</option>
							</select>
					    </td>
				  	</tr>
				  	<tr class="tr_style">
					    <td style="text-align: right; width: 70px;">或：</td>
					    <td>
					    	<select id="tgId2" class="select_item" style="width:100%; margin-left: 0px;">
								<option value="-1">-----请选择-----</option>
							</select>
					    </td>
				  	</tr>
				  	<tr class="tr_style">
					    <td style="text-align: right; width: 70px;">或：</td>
					    <td>
					    	<select id="tgId3" class="select_item" style="width:100%; margin-left: 0px;">
								<option value="-1">-----请选择-----</option>
							</select>
					    </td>
				  	</tr>
				  	<tr class="tr_style">
					    <td style="text-align: right; width: 70px;">操作组：</td>
					    <td>
					    	<select id="ogId" class="select_item" style="width:100%; margin-left: 0px;">
								<option value="-1">-----请选择-----</option>
							</select>
					    </td>
				  	</tr>
				  	<tr class="tr_style">
					    <td style="text-align: right;">时间段：</td>
					    <td>
					    	<select id="startHourId" class="select_item" style="width:70px; margin-left: 0px;">
								<%
								for (int n = 0; n < 24; n++) {
								%>
									<option value=<%=n %>><%=n %></option>
								<%
								}
								%>
							</select>
					    	<span class="span_txt4">时</span>
					    	<select id="startMinId" class="select_item" style="width:70px; margin-left: 4px;">
								<%
								for (int n = 0; n < 59; n++) {
								%>
									<option value=<%=n %>><%=n %></option>
								<%
								}
								%>
							</select>
					    	<span class="span_txt4">分&nbsp;&nbsp;到&nbsp;&nbsp;</span>
					    	<select id="endHourId" class="select_item" style="width:70px; margin-left: 4px;">
								<%
								for (int n = 0; n < 24; n++) {
								%>
									<option value=<%=n %>><%=n %></option>
								<%
								}
								%>
							</select>
					    	<span class="span_txt4">时</span>
					    	<select id="endMinId" class="select_item" style="width:70px; margin-left: 4px;">
								<%
								for (int n = 0; n < 59; n++) {
								%>
									<option value=<%=n %>><%=n %></option>
								<%
								}
								%>
							</select>
					    	<span class="span_txt4">分</span>
					    </td>
				  	</tr>
				</table>
			</div>
	  	</div>
	</body>
</html>