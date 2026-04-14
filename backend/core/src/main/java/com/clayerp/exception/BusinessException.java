package com.clayerp.exception;

public abstract class BusinessException extends RuntimeException {

    private final String messageKey;
    private final Object[] params;

    public BusinessException(String messageKey, Object... params) {
        super(messageKey);
        this.messageKey = messageKey;
        this.params = params;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public Object[] getParams() {
        return params;
    }

}
