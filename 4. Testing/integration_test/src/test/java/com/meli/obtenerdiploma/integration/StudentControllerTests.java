package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

  @Autowired
  private MockMvc mock_mvc;

  @Test
  void testListStudents() throws Exception {
    this.mock_mvc.perform(get("/student/listStudents"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().contentType("application/json"))
      .andExpect(jsonPath("$").isArray());
  }

  @Test
  void testGetStudent() {

  }

  @Test
  void testModifyStudent() {

  }

  @Test
  void testRegisterStudent() {

  }

  @Test
  void testRemoveStudent() {

  }
}
