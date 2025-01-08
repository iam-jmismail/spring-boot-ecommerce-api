package com.jmismail.ecommerce.responses;

public class ErrorResponse {
    private  String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return error;
    }

    public void setErrorMessage(String error) {
        this.error = error;
    }
}
