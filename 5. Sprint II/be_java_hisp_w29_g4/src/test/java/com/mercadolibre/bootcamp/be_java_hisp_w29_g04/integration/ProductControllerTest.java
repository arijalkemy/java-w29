package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.ProductDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PostsBySellersFollowedDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PromosByUserCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository.InMemoryStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    private static InMemoryStorageImpl memoryStorage;
    @Autowired
    private MockMvc mockMvc;

    @Autowired /* It has the camel case configuration */
    private ObjectMapper objectMapper;

    private final Integer SELLER_ID = 1;
    private final Integer COMMON_ID = 4;

    @BeforeAll
    static void setup() {
        /* We use this class that already loads test data in memory */
        memoryStorage = InMemoryStorageImpl.getInstance();
    }

    @Test
    @DisplayName("US-0012: Get promo posts by seller id: valid seller id")
    void getPromoPostsBySellerId_validSellerId_returnPromoPosts() throws Exception {
        String SELLER_ID = "1";

        DateTimeFormatter europeanFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = LocalDate.now().format(europeanFormatter);

        mockMvc.perform(get("/products/promo-post/list")
                        .param("seller_id", SELLER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].product.product_id", is(1)))
                .andExpect(jsonPath("$[0].product.product_name").value("MacBook Pro"))
                .andExpect(jsonPath("$[0].product.type").value("Electronics"))
                .andExpect(jsonPath("$[0].product.brand").value("Apple"))
                .andExpect(jsonPath("$[0].product.color").value("Space Gray"))
                .andExpect(jsonPath("$[0].product.notes").value("Latest model"))
                .andExpect(jsonPath("$[0].category").value(100))
                .andExpect(jsonPath("$[0].price").value(1104.9915))
                .andExpect(jsonPath("$[0].has_promo").value(true))
                .andExpect(jsonPath("$[0].discount").value(0.15))
                .andExpect(jsonPath("$[0].user_id").value(SELLER_ID))
                .andExpect(jsonPath("$[0].date").value(formattedDate));
    }
  
    @Test
    @DisplayName("Create PromoPost with price 15000000 throw validationException")
    public void testCreatePromoPostBadRequest() throws Exception {
        // Arrange
        String requestJson = "{\n" +
                "    \"user_id\": 1,\n" +
                "    \"date\": \"29-04-2021\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer2\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 15000000,\n" +
                "    \"has_promo\": true,\n" +
                "    \"discount\": 0.25\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("El precio maximo por producto es de 10.000.000"));
    }

    @Test
    @DisplayName("US-0012: Get promo posts by seller id: invalid seller id")
    void getPromoPostsBySellerId_invalidSellerId_throwNotFoundException() throws Exception {
        String INVALID_ID = "100";
        mockMvc.perform(get("/products/promo-post/list")
                        .param("seller_id", INVALID_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existing user with the provided id"));
    }
  
    @Test
    @DisplayName("US-0012: Get promo posts by seller id: seller doesn't have any promo")
    void getPromoPostsBySellerId_noPromosFound_throwNotFoundException() throws Exception {
        mockMvc.perform(get("/products/promo-post/list")
                        .param("seller_id", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Seller doesn't have any promo"));
    }


    @Test
    @DisplayName("US-0012: Get promo posts by seller id - common user id")
    void getPromoPostsBySellerId_receivedCommonUserId_throwBadRequestException() throws Exception {
        mockMvc.perform(get("/products/promo-post/list")
                        .param("seller_id", "4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Only sellers have posts!"));
    }


    @Test
    @DisplayName("US-0009 Happy path")
    void getPostsOfFollowedSeller_Ok () throws Exception {
        // Arrange
        ProductDto product = new ProductDto(1, "MacBook Pro", "Electronics", "Apple", "Space Gray", "Latest model");
        PostsBySellersFollowedDto expected = new PostsBySellersFollowedDto(COMMON_ID, List.of(new PostDto(1, LocalDate.now(), product, 100, 1104.9915)));

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", COMMON_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        PostsBySellersFollowedDto actual = objectMapper.readValue(
                responseContent,
                new TypeReference<>() {}
        );
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("US-0009 User Not Found")
    void getPostsOfFollwedSeller_UserNotFound () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 100))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("message").value("No existing user with the provided id"));
    }

    @Test
    @DisplayName("US-0009 Seller instead of CommonUser")
    void getPostsOfFollwedSeller_BadRequestException () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", SELLER_ID))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("message").value("Only users can get sellers posts."));
    }

    @Test
    @DisplayName("US-0009 Invalid Order")
    void getPostsOfFollwedSeller_InvalidOrderException () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list?order={order}", COMMON_ID, "badOrder"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("message").value("Invalid order."));
    }

    @Test
    @DisplayName("US-0009 Empty Following list")
    void getPostsOfFollwedSeller_EmptyFollowing () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 7))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("message").value("This user do not follow any seller."));
    }

    @Test
    void get_promoPost_count_ok() throws Exception {
        // 1. Arrange
        // in setup

        // 2. Act
        MvcResult result = mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(SELLER_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        PromosByUserCountDto promosCount = objectMapper.readValue(
                responseContent,
                new TypeReference<PromosByUserCountDto>() {}
        );

        // 3. Assert
        User user = memoryStorage.getUsersById().get(SELLER_ID);
        Assertions.assertEquals(1, promosCount.getPromoProductsCount());
        Assertions.assertEquals(user.getUsername(), promosCount.getUserName());
        Assertions.assertEquals(user.getUserId(), promosCount.getUserId());
    }

    @Test
    void get_promoPost_count_user_NotFound() throws Exception {
        // 1. Arrange
        // in setup

        // 2. Act & 3. Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(Integer.MAX_VALUE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void get_promoPost_count_bad_relationship() throws Exception {
        // 1. Arrange
        // in setup

        // 2. Act & 3. Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(COMMON_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    /* US 0005*/
    @Test
    public void testCreatePostOk() throws Exception {
        // Arrange
        String requestJson = "{\n" +
                "    \"user_id\": 1,\n" +
                "    \"date\": \"29-04-2021\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer2\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red & Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The post was created successfully"));
    }

    @Test
    @DisplayName("Create Post with price 15000000 throw validationException")
    public void testCreatePostBadRequest() throws Exception {
        // Arrange
        String requestJson = "{\n" +
                "    \"user_id\": 1,\n" +
                "    \"date\": \"29-04-2021\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer2\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 15000000\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("El precio maximo por producto es de 10.000.000"));
    }

    /* US 0010*/
    @Test
    public void testCreatePromoPostOk() throws Exception {
        // Arrange
        String requestJson = "{\n" +
                "    \"user_id\": 3,\n" +
                "    \"date\": \"29-04-2021\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer2\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red & Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50,\n" +
                "    \"has_promo\": true,\n" +
                "    \"discount\": 0.25\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post") // Aquí colocas la URL del endpoint
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The post was created successfully"));
    }

    /* # --------- CRUD ---------*/

    @Test
    void getPosts_ok() throws Exception {
        // 1. Arrange & 2. Act
        MvcResult result = mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        List<PostDto> posts = objectMapper.readValue(
                responseContent,
                new TypeReference<>() {}
        );

        Set<Integer> sellers = posts
                .stream()
                .map(PostDto::getUserId)
                .collect(Collectors.toSet());

        // 3. Assert
        int count = memoryStorage.getPosts().values().stream().flatMap(Collection::stream).toList().size();
        Assertions.assertEquals(count, posts.size());
        Assertions.assertTrue(sellers.containsAll(List.of(1,2,3)));
    }

    @Test
    void getPostById_ok() throws Exception {
        // 1. Arrange & 2. Act
        MvcResult result = mockMvc.perform(get("/products/{postsId}", 2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        PostDto post = objectMapper.readValue(
                responseContent,
                new TypeReference<>() {}
        );

        // 3. Assert
        Post p1 = memoryStorage.getPosts()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(p -> p.getId().equals(2))
                        .findFirst().get();
        Assertions.assertEquals(p1.getProduct().getBrand(), post.getProduct().getBrand());
        Assertions.assertEquals(p1.getProduct().getId(), post.getProduct().getId());
    }

    @Test
    void deletePost_ok() throws Exception {
        // 1. Arrange & 2. Act & 3. Assert
        mockMvc.perform(delete("/products/{postsId}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post deleted successfully"));
    }

    @Test
    void deletePost_NotFoundException() throws Exception {
        // 1. Arrange & 2. Act & 3. Assert
        mockMvc.perform(get("/products/{postsId}", 99)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post not found"));
    }
}

