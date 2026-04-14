package com.clayerp.exception;

import com.clayerp.dto.ErrorResponse;
import com.clayerp.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageService messageService;

    public GlobalExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(NotFoundException ex) {

        return new ErrorResponse(
                messageService.get(ex.getMessageKey(), ex.getParams())
        );

    }

    @ExceptionHandler(RuleViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleRuleViolation(RuleViolationException ex) {

        return new ErrorResponse(
                messageService.get(ex.getMessageKey(), ex.getParams())
        );

    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(ValidationException ex) {

        return new ErrorResponse(
                messageService.get(ex.getMessageKey(), ex.getParams())
        );

    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBusiness(BusinessException ex) {

        return new ErrorResponse(
                messageService.get(ex.getMessageKey(), ex.getParams())
        );

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneric(Exception ex) {

        return new ErrorResponse(messageService.get("system.internal.error"));

    }

}
