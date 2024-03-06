package com.example.crud.Exception;

public class Exception extends RuntimeException{
    public final String message;
    public final int statusCode;
    public Exception(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
