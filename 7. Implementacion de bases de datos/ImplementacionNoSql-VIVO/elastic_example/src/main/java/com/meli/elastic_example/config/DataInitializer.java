package com.meli.elastic_example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.elastic_example.entity.LiteraryWork;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ElasticsearchOperations operations;
    private final ObjectMapper objectMapper;

    public DataInitializer(ElasticsearchOperations operations, ObjectMapper objectMapper) {
        this.operations = operations;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (operations.indexOps(LiteraryWork.class).exists()) {
            operations.indexOps(LiteraryWork.class).delete();
        }
        operations.indexOps(LiteraryWork.class).create();
        operations.indexOps(LiteraryWork.class).putMapping();

        ClassPathResource resource = new ClassPathResource("data.json");
        List<LiteraryWork> literaryWorks = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<List<LiteraryWork>>() {}
        );

        literaryWorks.forEach(operations::save);

        System.out.println("Índice 'literarywork' inicializado y datos cargados.");
    }
}
