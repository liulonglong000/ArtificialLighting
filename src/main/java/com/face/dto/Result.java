package com.face.dto;

import com.face.common.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    /**
     * 操作成功Result
     */
    public Result() {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
    }
    /**
     * 操作成功Result
     */
    public Result(String msg,String flag) {
       
        this.msg = msg;
    }
    /**
     * 自定义Result状态
     * @param resultCode
     */
    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 操作成功Result，且指定数据
     * @param data
     */
    public Result(T data) {
    	
        this();
        this.data = data;
    }

	
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
    
}
