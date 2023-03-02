package com.example.jira.controller;

import com.example.jira.model.IssuesList;
import com.example.jira.model.Issue;

import java.util.List;
import java.util.Map;

import static com.example.jira.TestData.ID_1;
import static com.example.jira.TestData.ID_2;
import static com.example.jira.TestData.KEY_1;
import static com.example.jira.TestData.KEY_2;
import static com.example.jira.TestData.EXPAND_1;
import static com.example.jira.TestData.EXPAND_2;
import static com.example.jira.TestData.SELF_1;
import static com.example.jira.TestData.SELF_2;

public class Utils {

    protected static IssuesList getIssuesList() {
        Issue issue_1 = new Issue();
        issue_1.setId(ID_1);
        issue_1.setSelf(SELF_1);
        issue_1.setKey(KEY_1);
        issue_1.setExpand(EXPAND_1);
        issue_1.setFields(Map.of("customfield_11000", "M"));

        Issue issue_2 = new Issue();
        issue_2.setId(ID_2);
        issue_2.setSelf(SELF_2);
        issue_2.setKey(KEY_2);
        issue_1.setExpand(EXPAND_2);
        issue_2.setFields(Map.of("customfield_11000", "M"));

        IssuesList issuesList = new IssuesList();
        issuesList.setTotal(2L);
        issuesList.setWeightOfIssuesInTheEpic(2.0);
        issuesList.setIssues(List.of(issue_1, issue_2));

        return issuesList;
    }
}
