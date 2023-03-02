package com.example.jira.model;

import com.example.jira.deserializer.JsonObjectListDeserializer;
import com.example.jira.deserializer.JsonObjectMapDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Jacksonized
@Builder
public class SingleProjectInfo {

    private String id;
    private String self;
    private String key;
    @JsonProperty("issueTypes")
    @JsonDeserialize(using = JsonObjectListDeserializer.class)
    private List<IssueType> issueTypes;
    @JsonProperty("lead")
    @JsonDeserialize(using = JsonObjectMapDeserializer.class)
    private Map<String, String> lead;
    @JsonProperty("avatarUrls")
    @JsonDeserialize(using = JsonObjectMapDeserializer.class)
    private Map<String, String> avatarUrls;
    @JsonProperty("projectCategory")
    @JsonDeserialize(using = JsonObjectMapDeserializer.class)
    private Map<String, String> projectCategory;
    @JsonProperty("roles")
    @JsonDeserialize(using = JsonObjectMapDeserializer.class)
    private Map<String, String> roles;

}

