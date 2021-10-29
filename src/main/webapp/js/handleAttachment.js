function resetFileCtrl(fileId) {
	var file = document.getElementById(fileId);	
	if (file.outerHTML) {	// for IE, Opera, Safari, Chrome
		file.outerHTML = file.outerHTML;
	} else {	// for FF(包括3.5)
		file.value = "";
	}
}

function clearFile(fileId) {
	$("#picShowId").attr('src', "");	
	$("#picSrcFileId").val("");
	
	resetFileCtrl(fileId);

	$("#pisHasId").hide();
	$("#pisNoneId").show();
}

function onSelectPic(file) {
	var str = file.value;
	if (str != null && str !== "") {
		var type = str.substring(str.lastIndexOf(".") + 1, str.length);
		if (!(type == "jpg" || type == "bmp" || type == "png" || type == "JPG" || type == "BMP" || type == "PNG"))
		{
			Dialog.alert("图片类型不支持！");
			file.value = "";
			return false;
		}
		
		if (file.files[0].size > 104857600) {
			Dialog.alert("图片大小大于100MB！");
			file.value = "";
			return false;
		}
		
		$("#pisHasId").show();
		$("#pisNoneId").hide();
		
		var reader = new FileReader();  
		reader.onload = function(evt) {  
			$("#picShowId").attr('src' , evt.target.result);
		}    
		reader.readAsDataURL(file.files[0]);  
	} 

	return true;
}

function showSelFile() {
	$("#picShowId").attr('src', "");		
	resetFileCtrl("picSelId");
	$("#pisNoneId").show();
	$("#pisHasId").hide();
}

function hideSelFile() {
	resetFileCtrl("picSelId");
	$("#pisNoneId").hide();
	$("#pisHasId").show();
}
