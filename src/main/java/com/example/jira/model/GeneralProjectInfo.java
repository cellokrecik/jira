package com.example.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Jacksonized
@Builder
public class GeneralProjectInfo {

    private String id;
    private String self;
    private String key;
    private Map<String, String> avatarUrls;
    private Map<String, String> projectCategory;
}
