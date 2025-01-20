package com.example.calculadora_calorias.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class JsonFileMapper {
    public static <T> T readFromJsonFile(String jsonFileName, TypeReference<T> typeReference) {
        try {
            final File jsonFile = new ClassPathResource(jsonFileName).getFile();
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonFile, typeReference);
        } catch (IOException e) {
            System.out.println("Could not find file!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
