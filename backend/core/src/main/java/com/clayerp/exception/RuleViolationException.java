package com.clayerp.exception;

public class RuleViolationException extends BusinessException {

    public RuleViolationException(String messageKey, Object... params) {
        super(messageKey, params);
    }

}
