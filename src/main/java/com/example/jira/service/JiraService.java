package com.example.jira.service;

import com.example.jira.client.JiraClient;
import com.example.jira.exception.NotFoundException;
import com.example.jira.exception.EpicsNotFoundException;
import com.example.jira.exception.ProjectNotFoundException;
import com.example.jira.exception.IssuesNotFoundException;
import com.example.jira.mapper.Mapper;
import com.example.jira.model.GeneralProjectInfo;
import com.example.jira.model.SingleProjectInfo;
import com.example.jira.model.BoardsList;
import com.example.jira.model.IssuesList;
import com.example.jira.model.EpicList;
import com.example.jira.model.TShirtSize;
import com.example.jira.model.Issue;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.jira.service.Utils.calculate;

@Service
@RequiredArgsConstructor
@Slf4j
public class JiraService {

    private final JiraClient jiraClient;
    private final TShirtSizeService tShirtSizeService;

    public List<GeneralProjectInfo> getAllProject() throws JsonProcessingException {
        String projects = jiraClient.getAllProjects();
        if (projects != null && !projects.isBlank()) {
            return Mapper.mapToListOfProjects(projects);
        }
        throw new NotFoundException("Projects");
    }

    public SingleProjectInfo getProject(String id) throws JsonProcessingException {
        String project = jiraClient.getProjectById(id);
        if (project != null && !project.isBlank()) {
            return Mapper.mapToSingleProjectInfo(project);
        }
        throw new ProjectNotFoundException(id);
    }

    public BoardsList getAllBoards() throws JsonProcessingException {
        String boards = jiraClient.getAllBoards();
        if (boards != null && boards.isBlank()) {
            return Mapper.mapToListOfBoards(jiraClient.getAllBoards());
        }
        throw new NotFoundException("Boards");
    }

    public IssuesList getAllIssuesByEpicKey(String epicKey) throws JsonProcessingException {
        String issuesByEpicKey = jiraClient.getAllIssuesByEpicKey(epicKey);
        if (issuesByEpicKey != null && !issuesByEpicKey.isBlank()) {
            IssuesList result = Mapper.mapToListOfIssuesByEpicKey(issuesByEpicKey);
            double sumOfIssuesWeightsInTheEpic = 0;
            for (Issue issue : result.getIssues()) {
                sumOfIssuesWeightsInTheEpic += calculateWeightOfIssues(issue);
            }
            result.setWeightOfIssuesInTheEpic(sumOfIssuesWeightsInTheEpic);
            return result;
        }
        throw new IssuesNotFoundException(epicKey);
    }

    public EpicList getAllEpicsByBoardId(String boardId) throws JsonProcessingException {
        String allEpicsByBoardId = jiraClient.getAllEpicsByBoardId(boardId);
        if (allEpicsByBoardId != null && !allEpicsByBoardId.isBlank()) {
            return Mapper.mapToListOfEpicByBoardId(allEpicsByBoardId);
        }
        throw new EpicsNotFoundException(boardId);
    }

    private double calculateWeightOfIssues(Issue issue) {
        AtomicReference<Double> weightOfIssue = new AtomicReference<>((double) 0);
        List<TShirtSize> allTShirtSizes = tShirtSizeService.getAllTShirtSizes();
        Map<String, String> fields = issue.getFields();
        if (fields != null) {
            return calculate(allTShirtSizes, fields);
        }
        return weightOfIssue.get();
    }
}
