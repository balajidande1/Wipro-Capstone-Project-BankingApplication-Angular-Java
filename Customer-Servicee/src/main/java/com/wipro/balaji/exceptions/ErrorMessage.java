package com.wipro.balaji.exceptions;


public class ErrorMessage {
    private String error;
    private String message;

    public ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }

    // getters & setters
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

