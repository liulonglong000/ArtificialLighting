// 操作前用于判断是否设置了园区信息
function checkParkExist(userType, userId, srcId) {
	if (userType == "系统管理员") {
		return true;
	}
	
	var postData = {
		"userId" : userId
	};
	    
    doAjaxWithToken(postData, "user/getParkInfo", function (data) {
    	var msg = data[0].message;
    	if (msg == "add") {
			Dialog.alert("请先添加园区信息！", function() {
				menuNeedChange(srcId, "parkInfoId");
				self.location.href = $("#basePathId").val() + '';
			});
		} else {
			$("#parkId").val(data[1].id);
		}
    });	 
}

function getParkInfoFromServer(userId) {
	var postData = {
    	"userId" : userId
	};
    
    doAjaxWithToken(postData, "user/getParkInfo", function (data) {
    	var msg = data[0].message;
    	if (msg == "success") {
    		var dataObj = data[1];
        	$("#parkIdId").val(data[1].id);
        	$("#parkInputId").hide();
			$("#parkViewId").show();
			document.getElementById("parkIdShowId").innerText = data[1].id;
        	
    		$("#parkNameId").val(data[1].name);
    		$("#parkAreaId").val(data[1].area);
    		$("#parkAddressId").val(data[1].addr);
    		$("#parkRemarkId").val(data[1].remark);
    		
    		if (data[1].pic.length > 0) {
    			$("#picShowId").attr('src', "downloadFile/downloadFile?inputPath=" + data[1].pic);
    			$("#picSrcFileId").val(data[1].pic);
    			hideSelFile();
    		} else {
    			$("#picSrcFileId").val("");
    			showSelFile();
    		}
    		
    		$("#btnAddParkId").hide();
			$("#btnEditParkId").show();
		} 
    });
}

function toSaveParkInfo(url, successInfo) {
    var parkId = $("#parkIdId").val();
    if (parkId == null || StringTrim(parkId) == "") {
        Dialog.alert("请输入园区ID!", function(){$("#parkIdId").focus();});		        
        return false;
    } 
    
    var form = new FormData(document.getElementById("fileForm"));
	$.ajax({
		type : "post",
		url : url,
		async : false,
		dataType : "json",
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				Dialog.alert(successInfo);
			} else {
				Dialog.alert(msg);
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	    	
	
    return true;
}

function toResetGatewayInfo() {
	$("#gatewayIdId").val("");
	$("#gatewayNameId").val("");
	$("#gatewayAddressId").val("");
	$("#gatewayRemarkId").val("");
	clearFile('picSelId');
}

function toSaveGatewayInfo(url, successInfo, bAdd) {
    var parkId = $("#gatewayIdId").val();
    if (parkId == null || StringTrim(parkId) == "") {
        Dialog.alert("请输入网关ID!", function(){$("#gatewayIdId").focus();});		        
        return false;
    } 
    
    var form = new FormData(document.getElementById("fileForm"));
	$.ajax({
		type : "post",
		url : url,
		async : false,
		dataType : "json",
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				if (bAdd) {
					Dialog.confirm(successInfo + "继续添加？", function() {
						toResetGatewayInfo();
					}, function() {
						menuNeedChange("addGwInfoId", "queryGwInfoId");
						self.location.href = $("#basePathId").val() + 'gatewayJsp/webQueryGwTable?userId=' + $("#userIdId").val();
					});
				} else {
					Dialog.alert(successInfo, function() {
						self.location.href = $("#basePathId").val() + 'gatewayJsp/webQueryGwTable?userId=' + $("#userIdId").val();
					});
				}
			} else {
				Dialog.alert(msg);
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	    	
	
    return true;
}

function toResetGreenhouseInfo() {
	$("#ghIdId").val("");
	$("#ghNameId").val("");
	$("#ghAddressId").val("");
	document.getElementById("gwIdId").options[0].selected = true;
	document.getElementById("userIdId").options[0].selected = true;
	$("#ghRemarkId").val("");
	clearFile('picSelId');
}  

function toSaveGreenhouseInfo(url, successInfo, bAdd,userId) {
	
    var parkId = $("#ghIdId").val();
    if (parkId == null || StringTrim(parkId) == "") {
        Dialog.alert("请输入温室ID!", function(){$("#ghIdId").focus();});		        
        return false;
    } 
    
    var gwId = $("#gwIdId").val();
    
    if (gwId == null || gwId == "-1") {
        Dialog.alert("请选择温室挂载的网关！", function(){$("gwIdId").focus();});		        
        return false;
    }else{
    	var a=gwId.split("-") ;
    	  var postData = {
    	        	"userId" : userId,
    	        	"gwId" : a[0],
    	        	"nodeId" : a[1]
    	    	};
    	  doAjaxWithToken(postData, "gateway/getNodesOfParkPd", function (data) {
    		  
    	    	var msg = data[1].xiaoxi;
    	    	
    	    	if (msg != "success") {
    	    	
    	    		Dialog.confirm(msg + "，是否继续添加？", function() {
    	    		
    	    			SaveGreenhouseInfo(url, successInfo, bAdd,userId);
					}, function() {
						toResetGreenhouseInfo();
					});
    			} else{
    				
    				SaveGreenhouseInfo(url, successInfo, bAdd,userId);
    			}
    	    });
    }
 
   
    
	
    return true;
}

function  SaveGreenhouseInfo(url, successInfo, bAdd,userId) {
	
	var form = new FormData(document.getElementById("fileForm"));

	$.ajax({
		type : "post",
		url : url,
		async : false,
		dataType : "json",
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				if (bAdd) {
					Dialog.confirm(successInfo + "继续添加？", function() {
						toResetGreenhouseInfo();
					}, function() {
						menuNeedChange("addGhInfoId", "queryGhInfoId");
						self.location.href = $("#basePathId").val() + 'gatewayJsp/webQueryGreenhouse?userId=' + $("#userIdId").val();
					});
				} else {
					Dialog.alert(successInfo, function() {
						self.location.href = $("#basePathId").val() + 'gatewayJsp/webQueryGreenhouse?userId=' + $("#userIdId").val();
					});
				}
			} else {
				Dialog.alert(msg);
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	    	
	
	
	
	
}



function toGetGatewaysOfPark(userId) {
	var postData = {
    	"userId" : userId
	};
	var postuserData = {
	    	"parentUserId" : userId
		};
	  doAjaxWithToken(postuserData, "user/queryUserInfo", function (data) {
	    	var msg = data[0].message;
	    	if (msg == "success") {
	    		for (var i = 1; i < data.length; i++) {
	    			
	    			$("#userIdId").append("<option value=\"" + data[i].userId + "\">"+ data[i].userName+ "</option>");
	    		}
			} 
	    });
    doAjaxWithToken(postData, "gateway/getNodesOfPark", function (data) {
    	var msg = data[0].message;
    	if (msg == "success") {
    		for (var i = 1; i < data.length; i++) {
    			$("#gwIdId").append("<option value=\"" + data[i].gwId+"-"+data[i].nodeId + "\">"+ data[i].nodeName+"(网关"+data[i].gwId+"节点"+data[i].nodeId+","+data[i].status+")"+ "</option>");
    		}
		} 
    });
}

function toSaveNodeInfo() {
    var form = new FormData(document.getElementById("fileForm"));
	$.ajax({
		type : "post",
		url : "gateway/mdyNodeInfo",
		async : false,
		dataType : "json",
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				Dialog.alert("修改节点信息成功！", function() {
					self.location.href = $("#basePathId").val() + 'gatewayJsp/webQueryNode?ghId=' + $("#ghIdId").val();
				});
			} else {
				Dialog.alert(msg);
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	    	
	
    return true;
}



