package com.example.jira;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;


public class IssuesMocks {

    public static void setupMockIssuesResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/agile/1.0/epic/IFZ-614/issue"))
                .willReturn(
                        WireMock.aResponse()
                                .withStatus(HttpStatus.OK.value())
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody(copyToString(
                                        IssuesMocks.class.getClassLoader().getResourceAsStream("responses/get-all-issues-by-epic-key-response.json"),
                                        defaultCharset()))));
    }
}
