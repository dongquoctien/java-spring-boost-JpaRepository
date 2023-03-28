package com.example.demoAPI.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CommonUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param jsonNode
     * @param listKeyNm
     * @return result > list
     */
    public static JsonNode getBaseTypeNode(JsonNode jsonNode, String listKeyNm) {
        ObjectNode rsValue = JsonNodeFactory.instance.objectNode();
        ObjectNode resultDataObj = JsonNodeFactory.instance.objectNode();
        resultDataObj.set(listKeyNm, jsonNode);
        rsValue.set("result", resultDataObj);
        return rsValue;
    }

    public static JsonNode convertVoToJsonNode(Object fromValue) {
        return objectMapper.convertValue(fromValue, JsonNode.class);
    }
}
