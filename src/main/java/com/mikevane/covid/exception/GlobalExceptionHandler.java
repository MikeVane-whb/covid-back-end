package com.mikevane.covid.exception;

import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理 handler
 * @author: whb
 * @date: 2023-03-02-18-20
 * @version: 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获 ServiceException 异常
     * @param serviceException
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceExceptionHandle(ServiceException serviceException){
        log.error(serviceException.getMessage());
        return Result.error(serviceException.getCode(), serviceException.getMessage());
    }

    /**
     * 捕获 ObjectException 异常
     * @param objectException
     * @return
     */
    @ExceptionHandler(ObjectException.class)
    @ResponseBody
    public Result objectExceptionHandle(ObjectException objectException){
        log.error(objectException.getMessage());
        if (objectException.getReason() != null){
            log.error(objectException.getReason());
        }
        return Result.error(objectException.getCode(), objectException.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result nullPointerHandler(NullPointerException nullPointerException){
        log.error("空指针异常");
        log.error(nullPointerException.getMessage());
        return Result.error(ErrorCodeEnum.SERVER_ERROR.getCode(), ErrorCodeEnum.SERVER_ERROR.getMsg());
    }
}
