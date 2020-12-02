package com.cheky.springboot.demo.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class OptimizedBooleanDeserializer extends JsonDeserializer<Boolean> {

    private final static String ZERO = "0";

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        String text = jsonParser.getText();
        return !ZERO.equals(text);
    }
}
