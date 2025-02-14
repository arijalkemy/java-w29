package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.dto.PostDto;
import com.meli.socialmeli.dto.ProductDto;
import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Product;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationT10T12 {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SellerRepositoryImpl sellerRepository;

    @Autowired
    private ProductRepositoryImpl productRepository;

    @Autowired
    private PostRepositoryImpl postRepository;


    private PostDto promoPostDto;

    private Seller seller1;

    private Seller seller2;

    @BeforeEach
    void setUp() {
        seller1 = new Seller(98, "Carlos", List.of());
        this.sellerRepository.save(seller1);

        seller2 = new Seller(99, "Carlos", List.of());
        this.sellerRepository.save(seller2);

        ProductDto productDto = ProductDto.builder()
                .productId(666)
                .productName("Product Name")
                .type("Regular")
                .brand("Brand")
                .color("Blue")
                .notes("Valid notes here")
                .build();

        promoPostDto = PostDto.builder()
                .id(1)
                .userId(seller1.getId())
                .date(LocalDate.now())
                .product(productDto)
                .category(100)
                .price(99.99)
                .hasPromo(true)
                .discount(5.0)
                .build();

    }


    @Test
    public void testAddPromoPostSuccess() throws Exception {
        ProductDto productDto = ProductDto.builder()
                .productId(777)
                .productName("Product Name")
                .type("Regular")
                .brand("Brand")
                .color("Blue")
                .notes("Valid notes here")
                .build();

        promoPostDto.setProduct(productDto);

        String promoPostJson = objectMapper.writeValueAsString(promoPostDto);
        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(Messages.SUCCESS));
    }

    @Test
    public void testAddPromoPostSellerNotFound() throws Exception {
        promoPostDto.setUserId(9999); // Establece un userId que no existe
        String promoPostJson = objectMapper.writeValueAsString(promoPostDto);

        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.USER_NOT_FOUND.replace("%s", "9999")));
    }

    @Test
    public void testAddPromoPostProductConflict() throws Exception {
        Product product = new Product(666,"nombre","tipo","marca","color","notas");
        this.productRepository.save(product);

        String promoPostJson = objectMapper.writeValueAsString(promoPostDto);


        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value(Messages.PRODUCT_CONFLICT));
    }

  /*  @Test
    public void testAddPromoPostConflict() throws Exception {
        Product product = new Product(888,"nombre","tipo","marca","color","notas");
        this.productRepository.save(product);

        Post promoPost = new Post(987,LocalDate.now(),22.2,product,seller1,12.2,true,3);
        this.postRepository.save(promoPost);

        ProductDto productDto = ProductDto.builder()
                .productId(999)
                .productName("Product Name")
                .type("Regular")
                .brand("Brand")
                .color("Blue")
                .notes("Valid notes here")
                .build();

        PostDto promoPostDto = PostDto.builder()
                .id(13)
                .userId(promoPost.getSeller().getId())
                .date(promoPost.getDate())
                .product(productDto)
                .category(promoPost.getCategory())
                .price(promoPost.getPrice())
                .hasPromo(promoPost.getHasPromo())
                .discount(promoPost.getDiscount())
                .build();


        String promoPostJson = objectMapper.writeValueAsString(promoPostDto);


        mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(promoPostJson))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value(Messages.POST_CONFLICT));
    }*/

    @Test
    public void testListPromosBySeller() throws Exception {

        Product product = new Product(555,"nombre","tipo","marca","color","notas");
        this.productRepository.save(product);

        Post promoPost = new Post(987,LocalDate.now(),22.2,product,seller1,12.2,true,3);
        this.postRepository.save(promoPost);

        mockMvc.perform(get("/products/promo-post/list")
                        .param("user_id",seller1.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(seller1.getId().toString()))
                .andExpect(jsonPath("$.user_name").value(seller1.getName()))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts").isNotEmpty());


    }

    @Test
    public void testListPromosBySellerWithNoProducts() throws Exception {

        mockMvc.perform(get("/products/promo-post/list")
                        .param("user_id",seller2.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(seller2.getId().toString()))
                .andExpect(jsonPath("$.user_name").value(seller2.getName()))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts").isEmpty());
    }

    @Test
    public void testListPromosBySellerNotFound() throws Exception {

        mockMvc.perform(get("/products/promo-post/list")
                        .param("user_id","543"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.USER_NOT_FOUND.replace("%s", "543")));
    }

}
