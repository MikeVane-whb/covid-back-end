package com.mikevane.covid.exception;

import lombok.Getter;

/**
 * Object 相关的 exception
 * @author: whb
 * @date: 2023-04-08-11-19
 * @version: 1.0
 */
@Getter
public class ObjectException extends RuntimeException {
    private String code;
    private String reason;
    public ObjectException(String code, String msg){
        super(msg);
        this.code = code;
    }

    public ObjectException(String code, String msg, String reason){
        super(msg);
        this.code = code;
        this.reason = reason;
    }
}
