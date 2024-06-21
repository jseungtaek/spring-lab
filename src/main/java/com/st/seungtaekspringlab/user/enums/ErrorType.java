package com.st.seungtaekspringlab.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

    /**
     * ERROR 404
     * 찾을 수 없는 유저
     */
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_EXCEPTION_404","해당 유저를 찾을 수 없습니다. "),

    /**
     * ERROR 401
     * 패스워드 불일치
     */
    PASSWORD_INVALID(HttpStatus.BAD_REQUEST, "USER_EXCEPTION_401","비밀번호가 일치하지 않습니다. "),


    /**
     * ERROR 409
     * 이미 가입된 이메일로 가입 시도
     */
    USER_DUPLICATE(HttpStatus.CONFLICT, "USER_EXCEPTION_409","이미 가입된 이메일 입니다. "),


    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ErrorType(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
