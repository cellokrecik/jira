package com.example.jira.jiraService;

import com.example.jira.model.GeneralProjectInfo;
import com.example.jira.model.TShirtSize;
import com.example.jira.model.TShirtSizeName;

import java.util.List;
import java.util.Map;

import static com.example.jira.TestData.KEY_1;
import static com.example.jira.TestData.ID_1;
import static com.example.jira.TestData.SELF_1;

public class Utils {

    protected static List<GeneralProjectInfo> getProjectsList() {
        return List.of(GeneralProjectInfo.builder()
                .id(ID_1)
                .self(SELF_1)
                .key(KEY_1)
                .avatarUrls(Map.of("key_1", "value_1", "key_2", "value_2"))
                .projectCategory(Map.of("key_1", "value_1", "key_2", "value_2"))
                .build());
    }

    protected static Map<String, String> getIssuesTShirtSizes() {
        return Map.of("customfield_1", "M", "customfield_2", "L");
    }

    protected static String ISSUES_BY_EPIC_KEY = "{\"expand\":\"schema,names\",\"startAt\":0,\"maxResults\":50,\"total\":2,\"issues\":[{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\"id\":\"26966\",\"self\":\"https://ocadotech.atlassian.net/rest/agile/1.0/issue/26966\",\"key\":\"IFZ-649\",\"fields\":{\"customfield_11000\":\"M\"}},{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\"id\":\"26966\",\"self\":\"https://ocadotech.atlassian.net/rest/agile/1.0/issue/26966\",\"key\":\"IFZ-649\",\"fields\":{\"customfield_11000\":\"S\"}}]}";
}
