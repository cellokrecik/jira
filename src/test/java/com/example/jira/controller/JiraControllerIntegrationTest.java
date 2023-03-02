package com.example.jira.controller;

import com.example.jira.service.JiraService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.jira.controller.Utils.getIssuesList;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.mockito.BDDMockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = JiraController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class JiraControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JiraService jiraService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void whenPostEmployee_thenCreateEmployee() throws Exception {

        given(jiraService.getAllIssuesByEpicKey("IFZ-614")).willReturn(getIssuesList());

        mvc.perform(get("/issue/IFZ-614")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", aMapWithSize(3)))
                        .andExpect(jsonPath("$.total", is(2)))
                        .andExpect(jsonPath("$.weightOfIssuesInTheEpic", is(2.0)));

        verify(jiraService, VerificationModeFactory.times(1)).getAllIssuesByEpicKey("IFZ-614");
        reset(jiraService);
    }
}
