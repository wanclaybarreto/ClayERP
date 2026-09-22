package com.clayerp.dto;

import java.time.Instant;

public class ApiResponse<T> {

    private boolean success;
    private T data;
    private Instant timestamp;

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
        timestamp = Instant.now();
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
