package com.example.user.exception;

public class UserErrorResponse {
    private int status;

    private String message;


    public UserErrorResponse() {
    }

    public UserErrorResponse(String message, int status) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
