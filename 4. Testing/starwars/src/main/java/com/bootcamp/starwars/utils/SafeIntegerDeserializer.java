package com.bootcamp.starwars.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SafeIntegerDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = p.getText().trim();
        if ("NA".equals(value)) {
            return null;  // Return null for "NA" or return 0 if you prefer.
        }
        try {
            return Integer.parseInt(value);  // Try parsing normally
        } catch (NumberFormatException e) {
            return null;  // Return null if there's a number format exception
        }
    }
}
