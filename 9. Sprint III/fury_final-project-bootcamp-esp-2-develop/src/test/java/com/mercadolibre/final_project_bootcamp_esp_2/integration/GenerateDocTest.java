package com.mercadolibre.final_project_bootcamp_esp_2.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class GenerateDocTest extends ControllerTest {

  /**
   * Integration test to generate swagger.yaml file for fury docs
   * [http://furydocs.io/documentation-service]
   *
   * @throws IOException if an error occurs during the generation
   */
  @Test
  void generateSwaggerDocumentation() throws IOException {
    ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity("/v3/api-docs", String.class);
    assertTrue(responseEntity
        .getStatusCode()
        .is2xxSuccessful());
    assertNotNull(responseEntity.getBody());

    Path outputDir = Paths.get("docs/specs");
    Files.createDirectories(outputDir);

    ObjectMapper mapper = new ObjectMapper();
    Object json = mapper.readValue(responseEntity.getBody(), Object.class);
    String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

    Files.writeString(outputDir.resolve("swagger.yaml"), indented);
  }
}
