function toMdyTg(id, name, remark) {	
    $("#tgNameId").val(name);
	$("#remarkId").val(remark);
				
	var diag = new Dialog();
	diag.Width = 600;
	diag.Height = 120;
	diag.Title = "修改阈值组信息";
	diag.InvokeElementId = "tgDivId";
	diag.OKEvent = function() {
		var postData = {
				"userId" : $("#userIdId").val(),
				"tgName" : $("#tgNameId").val(),
				"remark" : $("#remarkId").val(),
				"tgId" : id
			};
		    
	    doAjaxWithToken(postData, "autoctrl/mdyThresholdGroupInfo", function (data) {
	    	Dialog.alert("修改阈值组信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryThresholdGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function getCurrentTimeMillis() {
	var myDate = new Date();
	return "" + myDate.getFullYear() + myDate.getMonth() + myDate.getDate() + myDate.getHours() + myDate.getMinutes() + myDate.getSeconds() + myDate.getMilliseconds();
}

function toAddTg() {
	$("#tgNameId").val("");
	$("#remarkId").val("");
				
	var diag = new Dialog();
	diag.Width = 600;
	diag.Height = 120;
	diag.Title = "添加阈值组信息";
	diag.InvokeElementId = "tgDivId";
	diag.OKEvent = function() {
		var postData = {
				"userId" : $("#userIdId").val(),
				"tgName" : $("#tgNameId").val(),
				"remark" : $("#remarkId").val(),
				"tgId" : getCurrentTimeMillis(),
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/addThresholdGroupInfo", function (data) {
	    	Dialog.alert("添加阈值组信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryThresholdGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toDelTg(tgId) {
	Dialog.confirm("确定要删除该阈值组吗？", function() {
		var postData = {
				"tgId" : tgId
			};
		    
	    doAjaxWithToken(postData, "autoctrl/delThresholdGroupInfo", function (data) {
	    	Dialog.alert("删除阈值组信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryThresholdGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	
	});
}

function addUIThresholdParas(data) {
	for (var k = 0; k < data[1].length; k++) {
		$("#gwIdId").append("<option value=\"" + data[1][k].nodeId + "," + data[1][k].sensorType + "," + data[1][k].sensorId + 
				"," + data[1][k].sensorUnit + "," + data[1][k].gwId + "\">"+ "网关" + data[1][k].gwId + "  " + data[1][k].nodeName + "  " + data[1][k].sensorTypeName + data[1][k].sensorId + "</option>");
	}
	for (var k = 0; k < data[2].length; k++) {
		$("#typeCodeId").append("<option value=\"" + data[2][k].typeId + "\">"+ data[2][k].typeName + "</option>");
	}
	for (var k = 0; k < data[3].length; k++) {
		$("#compCodeId").append("<option value=\"" + data[3][k].compId + "\">"+ data[3][k].compName + "</option>");
	}
}

function toAddThreshold(tgId) {
	var hasGetDatas = $("#getDatasId").val();
	if (hasGetDatas == "0") {
		var postData = {
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/getDatasForThresholdAdd", function(data) {
	    	addUIThresholdParas(data);
	    	$("#getDatasId").val("1");
	    	showAddThreshold(tgId);
	    });	 
	} else {
		showAddThreshold(tgId);
	}
}

function checkThresholdInput() {
    if (!checkSelectValid("gwIdId", "传感器")) {
        return false;
    }    
    if (!checkTextValid("typeParaId", "阈值条件类型参数")) {
    	return false;
    }
    if (!checkSelectValid("typeCodeId", "阈值条件类型")) {
        return false;
    }
    if (!checkSelectValid("compCodeId", "比较方法")) {
        return false;
    }
    if (!checkTextValid("compParaId", "比较方法参数")) {
    	return false;
    }
    return true;
}

function showAddThreshold(tgId) {
	document.getElementById("gwIdId").options[0].selected = true;
	$("#typeParaId").val("");	
	document.getElementById("typeCodeId").options[0].selected = true;
	document.getElementById("compCodeId").options[0].selected = true;
	$("#compParaId").val("");
	document.getElementById("unitId").innerHTML = "";
				
	var diag = new Dialog();
	diag.Width = 606;
	diag.Height = 120;
	diag.Title = "添加阈值信息";
	diag.InvokeElementId = "thresholdDivId";
	diag.OKEvent = function() {
		if (!checkThresholdInput()) {
			return;
		}
		
		var selectCtrl = document.getElementById("gwIdId");
		var obj = selectCtrl.options[selectCtrl.selectedIndex];
		var paramArray = obj.value.split(",");
		var postData = {
				"thresholdId" : getCurrentTimeMillis(),
				"tgId" : tgId,
				"gwId" : $("#gatewayFilterId").val(),
				"nodeId" : paramArray[0],
				"sensorTypeCode" : paramArray[1],
				"sensorId" : paramArray[2],
				"typeCode" : $('#typeCodeId option:selected').val(),
				"typePara" : $("#typeParaId").val(),
				"compCode" : $('#compCodeId option:selected').val(),
				"compPara" : $("#compParaId").val(),
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/addThresholdInfo", function (data) {
	    	Dialog.alert("添加阈值信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryThresholdGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function sensorSelChanged(obj) {
//	alert("Option中的中文：" + obj.options[obj.selectedIndex].innerHTML);
	paramArray = obj.value.split(",");	
	document.getElementById("unitId").innerHTML = paramArray[3];
}

function toMdyThreshold(thresholdId, gwId, nodeId, sensorTypeCode, sensorId, typePara, typeCode, compCode, compPara) {
	var hasGetDatas = $("#getDatasId").val();
	if (hasGetDatas == "0") {
		var postData = {
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/getDatasForThresholdAdd", function(data) {
	    	addUIThresholdParas(data);
	    	$("#getDatasId").val("1");
	    	showMdyThreshold(thresholdId, gwId, nodeId, sensorTypeCode, sensorId, typePara, typeCode, compCode, compPara);
	    });	 
	} else {
		showMdyThreshold(thresholdId, gwId, nodeId, sensorTypeCode, sensorId, typePara, typeCode, compCode, compPara);
	}
}

function showMdyThreshold(thresholdId, gwId, nodeId, sensorTypeCode, sensorId, typePara, typeCode, compCode, compPara) {
	var sensorCtrl = document.getElementById("gwIdId");
	for (var i = 0; i < sensorCtrl.options.length; i++) {
		var valS = sensorCtrl.options[i].value.split(",");
		if (valS[0] != nodeId) {
			continue;
		}
		if (valS[1] != sensorTypeCode) {
			continue;
		}
		if (valS[2] != sensorId) {
			continue;
		}
		if (valS[4] != gwId) {
			continue;
		}
		sensorCtrl.options[i].selected = true;		
		document.getElementById("unitId").innerHTML = valS[3];
		break;
	}
	
	$("#typeParaId").val(typePara);	
	var typeCodeCtrl = document.getElementById("typeCodeId");
	for (var j = 0; j < typeCodeCtrl.options.length; j++) {
		if (typeCodeCtrl.options[j].value == typeCode) {
			typeCodeCtrl.options[j].selected = true;
			break;
		}
	}
	
	var compCodeCtrl = document.getElementById("compCodeId");
	for (var k = 0; k < compCodeCtrl.options.length; k++) {
		if (compCodeCtrl.options[k].value == compCode) {
			compCodeCtrl.options[k].selected = true;
			break;
		}
	}
	$("#compParaId").val(compPara);
				
	var diag = new Dialog();
	diag.Width = 606;
	diag.Height = 120;
	diag.Title = "修改阈值信息";
	diag.InvokeElementId = "thresholdDivId";
	diag.OKEvent = function() {
		if (!checkThresholdInput()) {
			return;
		}
		
		var selectCtrl = document.getElementById("gwIdId");
		var obj = selectCtrl.options[selectCtrl.selectedIndex];
		var paramArray = obj.value.split(",");
		var postData = {
				"thresholdId" : thresholdId,
				"gwId" : $("#gatewayFilterId").val(),
				"nodeId" : paramArray[0],
				"sensorTypeCode" : paramArray[1],
				"sensorId" : paramArray[2],
				"typeCode" : $('#typeCodeId option:selected').val(),
				"typePara" : $("#typeParaId").val(),
				"compCode" : $('#compCodeId option:selected').val(),
				"compPara" : $("#compParaId").val(),
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/mdyThresholdInfo", function (data) {
	    	Dialog.alert("修改阈值信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryThresholdGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toDelThreshold(thresholdId) {
	Dialog.confirm("确定要删除该阈值吗？", function() {
		var postData = {
				"thresholdId" : thresholdId,
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/delThresholdInfo", function (data) {
	    	Dialog.alert("删除阈值信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryThresholdGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	
	});
}

function toAddOg() {
	$("#tgNameId").val("");
	$("#remarkId").val("");
				
	var diag = new Dialog();
	diag.Width = 600;
	diag.Height = 120;
	diag.Title = "添加操作组信息";
	diag.InvokeElementId = "tgDivId";
	diag.OKEvent = function() {
		var postData = {
				"userId" : $("#userIdId").val(),
				"ogName" : $("#tgNameId").val(),
				"remark" : $("#remarkId").val(),
				"ogId" : getCurrentTimeMillis(),
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/addOperationGroupInfo", function (data) {
	    	Dialog.alert("添加操作组信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryOperationGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toMdyOg(id, name, remark) {	
    $("#tgNameId").val(name);
	$("#remarkId").val(remark);
				
	var diag = new Dialog();
	diag.Width = 600;
	diag.Height = 120;
	diag.Title = "修改操作组信息";
	diag.InvokeElementId = "tgDivId";
	diag.OKEvent = function() {
		var postData = {
				"userId" : $("#userIdId").val(),
				"ogName" : $("#tgNameId").val(),
				"remark" : $("#remarkId").val(),
				"ogId" : id
			};
		    
	    doAjaxWithToken(postData, "autoctrl/mdyOperationGroupInfo", function (data) {
	    	Dialog.alert("修改操作组信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryOperationGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toDelOg(tgId) {
	Dialog.confirm("确定要删除该操作组吗？", function() {
		var postData = {
				"ogId" : tgId
			};
		    
	    doAjaxWithToken(postData, "autoctrl/delOperationGroupInfo", function (data) {
	    	Dialog.alert("删除操作组信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryOperationGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	
	});
}

function toAddOperation(tgId) {
	var hasGetDatas = $("#getDatasId").val();
	if (hasGetDatas == "0") {
		var postData = {
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/getDatasForOperationAdd", function(data) {
	    	addUIOperationParas(data);
	    	$("#getDatasId").val("1");
	    	showAddOperation(tgId);
	    });	 
	} else {
		showAddOperation(tgId);
	}
}

function addUIOperationParas(data) {
	for (var k = 1; k < data.length; k++) {		
		if (data[k][0].equipType == "LED") {
			$("#gwIdId").append("<option value=\"" + data[k][0].nodeId + "," + data[k][0].equipType + "," + data[k][0].equipId + 
					"\">"+ data[k][0].nodeName + "  " + data[k][0].equipTypeName + "</option>");
		}
	}
}

function checkOperationInput() {
    if (!checkSelectValid("gwIdId", "设备")) {
        return false;
    } 
    return true;
}

function showAddOperation(tgId) {
	document.getElementById("gwIdId").options[0].selected = true;
				
	var diag = new Dialog();
	diag.Width = 606;
	diag.Height = 120;
	diag.Title = "添加操作信息";
	diag.InvokeElementId = "thresholdDivId";
	diag.OKEvent = function() {
		if (!checkOperationInput()) {
			return;
		}
		
		var selectCtrl = document.getElementById("gwIdId");
		var obj = selectCtrl.options[selectCtrl.selectedIndex];
		var paramArray = obj.value.split(",");
		var ctrlType = paramArray[1] + "OFF";
		if (document.getElementById("operaId").checked) {
			ctrlType = paramArray[1] + "ON";
		}
		var postData = {
				"operationId" : getCurrentTimeMillis(),
				"ogId" : tgId,
				"gwId" : $("#gatewayFilterId").val(),
				"nodeId" : paramArray[0],
				"equipTypeCode" : paramArray[1],
				"equipId" : paramArray[2],
				"controlType" : ctrlType,
				"para1" : null,
				"para2" : null,
				"para3" : null,
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/addOperationInfo", function (data) {
	    	Dialog.alert("添加操作信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryOperationGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toMdyOperation(thresholdId, nodeId, equipTypeCode, equipId, ctrlType) {
	var hasGetDatas = $("#getDatasId").val();
	if (hasGetDatas == "0") {
		var postData = {
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/getDatasForOperationAdd", function(data) {
	    	addUIOperationParas(data);
	    	$("#getDatasId").val("1");
	    	showMdyOperation(thresholdId, nodeId, equipTypeCode, equipId, ctrlType);
	    });	 
	} else {
		showMdyOperation(thresholdId, nodeId, equipTypeCode, equipId, ctrlType);
	}
}

function showMdyOperation(thresholdId, nodeId, equipTypeCode, equipId, ctrlType) {
	var sensorCtrl = document.getElementById("gwIdId");
	for (var i = 0; i < sensorCtrl.options.length; i++) {
		var valS = sensorCtrl.options[i].value.split(",");
		if (valS[0] != nodeId) {
			continue;
		}
		if (valS[1] != equipTypeCode) {
			continue;
		}
		if (valS[2] != equipId) {
			continue;
		}
		sensorCtrl.options[i].selected = true;
		break;
	}	
	if (ctrlType == equipTypeCode + "ON") {
		document.getElementById("operaId").checked = true;
	} else {
		document.getElementById("operaId2").checked = true;
	}
				
	var diag = new Dialog();
	diag.Width = 606;
	diag.Height = 120;
	diag.Title = "修改操作信息";
	diag.InvokeElementId = "thresholdDivId";
	diag.OKEvent = function() {
		if (!checkOperationInput()) {
			return;
		}
		
		var selectCtrl = document.getElementById("gwIdId");
		var obj = selectCtrl.options[selectCtrl.selectedIndex];
		var paramArray = obj.value.split(",");
		var ctrlType = paramArray[1] + "OFF";
		if (document.getElementById("operaId").checked) {
			ctrlType = paramArray[1] + "ON";
		}
		var postData = {
				"operationId" : thresholdId,
				"gwId" : $("#gatewayFilterId").val(),
				"nodeId" : paramArray[0],
				"equipTypeCode" : paramArray[1],
				"equipId" : paramArray[2],
				"controlType" : ctrlType,
				"para1" : null,
				"para2" : null,
				"para3" : null,
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/mdyOperationInfo", function (data) {
	    	Dialog.alert("修改操作信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryOperationGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toDelOperation(thresholdId) {
	Dialog.confirm("确定要删除该操作吗？", function() {
		var postData = {
				"operationId" : thresholdId,
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/delOperationInfo", function (data) {
	    	Dialog.alert("删除操作信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryOperationGroup?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	
	});
}

function toAddStrategy() {
	var hasGetDatas = $("#getDatasId").val();
	if (hasGetDatas == "0") {
		var postData = {
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/getDatasForStrategyAdd", function(data) {
	    	addUIStrategyParas(data);
	    	$("#getDatasId").val("1");
	    	showAddStrategy();
	    });	 
	} else {
		showAddStrategy();
	}
}

function addUIStrategyParas(data) {
	for (var k = 0; k < data[1].length; k++) {
		$("#tgId1").append("<option value=\"" + data[1][k].tgId + "\">"+ data[1][k].tgName + "</option>");
		$("#tgId2").append("<option value=\"" + data[1][k].tgId + "\">"+ data[1][k].tgName + "</option>");
		$("#tgId3").append("<option value=\"" + data[1][k].tgId + "\">"+ data[1][k].tgName + "</option>");
	}
	
	for (var k = 0; k < data[2].length; k++) {
		$("#ogId").append("<option value=\"" + data[2][k].ogId + "\">"+ data[2][k].ogName + "</option>");
	}
}

function showAddStrategy() {
	document.getElementById("tgId1").options[0].selected = true;
	document.getElementById("tgId2").options[0].selected = true;
	document.getElementById("tgId3").options[0].selected = true;
	document.getElementById("ogId").options[0].selected = true;
				
	var diag = new Dialog();
	diag.Width = 606;
	diag.Height = 250;
	diag.Title = "添加策略信息";
	diag.InvokeElementId = "thresholdDivId";
	diag.OKEvent = function() {
		if (!checkStrategyInput()) {
			return;
		}
		
		var tgCtrl1 = document.getElementById("tgId1");
		var tg1 = tgCtrl1.options[tgCtrl1.selectedIndex].value;
		var tgCtrl2 = document.getElementById("tgId2");
		var tg2 = tgCtrl2.options[tgCtrl2.selectedIndex].value;
		if (tg2 == "-1") {
			tg2 = null;
		}
		var tgCtrl3 = document.getElementById("tgId3");
		var tg3 = tgCtrl3.options[tgCtrl3.selectedIndex].value;
		if (tg3 == "-1") {
			tg3 = null;
		}
		var ogCtrl = document.getElementById("ogId");
		var og = ogCtrl.options[ogCtrl.selectedIndex].value;
		var postData = {
				"strategyId" : getCurrentTimeMillis(),
				"ghId" : $("#greenHouseFilterId").val(),
				"tgId1" : tg1,
				"tgId2" : tg2,
				"tgId3" : tg3,
				"ogId" : og,
				"start" : document.getElementById("startHourId").selectedIndex + ":" + document.getElementById("startMinId").selectedIndex,
				"end" : document.getElementById("endHourId").selectedIndex + ":" + document.getElementById("endMinId").selectedIndex,
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/addStrategyInfo", function (data) {
	    	Dialog.alert("添加策略信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryStrategy?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function checkStrategyInput() {
    if (!checkSelectValid("tgId1", "阈值组1")) {
        return false;
    }    
    var tgSel2 = document.getElementById("tgId2").selectedIndex;
    var tgSel3 = document.getElementById("tgId3").selectedIndex;
    if (tgSel2 == 0 && tgSel3 != 0) {
    	Dialog.alert("请选择阈值组2!", function(){$("#tgId2").focus();});
        return false;
    }
    if (!checkSelectValid("ogId", "操作组")) {
        return false;
    }
    return true;
}

function toMdyStrategy(strategyId, tgId1, tgId2, tgId3, ogId, sHour, sMin, eHour, eMin) {
	var hasGetDatas = $("#getDatasId").val();
	if (hasGetDatas == "0") {
		var postData = {
				"ghId" : $("#greenHouseFilterId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/getDatasForStrategyAdd", function(data) {
	    	addUIStrategyParas(data);
	    	$("#getDatasId").val("1");
	    	showMdyStrategy(strategyId, tgId1, tgId2, tgId3, ogId, sHour, sMin, eHour, eMin);
	    });	 
	} else {
		showMdyStrategy(strategyId, tgId1, tgId2, tgId3, ogId, sHour, sMin, eHour, eMin);
	}
}

function showMdyStrategy(strategyId, tgId1, tgId2, tgId3, ogId, sHour, sMin, eHour, eMin) {
	var i = 0; 
	var eleTg1 = document.getElementById("tgId1");
	for (i = 0; i < eleTg1.options.length; i++) {
		var valS = eleTg1.options[i].value;
		if (valS != tgId1) {
			continue;
		}
		eleTg1.options[i].selected = true;
		break;
	}	
	
	var eleTg2 = document.getElementById("tgId2");
	for (i = 0; i < eleTg2.options.length; i++) {
		var valS = eleTg2.options[i].value;
		if (valS != tgId2) {
			continue;
		}
		eleTg2.options[i].selected = true;
		break;
	}
	if (i == eleTg2.options.length) {
		document.getElementById("tgId2").options[0].selected = true;
	}

	var eleTg3 = document.getElementById("tgId3");
	for (i = 0; i < eleTg3.options.length; i++) {
		var valS = eleTg3.options[i].value;
		if (valS != tgId3) {
			continue;
		}
		eleTg3.options[i].selected = true;
		break;
	}
	if (i == eleTg3.options.length) {
		document.getElementById("tgId3").options[0].selected = true;
	}
	
	var eleOg = document.getElementById("ogId");
	for (i = 0; i < eleOg.options.length; i++) {
		var valS = eleOg.options[i].value;
		if (valS != ogId) {
			continue;
		}
		eleOg.options[i].selected = true;
		break;
	}
	
	document.getElementById("startHourId").options[sHour].selected = true;
	document.getElementById("startMinId").options[sMin].selected = true;
	document.getElementById("endHourId").options[eHour].selected = true;
	document.getElementById("endMinId").options[eMin].selected = true;
				
	var diag = new Dialog();
	diag.Width = 606;
	diag.Height = 250;
	diag.Title = "修改策略信息";
	diag.InvokeElementId = "thresholdDivId";
	diag.OKEvent = function() {
		if (!checkStrategyInput()) {
			return;
		}
		
		var tgCtrl1 = document.getElementById("tgId1");
		var tg1 = tgCtrl1.options[tgCtrl1.selectedIndex].value;
		var tgCtrl2 = document.getElementById("tgId2");
		var tg2 = tgCtrl2.options[tgCtrl2.selectedIndex].value;
		if (tg2 == "-1") {
			tg2 = null;
		}
		var tgCtrl3 = document.getElementById("tgId3");
		var tg3 = tgCtrl3.options[tgCtrl3.selectedIndex].value;
		if (tg3 == "-1") {
			tg3 = null;
		}
		var ogCtrl = document.getElementById("ogId");
		var og = ogCtrl.options[ogCtrl.selectedIndex].value;
		var postData = {
				"strategyId" : strategyId,
				"tgId1" : tg1,
				"tgId2" : tg2,
				"tgId3" : tg3,
				"ogId" : og,
				"start" : document.getElementById("startHourId").selectedIndex + ":" + document.getElementById("startMinId").selectedIndex,
				"end" : document.getElementById("endHourId").selectedIndex + ":" + document.getElementById("endMinId").selectedIndex,
				"userId" : $("#userIdId").val()
			};
		    
	    doAjaxWithToken(postData, "autoctrl/mdyStrategyInfo", function (data) {
	    	Dialog.alert("修改策略信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryStrategy?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	 
	}; 
	diag.show();
}

function toDelStrategy(strategyId) {
	Dialog.confirm("确定要删除该策略吗？", function() {
		var postData = {
				"strategyId" : strategyId
			};
		    
	    doAjaxWithToken(postData, "autoctrl/delStrategyInfo", function (data) {
	    	Dialog.alert("删除策略信息成功！", function() {				
				self.location.href = $("#basePathId").val() + 'autoctrlJsp/webQueryStrategy?ghId=' + $("#greenHouseFilterId").val();
			});
	    });	
	});
}



