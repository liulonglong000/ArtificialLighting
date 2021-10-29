<%@ page language="java" import="java.util.*, com.face.model.Session, com.face.dto.UserRole" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>历史信息查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/globalFun.js"></script>
	<script type="text/javascript" src="js/zDialog.js"></script>
	<script type="text/javascript" src="js/laydate.js"></script>
	<script type="text/javascript" src="js/handleGreenHouse.js"></script>
    
    <link href="css/greenhouse.css" type="text/css" rel="stylesheet"/>
    <!-- <link href="css/Highcharts/highcharts.css" type="text/css" rel="stylesheet"/> -->
        
    <style type="text/css">
		${demo.css}
    </style>
    
    <%
	Session sessionInfo = (Session)request.getSession().getAttribute("sessionInfo");
	if (sessionInfo == null) {	
		response.getWriter().write("<script type=\"text/javascript\">window.open(\'../login.jsp\', \'_top\');</script>");
		return;
	}
	String userType = sessionInfo.getRoleName();
	%>
    
    <script type="text/javascript">
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
		            borderRadius: 3,
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
		                fontWeight: 'bold'
		            }	 				
	            },
	            subtitle: { 					// 副标题
	                text: null 
	            },	            
	            tooltip: {
	            	enabled: true,
		            /* backgroundColor: {
		                linearGradient: [0, 0, 0, 60],
		                stops: [
		                    [0, '#FFFFFF'],
		                    [1, '#E0E0E0']
		                ]
		            },
		            borderWidth: 1,
		            borderColor: '#AAA', */
		            formatter: function() {
		            	var sensorName = this.series.name.substring(0, this.series.name.indexOf("("));
		            	var sensorUnit = this.series.name.substring(this.series.name.indexOf("(") + 1, this.series.name.indexOf(")"));
		            	var val = Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + "<br>" + sensorName + ": <strong>" + this.y + "</strong>";
		            	val += sensorUnit;
		                return val;
	                },
		        },
	            xAxis: {    					// x轴
	            	/* categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'], */
                    lineColor: 'black',
	            	lineWidth: 1,
                    /* labels: {
                        y: 20, //x轴刻度往下移动20px
                        style: {
                            color: '#19a0f5',//颜色
                            fontSize:'14px'  //字体
                        }
                    }, */
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
		                    return Highcharts.dateFormat('%m-%d %H:%M', this.value);  
		                },
		                /* step: 3, */
		                /* style: {
		                    color: 'red'
		                } */
		            }
	            },
	            /* legend: {
	            	layout: 'vertical',
	            	align: 'right',
		            verticalAlign: 'top',
		            x: 0,
		            y: 100,
		            itemMarginTop: 20
	            },   */
	        		/* tooltip: {    
	            		shared : true,  
	           		xDateFormat: '%Y-%m-%d'     // 鼠标移动到趋势线上时显示的日期格式    
	       		}, */ 
	            yAxis: [
	            	{    					// Y轴
            			lineColor: '#DC143C',
		            	lineWidth: 1,
		            	tickColor: '#DC143C',
		            	tickWidth: 1,
		            	minorTickInterval: 'auto',
			            minorTickColor: '#DC143C',
			            minorTickWidth: 1,
			            minorTickLength: 5,
		                title: {
		                    text: '空气/土壤温度(°C)'		// y轴标题
		                },
		                gridLineColor: '#A9A9A9',
		           		gridLineWidth: 1
		            },
		            {
            			lineColor: '#32CD32',
		            	lineWidth: 1,
		            	tickColor: '#32CD32',
		            	tickWidth: 1,
		            	minorTickInterval: 'auto',
			            minorTickColor: '#32CD32',
			            minorTickWidth: 1,
			            minorTickLength: 5,
		            	title: {
			                    text: '空气/土壤湿度(%)'		// y轴标题
			                },
		                gridLineColor: '#A9A9A9',
		           		gridLineWidth: 1
		            },		            
		            {
		            	opposite: true,
            			lineColor: '#0000CD',
		            	lineWidth: 1,
		            	tickColor: '#0000CD',
		            	tickWidth: 1,
		            	minorTickInterval: 'auto',
			            minorTickColor: '#0000CD',
			            minorTickWidth: 1,
			            minorTickLength: 5,
			            title: {
			                    text: '光照度(lux)'		// y轴标题
			                },
		                gridLineColor: '#A9A9A9',
		           		gridLineWidth: 1
		            },
		            {
		            	opposite: true,
            			lineColor: '#32CD32',
		            	lineWidth: 1,
		            	tickColor: '#32CD32',
		            	tickWidth: 1,
		            	minorTickInterval: 'auto',
			            minorTickColor: '#32CD32',
			            minorTickWidth: 1,
			            minorTickLength: 5,
		            	title: {
			                    text: 'CO2浓度(ppm)'		// y轴标题
			                },
		                gridLineColor: '#A9A9A9',
		           		gridLineWidth: 1
		            },
		            {
		            	opposite: true,
            			lineColor: '#0000CD',
		            	lineWidth: 1,
		            	tickColor: '#0000CD',
		            	tickWidth: 1,
		            	minorTickInterval: 'auto',
			            minorTickColor: '#0000CD',
			            minorTickWidth: 1,
			            minorTickLength: 5,
			            title: {
			                    text: '土壤电导率(us/cm)'		// y轴标题
			                },
		                gridLineColor: '#A9A9A9',
		           		gridLineWidth: 1
		            }
	            ],
	            plotOptions: {                  // 图表标示的各种选项
	                line: {                     // 这里由于是折线图，那么就是折线图的选项
	                    dataLabels: {           // 数据标签
	                        enabled: false,      // 允许显示数据，默认为false，不显示具体数据
	                    },
	                    enableMouseTracking: true  // 这个让鼠标放到数据点的时候，不动态显示一个小圆圈，默认为true
	                },
	                /* series: {
						showCheckbox: true
					} */
					series: {
		                marker: {
		                    enabled: false,
		                }
		            }
	            },
	        };
	    });
	    
	     
    </script>

  </head>
  
    <body style="background-color: white; padding-bottom: 10px;">
    	<div class="layout_content_box_right box_style" style="margin-top:28px;">    		
		    <div class="title_box_bg">
		        <%@ include file="GlobalGhRetPath.jsp"%>
		        
		        <% int navId = 4; %>
    			<%@ include file="../GlobalNav.jsp"%>   			
    			
		    </div>

			<div class="sys_right_content_box" style="margin-top: 20px; margin-bottom:20px; float: right;">
				<div class="info_txt_box">
				<form action="${pageContext.request.contextPath}/gateway/webGetHistoryInfo" id="queryForm" method="post">
					<a href="javascript:;" onclick="toSearchData('<%=request.getAttribute("gwId") %>', true);" class="search_btn" style="margin-left: 20px;">导出</a>
					<a href="javascript:;" onclick="toSearchData('<%=request.getAttribute("gwId") %>', false);" class="search_btn" style="margin-left: 20px;">查询</a> 
					<input type="hidden"  id="isExport" name="isExport" value="true" />
					<input type="hidden"  id="gwId" name="gwId" value="<%=request.getAttribute("gwId") %>" />
					<input type="hidden"  id="ghId" name="ghId" value="<%=request.getAttribute("ghId") %>" />
					<input class="input_time laydate-icon" name="endTimeFilter" id="end" value="<%=request.getAttribute("endtime") %>"> 
					<span class="txt_style2" style="width: 70px;">结束时间</span> 
					<input class="input_time laydate-icon" name="startTimeFilter" id="start" value="<%=request.getAttribute("starttime") %>"> 
					<span class="txt_style2" style="width: 70px;">开始时间</span> 
					<select id="nodeFilterId" name="nodeFilter" class="select_item" style="width:160px; float:right; margin-right:8px;">
						<option value="-1">-----请选择-----</option>
						<%
						@SuppressWarnings("unchecked")
						Map<String, String> mpNodes = (Map<String, String>)request.getAttribute("nodeList");
						if (mpNodes != null) {
							for (Map.Entry<String, String> entry : mpNodes.entrySet()) {
						%>
						<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
						<%
							}
						}
						%>
					</select> 
					<span class="txt_style2" style="width: 90px;">节点</span>	
					
					
		</form>
									
				</div>
			</div>
	
			<div class="fcontent_border" style="display: none; width: 96%;" id="tableHead">
		    	<div class="table_fcontent">
	               	<table border="0" style="table-layout: fixed;">
						<tr class="tr_style" id="trHead" style="background-color:#b3e4b3; border-bottom:1px solid #05a704;">
						</tr>
					</table>
				</div>
				<div class="table_fcontent" style="height: 420px; overflow-x: auto;">
	               	<table border="0" style="table-layout: fixed;" id="tableData">
					</table>
				</div>
	  		</div>	  		    
	    	
	    	<!-- <script src="js/jquery.js"></script> -->
	    	<script src="js/jquery.min.js"></script>
	    	<script src="js/Highcharts/highcharts.js"></script>
			<script src="js/Highcharts/modules/exporting.js"></script>
	
			<div id="container" style="display:block; float:left; height: 600px; margin: 20px; min-width: 310px; width: 98%;">
		
			</div>
		</div>
		
		<script type="text/javascript">
			var start = {
			    elem: '#start',
			    format: 'YYYY-MM-DD hh:mm',
			    /* min: laydate.now(), *///设定最小日期为当前日期
			    max: laydate.now(), 
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			         end.min = datas; //开始日选好后，重置结束日的最小日期
			         end.start = datas; //将结束日的初始值设定为开始日
			    }
			};	
			var end = {
			    elem: '#end',
			    format: 'YYYY-MM-DD hh:mm',
			    /* min: laydate.now(),*/
			    max: laydate.now(), 
			    istime: true,
			    istoday: false,
			    choose: function(datas){
			        start.max = datas; //结束日选好后，充值开始日的最大日期
			    }
			};
			laydate(start);
			laydate(end);
		</script>	
    </body>
</html>
