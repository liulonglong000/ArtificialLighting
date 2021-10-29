function getRealPath() {
	// 获取当前网址，如： http://localhost:8083/myproj/view/my.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： myproj/view/my.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/myproj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

	// 得到了 http://localhost:8083/myproj
	var realPath = localhostPaht + projectName;
	return realPath;
}

function StringTrim(str) {
	if (str == null) {
		return null;
	}
  return str.replace(/(^\s*)|(\s*$)/g, "");
}

function isNumber(str) {
	var rep = /^([0-9])*$/;
	var strvalue = str;
	var newstrvalue = strvalue.match(rep);
	if (newstrvalue == null) {
		return false;
	} else {
		return true;
	}
}

function checkMobile(str) {
	if (StringTrim(str).length == 11 && isNumber(str)) {
		return true;
	} else {
		return false;
	}
}

function checkOfficeTelephone(str) {
	if (str.length == 0) {
		return true;
	}
	if (StringTrim(str).length == 8 && isNumber(str)) {
		return true;
	} else {
		return false;
	}
}

function checkIP(ip) {
    var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
    return reg.test(ip);
} 

function limitInputForFloat(o, info, decimals) {
	var _value = o.value;
	if (_value == null || StringTrim(_value) == "") {
		return true;
	}
	var reg = /^\d+(\.\d{0,2})?$/;
	if (decimals == 3) {
		reg = /^\d+(\.\d{0,3})?$/;
	} else if (decimals == 4) {
		reg = /^\d+(\.\d{0,4})?$/;
	} 

	if (!reg.test(_value)) {
		Dialog.alert(info + "输入有误，请重新输入，小数点后最多输入" + decimals + "位!", function() {
			o.value = "";
			return false;
		});
	}
	return true;
}

function limitInputForInt(o, info) {
	var _value = o.value;
	if (_value == null || StringTrim(_value) == "") {
		return true;
	}
	var reg = /^\d+(\.\d{0,2})?$/;

	if (!reg.test(_value)) {
		Dialog.alert(info + "输入有误，请重新输入，只能为数字!", function() {
			o.value = "";
			return false;
		});
	}
	return true;
}

function jumpToLoginPage() {
	window.open('Login.jsp', '_top');
}

function toSearch(formId, queryAction) {
	var form = document.getElementById(formId);
	if (form.page != undefined) {
		form.page.value = 1;
	}
	form.action = queryAction;
	form.submit();
}

function topage(page, actionName) {
    var form = document.forms[0];
    form.page.value = page; 
    form.action = actionName;
    form.submit(); 
}

function resetSearch(formId, queryAction) {
	var form = document.getElementById(formId);
	var specialSel = document.getElementById("numPrePageId");
	var v = form.elements;
	for (var i = 0; i < v.length; i++) {
		if (v[i].type == "text" || v[i].type == "checkbox") {
			v[i].value = "";
		} else if (v[i].type == "select-one") {
			if (v[i] == specialSel) {
				continue;
			}
			v[i].options[0].selected = true;
		} 
	}
	toSearch(formId, queryAction);
}

$(document).ready(function() {
	$("#greenHouseGetId").bind({
		mouseenter : function(e) {
			$.ajax({
				type : "post",
				url : "getAllGreenHouseInfo.action",
				async : true,
				dataType : "json",
				success : function(data) {
					var msg = data[0].message;
					if (msg == "relogin") {
						jumpToLoginPage();
					} else if (msg == "success") {
						for (var i = 1; i < data.length; i++) {
							$("#greenHouseUlId").append("<li><a href=\"getGreenHouseInfo.action?id=" + data[i].id + "\">" 
									 + data[i].name + "</a></li>");
						}
						
						$("#greenHouseGetId").unbind('mouseenter').unbind('mouseleave');
					} else {
						Dialog.alert(msg);
					}
				},
				error : function(msg) {
					ajaxFail(msg);
				}
			});	
		},
		mouseleave : function(e) {
		},
		click : function(e) {
		}
	});
});	

function ajaxFail(msg) {
	if (msg.statusText.indexOf("NetworkError") >= 0) {
		Dialog.alert("连接服务器失败，请稍后重试！");
	} else {
		Dialog.alert("系统错误！" + msg.statusText);
	}	
}

function toRunFunctionAfterLogin(functionName) {
	$("#passwordId").val('');
	$("#passwordId").focus();
	
	var diag = new Dialog();
	diag.Width = 240;
	diag.Height = 80;
	diag.Title = "请输入密码";
	diag.InvokeElementId="pwdDivId";
	diag.OKEvent = function() {
		var password = $("#passwordId").val();
		if (password == null || StringTrim(password) == "") {
	    	Dialog.alert("请输入密码!", function(){$("#passwordId").focus();});
	        return false;   
	    }
        
        var postData = {
			"password" : password
		};
		$.ajax({
			type : "post",
			url : "verifyPassword.action",
			async : false,
			dataType : "json",
			data : postData,
			success : function(data) {
				var msg = data[0].message;
				if (msg == "success") {
					diag.close();
					functionName(true);
				} else {
					Dialog.alert(msg, function () {
						$("#passwordId").focus();
					});
				}
			},
			error : function(msg) {
				ajaxFail(msg);
			}
		});	
	}; 
	diag.show();
}

function gotoSearch(queryAction) {
	var form = document.forms[0];
	if (form.page != undefined) {
		form.page.value = 1;
	}
	form.action = queryAction;
	form.submit();
}

function toResetSearch(queryAction) {
	var form = document.forms[0];
	var specialSel = document.getElementById("numPrePageId");
	var v = form.elements;
	for (var i = 0; i < v.length; i++) {
		if (v[i].type == "text" || v[i].type == "checkbox") {
			v[i].value = "";
		} else if (v[i].type == "select-one") {
			if (v[i] == specialSel) {
				continue;
			}
			v[i].options[0].selected = true;
		}
	}
	gotoSearch(queryAction);
}

function checkTextValid(elementId, confirmInfo) {
	var textVal = $("#" + elementId).val();	
    if (textVal == null || StringTrim(textVal) == "") {
        Dialog.alert("请输入" + confirmInfo + "!", function(){$("#" + elementId).focus();});		        
        return false;
    }
    return true;
}

function checkSelectValid(elementId, confirmInfo) {    
    if (document.getElementById(elementId).selectedIndex == 0) {
    	Dialog.alert("请选择" + confirmInfo + "!", function(){$("#" + elementId).focus();});
        return false;
    }
    return true;
}


// ajax通用post函数，自动添加token
function doAjaxWithToken(postData, url, successFun, failFun) {    
	postData.token = sessionStorage.alToken;
	
	$.ajax({
		type : "post",
		url : url,
		async : false,
		dataType : "json",
		data : postData,
		success : function(data) {
			var msg = data[0].message;
			if (msg == "success" || msg == "add") {				
				if (successFun) {
					successFun(data);
				}
			} else {
				Dialog.alert(msg, function() {
					if (failFun) {
						failFun();
					}
				});
			}
		},
		error : function(msg) {
			ajaxFail(msg);
		}
	});	    		    
    return true;
}
