package com.adu.springboot.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 设置全局异常处理类
 */
@ControllerAdvice(basePackages = {"com.adu.springboot.controller"})
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorResult() {
        Map<String,Object> errorResultMap = new HashMap<>(10);
        errorResultMap.put("code","500");
        errorResultMap.put("message","系统错误!");
        return errorResultMap;
    }
}
