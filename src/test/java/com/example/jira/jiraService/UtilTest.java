package com.example.jira.jiraService;

import org.junit.jupiter.api.Test;


import static com.example.jira.TestData.getTShirtSizes;
import static com.example.jira.jiraService.Utils.getIssuesTShirtSizes;
import static com.example.jira.service.Utils.calculate;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    void checkingCalculateMethod() {
        double calculatedValue = calculate(getTShirtSizes(), getIssuesTShirtSizes());
        assertNotNull(calculatedValue, "Calculated value must be not null.");
        assertEquals(2.5, calculatedValue, "Calculated value is not as expected.");
    }
}
