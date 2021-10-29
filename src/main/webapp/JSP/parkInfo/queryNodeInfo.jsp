<%@ page language="java" import="java.util.*, com.face.entity.NodeInfo, com.face.entity.SensorInfo, com.face.model.Session, com.face.dto.UserRole" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/handleCookie.js"></script>
	
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
	
	<script type="text/javascript">
		var gwFilter_g = 0;
		var nodeFilter_g = 0;
		var sensorFilter_g = 0;
		var sensorTypeCode_g = 0;
		var chartTitle_g = 0;
		
		function remainTimer() {
			var elem = document.getElementById("remainTimeId");
			var nowData = elem.innerHTML;
			if (nowData > 1) {
				nowData = nowData -1;
				elem.innerHTML = nowData;
			} else {
				if (sensorFilter_g != 0) {
					setCookie('greenHouseId', $("#greenHouseFilterId").val(), 's60');
					setCookie('gwFilter', gwFilter_g, 's60');
					setCookie('nodeFilter', nodeFilter_g, 's60');
					setCookie('sensorFilter', sensorFilter_g, 's60');
					setCookie('sensorTypeCode', sensorTypeCode_g, 's60');					
					setCookie('chartTitle', chartTitle_g, 's60');
				}
				/* location.reload();*/		
				self.parent.frames['main'].location = $("#basePathId").val() + "gatewayJsp/webGetGhNodesData?ghId=" + $("#greenHouseFilterId").val() + ""; 	
				/* self.parent.frames['main'].location.reload(true); */
				/* ifrmid.window.location.reload(); */		
				/* alert(self.parent.frames['main'].src="gatewayJsp/webQueryPark"); */
			}		
		}
		
		setInterval("remainTimer()", 1000);
		
		function toShowSensorDetail(gwId, nodeId, sensorId, sensorTypeCode, title) {
			var postData = {
				"gwId" : gwId,
				"nodeId" : nodeId,
				"sensorId" : sensorId,
				"sensorTypeCode" : sensorTypeCode
			};
			
			doAjaxWithToken(postData, "gateway/webGetRecentInfo", function (data) {
				gwFilter_g = gwId;
				nodeFilter_g = nodeId;
				sensorFilter_g = sensorId;
				sensorTypeCode_g = sensorTypeCode;
				chartTitle_g = title;
						
		    	// 图表使用中国时区的时间
		    	Highcharts.setOptions({ global: { useUTC: false } });
		    	Highcharts.setOptions({ colors: ['#24CBE5'] });
		    	
		    	var name = data[0].yTitle;
				chartHistory.title.text = title;						
				chartHistory.yAxis.title.text = data[0].yTitle;
        
				var chart = new Highcharts.Chart(chartHistory);
				
				if (data[1].data.length > 2) {
					var series = {
						name: name,   
	                    data: data[1].data,
	                };	
					chart.addSeries(series);
				}
		    });
		}
	
		var chartHistory;
		$(function () {
			Highcharts.setOptions({
				// 所有语言文字相关配置都设置在 lang 里
				lang: {
					resetZoom: '重  置',
					resetZoomTitle: '重置缩放比例'
				}
			});
			chartHistory = {
	            chart: {    					// 图表总体的设置
	            	renderTo: 'container',
	            	backgroundColor: '#FCFFC5',
	            	borderColor: '#ffc891',
		            borderRadius: 6,
		            borderWidth: 2,
	                type: 'line',    			// 这个默认为line即折线图,还可以为柱状column，不过饼状图不是这里设置，而是直接在series数据列上指定 type: 'pie',
	                zoomType: 'x',
					selectionMarkerFill: 'rgba(0,0,0, 0.2)',
					resetZoomButton: {
						// 按钮定位
						position:{
							align: 'right', // by default
							verticalAlign: 'top', // by default
							x: 0,
							y: -50
						},
						// 按钮样式
						theme: {
							fill: 'white',
							stroke: 'silver',
							r: 0,
							states: {
								hover: {
									fill: '#41739D',
									style: {
										color: 'white'
									}
								}
							}
						}
					},
					panning: true,
					panKey: 'shift'
	            },
	            credits: {
		            enabled: false
		        },
	            title: {    					// 图表标题
	                text: null, 	
	                style: {
		                color: '#515151',
		                fontWeight: 'bold',
		                letterSpacing: "2px"
		            }			
	            },
	            subtitle: { 					// 副标题
	                text: '24小时数据信息'
	            },	            
	            tooltip: {
	            	enabled: true,
		            formatter: function() {		                
		                var sensorName = this.series.name.substring(0, this.series.name.indexOf("("));
		            	var sensorUnit = this.series.name.substring(this.series.name.indexOf("(") + 1, this.series.name.indexOf(")"));
		            	var val = Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + "<br>" + sensorName + ": <strong>" + this.y + "</strong>";
		            	val += sensorUnit;
		                return val;
	                },
		        },
	            xAxis: {    					// x轴
	            	lineColor: 'black',
	            	lineWidth: 1,
                    gridLineColor: '#A9A9A9',
	                gridLineWidth: 1,			// 纵向网格线宽度
	                minorGridLineDashStyle: 'longdash',
		            minorTickInterval: 'auto',
		            minorTickWidth: 1,
			        minorTickLength: 5,
		            tickColor: 'black',
		            tickWidth: 1,
	                startOnTick: false,
	                endOnTick: false,
	                type: 'datetime',  
		            labels: {  
		                formatter: function() {  
			                if (this.value == 0) {
			                	return '';
			                }	
		                    return Highcharts.dateFormat('%H:%M', this.value);  
		                }
		            }
	            },
	            legend: {
	            	enabled: false
	            },  	        		
	            yAxis:{    					// Y轴
           			lineColor: '#DC143C',
	            	lineWidth: 1,
	            	tickColor: '#DC143C',
	            	tickWidth: 1,
	            	minorTickInterval: 'auto',
		            minorTickColor: '#DC143C',
		            minorTickWidth: 1,
		            minorTickLength: 5,
	                title: {
	                    text: ''		// y轴标题
	                },
	                gridLineColor: '#A9A9A9',
	           		gridLineWidth: 1
	            },		           
	            plotOptions: {                  // 图表标示的各种选项
	                line: {                     // 这里由于是折线图，那么就是折线图的选项
	                    dataLabels: {           // 数据标签
	                        enabled: false,      // 允许显示数据，默认为false，不显示具体数据
	                    },
	                    enableMouseTracking: true  // 这个让鼠标放到数据点的时候，不动态显示一个小圆圈，默认为true
	                },
					series: {
		                marker: {
		                    enabled: false,
		                }
		            }
	            },
	            exporting: {
		            enabled: false
		        }
	        };
	        
	        var ghId = getCookie('greenHouseId');
	        if (ghId != null) {
	        	if (ghId == $("#greenHouseFilterId").val()) {
					toShowSensorDetail(getCookie('gwFilter'), getCookie('nodeFilter'), getCookie('sensorFilter'), 
					getCookie('sensorTypeCode'), getCookie('chartTitle'));
				}
			}	
	    });
	</script>
  </head>
  
  	<body style="background-color: white; padding-bottom: 10px;">    	
		<div class="layout_content_box_right box_style" style="margin-top:28px;">    		
		    <div class="title_box_bg">
		        <%@ include file="GlobalGhRetPath.jsp"%>
		        <input type="hidden" id="basePathId" value="<%=basePath%>">
		        <input type="hidden" id="greenHouseFilterId" value="<%=request.getAttribute("ghId") %>">
		        
		        <% int navId = 1; %>
    			<%@ include file="../GlobalNav.jsp"%>
    			
    			<span class="more" style="width:195px;">距离下次更新还剩：<strong id="remainTimeId">600</strong>秒</span>
		    </div>
		    
		    <div class="div_h10"></div>
		    <div class="div_h10"></div>
		    
		    <!-- <div class="div1200" style="min-height: 468px;"> -->		    	
	            <div class="ghNodeData_bg">
            		<%
            		@SuppressWarnings("unchecked")
           			List<NodeInfo> lst = (List<NodeInfo>)request.getAttribute("nodeList"); 
       				for (NodeInfo info : lst) {       					
            		%>
				    <div class="div_h10"></div>
				    
				    <div style="display: block; float: left; width: 100%;">
            		<div class="one_node_bg">
            			<span><%=info.getNodeName()%></span>
            		</div>
            		<div class="one_node_detail_bg">
            			<span style="margin-left: 18px;">最新数据时间：<strong><%=info.getGatherTimeString() %></strong></span>
           				<%
       					Map<Short, List<SensorInfo>> lstSensor = info.getMpSensor();
       					for (List<SensorInfo> lsensor : lstSensor.values()) {
       					for (SensorInfo sensor : lsensor) {
       						String className = sensor.getClassName();
       						float fVal = sensor.getSensorValue();
       						String title = info.getNodeName() + "-" + sensor.getSensorName() + "（" + sensor.getUnit() + "）";
           				%>
				      	<div class="<%=className%> sensor_bg_common" 
				      		onclick="toShowSensorDetail('<%=request.getAttribute("gwId")%>', '<%=info.getNodeId()%>', 
				      		'<%=sensor.getSensorId()%>', '<%=sensor.getSensorTypeCode()%>', '<%=title%>');">
            				<div class="<%=sensor.getPicClass()%> sensor_img_common"></div>
            				<div class="sensor_right_bg">
            					<div class="sensor_right_top_bg">
            						<div class="<%=className%>_font sensor_right_top_left_bg">
	            						<%
	            						if (fVal >= 10000) {
	            						%>
            							<span><%=(int)fVal%></span>
            							<%
            							} else {
            							%>
            							<span><%=fVal%></span>
            							<%
            							}
            							%>
            						</div>
            						<div class="sensor_right_top_right_bg">
            							<span><%=sensor.getUnit()%></span>
            						</div>
            					</div>
            					<div class="sensor_right_bottom_bg">
            						<span><%=sensor.getSensorName()%></span>
            					</div>
            				</div>
            			</div> 
				        <%
				        }
				        } 		   	
				        %>
				    </div>
				    </div>
				        
            		<div class="div_h10"></div>
            		<%
            		}
            		%>
	            </div>	           
 	
				<div id="container" class="chart_recent_bg"></div>
	      	</div>
		
		<!-- </div> -->
	</body>
</html>