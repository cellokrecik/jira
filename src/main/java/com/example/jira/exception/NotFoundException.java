package com.example.jira.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String input) {
        super(input + " were not found.");
    }
}
