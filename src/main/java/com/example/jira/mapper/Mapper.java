package com.example.jira.mapper;

import com.example.jira.model.GeneralProjectInfo;
import com.example.jira.model.SingleProjectInfo;
import com.example.jira.model.IssuesList;
import com.example.jira.model.BoardsList;
import com.example.jira.model.EpicList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.util.List;


public class Mapper {

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public Mapper () {
        OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static List<GeneralProjectInfo> mapToListOfProjects(String projectsAsString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(projectsAsString, new TypeReference<>() {
        });
    }

    public static SingleProjectInfo mapToSingleProjectInfo(String projectsAsString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(projectsAsString, SingleProjectInfo.class);
    }

    public static BoardsList mapToListOfBoards(String projectsAsString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(projectsAsString, BoardsList.class);
    }

    public static IssuesList mapToListOfIssuesByEpicKey(String projectsAsString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(projectsAsString, IssuesList.class);
    }

    public static EpicList mapToListOfEpicByBoardId(String projectsAsString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(projectsAsString, EpicList.class);
    }
}
