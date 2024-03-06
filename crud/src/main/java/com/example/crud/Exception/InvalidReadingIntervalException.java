package com.example.crud.Exception;

public class InvalidReadingIntervalException extends Exception {
    public InvalidReadingIntervalException(String message, int statusCode) {
        super(message, statusCode);
    }
}
