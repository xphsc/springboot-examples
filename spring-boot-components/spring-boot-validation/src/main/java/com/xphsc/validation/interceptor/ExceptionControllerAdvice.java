package com.xphsc.validation.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xphsc.validation.exception.ParamValidException;
import com.xphsc.validation.exception.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@RestControllerAdvice
public class ExceptionControllerAdvice  {

    @ExceptionHandler(ParamValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object paramValidExceptionHandler(ParamValidException ex, HttpServletResponse response) {
        JSONObject jsonpObject = new JSONObject();
        jsonpObject.put("msg", ValidationErrors.INVALID_PARAMS.getMsg());
        jsonpObject.put("status", 200);
        jsonpObject.put("data", ex.getFieldErrors());
        jsonpObject.put("code", ValidationErrors.INVALID_PARAMS.getCode() );
        return jsonpObject;
    }

    @ExceptionHandler(BindException.class)
    public Object bindExceptionHandler(BindException ex, HttpServletResponse response) {
        return paramValidExceptionHandler(new ParamValidException(ex), response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Object constraintViolationExceptionHandler(ConstraintViolationException ex, HttpServletResponse response, HandlerMethod handlerMethod) {
        return paramValidExceptionHandler(new ParamValidException(ex, handlerMethod.getMethodParameters()), response);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object constraintViolationExceptionHandler(MethodArgumentNotValidException ex, HttpServletResponse response, HandlerMethod handlerMethod) {
        return paramValidExceptionHandler(new ParamValidException(ex, handlerMethod.getMethodParameters()), response);
    }




}