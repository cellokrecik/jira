package com.example.jira.client;


import com.example.jira.config.JiraConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jira", url = "${jira.api.baseUrl}", configuration = JiraConfig.class)
public interface JiraClient {

    @GetMapping("/api/3/project")
    String getAllProjects();

    @GetMapping("/api/3/project/{id}")
    String getProjectById(@PathVariable("id") String id);

    @GetMapping("/agile/1.0/board")
    String getAllBoards();

    @GetMapping("/agile/1.0/board/{boardId}/epic")
    String getAllEpicsByBoardId(@PathVariable("boardId") String boardId);

    @GetMapping("/agile/1.0/epic/{epicKey}/issue")
    String getAllIssuesByEpicKey(@PathVariable("epicKey") String epicKey);
}
