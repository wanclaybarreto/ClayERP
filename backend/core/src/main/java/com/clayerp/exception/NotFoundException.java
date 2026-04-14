package com.clayerp.exception;

public class NotFoundException extends BusinessException {

    public NotFoundException(String messageKey) {
        super(messageKey);
    }

}
