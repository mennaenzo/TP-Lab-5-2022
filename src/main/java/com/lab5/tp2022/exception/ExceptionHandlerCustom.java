package com.lab5.tp2022.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerCustom {
    @ExceptionHandler(value = {HttpClientErrorException.class})
    protected ResponseEntity<Object> handleHttpClientErrorException(final HttpClientErrorException ex, final WebRequest request){
        return new ResponseEntity(ErrorBody.builder()
                .code(ex.getStatusCode().value())
                .message(ex.getStatusText())
                .build(), ex.getStatusCode());
    }
}
