package com.clayerp.dto;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private boolean success;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
        timestamp = LocalDateTime.now();
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
