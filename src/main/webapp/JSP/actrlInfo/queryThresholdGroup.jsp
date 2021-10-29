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
    			
    			<a href="javascript:void(0)" onclick="toAddTg();" style="float: right; margin: 10px;">添加阈值组</a> 			
		    </div>
		    
		    <div class="table_content">
               	<table width="100%" border="0">
					<tr class="tr_style">
 						<td nowrap="nowrap">序号</td>
                        <td nowrap="nowrap">名称</td>
                        <td nowrap="nowrap">说明</td>
                        <td nowrap="nowrap">创建者</td> 
                        <td nowrap="nowrap">修改时间</td>   
                        <td nowrap="nowrap">操作</td> 
                        <td nowrap="nowrap">传感器</td> 
                        <td nowrap="nowrap">条件</td>   
                        <td nowrap="nowrap">操作</td> 
					</tr>
 						
 					<%
 					@SuppressWarnings("unchecked")
          			List<ThresholdGroupInfo> lst = (List<ThresholdGroupInfo>)request.getAttribute("tgList"); 
          			if (lst != null) {
          				int nId = 1;
      					for (ThresholdGroupInfo entity : lst) {    
      						List<ThresholdInfo> lstThresholds = entity.getLstThresholds();
      						int nRowSpan = lstThresholds.size();
      						if (nRowSpan == 0) {
      							nRowSpan = 1;
      						}
	               	%>
 					<tr class="tr_style">
   						<td rowspan="<%=nRowSpan %>"><%=nId%><%nId++;%></td>
		                <td rowspan="<%=nRowSpan %>" style="text-align: left;" nowrap="nowrap"><%=entity.getNameString() %></td>
		                <td rowspan="<%=nRowSpan %>" style="text-align: left;" nowrap="nowrap"><%=entity.getRemarkString() %></td>
		                <td rowspan="<%=nRowSpan %>" nowrap="nowrap"><%=entity.getUserNameString() %></td>
		                <td rowspan="<%=nRowSpan %>" nowrap="nowrap"><%=entity.getMdyTimeString() %></td>
                        <td rowspan="<%=nRowSpan %>" nowrap="nowrap">
                           	<a href="javascript:void(0)" onclick="toMdyTg('<%=entity.getIdString() %>', '<%=entity.getNameString() %>', '<%=entity.getRemarkString() %>');">修改阈值组</a>
                           	  |  <a href="javascript:void(0)" onclick="toDelTg('<%=entity.getIdString() %>');">删除阈值组</a>
                           	  |  <a href="javascript:void(0)" onclick="toAddThreshold('<%=entity.getIdString() %>');">添加阈值</a>
                        </td>
                        <%
                        	int nNum = 1;
                        	for (ThresholdInfo tInfo : lstThresholds) {
                        		if (nNum > 1) {  
                        %>
                    </tr>		
                    <tr class="tr_style">	
                        <%
                        		}
                        %>
                        <td nowrap="nowrap"><%=tInfo.getSensorFullName() %></td>
                        <td nowrap="nowrap"><%=tInfo.getInfo() %></td>
                        <td nowrap="nowrap">
                        	<a href="javascript:void(0)" onclick="toMdyThreshold('<%=tInfo.getThresholdBaseInfo().getThresholdId() %>', 
                        	'<%=tInfo.getThresholdBaseInfo().getGatewayId() %>', '<%=tInfo.getThresholdBaseInfo().getNodeId() %>', '<%=tInfo.getThresholdBaseInfo().getSensorTypeCode() %>', 
                        	'<%=tInfo.getThresholdBaseInfo().getSensorId() %>', '<%=tInfo.getThresholdBaseInfo().getThresholdParameter() %>', 
                        	'<%=tInfo.getThresholdBaseInfo().getThresholdTypeCode() %>', '<%=tInfo.getThresholdBaseInfo().getComparaType() %>', 
                        	'<%=tInfo.getThresholdBaseInfo().getThresholdValue() %>');">修改阈值</a>
                        	  |  <a href="javascript:void(0)" onclick="toDelThreshold('<%=tInfo.getThresholdBaseInfo().getThresholdId() %>');">删除阈值</a>
                        </td>
					<%
								nNum++;
							}
							
							if (lstThresholds.size() == 0) {
					%>
						<td nowrap="nowrap"></td>
                        <td nowrap="nowrap"></td>
                        <td nowrap="nowrap"></td>
					<%		
							}
						}
					}
					%>  	
					</tr>												
				</table>
             </div>		   
      	</div>
      	
      	
      	<div id="tgDivId" class="content_border" style="display: none; margin: 20px;"> 
			<div class="table_content">
				<table width="100%" border="0">  
					<tr class="tr_style">
					    <td style="text-align: right; width: 80px;">名称：</td>
					    <td><input class="input_txt5" id="tgNameId" name="tgName" type="text" value="" maxlength="20"/></td>
				  	</tr>
				  	<tr class="tr_style">
					    <td style="text-align: right;">备注：</td>
					    <td><input class="input_txt5" id="remarkId" name="remark" type="text" value="" maxlength="255"/></td>
				  	</tr>
				</table>
			</div>
	  	</div>
	  	
	  	<div id="thresholdDivId" class="content_border" style="display: none; margin: 20px;"> 
      		<input type="hidden" id="getDatasId" value="0">     	     	
			<div class="table_content">
				<table width="100%" border="0">  
					<tr class="tr_style">
					    <td style="text-align: right; width: 70px;">传感器：</td>
					    <td>
					    	<select id="gwIdId" name="gwId" onchange="sensorSelChanged(this);" class="select_item" style="width:100%; margin-left: 0px;">
								<option value="-1">-----请选择-----</option>
							</select>
					    </td>
				  	</tr>
				  	<tr class="tr_style">
					    <td style="text-align: right;">条件：</td>
					    <td>
					    	<input class="input_txt5" id="typeParaId" name="typePara" onkeyup="value=value.replace(/[^\d]/g,'')" 
					    	onBlur="limitInputForInt(this, '时间');"  style="ime-mode:Disabled; width: 60px;" type="text" value="" maxlength="8"/>
					    	<span class="span_txt4">秒内</span>
					    	<select id="typeCodeId" name="typeCode" class="select_item" style="width: 120px;">
								<option value="-1">---请选择---</option>
							</select>
							<select id="compCodeId" name="compCode" class="select_item" style="width: 120px;">
								<option value="-1">---请选择---</option>
							</select>
							<input class="input_txt5" id="compParaId" name="compPara" onkeyup="value=value.replace(/[^\d]/g,'')" 
							onBlur="limitInputForInt(this, '比较值');"  style="ime-mode:Disabled; width: 80px; margin-left: 5px;" type="text" value=""/>
							<span class="span_txt4" id="unitId">lux</span>
					    </td>
				  	</tr>
				</table>
			</div>
	  	</div>
	</body>
</html>