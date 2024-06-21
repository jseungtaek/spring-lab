package com.st.seungtaekspringlab.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserCustomExceptionHandler {

    @ExceptionHandler(UserCustomException.class)
    protected ResponseEntity<UserErrorResponseEntity> handlerCustomException(UserCustomException userCustomException) {
        return UserErrorResponseEntity.responseEntity(userCustomException.getErrorType());
    }
}
