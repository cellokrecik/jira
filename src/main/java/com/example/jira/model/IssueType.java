package com.example.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueType {

    private String id;
    private String self;
    private String description;
    private String name;
    private String iconUrl;
    private boolean subtask;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    private Long avatarId;
    private Long hierarchyLevel;

}
