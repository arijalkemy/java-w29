package com.bootcampW22.EjercicioGlobal.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTestPractica {
    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    VehicleRepositoryImpl vehicleRepository;

//    @BeforeAll
//    public void loadTestDataBase() throws IOException {
//        File file;
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Vehicle> vehicles;
//
//        file = ResourceUtils.getFile("src/test/resources/vehicles_test.json");
//        vehicles = objectMapper.readValue(file, new TypeReference<>(){});
//
//        vehicleRepository.setTestData(vehicles);
//    }

    @Test
    @DisplayName("US0001 - Integration Test: Get Vehicles By Year And Color - Happy Path")
    public void getVehiclesByColorAndYearOkTest() throws Exception {
        // Arrange
        Integer year = 2002;
        String color = "Maroon";

        // Act & Assert
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(5))
                .andExpect(jsonPath("$[*].color").value(everyItem(equalToIgnoringCase(color))))
                .andExpect(jsonPath("$[*].year").value(everyItem(is(year))));
    }

    @Test
    @DisplayName("US0001 - Integration Test: Get Vehicles By Year And Color - NotFoundException")
    public void getVehiclesByColorAndYearThrowNotFoundExceptionTest() throws Exception {
        // Arrange
        Integer year = 2001;
        String nonExistentColor = "Some color";

        // Act & Assert
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", nonExistentColor, year))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
    }

    @Test
    @DisplayName("US0002 - Integration test - Happy Path")
    public void getVehiclesByBrandAndRangeOfYearOkTest() throws Exception {
        // Arrange
        String brand = "Honda";
        Integer start_year = 2002;
        Integer end_year = 2006;

        // Act & Assert
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", brand, start_year, end_year))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(4))
                .andExpect(jsonPath("$[*].brand").value(everyItem(is(brand))))
                .andExpect(jsonPath("$[*].year").value(everyItem(greaterThanOrEqualTo(start_year))))
                .andExpect(jsonPath("$[*].year").value(everyItem(lessThanOrEqualTo(end_year))));
    }

    @Test
    @DisplayName("US0003 - Integration Test: Get Average Speed By Brand - Happy Path")
    public void getAverageSpeedByBrandOkTest() throws Exception {
        // Arrange
        String brand = "Chevrolet";

        // Act & Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.average_speed").value(156.7));
    }

    @Test
    @DisplayName("US0003 - Integration Test: Get Average Speed By Brand - NotFoundException")
    public void getAverageSpeedByBrandThrowNotFoundExceptionTest() throws Exception {
        // Arrange
        String nonExistentBrand = "Some Brand";

        // Act & Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", nonExistentBrand))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos de esa marca."));
    }

    @Test
    @DisplayName("US0004 - Integration Test: Get Average capacity By Brand - Happy Path")
    public void getAverageCapacityByBrandOkTest() throws Exception {
        // Arrange
        String brand = "Chevrolet";

        // Act & Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.average_capacity").value(3.58));
    }

    @Test
    @DisplayName("US0005 - Integration Test: Get Vehicles By Range Of Weight - Happy Path")
    public void getVehiclesByRangeOfWeightOkTest() throws Exception {
        // Arrange
        Double weight_min = 270.0;
        Double weight_max = 288.8;

        // Act & Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(weight_min))
                        .param("max", String.valueOf(weight_max)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(25))
                .andExpect(jsonPath("$[*].weight").value(everyItem(greaterThanOrEqualTo(weight_min))))
                .andExpect(jsonPath("$[*].weight").value(everyItem(lessThanOrEqualTo(weight_max))));
    }

    @Test
    @DisplayName("US0005 - Integration Test: Get Vehicles By Range Of Weight - NotFoundException")
    public void getVehiclesByRangeOfWeightThrowNotFoundExceptionTest() throws Exception {
        // Arrange
        Double weight_min = 299.96;
        Double weight_max = 350.0;

        // Act & Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(weight_min))
                        .param("max", String.valueOf(weight_max)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos en ese rango de peso."));
    }

}
