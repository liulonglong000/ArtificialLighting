function toResetLightTrigger() {
	$("#startHourId").val(0);
	$("#startMinId").val(0);
	$("#endHourId").val(0);
	$("#endMinId").val(0);
	$("#lightLowId").val("");
	$("#lightHighId").val("");
	$("input[name='irriState']").eq(1).attr("checked", "checked");
	$("input[name='irriState']").eq(1).click();
}

function toAddLightTrigger() {
	var ghId = $("#greenHouseFilterId").val(); 
	if (ghId == null || ghId == -1) {
		Dialog.alert("请选择温室!", function(){$("#greenHouseFilterId").focus();});		        
        return false;
	}
	if (!checkTrigger()) {
		return false;
	}
	
	doAddLightTrigger(false);
}

function checkTrigger() {	
	if (!checkTextValid("lightLowId", "补光下限")) {
    	return false;
    }
	if (!checkTextValid("lightHighId", "补光上限")) {
    	return false;
    }
	
	var lightLow = $("#lightLowId").val();
	var lightHigh = $("#lightHighId").val();
    if (parseFloat(lightLow) >= parseFloat(lightHigh)) {
    	Dialog.alert("光照度设置不正确!", function(){$("#lightLowId").focus();});		        
        return false;
    }
	
	return true;
}

function doAddLightTrigger(hasLogin) {
	var state = true;
	var radio = document.getElementById('stateNoId');
	if (radio.checked) {
		state = false;
	}
	var postData = {
		"ghId" : $("#greenHouseFilterId").val(),
    	"startHour" : $("#startHourId").val(),
    	"startMin" : $("#startMinId").val(),
    	"endHour" : $("#endHourId").val(),
    	"endMin" : $("#endMinId").val(),
    	"lightlow" : $("#lightLowId").val(),
    	"lighthigh" : $("#lightHighId").val(),
		"status" : state
	};
	$.ajax({
		type : "post",
		url : "addLightTrigger.action",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "relogin") {
				if (!hasLogin) {
					toRunFunctionAfterLogin(doAddLightTrigger);
				} else {
					Dialog.alert(msg);
				}
			} else if (msg == "success") {
				Dialog.alert("添加补光条件成功！", function() {
					toResetLightTrigger();
				});
			} else {
				Dialog.alert("添加补光条件失败:" + msg);	
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});
}

function toModifyLightTriggerState(handleId, nowState) {
	var confirmStr = "确定要";
	if (nowState == 1) {
		confirmStr += "禁用";
	} else {
		confirmStr += "启用";
	}
	confirmStr += "该补光条件吗？";
	
	Dialog.confirm(confirmStr, function() {
		$("#handleIdId").val(handleId);
		$("#stateId").val(nowState);
		doModifyLightTriggerState(false);
	}, function() {
		return false;
	});
}

function doModifyLightTriggerState(hasLogin) {
	var postData = {
		"handleId" : $("#handleIdId").val(),
		"status" : $("#stateId").val()
	};
	$.ajax({
		type : "post",
		url : "modifyLightTriggerState.action",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "relogin") {
				if (!hasLogin) {
					toRunFunctionAfterLogin(doModifyLightTriggerState);
				} else {
					Dialog.alert(msg);
				}
			} else if (msg == "success") {
				Dialog.alert("修改补光条件的状态成功！", function() {
					document.forms[0].submit();
				});
			} else {
				Dialog.alert("修改补光条件的状态失败:" + msg);	
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});
}

function toDeleteLightTrigger(delId) {
	Dialog.confirm("确定要删除该补光条件吗？", function() {
		$("#handleIdId").val(delId);
		doDeleteLightTrigger(false);
	}, function() {
		return false;
	});
}

function doDeleteLightTrigger(hasLogin) {
	var postData = {
    	"handleId" : $("#handleIdId").val()
	};
	$.ajax({
		type : "post",
		url : "delLightTrigger.action",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "relogin") {
				if (!hasLogin) {
					toRunFunctionAfterLogin(doDeleteLightTrigger);
				} else {
					Dialog.alert(msg);
				}
			} else if (msg == "success") {
				Dialog.alert("删除补光条件成功！", function() {
					document.forms[0].submit();
				});
			} else {
				Dialog.alert(msg);	
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	
}

function toModifyLightTrigger(delId) {	
	var postData = {
		"handleId" : delId
	};
	$.ajax({
		type : "post",
		url : "getSelForLightTrigger.action",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				$("#ghInfoId").text(data[1].ghName);
				$("#startHourId").val(data[1].startHour);
				$("#startMinId").val(data[1].startMin);
				$("#endHourId").val(data[1].endHour);
				$("#endMinId").val(data[1].endMin);
				$("#lightLowId").val(data[1].lightLow);
				$("#lightHighId").val(data[1].lightHigh);
				if (data[1].state) {
					$("input[name='irriState']").eq(0).attr("checked", "checked");
					$("input[name='irriState']").eq(0).click();
				} else {
					$("input[name='irriState']").eq(1).attr("checked", "checked");
					$("input[name='irriState']").eq(1).click();
				}
				
				var diag = new Dialog();
				diag.Width = 660;
				diag.Height = 200;
				diag.Title = "修改补光条件";
				diag.InvokeElementId="mdyTriggerDivId";
				diag.OKEvent = function() {
					if (!checkTrigger()) {
						return false;
					}
					$("#handleIdId").val(delId);
					doModifyLightTrigger(false);	
				}; 
				diag.show();
				
			} else {
				Dialog.alert("获取补光条件信息失败:" + msg);	
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});
}

function doModifyLightTrigger(hasLogin) {
	var state = 1;
	var radio = document.getElementById('stateNoId');
	if (radio.checked) {
		state = 0;
	}
	var postData = {
		"handleId" : $("#handleIdId").val(),
    	"startHour" : $("#startHourId").val(),
    	"startMin" : $("#startMinId").val(),
    	"endHour" : $("#endHourId").val(),
    	"endMin" : $("#endMinId").val(),
    	"lightlow" : $("#lightLowId").val(),
    	"lighthigh" : $("#lightHighId").val(),
		"status" : state
	};
	$.ajax({
		type : "post",
		url : "modifyLightTrigger.action",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "relogin") {
				if (!hasLogin) {
					toRunFunctionAfterLogin(doModifyLightTrigger);
				} else {
					Dialog.alert(msg);
				}
			} else if (msg == "success") {
				Dialog.alert("修改补光条件成功！", function() {
					document.forms[0].submit();
				});
			} else {
				Dialog.alert(msg);	
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	
}

