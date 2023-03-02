package com.example.jira.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Epic {

    private Long id;
    private String self;
    private String key;

}
