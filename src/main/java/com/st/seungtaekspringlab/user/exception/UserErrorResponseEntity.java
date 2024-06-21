package com.st.seungtaekspringlab.user.exception;

import com.st.seungtaekspringlab.user.enums.ErrorType;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class UserErrorResponseEntity {

    private int status;
    private String code;
    private String message;

    public static ResponseEntity<UserErrorResponseEntity> responseEntity(ErrorType errorType) {
        return ResponseEntity
                .status(errorType.getHttpStatus())
                .body(UserErrorResponseEntity.builder()
                        .status(errorType.getHttpStatus().value())
                        .code(errorType.name())
                        .message(errorType.getMessage())
                        .build());
    }
}
