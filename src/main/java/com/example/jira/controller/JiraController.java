package com.example.jira.controller;

import com.example.jira.model.EpicList;
import com.example.jira.model.GeneralProjectInfo;
import com.example.jira.model.SingleProjectInfo;
import com.example.jira.model.BoardsList;
import com.example.jira.model.IssuesList;
import com.example.jira.service.JiraService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping
public class JiraController {

    private final JiraService jiraService;

    @GetMapping("/project")
    public List<GeneralProjectInfo> getProjects() throws JsonProcessingException {
        return jiraService.getAllProject();
    }

    @GetMapping("/project/{id}")
    public SingleProjectInfo getProjects(@PathVariable("id") String id) throws JsonProcessingException {
        return jiraService.getProject(id);
    }

    @GetMapping("/board")
    public BoardsList getBoards() throws JsonProcessingException {
        return jiraService.getAllBoards();
    }

    @GetMapping("/issue/{epicKey}")
    public IssuesList getIssuesByEpicKey(@PathVariable("epicKey") String epicKey) throws JsonProcessingException {
        return jiraService.getAllIssuesByEpicKey(epicKey);
    }

    @GetMapping("/epic/{boardKey}")
    public EpicList getEpicsByBoardKey(@PathVariable("boardKey") String boardKey) throws JsonProcessingException {
        return jiraService.getAllEpicsByBoardId(boardKey);
    }
}
