function toSaveSelfPwd(userId){
    var oldPassword = $("#oldPasswordId").val();
    var newPassword = $("#newPasswordId").val();
    var newPassword2 = $("#newPassword2Id").val();
    if (oldPassword == null || StringTrim(oldPassword) == "") {
        Dialog.alert("请输入旧密码!", function(){$("#oldPasswordId").focus();});		        
        return false;
    }		    
    if (newPassword == null || StringTrim(newPassword) == "") {
    	Dialog.alert("请输入新密码!", function(){$("#newPasswordId").focus();});
        return false;   
    }
    if (newPassword2 == null || StringTrim(newPassword2) == "") {
    	Dialog.alert("请输入确认密码!", function(){$("#newPassword2Id").focus();});
        return false;   
    }
    if (newPassword2 != newPassword) {
    	Dialog.alert("密码和确认密码不同，请重新输入!", function(){$("#newPasswordId").focus();});
		return false;
	}
	var reg = /^[a-zA-Z0-9_]{6,16}$/;   
	var r = newPassword.match(reg);
	if (r == null) {
		Dialog.alert("密码应为6到16位，数字、字母、下划线的组合，请重新输入!", function(){$("#newPasswordId").focus();});
    	return false;
    }
    
    var postData = {
    	"userId" : userId,
    	"userPwdOld" : oldPassword,
		"userPwdNew" : newPassword
	};
    
    doAjaxWithToken(postData, "user/mdyUserPwd", function (data) {
    	Dialog.alert("密码更改成功！");
		$("#oldPasswordId").val("");
		$("#newPasswordId").val("");
		$("#newPassword2Id").val("");
    });
    
    return true;
}

function getSelInfoFromServer(userId) {
	var postData = {
    	"userId" : userId
	};
    
    doAjaxWithToken(postData, "user/getLoginInfo", function (data) {
    	var dataObj = data[1];
    	$("#userRealNameId").val(data[1].name);
		$("#userMobileId").val(data[1].phone);
		
		if (data[1].picPath.length > 0) {
			$("#picShowId").attr('src', "downloadFile/downloadFile?inputPath=" + data[1].picPath);
			$("#picSrcFileId").val(data[1].picPath);
			hideSelFile();
		} else {
			$("#picSrcFileId").val("");
			showSelFile();
		}
    });
}

function toSaveUserInfo(){
    var userRealName = $("#userRealNameId").val();
    var userMobile = $("#userMobileId").val();
    if (userRealName == null || StringTrim(userRealName) == "") {
        Dialog.alert("请输入姓名!", function(){$("#userRealNameId").focus();});		        
        return false;
    }		    
    if (userMobile == null || StringTrim(userMobile) == "") {
    	Dialog.alert("请输入手机号码!", function(){$("#userMobileId").focus();});
        return false;   
    }
    if (!checkMobile(userMobile)) {
    	Dialog.alert("请输入11位数字的手机号码!", function(){$("#userMobileId").focus();});
        return false;   
    }    
    
    var form = new FormData(document.getElementById("fileForm"));
	$.ajax({
		type : "post",
		url : "user/mdySelfInfo",
		async : false,
		dataType : "json",
		data : form,
		processData : false,			// 告诉jQuery不要去处理发送的数据
        contentType : false,			// 告诉jQuery不要去设置Content-Type请求头
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {
				Dialog.alert("修改个人信息成功！");
			} else {
				Dialog.alert(msg);
			}
		},
		/*error : function(data) {
			Dialog.alert(data[0].message);
		},*/
		error : function(msg) {
			ajaxFail(msg);
		}
	});	    		    
    return true;
}

function toResetUserInfo() {
	$("#userNameId").val("");
	$("#userRealNameId").val("");
	$("#newPasswordId").val("");
	$("#newPassword2Id").val("");
}

function toAddUserInfo(parentUserId, userRole) {
	var userName = $("#userNameId").val();
    var userRealName = $("#userRealNameId").val();
	var newPassword = $("#newPasswordId").val();
    var newPassword2 = $("#newPassword2Id").val();
    
    if (userName == null || StringTrim(userName) == "") {
        Dialog.alert("请输入用户名!", function(){$("#userNameId").focus();});		        
        return false;
    }
    if (userRealName == null || StringTrim(userRealName) == "") {
        Dialog.alert("请输入姓名!", function(){$("#userRealNameId").focus();});		        
        return false;
    }		    
    if (newPassword == null || StringTrim(newPassword) == "") {
    	Dialog.alert("请输入密码!", function(){$("#newPasswordId").focus();});
        return false;   
    }
    if (newPassword2 == null || StringTrim(newPassword2) == "") {
    	Dialog.alert("请输入确认密码!", function(){$("#newPassword2Id").focus();});
        return false;   
    }
    if (newPassword2 != newPassword) {
    	Dialog.alert("密码和确认密码不同，请重新输入!", function(){$("#newPasswordId").focus();});
		return false;
	}
	var reg = /^[a-zA-Z0-9_]{6,16}$/;   
	var r = newPassword.match(reg);
	if (r == null) {
		Dialog.alert("密码应为6到16位，数字、字母、下划线的组合，请重新输入!", function(){$("#newPasswordId").focus();});
    	return false;
    }    
	
	var postData = {
			"parentUserId" : parentUserId,
			"userId" : userName,
			"userName" : userRealName,
			"userPwd" : newPassword,
			"userRole" : userRole,
			"parkId" : $("#parkId").val()
		};
	    
    doAjaxWithToken(postData, "user/addUser", function (data) {
    	Dialog.confirm("添加用户成功！继续添加？", function() {
			toResetUserInfo();
		}, function() {
			menuNeedChange("addUserInfoId", "queryUserInfoId");
			self.location.href = $("#basePathId").val() + 'userJsp/webQueryUserInfo?parentUserId=' + parentUserId;
		});
    });	 
}

function toResetUserPwd(userId) {
	Dialog.confirm("确定要重置用户" + userId + "的密码吗？", function() {
		var postData = {
				"userId" : userId
			};
		    
	    doAjaxWithToken(postData, "user/resetPassword", function (data) {
	    	Dialog.alert("重置用户" + userId + "的密码成功！");
	    });	 
	});	
}
