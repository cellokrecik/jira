package com.example.jira.jiraService;

import com.example.jira.WireMockConfig;
import com.example.jira.IssuesMocks;
import com.example.jira.client.JiraClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
public class JiraClientIntegrationTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private JiraClient jiraClient;

    @BeforeEach
    void setUp() throws IOException {
        IssuesMocks.setupMockIssuesResponse(wireMockServer);
    }

    @Test
    public void whenGetIssues_thenIssuesShouldBeReturned() {
        assertFalse(jiraClient.getAllIssuesByEpicKey("IFZ-614").isEmpty());
    }

    @Test
    public void whenGetIssues_thenResultContainsTheCustomfield_11000() {

        String issues = jiraClient.getAllIssuesByEpicKey("IFZ-614");
        assertTrue(issues.contains("customfield_11000"));
    }
}
