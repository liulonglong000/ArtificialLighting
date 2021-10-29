function toCheckLoginInfo(){
	var userName = $("#userId").val();
    var password = $("#pwdId").val();
    if (userName == null || StringTrim(userName) == "" || StringTrim(userName) == "用户账号") {
        Dialog.alert("请输入用户账号!", function(){$("#userId").focus();});		        
        return false;
    }		    
    if (password == null || StringTrim(password) == "") {
    	Dialog.alert("请输入登录密码!", function(){$("#showPwdId").focus();});
        return false;   
    }
    
    var postData = {
		"userId" : userName,
		"userPwd" : password
	};
	$.ajax({
		type : "post",
		url : "login/doLogin",
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success") {				
				var token = data[1].token;
				var userRole = data[1].userRole;
				sessionStorage.alToken = token; 		// 保存数据
				sessionStorage.alRole = userRole;
				sessionStorage.alUserId = userName;
				sessionStorage.alUserPwd = password;
				window.open($("#basePathId").val() + 'frame/main.jsp', '_top');
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

function toResetLoginInfo() {
	$("#userId").val("用户账号");
	document.getElementById("userId").style.color = "#aaa";
	$("#pwdId").val("");
	$("#showPwdId").show();
	$("#pwdId").hide();
}

function clearPromptName(inputObj) {
	if (inputObj.value == "用户账号") { 
		inputObj.value = ""; 
		inputObj.style.color = "#000000";
	} 
}

function resetPromptName(inputObj) {
	if (inputObj.value == "") { 
		inputObj.value = "用户账号"; 
		inputObj.style.color = "#aaa";
	} 
}

function clearPromptPw(inputObj) {
	$("#showPwdId").hide();
	$("#pwdId").show().focus();
}

function resetPromptPw(inputObj) {
	if (inputObj.value == "") {
		$("#showPwdId").show();
		$("#pwdId").hide();
	} 
}

function clearPromptType(inputObj) {
	$("#showTypeId").hide();
	$("#typeId").show().focus();
}

function resetPromptType(inputObj) {
	if (inputObj.value == "") {
		$("#showTypeId").show();
		$("#typeId").hide();
	} 
}

function gotoLogout() {
	var flag = confirm("确定要退出该系统吗？");
	if (flag == true) {
		var postData = {
				"token" : sessionStorage.alToken
			};
			$.ajax({
				type : "post",
				url : "login/doLogout",
				async : false,
				dataType : "json",
				data : postData,
				success : function(data) {
					var msg = data[0].message;
					if (msg == "success") {			
						jumpToLogin()
					} else {
						alert(msg, function() {
							jumpToLogin();
						});
					}
				},
				error : function(msg) {
					ajaxFail(msg);
				}
			});	  
	}	
	
	/*Dialog.confirm("确定要退出该系统吗？", function() {
		var postData = {
			"token" : sessionStorage.alToken
		};
		$.ajax({
			type : "post",
			url : "login/doLogout",
			async : false,
			dataType : "json",
			data : postData,
			success : function(data) {
				var msg = data[0].message;
				if (msg == "success") {			
					jumpToLogin()
				} else {
					Dialog.alert(msg, function() {
						jumpToLogin();
					});
				}
			},
			error : function(msg) {
				ajaxFail(msg);
			}
		});	    
	}, function() {
		return false;
	});*/
}

function jumpToLogin() {
	window.open('login.jsp', '_top');
}
