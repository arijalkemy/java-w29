package com.example.entities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class HeightDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().trim();

        // Si el valor es "NA", devuelve 0 o null
        if ("NA".equalsIgnoreCase(value)) {
            return 0;  // O puedes retornar null si prefieres
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;  // O puedes retornar null si prefieres
        }
    }
}