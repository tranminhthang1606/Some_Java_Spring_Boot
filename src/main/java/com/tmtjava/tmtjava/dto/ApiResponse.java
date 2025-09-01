package com.tmtjava.tmtjava.dto;

public class ApiResponse<T> {
    private String message;
    private int code;
    private String status;
    private T data;

    public ApiResponse() {}

    public ApiResponse(String message, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public ApiResponse(String message, int code, String status, T data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
