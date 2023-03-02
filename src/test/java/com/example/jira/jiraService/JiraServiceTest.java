package com.example.jira.jiraService;
import com.example.jira.client.JiraClient;
import com.example.jira.exception.IssuesNotFoundException;
import com.example.jira.exception.NotFoundException;
import com.example.jira.model.GeneralProjectInfo;
import com.example.jira.model.IssuesList;
import com.example.jira.service.TShirtSizeService;
import com.example.jira.service.JiraService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.example.jira.TestData.getTShirtSizes;
import static com.example.jira.jiraService.Utils.ISSUES_BY_EPIC_KEY;
import static com.example.jira.jiraService.Utils.getProjectsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class JiraServiceTest {

    @Mock
    private JiraClient jiraClient;
    @Mock
    private TShirtSizeService tShirtSizeService;
    @InjectMocks
    private JiraService jiraService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void whenGetAllProjects_ProjectsAreReturned() throws JsonProcessingException {
        when(jiraClient.getAllProjects()).thenReturn(mapper.writeValueAsString(getProjectsList()));

        List<GeneralProjectInfo> result = jiraService.getAllProject();

        assertNotNull(result, "Result must be not null.");
        assertEquals(1, result.size(), "Projects list's size is not as expected.");
        assertEquals("id_1", result.get(0).getId(), "Project ID is not as expected.");
    }

    @Test
    void whenGetAllProjects_ThrowsNotFoundExcpetion() {
        when(jiraClient.getAllProjects()).thenThrow(new NotFoundException("Projects"));

        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> {
            jiraService.getAllProject();
        });

        assertNotNull(exception, "Result must be not null.");
        assertEquals("Projects were not found.", exception.getMessage(), "Msg of exception is not as expected.");
    }

    @Test
    void whenGetAllIssuesFromJira_IssuesByEpicKeyAreReturned() throws JsonProcessingException {
        when(jiraClient.getAllIssuesByEpicKey("epicKey")).thenReturn(ISSUES_BY_EPIC_KEY);
        when(tShirtSizeService.getAllTShirtSizes()).thenReturn(getTShirtSizes());

        IssuesList result = jiraService.getAllIssuesByEpicKey("epicKey");

        assertNotNull(result, "Result must be not null.");
        assertEquals(1.6, result.getWeightOfIssuesInTheEpic(), "Weight of issues in the epic is not as expected.");
    }

    @Test
    void whenGetAllIssuesFromJira_ThrowsIssuesNotFoundException() throws JsonProcessingException {
        when(jiraClient.getAllIssuesByEpicKey("epicKey")).thenReturn("");

        IssuesNotFoundException exception = Assertions.assertThrows(IssuesNotFoundException.class, () -> {
            jiraService.getAllIssuesByEpicKey("epicKey");
        });

        assertNotNull(exception, "Result must be not null.");
        assertEquals("Issues with epic key epicKey not found", exception.getMessage(), "Msg of exception is not as expected.");
    }
}
