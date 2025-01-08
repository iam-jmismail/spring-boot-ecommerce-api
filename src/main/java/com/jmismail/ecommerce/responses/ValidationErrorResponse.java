package com.jmismail.ecommerce.responses;

import java.util.Map;

public class ValidationErrorResponse {
    private Map<String, String> errors;

    public ValidationErrorResponse(Map<String, String> errors){
        this.errors = errors;
    }

    public Map<String, String> getErrors(){
        return  this.errors;
    }

    public void setErrors(Map<String, String> errors){
        this.errors = errors;
    }
}
