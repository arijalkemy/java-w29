package com.bootcampW22.EjercicioGlobal.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
  @Autowired
  private MockMvc mock_mvc;

  @Test
  void testGetVehiclesByColorAndYear() throws Exception {
    mock_mvc.perform(get("/vehicles/color/{color}/year/{year}", "Mauv", "1986"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().contentType("application/json"))
      .andExpect(jsonPath("$[0].brand").value("Pontiac"));
  }

  @Test
  void testGetVehiclesByColorAndYearNotFound() throws Exception {
    mock_mvc.perform(get("/vehicles/color/{color}/year/{year}", "NoExiste", "1986"))
      .andDo(print())
      .andExpect(status().isNotFound())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
  }
}
