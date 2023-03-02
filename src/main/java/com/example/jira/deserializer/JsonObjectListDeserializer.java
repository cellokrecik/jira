package com.example.jira.deserializer;

import com.example.jira.model.IssueType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class JsonObjectListDeserializer extends StdDeserializer<List<IssueType>> {

    public JsonObjectListDeserializer() {
        super(List.class);
    }

    @Override
    public List<IssueType> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        List<IssueType> result = new ArrayList<>();
        if (node.isArray()) {
            for (JsonNode element : node) {
                IssueType issueType = new IssueType();
                if (element.findValue("id") != null) {
                    issueType.setId(element.findValue("id").asText());
                }
                if (element.findValue("name") != null) {
                    issueType.setName(element.findValue("name").asText());
                }
                if (element.findValue("description") != null) {
                    issueType.setDescription(element.findValue("description").asText());
                }
                if (element.findValue("self") != null) {
                    issueType.setSelf(element.findValue("self").asText());
                }
                if (element.findValue("avatarId") != null) {
                    issueType.setAvatarId(Long.parseLong(element.findValue("avatarId").asText()));
                }
                if (element.findValue("iconUrl") != null) {
                    issueType.setIconUrl(element.findValue("iconUrl").asText());
                }
                if (element.findValue("hierarchyLevel") != null) {
                    issueType.setHierarchyLevel(Long.parseLong(element.findValue("id").asText()));
                }
                if (element.findValue("subtask") != null) {
                    issueType.setSubtask(element.findValue("subtask").asBoolean());
                }
                result.add(issueType);
            }
        }
        return result;
    }
}
