package com.example.jira.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class JsonObjectTShirtSizeDeserializer extends StdDeserializer<Map<String, String>> {

    private final List<String> T_SHIRT_SIZE_LIST = List.of("customfield_11000",
                                                            "customfield_11040",
                                                            "customfield_11974",
                                                            "customfield_11154",
                                                            "customfield_10492",
                                                            "customfield_10484");

    public JsonObjectTShirtSizeDeserializer() {
        super(List.class);
    }

    @Override
    public Map<String, String> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        Map<String, String> result = new HashMap<>();

        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        fields.forEachRemaining(field -> {
            if (T_SHIRT_SIZE_LIST.contains(field.getKey())) {
                result.put(field.getKey(), field.getValue().textValue());
            }
        });
        return result;
    }
}
