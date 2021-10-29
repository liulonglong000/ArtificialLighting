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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<link href="css/greenhouse.css" type="text/css" rel="stylesheet"/>
	
	<!-- <script language="javascript" type="text/javascript" src="js/frame/menu.js"></script> -->
	<base target="main" />
	
	<script language='javascript'>var curopenItem = '1';</script>
	
	<script>
		function menuClicked(next, dest) {
			var cur = document.getElementsByClassName("active");
			if (cur) {
				cur[0].className = "";
			} else {   
				var tagname = document.getElementsByTagName("a");  
				for (var i = 0; i < tagname.length; i++) {    
					if (tagname[i].className == "active") {     
						tagname[i].className = "";
						break;
					}
				}
			}
			
			next.className = "active";
			self.parent.frames['main'].location.href = '${pageContext.request.contextPath}/' + dest;
		}
	</script>
	
	<%
	String userType = "";
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo != null) {	
		userType = sessionInfo.getRoleName();
	}
	%>

  </head>
  
	<body style="overflow-x:hidden">
		<div class="nav_bg">
			<div class="left_nav_box">
		    	<div class="nav_box">
		        	<%
		    		if (userType.equals(UserRole.ROLE_SYS_ADMIN)) {
		    		%>	
				    <dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item1_CompanyManager")' class="park_monitor_box_link">园区监控</a></dt>
				        <dd style='display:block' id='item1_CompanyManager'>
				        	<ul>
				            	<li><a href="javascript:;" onClick='menuClicked(this, "gatewayJsp/webQueryPark")' class="active">所有园区信息</a></li>
				          	</ul>
				        </dd>
				    </dl>    	
				    <dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item1_UserManager")' class="user_manage_box_link">用户管理</a></dt>
				        <dd style='display:block' id='item1_UserManager'>
				        	<ul>
				            	<li><a id="queryUserInfoId" href="javascript:;" onClick='menuClicked(this, "userJsp/webQueryUserInfo?parentUserId=<%=sessionInfo.getUserIdString()%>")'>园区管理员查询</a></li>
				            	<li><a id="addUserInfoId" href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/addUserInfo.jsp")'>添加园区管理员</a></li>
				          	</ul>
				        </dd>
				    </dl>			
		      		<dl class='one_box'>
		        		<dt><a href="javascript:;" onClick='showHide("item1_SelfInfo")' class="self_info_box_link">个人信息</a></dt>
	        			<dd style='display:block' id='item1_SelfInfo'>
	          				<ul>
	            				<li><a href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/modifySelfInfo.jsp")'>修改个人信息</a> </li>
	            				<li><a href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/modifySelfPwd.jsp")'>修改密码</a> </li>
	          				</ul>
	        			</dd>
	      			</dl>
	      			<%
	      			} else if (userType.equals(UserRole.ROLE_PARK_ADMIN)) {
	      			%>
	      			<dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item3_GhMonitor")' class="gw_monitor_box_link">温室监控</a></dt>
				        <dd style='display:block' id='item3_GhMonitor'>
				        	<ul>
				            	<li><a href="javascript:;" onClick='menuClicked(this, "gatewayJsp/webQueryGhInfo?userId=<%=sessionInfo.getUserIdString() %>")' class="active">所有温室信息</a></li>
				          	</ul>
				        </dd>
				    </dl>  
	      			<dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item2_GwMonitor")' class="gw_monitor_box_link">网关监控</a></dt>
				        <dd style='display:block' id='item2_GwMonitor'>
				        	<ul>
				            	<li><a href="javascript:;" onClick='menuClicked(this, "gatewayJsp/webQueryGateway?userId=<%=sessionInfo.getUserIdString() %>")' class="active">所有网关信息</a></li>
				          	</ul>
				        </dd>
				    </dl>  
				    <dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item2_SysSetting")' class="sys_setting_box_link">系统设置</a></dt>
				        <dd style='display:block' id='item2_SysSetting'>
				        	<ul>
				        		<li><a id="parkInfoId" href="javascript:;" onClick='menuClicked(this, "JSP/parkInfo/parkInfo.jsp")'>园区信息</a></li>
				            	<li><a id="queryGwInfoId" href="javascript:;" onClick='menuClicked(this, "gatewayJsp/webQueryGwTable?userId=<%=sessionInfo.getUserIdString() %>")'>网关查询</a></li>
				            	<li><a id="addGwInfoId" href="javascript:;" onClick='menuClicked(this, "JSP/parkInfo/addGatewayInfo.jsp")'>添加网关</a></li>
				            	<li><a id="queryGhInfoId" href="javascript:;" onClick='menuClicked(this, "gatewayJsp/webQueryGreenhouse?userId=<%=sessionInfo.getUserIdString() %>")'>温室查询</a></li>
				            	<li><a id="addGhInfoId" href="javascript:;" onClick='menuClicked(this, "JSP/parkInfo/addGreenhouseInfo.jsp")'>添加温室</a></li>
				          	</ul>
				        </dd>
				    </dl> 
	      			<dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item2_UserManager")' class="user_manage_box_link">用户管理</a></dt>
				        <dd style='display:block' id='item2_UserManager'>
				        	<ul>
				            	<li><a id="queryUserInfoId" href="javascript:;" onClick='menuClicked(this, "userJsp/webQueryUserInfo?parentUserId=<%=sessionInfo.getUserIdString()%>")'>园区工作人员查询</a></li>
				            	<li><a id="addUserInfoId" href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/addUserInfo.jsp")'>添加园区工作人员</a></li>
				          	</ul>
				        </dd>
				    </dl>
	      			<dl class='one_box'>
		        		<dt><a href="javascript:;" onClick='showHide("item2_SelfInfo")' class="self_info_box_link">个人信息</a></dt>
	        			<dd style='display:block' id='item2_SelfInfo'>
	          				<ul>
	            				<li><a href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/modifySelfInfo.jsp")'>修改个人信息</a> </li>
	            				<li><a href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/modifySelfPwd.jsp")'>修改密码</a> </li>
	          				</ul>
	        			</dd>
	      			</dl>
	      			<%
	      			} else if (userType.equals(UserRole.ROLE_PARK_USER)) {
	      			%>
	      			<dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item3_GhMonitor")' class="gw_monitor_box_link">温室监控</a></dt>
				        <dd style='display:block' id='item3_GhMonitor'>
				        	<ul>
				            	<li><a href="javascript:;" onClick='menuClicked(this, "gatewayJsp/webQueryGhInfo?userId=<%=sessionInfo.getUserIdString() %>")' class="active">所有温室信息</a></li>
				          	</ul>
				        </dd>
				    </dl>  
	      			<dl class='one_box'>
				        <dt><a href="javascript:;" onClick='showHide("item3_SysSetting")' class="sys_setting_box_link">系统设置</a></dt>
				        <dd style='display:block' id='item3_SysSetting'>
				        	<ul>
				        		<li><a id="parkInfoId" href="javascript:;" onClick='menuClicked(this, "userJsp/webGetParkInfo?userId=<%=sessionInfo.getUserIdString() %>")'>园区信息</a></li>
		
				          	</ul>
				        </dd>
				    </dl>  				    
	      			<dl class='one_box'>
		        		<dt><a href="javascript:;" onClick='showHide("item3_SelfInfo")' class="self_info_box_link">个人信息</a></dt>
	        			<dd style='display:block' id='item3_SelfInfo'>
	          				<ul>
	            				<li><a href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/modifySelfInfo.jsp")'>修改个人信息</a> </li>
	            				<li><a href="javascript:;" onClick='menuClicked(this, "JSP/userInfo/modifySelfPwd.jsp")'>修改密码</a> </li>
	          				</ul>
	        			</dd>
	      			</dl>	      			
	      			<%
	      			}
	      			%>
		        </div>
			</div>
		</div>
	</body>

</html>
