package com.example.jira.exception;

public class EpicsNotFoundException extends RuntimeException {

    public EpicsNotFoundException(String boardId) {
        super(String.format("Epics with board id %s not found", boardId));
    }
}
