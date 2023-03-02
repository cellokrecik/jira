package com.example.jira.config;

import feign.auth.BasicAuthRequestInterceptor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Data
public class JiraConfig {

    @Value("${jira.api.username}")
    private String jiraApiUsername;

    @Value("${jira.api.password}")
    private String jiraApiPassword;
    @Value("${jira.api.baseUrl}")
    private String baseUrl;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(jiraApiUsername, jiraApiPassword);
    }
}
