package com.msbautista.mockapi.exception;

abstract public class RejectException extends Exception {
    protected RejectException(String message) {
        super(message);
    }
}
