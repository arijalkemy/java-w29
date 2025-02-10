package com.social_media.social_media.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static com.social_media.social_media.TestUtils.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureMockMvc
public class I0010 {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("I-0010 - Create Post Promo Test")
    void postNewPromo() throws Exception {
        Product product = new Product(7L, "Camiseta de la Seleccion Argentina", "Ropa", "Adidas", "Blanco", "Tira facha");
        Post postPromo = new Post(7L, 7L, LocalDate.now(), product, 1, 7.00, 25.00, null);
        PostPromoRequestDto payloadDto = convertPostPromoToRequestDto(postPromo);
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = objectWriter.writeValueAsString(payloadDto);

        mockMvc.perform(post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(payloadDto.getUser_id()))
                .andExpect(jsonPath("$.date").value(payloadDto.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.product.product_id").value(payloadDto.getProduct().getProduct_id().toString()))
                .andExpect(jsonPath("$.product.product_name").value(payloadDto.getProduct().getProduct_name()))
                .andExpect(jsonPath("$.product.type").value(payloadDto.getProduct().getType()))
                .andExpect(jsonPath("$.product.brand").value(payloadDto.getProduct().getBrand()))
                .andExpect(jsonPath("$.product.color").value(payloadDto.getProduct().getColor()))
                .andExpect(jsonPath("$.product.notes").value(payloadDto.getProduct().getNotes()))
                .andExpect(jsonPath("$.category").value(payloadDto.getCategory().toString()))
                .andExpect(jsonPath("$.price").value(payloadDto.getPrice().toString()))
                .andExpect(jsonPath("$.has_promo").value(payloadDto.getHas_promo().toString()))
                .andExpect(jsonPath("$.discount").value(payloadDto.getDiscount().toString()))
                .andReturn();
    }
}
