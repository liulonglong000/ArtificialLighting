function toCloseLed(equiName, gwId, nodeId, equiType, equiId) {
	Dialog.confirm("确定要关闭该" + equiName + "吗？", function() {
		doOperationLed(gwId, nodeId, equiType, equiId, equiType + "OFF", "关闭" + equiName, null, null);
	}, function() {
		return false;
	});
}

function toOpenLed(equiName, gwId, nodeId, equiType, equiId, timeId) {
	Dialog.confirm("确定要打开该" + equiName + "吗？", function() {
		var textVal = $("#timeId" + timeId).val();	
	    if (textVal == null || StringTrim(textVal) == "") {
	    	textVal = null;
	    }
	    if (equiType == "DRIP") {
	    	if ($("#unitId" + timeId).val() == "0") {
	    		doOperationLed(gwId, nodeId, equiType, equiId, equiType + "ON", "打开" + equiName, textVal, null);
	    	} else {
	    		doOperationLed(gwId, nodeId, equiType, equiId, equiType + "ON", "打开" + equiName, null, textVal);
	    	}
	    } else {
	    	doOperationLed(gwId, nodeId, equiType, equiId, equiType + "ON", "打开" + equiName, textVal, null);
	    }
	}, function() {
		return false;
	});
}

function sleep(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime)
			return;
	}
}

function doOperationLed(gwId, nodeId, equiType, equiId, controlType, finalMsg, timePara, countPara) {
	var myDate = new Date();
	var tradeId = "0_" + myDate.getFullYear() + myDate.getMonth() + myDate.getDate() + myDate.getHours() 
	+ myDate.getMinutes() + myDate.getSeconds() + myDate.getMilliseconds() % 99;
    
    var postData = {
    	"tradeId" : tradeId,
    	"gwId" : gwId,
		"nodeId" : nodeId,
		"equiType" : equiType,
		"equiId" : equiId,
		"controlType" : controlType,
		"para1" : timePara,
		"para2" : countPara,
		"insertWay" : "0",
		"userId" : sessionStorage.alUserId
	};
    
    doAjaxWithToken(postData, "operation/addTradeInfo", function (data) {
    	sleep(1000);
    	var count = 1;
		checkResult(tradeId, finalMsg, count);
    	/*setTimeout("checkResult(tradeId, finalMsg)", 3000);*/ 
    });
}

function checkResult(tradeId, finalMsg, count) {
	var postData = {
    	"tradeId" : tradeId
	};
	
	doAjaxWithToken(postData, "operation/checkTradeResult", function (data) {
		var result = data[1].result;
        if (result == "0" || result == "2") {
            if (count < 61) {
            	count++;
            	sleep(1000);
            	checkResult(tradeId, finalMsg, count);
            	return;
            }
            Dialog.alert(finalMsg + "失败：没有反应，请联系系统管理员！");
        } else if (result == "1") {
        	Dialog.alert(finalMsg + "成功！", function() {
        		self.parent.frames['main'].location = $("#basePathId").val() + "gatewayJsp/webGetGhNodesEquipment?ghId=" + $("#greenHouseFilterId").val() + "";
        	});
        } else {
        	Dialog.alert(finalMsg + "失败：" + data[1].remark);
        }
    });
}

function toRefreshNodeEquips(gatewayId, nodeId) {
	var postData = {
    	"gwId" : gatewayId,
		"nodeId" : nodeId,
		"userId" : sessionStorage.alUserId
	};
    
    doAjaxWithToken(postData, "operation/refreshNodeEquips", function (data) {
    	var trades = "";
        for (var i= 1; i < data.length; i++) {
            var tId = data[i].tradeId;
            if (trades.length > 0) {
                trades += "+";
            }
            trades += tId;
        }
        if (trades.length > 0) {
        	document.getElementById("refresh" + nodeId).style.display = "none";
        	
        	sleep(3000);
        	var count = 1;
    		checkRefreshResult(trades, nodeId, count);
        } 
    });
}

function checkRefreshResult(trades, nodeId, count) {
	var postData = {
    	"tradesId" : trades
	};
	
	doAjaxWithToken(postData, "operation/checkRefreshResult", function (data) {        
        var newTrades = "";
        for (var i = 1; i < data.length; i++) {
            var result = data[i].result;
            if (result == "0" || result == "2") {
                if (newTrades.length > 0) {
                    newTrades += "+";
                }
                newTrades += data[i].tradeId;
            } else if (result == "1") {

            } else {
            	Dialog.alert("更新节点设备状态失败：" + data[i].remark);
            	document.getElementById("refresh" + nodeId).style.display = "";
                return;
            }
        }

        if (newTrades.length == 0) {
            Dialog.alert("更新节点设备状态成功！", function() {
        		self.parent.frames['main'].location = $("#basePathId").val() + "gatewayJsp/webGetGhNodesEquipment?ghId=" + $("#greenHouseFilterId").val() + "";
        	});
        } else {
            if (count < 21) {
            	count++;
            	sleep(3000);
            	checkRefreshResult(newTrades, nodeId, count);
            } else {
            	Dialog.alert("更新节点设备状态失败：没有反应，请联系系统管理员");
            	document.getElementById("refresh" + nodeId).style.display = "";
            }
        }
    }, function() {
    	document.getElementById("refresh" + nodeId).style.display = "";
    });
}



