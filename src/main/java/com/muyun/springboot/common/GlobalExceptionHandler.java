package com.muyun.springboot.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 *
 * @author muyun
 * @date 2020/4/22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> messages = e.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).collect(Collectors.toList());

        log.error("请求参数校验失败:{}", messages);
        return Response.error(messages);
    }

    @ExceptionHandler(Exception.class)
    public Response<String> handleException(Exception e) {
        return Response.error(e.getMessage());
    }
}