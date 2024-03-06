package com.example.crud.Exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message, int statusCode)
    {
        super(message,statusCode);
    }
}
