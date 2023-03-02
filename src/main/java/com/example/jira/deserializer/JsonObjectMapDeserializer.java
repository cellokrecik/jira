package com.example.jira.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class JsonObjectMapDeserializer extends StdDeserializer<Map<String, String>> {

    public JsonObjectMapDeserializer() {
        super(List.class);
    }

    @Override
    public Map<String, String> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        Map<String, String> result = new HashMap<>();

        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        fields.forEachRemaining(field -> {
            result.put(field.getKey(), field.getValue().asText());
        });
        return result;
    }
}
