package com.clayerp.dto;

import java.time.Instant;

public class ErrorResponse {

    private boolean success;
    private String message;
    private Instant timestamp;

    public ErrorResponse(String message) {
        success = false;
        this.message = message;
        timestamp = Instant.now();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

}
