<%@ page language="java" import="java.util.*, com.face.entity.NodeInfo, com.face.model.Session, com.face.dto.UserRole" pageEncoding="UTF-8"%>

<div class="title_box1">
	<%
	if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
	%>
		<a href="gatewayJsp/webQueryPark">园区监控</a>
		<span class="crumb_txt" style="width:25px; margin-left: 5px;">=></span>
		<a href="gatewayJsp/webQueryGatewayOfPark?parkId=<%=request.getAttribute("parkId") %>" style="margin-left: 5px;"><%=request.getAttribute("parkName") %></a>
		<span class="crumb_txt" style="width:25px; margin-left: 5px;">=></span>
		<a href="gatewayJsp/webQueryGreenhouseOfGw?gwId=<%=request.getAttribute("gwId") %>" style="margin-left: 5px;"><%=request.getAttribute("gwName") %></a>
		<span class="crumb_txt" style="width:200px; margin-left: 5px;">=> <%=request.getAttribute("ghName") %></span>
	<%
	} else if (userType.equals(UserRole.ROLE_PARK_ADMIN)) {
	%>	            
		<%-- <a href="gatewayJsp/webQueryGateway?userId=<%=sessionInfo.getUserIdString() %>">网关监控</a>
		<span class="crumb_txt" style="width:25px; margin-left: 5px;">=></span>
		<a href="gatewayJsp/webQueryGreenhouseOfGw?gwId=<%=request.getAttribute("gwId") %>" style="margin-left: 5px;"><%=request.getAttribute("gwName") %></a>
		<span class="crumb_txt" style="width:200px; margin-left: 5px;">=> <%=request.getAttribute("ghName") %></span> --%>
	<a href="gatewayJsp/webQueryGhInfo?userId=<%=sessionInfo.getUserIdString() %>">温室监控</a>
		<span class="crumb_txt" style="width:200px; margin-left: 5px;">=> <%=request.getAttribute("ghName") %></span>	
	<%
	} else if (userType.equals(UserRole.ROLE_PARK_USER)) {
	%>	            
		<a href="gatewayJsp/webQueryGhInfo?userId=<%=sessionInfo.getUserIdString() %>">温室监控</a>
		<span class="crumb_txt" style="width:200px; margin-left: 5px;">=> <%=request.getAttribute("ghName") %></span>	
	<%
	}
	%>				            
</div>
