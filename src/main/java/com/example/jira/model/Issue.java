package com.example.jira.model;

import com.example.jira.deserializer.JsonObjectTShirtSizeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    private String expand;
    private String id;
    private String self;
    private String key;
    @JsonProperty("fields")
    @JsonDeserialize(using = JsonObjectTShirtSizeDeserializer.class)
    private Map<String, String> fields;

}
