package com.example.jira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JiraApplication {
	public static void main(String[] args) {
		SpringApplication.run(JiraApplication.class, args);
	}
}
