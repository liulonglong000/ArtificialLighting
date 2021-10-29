function getDateString(time) {
    var date = new Date(time);
    var now = "";
    now = date.getFullYear() + "-"; 
    now = now + ((date.getMonth()+1) < 10? ('0' + (date.getMonth() + 1)) : (date.getMonth() + 1)) + "-"; 
    now = now + (date.getDate()< 10 ? ('0' + date.getDate()) : date.getDate() );
    now = now + '&nbsp;' + (date.getHours() < 10 ? ('0' + date.getHours()) : date.getHours()) + ":";
    now = now + (date.getMinutes() < 10 ? ('0' + date.getMinutes()) : date.getMinutes()) + ":";
    now = now + (date.getSeconds() < 10 ? ('0' + date.getSeconds()) : date.getSeconds());
    return now;
}

function toSearchData(gwId, isExport) {
	var nodeFilter = $("#nodeFilterId").val();
	var startTimeFilter = $("#start").val();
	var endTimeFilter = $("#end").val();	
	
    if (nodeFilter == null || nodeFilter == -1) {
    	Dialog.alert("请选择节点!", function(){$("#nodeFilterId").focus();});
        return false;   
    }
    if (startTimeFilter == null || StringTrim(startTimeFilter) == "") {
    	Dialog.alert("请选择开始时间!", function(){$("#start").focus();});
        return false;   
    }
    if (endTimeFilter == null || StringTrim(endTimeFilter) == "") {
    	Dialog.alert("请选择结束时间!", function(){$("#end").focus();});
        return false;   
    }
	
    var postData = {
		"gwId" : gwId,
		"nodeFilter" : nodeFilter,
		"startTimeFilter" : startTimeFilter,
		"endTimeFilter" : endTimeFilter,
		"isExport" : isExport
	};
    
    if (isExport) {
			
			
			$('#queryForm').submit();
			return ;
	}
    
    doAjaxWithToken(postData, "gateway/webGetHistoryInfo", function (data) { 
		if (data.length <= 1) {
			document.getElementById("tableHead").style.display = "none";
		} else {
			document.getElementById("tableHead").style.display = "";
		}				

		// 图表使用中国时区的时间
    	Highcharts.setOptions({ global: { useUTC: false } });
    	
		chartHistory.title.text = $("#nodeFilterId option:selected").text() + "历史数据信息";
		chartHistory.subtitle.text = startTimeFilter + " - " + endTimeFilter;
		
		chartHistory.xAxis.labels.formatter = function() {  
            if (this.value == 0) {
            	return '';
            }		
            var startPrefix = startTimeFilter.substring(0, 10); 
            var endPrefix = endTimeFilter.substring(0, 10);  
            if (startPrefix == endPrefix) {
            	return Highcharts.dateFormat('%H:%M:%S', this.value); 
            } else {                       
            	return Highcharts.dateFormat('%m-%d %H:%M', this.value);  
            }
        };
		
		var yAxis0 = false;
		var yAxis1 = false;
		var yAxis2 = false;
		var yAxis3 = false;
		var yAxis4 = false;
		for (var i = 1; i < data.length; i++) {
			if (data[i].yAxis == 0) {
                yAxis0 = true;
			} else if (data[i].yAxis == 1) {
                yAxis1 = true;
			} else if (data[i].yAxis == 2) {
                yAxis2 = true;
			} else if (data[i].yAxis == 3) {
                yAxis3 = true;
			} else if (data[i].yAxis == 4) {
                yAxis4 = true;
			}
		}
		if (!yAxis0) {
			chartHistory.yAxis[0].visible = false;
		} else {
			chartHistory.yAxis[0].visible = true;
		}		
		if (!yAxis1) {
			chartHistory.yAxis[1].visible = false;
		} else {
			chartHistory.yAxis[1].visible = true;
		}
		if (!yAxis2) {
			chartHistory.yAxis[2].visible = false;
		} else {
			chartHistory.yAxis[2].visible = true;
		}
		if (!yAxis3) {
			chartHistory.yAxis[3].visible = false;
		} else {
			chartHistory.yAxis[3].visible = true;
		}
		if (!yAxis4) {
			chartHistory.yAxis[4].visible = false;
		} else {
			chartHistory.yAxis[4].visible = true;
		}

		var chart = new Highcharts.Chart(chartHistory);
		
		for (var i = 1; i < data.length; i++) {
			var series = {  
                yAxis: data[i].yAxis,  
                name: data[i].type,     
                data: data[i].data,
            };	
			chart.addSeries(series);
		}
		
		// 更新表格
		$("#trHead").empty();
		$("#tableData").empty();
		if (data.length <= 1) {
			return;
		}
		if (data.length <= 10) {
			$("#trHead").show();
			$("#trHead").append("<td width='100px'>序号</td><td width='200px'>时间</td>");
			for (var i = 1; i < data.length; i++) {
				$("#trHead").append("<td width='110px'> " + data[i].type + "</td>");
			}
		} else {
			$("#trHead").hide();
			var apdInfo = "<tr class='tr_style' style='background-color:#b3e4b3; border-bottom:1px solid #05a704;'><td width='100px'>序号</td><td width='200px'>时间</td>";
			for (var i = 1; i < data.length; i++) {
				apdInfo += "<td width='110px'> " + data[i].type + "</td>";
			}
			apdInfo += "</tr>";
			$("#tableData").append(apdInfo);
		}
		
		var timeArray = new Array();
		for (var i = 1; i < data.length; i++) {
			for (var j = 0; j < data[i].data.length; j++) {
				timeArray.push(data[i].data[j][0]);
			}
		}
		timeArray.sort();
		
		var timeAllArray = new Array();
		var curID = 0;
		timeAllArray.push(timeArray[curID]);
		for (var i = 1; i < timeArray.length; i++) {
			if (timeArray[i] == timeArray[curID]) {
				continue;
			}
			curID = i;
			timeAllArray.push(timeArray[curID]);
		}
		
		var row = 1;
		for (var i = 0; i < timeAllArray.length; i++) {
			var content = "<tr class=\"tr_style\"><td width='100px'> " + row 
				+ "</td><td width='200px'> " + getDateString(timeAllArray[i]) + "</td>";
			for (var cnt = 1; cnt < data.length; cnt++) {
				var tdId = "tdr" + (row - 1) + "c" + (cnt + 1);
				content = content + "<td width='110px' id=" + tdId + "></td>";
			}
			content = content + "</tr>";
			$("#tableData").append(content);
			row++;
		}
		if (data.length <= 10) {
			if (row > 10) {
				$("#trHead").append("<td width='17px'></td>");
			}
		}
		for (var i = 1; i < data.length; i++) {
			for (row = 0; row < timeAllArray.length; row++) {
				if (data[i].data[0][0] == timeAllArray[row]) {
					break;
				}
			}
			for (var j = 0; j < data[i].data.length; j++) {						
				for (; row < timeAllArray.length; row++) {
					if (data[i].data[j][0] == timeAllArray[row]) {
						
						// 去掉一个时间点多个值的情况
						for (; j + 1 < data[i].data.length;) {
							if (data[i].data[j + 1][0] == timeAllArray[row]) {
								j++;
							} else {
								break;
							}
						}
						
						break;
					}
				}
					
				if (data[i].data[j][0] == timeAllArray[row]) {
					var tdId = "tdr" + row + "c" + (i + 1);
					var val = data[i].data[j][1] + "";
					if (val.indexOf(".") < 0) {
						val = val + ".00";
					} else {
						if (val.charAt(val.length - 2) == ".") {
							val = val + "0";
						}
					}
					document.getElementById(tdId).innerHTML = val;
				}
				row++;
			}
		}
//				var minTime = data[1].data[0][0];
//				var maxTime = data[1].data[data[1].data.length - 1][0];
//				for (var i = 2; i < data.length; i++) {
//					if (data[i].data[0][0] < minTime) {
//						minTime = data[i].data[0][0];
//					} else if (data[i].data[data[i].data.length - 1][0] > maxTime) {
//						maxTime = data[i].data[data[i].data.length - 1][0];
//					}
//				}
//				var row = 1;
//				for (var i = minTime; i <= maxTime; i += 30 * 60 * 1000) {
//					var content = "<tr class=\"tr_style\"><td width='100px'> " + row 
//						+ "</td><td width='200px'> " + getDateString(i) + "</td>";
//					for (var cnt = 1; cnt < data.length; cnt++) {
//						var tdId = "tdr" + (row - 1) + "c" + (cnt + 1);
//						content = content + "<td width='110px' id=" + tdId + "></td>";
//					}
//					content = content + "</tr>";
//					$("#tableData").append(content);
//					row++;
//				}
//				if (data.length <= 10) {
//					if (row > 10) {
//						$("#trHead").append("<td width='17px'></td>");
//					}
//				}
//				for (var i = 1; i < data.length; i++) {
//					var time = minTime;
//					row = 0;
//					for (var j = 0; j < data[i].data.length; j++) {
//						if (data[i].data[j][0] == time) {
//							var tdId = "tdr" + row + "c" + (i + 1);
//							var val = data[i].data[j][1] + "";
//							if (val.indexOf(".") < 0) {
//								val = val + ".00";
//							} else {
//								if (val.charAt(val.length - 2) == ".") {
//									val = val + "0";
//								}
//							}
//							document.getElementById(tdId).innerHTML = val;
//						}								
//						time+= 30 * 60 * 1000;
//						row++;
//					}
//				}
	});	
}
