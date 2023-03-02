package com.example.jira.exception;

public class IssuesNotFoundException extends RuntimeException {

    public IssuesNotFoundException(String epicKey) {
        super(String.format("Issues with epic key %s not found", epicKey));
    }
}
