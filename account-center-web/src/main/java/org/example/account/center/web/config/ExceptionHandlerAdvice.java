package org.example.account.center.web.config;


import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import com.tove.web.infra.common.BaseErrorCode;
import com.tove.web.infra.common.BaseException;
import com.tove.web.infra.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.account.center.api.common.AccountErrorCode;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = NotLoginException.class)
    public Response<?> exception(NotLoginException exception, HandlerMethod handlerMethod, HttpServletResponse response){
        log.warn("{} WeTagException : {}", handlerMethod.getMethod(), exception.getMessage());
        return Response.getFail(AccountErrorCode.NO_LOGIN);
    }

    @ExceptionHandler(value = BaseException.class)
    public Response<?> exception(BaseException exception, HandlerMethod handlerMethod, HttpServletResponse response){
        log.warn("{} WeTagException : {}", handlerMethod.getMethod(), exception.getMsg());
        return Response.getFail(exception.getCode(), exception.getMsg());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response<?> exception(MethodArgumentNotValidException exception, HandlerMethod handlerMethod, HttpServletResponse response){
        log.warn("{} MethodArgumentNotValidException : {}", handlerMethod.getMethod(), exception.getMessage());
        return Response.getFail("4444", exception.getMessage());
    }

    @ExceptionHandler(value = SaTokenException.class)
    public Response<?> exception(SaTokenException exception, HandlerMethod handlerMethod, HttpServletResponse response){
        log.warn("{} MethodArgumentNotValidException : {}", handlerMethod.getMethod(), exception.getMessage());
        return Response.getFail("4444", exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Response<?> exception(Exception exception, HandlerMethod handlerMethod, HttpServletResponse response){
        log.warn("{} Exception : {}", handlerMethod.getMethod(), exception);
        return Response.getFail(BaseErrorCode.SYSTEM_BUSY);
    }
}
