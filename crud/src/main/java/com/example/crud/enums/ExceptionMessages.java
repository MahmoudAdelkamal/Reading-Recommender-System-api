package com.example.crud.enums;

public enum ExceptionMessages {
    BOOK_NOT_FOUND("NOT FOUND BOOK");

    public final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
}
