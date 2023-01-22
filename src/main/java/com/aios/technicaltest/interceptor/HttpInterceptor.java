package com.aios.technicaltest.interceptor;

import com.aios.technicaltest.exceptions.CustomException;
import com.aios.technicaltest.exceptions.ExceptionDto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HttpInterceptor extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity businessException(HttpServletRequest request, final CustomException e) {
        
        ExceptionDto dto = new ExceptionDto(request.getServletPath(), e.getException().getMessage());
        return new ResponseEntity(dto.getErrormessage(), e.getException().getStatus());
    }
}
