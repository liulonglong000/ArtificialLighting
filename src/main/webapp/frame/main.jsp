<%@ page language="java" import="java.util.*, com.face.dto.UserRole, com.face.model.Session" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基于智能手机的温室环境监测与补光控制系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<%
	String userType = "";	
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	userType = sessionInfo.getRoleName();
	int leftSize = 237;
	%>	

  </head>
  
	<frameset rows="83,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="frame/top.jsp" name="topFrame" scrolling="no">
		<frameset cols="<%=leftSize%>,*">
			<frame src="frame/left.jsp" noresize name="menu" scrolling="auto">
			<%
	   		if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
	   		%>
	   		<frame src="gatewayJsp/webQueryPark" noresize name="main" id="ifrmid" scrolling="yes">
   			<%
   			} else if (userType.equals(UserRole.ROLE_PARK_ADMIN)) {
   			%>
   			<frame src="gatewayJsp/webQueryGateway?userId=<%=sessionInfo.getUserIdString() %>" noresize name="main" scrolling="yes">
   			<%
   			} else if (userType.equals(UserRole.ROLE_PARK_USER)) {
   			%>
   			<frame src="gatewayJsp/webQueryGhInfo?userId=<%=sessionInfo.getUserIdString() %>" noresize name="main" scrolling="yes">   			
   			<%
   			} else {
   			%>  
   			<frame src="frame/right.jsp" noresize name="main" scrolling="yes">
   			<%
   			}
   			%>  
		</frameset>
	</frameset>
	<noframes>
		<body>您的浏览器不支持框架！</body>
	</noframes>

</html>
