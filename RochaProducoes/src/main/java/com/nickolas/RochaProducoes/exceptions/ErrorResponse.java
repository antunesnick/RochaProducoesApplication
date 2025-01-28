package com.nickolas.RochaProducoes.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {
    private final int status;
    private final String message;
    private String stackTrace;
    private List<ValidationError> errors;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    public void addValidationError(String field, String message) {
        if(Objects.isNull(errors)){
            this.errors = new ArrayList<>();
        }
        this.errors.add(new ValidationError(field, message));
    }


    private static class ValidationError {
        private String field;
        private String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
