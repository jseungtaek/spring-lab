package com.st.seungtaekspringlab.user.exception;

import com.st.seungtaekspringlab.user.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCustomException extends RuntimeException {
    ErrorType errorType;



}
