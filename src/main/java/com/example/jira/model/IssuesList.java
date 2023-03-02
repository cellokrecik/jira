package com.example.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssuesList {

    private Long total;
    private double weightOfIssuesInTheEpic;
    private List<Issue> issues;

}
