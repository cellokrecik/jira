package com.example.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {

    private Long id;
    private String self;
    private String name;
    private String type;
    private Location location;

}
