package com.face.common;

import lombok.Getter;

@Getter
public class FaceException extends RuntimeException {
    private ResultCode resultCode;
    public FaceException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
