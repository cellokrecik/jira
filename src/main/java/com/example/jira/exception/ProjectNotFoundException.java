package com.example.jira.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String id) {
        super(String.format("Project with Id %s not found", id));
    }
}
