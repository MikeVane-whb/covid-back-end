package com.mikevane.covid.exception;

import lombok.Getter;

/**
 * @author: whb
 * @date: 2023-03-02-16-12
 * @version: 1.0
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;
    public ServiceException(String code, String msg){
        super(msg);
        this.code = code;
    }
}
