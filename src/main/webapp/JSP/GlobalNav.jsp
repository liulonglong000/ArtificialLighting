<%@ page language="java" pageEncoding="UTF-8"%>

<div class="nav_main_bg">
	<div class="nav_main_content">
		<div class="nav_list_left_border"></div>
    	<ul class="nav_list clear">
    		<li>
        		<a href="gatewayJsp/webGetGhNodesData?ghId=<%=request.getAttribute("ghId") %>" <% if (navId == 1) { %> class="nav_home" <% } %>>环境监测</a>
        	</li>
        	<li>
        		<a href="gatewayJsp/webGetGhNodesEquipment?ghId=<%=request.getAttribute("ghId") %>" <% if (navId == 2) { %> class="nav_home" <% } %>>手动控制</a>
        	</li>
        	<li>
        		<a href="javascript:;" <% if (navId == 3) { %> class="nav_home" <% } %>>智能控制</a>
        		<ul>
   					<li><a href="autoctrlJsp/webQueryThresholdGroup?ghId=<%=request.getAttribute("ghId") %>">阈值组</a></li>
  					<li><a href="autoctrlJsp/webQueryOperationGroup?ghId=<%=request.getAttribute("ghId") %>">操作组</a></li>
  					<li><a href="autoctrlJsp/webQueryStrategy?ghId=<%=request.getAttribute("ghId") %>">策&nbsp;&nbsp;略</a></li>
   				</ul>
        	</li>
        	<li>
        		<a href="gatewayJsp/webGetDataForHistory?ghId=<%=request.getAttribute("ghId") %>" <% if (navId == 4) { %> class="nav_home" <% } %>>历史数据</a>
        	</li>
    	</ul>
    </div>
</div>
