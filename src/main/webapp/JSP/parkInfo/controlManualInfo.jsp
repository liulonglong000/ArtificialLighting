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
	<script type="text/javascript" src="js/handleOperation.js"></script>
	
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
		<div class="layout_content_box_right box_style" style="margin-top:28px; min-height:200px;">    		
		    <div class="title_box_bg">
		        <%@ include file="GlobalGhRetPath.jsp"%>
		        
		        <input type="hidden" id="greenHouseFilterId" value="<%=request.getAttribute("ghId") %>">
		        
		        <% int navId = 2; %>
    			<%@ include file="../GlobalNav.jsp"%>    			
		    </div>
		    
		    <div class="div_h10"></div>
		    <div class="div_h10"></div>
		    
		    <!-- <div class="div1200" style="min-height: 468px;"> -->		    	
	            <div class="ghNodeData_bg">
            		<%     
           			int nTimeId = 1; 
            		@SuppressWarnings("unchecked")
           			List<NodeInfo> lst = (List<NodeInfo>)request.getAttribute("nodeList"); 
       				for (NodeInfo info : lst) {  
       					Map<Short, List<EquipmentInfo>> lstSensor = info.getMpEquips();     
       					if (lstSensor.size() == 0) {
       						continue;
       					}					
            		%>
				    <div class="div_h10"></div>
            		<div class="one_node_bg">
            			<span><%=info.getNodeName()%></span>
            		</div>
            		<div class="one_node_detail_bg">
	            		<span style="margin-left: 18px; height: 40px; margin-top: -12px;">
	            			<a href="javascript:;" id="refresh<%=info.getNodeId() %>" onclick="toRefreshNodeEquips('<%=info.getGatewayId() %>', '<%=info.getNodeId() %>')" class="btn_bottom">更新设备状态</a>            		
	            		</span>
           				<% 	
           				for (List<EquipmentInfo> lstVal : lstSensor.values()) {
							for (EquipmentInfo sensor : lstVal) {
	       						/* if (!sensor.IsShow()) {
	       							continue;
	       						} */
	       						
	       						String timeUnit = sensor.getTimeUnit(); 
	       							
	       						String boderClass = "equip_open_bg";
	       						String imgClass = sensor.getEquip().getEquipmentType().toLowerCase();
	       						String imgClassflag=imgClass;
	       						boolean bOpen = true;
	       						if (sensor.IsClose()) {		
	       							boderClass = "equip_close_bg";    						    
	       						    bOpen = false;
	       						    imgClass += "_close_bg";
	       						} else {
	       							imgClass += "_open_bg";	
	       						} 		       						
	       								       									        
           				%>
				      	<div class="<%=boderClass %> equip_bg_common">
            				<div class="<%=imgClass %> equip_img_common"></div>
            				<div class="equip_right_bg">
            					<div class="equip_right_top_bg">
            						<span><%=sensor.getEquipmentFullName()%></span>
            					</div>
            					<div class="equip_right_middle_bg">
            						<span>最后连接时间：<%=sensor.getLastConnectTime()%></span>
            					</div>
            					<div class="equip_right_middle_bg">
            						<%
            						System.out.println(imgClassflag);
            						if (imgClassflag.equals("rbm") || imgClassflag.equals("frm")) {
            						if (!bOpen) {
            						%>	
            						<span>状态：关闭</span>
            						<span>执行操作：</span>
            						<input type="radio" name="sex" value="卷起">卷起
            						<input type="radio" name="sex" value="男生">铺开
            						<input type="radio" name="sex" value="卷起">卷起&nbsp;&nbsp;&nbsp;运行<input type="text" name="" value="">秒
            						<input type="radio" name="sex" value="铺开">铺开&nbsp;&nbsp;&nbsp;运行<input type="text" name="" value="">秒
            						<%
            						} else {
            						%>
            						<span style="width: 40px;">&nbsp;</span>
            						<%
            						}
            						
            						} else {
            						
            						if (!bOpen) {
            						%>
            						<span style="width: 40px;">开启</span>
            						<input class="input_txt5" id="timeId<%=nTimeId %>" type="text" onkeyup="value=value.replace(/[^\d]/g,'')" 
					    					onBlur="limitInputForInt(this, '时间');"  style="ime-mode:Disabled; width: 130px;"/>            						
            						<%
            						if (sensor.IsMultiPara()) {
            						%>
            						<select id="unitId<%=nTimeId %>" class="select_item" style="width:60px;">
										<option value="0"><%=timeUnit %></option>
										<option value="1">立方</option>
									</select>
            						<%
            						} else {
            						%>
            						<span style="width: 20px;"><%=timeUnit %></span>
            						<%
            						}
            						nTimeId++;
            						} else {
            						%>
            						<span style="width: 40px;">&nbsp;</span>
            						<%
            						}
            						}
            						%>
            					</div>
            					<div class="equip_right_bottom_bg">
            						<a href="javascript:;" onclick="toOpenLed('<%=sensor.getEquipmentFullName()%>', 
            						'<%=sensor.getEquip().getGatewayId()%>', '<%=sensor.getEquip().getNodeId()%>', 
            						'<%=sensor.getEquip().getEquipmentType()%>', '<%=sensor.getEquip().getEquipmentId()%>', '<%=nTimeId-1%>');" class="btn_box" style="<%if (bOpen) {%> display:none; <%} %> float: right; width:90px; font-size:14px;">打&nbsp;&nbsp;&nbsp;开</a>
	                                <a href="javascript:;" onclick="toCloseLed('<%=sensor.getEquipmentFullName()%>', 
	                                '<%=sensor.getEquip().getGatewayId()%>', '<%=sensor.getEquip().getNodeId()%>', 
	                                '<%=sensor.getEquip().getEquipmentType()%>', '<%=sensor.getEquip().getEquipmentId()%>');" class="btn_box" style="<%if (!bOpen) {%> display:none; <%} %> float: right; width:90px; font-size:14px;">关&nbsp;&nbsp;&nbsp;闭</a>	                                
            					</div>
            				</div>
            			</div> 
				        <%
				        	}
				        } 		   	
				        %>
				    </div>
				        
            		<div class="div_h10"></div>
            		<%
            		}
            		%>
	            </div>
	      	</div>
		
		<!-- </div> -->
	</body>
</html>