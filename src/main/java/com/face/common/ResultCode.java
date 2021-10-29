package com.face.common;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS("0000", "success"),
    SERVER_ERR("0001", "服务器内部错误！"),
    PARAM_ERR("002", "参数错误"),
    UNLOGIN("0003", "请先登录！"),
    USERNAME_PASSWORD_ERR("0004", "用户名或密码错误！"),
    REGION_ID_ERR("0005", "区域ID不存在"),
    CAMERA_ID_ERR("0006", "摄像头ID不存在"),
    REGION_HAS_CAMERA("0007", "所选区域下有摄像头，不能删除该区域"),
    REGION_PARENT_UNEXIST("0008", "父节点区域不存在"),
    REGION_NEAME_REPEAT("0009", "父节点下已有重名区域，情检查！"),
    CAMERA_ONLINE("0010", "有在线状态的摄像头，不能删除！"),
    CAPTURE_SERVER_ID_ERR("011", "抓拍服务器ID不存在！"),
	IDCARD_ERR("0012", "身份证信息输入有误"),
    CONTROL_REGSTORGE_ERR("0013", "获取低库信息为空"),
    HTTP_ERR("0014", "调用远程服务器出现错误"),
    WEBFRONT_ERR("0015", "前端传值错误"),
    STORAGE_WITH_DISPLAY("0016", "人像库已布控，不能删除"),
    CONTROL_UNEXIST("0017", "布控不存在"),
    REMOVE_USING_CONTROL("0018", "处于布控状态，不能删除"),
    RESULT_OUT_OF_SIZE("0019", "结果集记录数超过最大值范围！"),
    IP_NOTONLY_ERR("0020", "uri重复，请检查"),
    OLD_PASSWORD_ERROR("0021", "旧密码错误，请重新输入！"),
	RESULT_OERROR("0022", "相关数据不存在"),
	ERR_RESULT("0023", "数据已更新，请刷新页面重试"), 
	EXCEL_ERR("0024", "导出时数据量过大，请重试"),
	NUM_NOTONLY_ERR("0025", "像机编号不能重复，请检查"),
	RESERNUM_NOTONLY_ERR("0026", "识别服务器编号不能重复，请检查"),
	PENUM_NOTONLY_ERR("0027", "图像服务器编号不能重复，请检查"),
    DEPT_DUPLICATE_ERR("0028", "机构代码不能重复，请检查"),
    USER_DUPLICATE_ERR("0029", "用户帐号不能重复，请检查"),
    PEIP_NOTONLY_ERR("0030", "图像服务器IP地址不能重复，请检查"),
	READRE_NOTONLY_ERR("0031", "识别服务器地址不能重复，请检查");
    private String code;
    private String msg;
    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
	
    
}
