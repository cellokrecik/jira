package com.example.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private Long projectId;
    private String projectName;
    private String projectKey;
    private String projectTypeKey;
    private String avatarURI;
    private String name;

}
