package com.clayerp.exception;

public class ValidationException extends BusinessException {

    public ValidationException(String messageKey) {
        super(messageKey);
    }

}
