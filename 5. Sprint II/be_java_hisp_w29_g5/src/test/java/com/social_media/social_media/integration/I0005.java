package com.social_media.social_media.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.request.PostRequestDto;
import com.social_media.social_media.dto.request.ProductRequestDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class I0005 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    @DisplayName("I-0005 - Test of create post")
    void postNew() throws Exception{

        Product product = new Product(1L, "camiseta", "Ropa", "Adidas", "Rojo", "Ideal para correr y hacer ejercicio");
        Post post = new Post(1L,1L, LocalDate.now(),product, 2, 29.99, 0.0, LocalDate.now().plusDays(30));

        ProductRequestDto productRequestDtoToMock = TestUtils.convertProductToRequestDto(product);
        PostRequestDto postRequestDtoToMock = TestUtils.convertPostToRequestDto(post, productRequestDtoToMock);

        objectMapper.registerModule(new JavaTimeModule()); //Registra el módulo para LocalDate
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); //Evita que lo serialice como timestamp

        String jsonBody = objectMapper.writeValueAsString(postRequestDtoToMock);

        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1L))
                .andReturn();
    }
}
