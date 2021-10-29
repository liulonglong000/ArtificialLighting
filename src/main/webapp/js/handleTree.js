var IDMark_Switch = "_switch",
	IDMark_Icon = "_ico",
	IDMark_Span = "_span",
	IDMark_Input = "_input",
	IDMark_Check = "_check",
	IDMark_Edit = "_edit",
	IDMark_Remove = "_remove",
	IDMark_Ul = "_ul",
	IDMark_A = "_a";

function getFont(treeId, node) {
	return node.font ? node.font : {};
}
	    
function initGhTree() {
	var setting_category = {
		view: {
			fontCss: getFont,
	        addDiyDom: addDiyDom,
	        selectedMulti: false
	    }
	};

	function addDiyDom(treeId, treeNode) {
		var aObj = $("#" + treeNode.tId + IDMark_A);  
		if (treeNode.icon.indexOf("root.png") != -1) {			// 根节点						
			var editStr = "<button type='button' class='diyBtnAdd' id='diyBtn_add_" + treeNode.id + "' title='新增' onfocus='this.blur();'></button>";
			aObj.append(editStr);
			$("#diyBtn_add_" + treeNode.id).bind("click", function(){addGh();});
		} else if (treeNode.icon.indexOf("gh.png") != -1) {
			var editStr = "<button type='button' class='diyBtnEdit' id='diyBtn_edit_" + treeNode.id + "' title='修改' onfocus='this.blur();'></button>";
			aObj.append(editStr);
			$("#diyBtn_edit_" + treeNode.id).bind("click", function(){editGh(treeNode);});
		}		
	}
	
	$.ajax({
		type : "post",
		url : "getGhSetting.action",
		async : false,
		dataType : "json",
		success : function(data) {
			var msg = data.message;
			if (msg == "relogin") {
				jumpToLoginPage();
			} else if (msg == "success") {					
				var zNodes = data.data;					 
				var treeObj = $.fn.zTree.init($("#treeDemo"), setting_category, zNodes);
				treeObj.expandAll(true);
			} else {
				Dialog.alert(msg);
			}
		},
		error : function(msg) {
			if (msg.statusText.indexOf("NetworkError") >= 0) {
				Dialog.alert("连接服务器失败，请稍后重试！");
			} else {
				Dialog.alert("系统错误！" + msg.statusText);
			}
		}
	});	
}

function addGh() {
	document.getElementById('ghTitle').innerText = "添加设施温室";
	
	$("#locationId").val("");
	$("#ghNumId").val("");
	$("#ghAdminId").val("");
	$("#telId").val("");
	$("#addressId").val("");
	
	showSelFile();
	
	$("#btnAddId").show();
	$("#btnEditId").hide();
}

function editGh(treeNode) {
	document.getElementById('ghTitle').innerText = "修改设施温室";
	
	var postData = {
    	"greenHouseId" : treeNode.id
	};
	$.ajax({
		type : "post",
		url : "getGhInfoById.action",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				$("#ghId").val(treeNode.id);
				$("#locationId").val(data[1].location);
				$("#ghNumId").val(data[1].ghNum);
				$("#ghAdminId").val(data[1].admin);
				$("#telId").val(data[1].phone);
				$("#addressId").val(data[1].ip);
				
				if (data[1].picPath.length > 0) {
					$("#picShowId").attr('src', "downloadFile.action?inputPath=" + data[1].picPath);
					$("#picSrcFileId").val(data[1].picPath);
					hideSelFile();
				} else {
					$("#picSrcFileId").val("");
					showSelFile();
				}
			} else {
				Dialog.alert(msg);
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	
	
	$("#btnAddId").hide();
	$("#btnEditId").show();
}

function checkGhSetting() {
	if (!checkTextValid("locationId", "位置")) {
    	return false;
    }
	if (!checkTextValid("ghNumId", "棚号")) {
    	return false;
    }
	if (!checkTextValid("ghAdminId", "联系人")) {
    	return false;
    }
	if (!checkTextValid("telId", "联系电话")) {
    	return false;
    }
	var userMobile = $("#telId").val();
	if (!checkMobile(userMobile)) {
		if (!checkOfficeTelephone(userMobile)) {
	    	Dialog.alert("联系电话不正确，请重新输入!", function(){$("#telId").focus();});
	        return false;   
		}
    }
	if (!checkTextValid("addressId", "IP地址")) {
    	return false;
    }
	if (!checkIP($("#addressId").val())) {
		Dialog.alert("IP地址不正确，请重新输入!", function(){$("#addressId").focus();});
        return false;  
	}
	
	return true;
}

function toAddGhInfo() {	
	if (!checkGhSetting()) {
		return false;
	}
	
	doAddGhInfo(false);
}

function doAddGhInfo(hasLogin) {
	var form = new FormData(document.getElementById("ghSettingForm"));
	$.ajax({
		type : "post",
		url : "addGhInfo.action",
		dataType : "json",				// 返回值类型
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "relogin") {
				if (!hasLogin) {
					toRunFunctionAfterLogin(doAddGhInfo);
				} else {
					Dialog.alert(msg);
				}
			} else if (msg == "success") {
				Dialog.alert("添加设施温室成功！", function() {
					self.location.reload();
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

function toMdyGhInfo() {	
	if (!checkGhSetting()) {
		return false;
	}
	
	doMdyGhInfo(false);
}

function doMdyGhInfo(hasLogin) {
	var form = new FormData(document.getElementById("ghSettingForm"));
	$.ajax({
		type : "post",
		url : "mdyGhInfo.action",
		dataType : "json",				// 返回值类型
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "relogin") {
				if (!hasLogin) {
					toRunFunctionAfterLogin(doMdyGhInfo);
				} else {
					Dialog.alert(msg);
				}
			} else if (msg == "success") {
				Dialog.alert("修改设施温室成功！", function() {
					self.location.reload();
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
