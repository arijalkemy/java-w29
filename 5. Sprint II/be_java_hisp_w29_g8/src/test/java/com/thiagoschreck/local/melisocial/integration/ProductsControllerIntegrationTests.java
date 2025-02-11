package com.thiagoschreck.local.melisocial.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thiagoschreck.local.melisocial.dto.PostDTO;
import com.thiagoschreck.local.melisocial.dto.response.FeedPostsDto;
import com.thiagoschreck.local.melisocial.dto.response.PostWithNoPromoAndDiscountDto;
import com.thiagoschreck.local.melisocial.dto.request.CreatePostDTO;
import com.thiagoschreck.local.melisocial.dto.request.CreateProductDTO;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsResponseDTO;
import com.thiagoschreck.local.melisocial.entity.product.Post;
import com.thiagoschreck.local.melisocial.entity.product.Product;
import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.repository.IPostsRepository;
import com.thiagoschreck.local.melisocial.repository.IUsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IPostsRepository postsRepository;

    @Autowired
    private IUsersRepository usersRepository;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    void getAllPromoPostsFromSeller() throws Exception {
        Seller seller = usersRepository.save(new Seller("Johnny Test"));

        Product firstProduct = new Product(998, "Taza", "Oficina", "N/A", "Negro", null);
        Post firstPost = postsRepository.save(
                new Post(0, seller.getUserId(), LocalDate.now(), firstProduct, 1, 100.0, true, 0.25));
        Product secondProduct = new Product(999, "Silla", "Oficina", "N/A", "Marrón", null);
        Post secondPost = postsRepository.save(
                new Post(1, seller.getUserId(), LocalDate.now(), secondProduct, 1, 500.0, true, 0.25)
        );

        MvcResult getAllPromoPostsFromSellerResult = mockMvc.perform(get("/products/promo-post/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("user_id", String.valueOf(seller.getUserId())))
                .andExpect(status().isOk())
                .andReturn();

        PromoPostsResponseDTO promoPostsResponse = map(getAllPromoPostsFromSellerResult, PromoPostsResponseDTO.class);
        List<PostDTO> expectedPosts = List.of(map(firstPost), map(secondPost));

        assertNotNull(promoPostsResponse);
        assertIterableEquals(expectedPosts, promoPostsResponse.posts());
    }

    @Test
    void getAllPromoPostsFromSellerSellerNotFound() throws Exception {
        mockMvc.perform(get("/products/promo-post/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("user_id", "0"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllPromoPostsFromSellerEmptyResult() throws Exception {
        Seller seller = usersRepository.save(new Seller("Johnny Test"));

        MvcResult getAllPromoPostsFromSellerResult = mockMvc.perform(get("/products/promo-post/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("user_id", String.valueOf(seller.getUserId())))
                .andExpect(status().isOk())
                .andReturn();

        PromoPostsResponseDTO promoPostsResponse = map(getAllPromoPostsFromSellerResult, PromoPostsResponseDTO.class);
        List<PostDTO> expectedPosts = Collections.emptyList();

        assertNotNull(promoPostsResponse);
        assertIterableEquals(expectedPosts, promoPostsResponse.posts());
    }

    @Test
    void getAllPromoPostsFromSellerHasOnlyNonPromoPosts() throws Exception {
        Seller seller = usersRepository.save(new Seller("Johnny Test"));

        Product firstProduct = new Product(998, "Taza", "Oficina", "N/A", "Negro", null);
        postsRepository.save(new Post(0, seller.getUserId(), LocalDate.now(), firstProduct, 1, 100.0, false, 0));
        Product secondProduct = new Product(999, "Silla", "Oficina", "N/A", "Marrón", null);
        postsRepository.save(new Post(1, seller.getUserId(), LocalDate.now(), secondProduct, 1, 500.0, false, 0));

        MvcResult getAllPromoPostsFromSellerResult = mockMvc.perform(get("/products/promo-post/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("user_id", String.valueOf(seller.getUserId())))
                .andExpect(status().isOk())
                .andReturn();

        PromoPostsResponseDTO promoPostsResponse = map(getAllPromoPostsFromSellerResult, PromoPostsResponseDTO.class);
        List<PostDTO> expectedPosts = Collections.emptyList();

        assertNotNull(promoPostsResponse);
        assertIterableEquals(expectedPosts, promoPostsResponse.posts());
    }
    @Test
    void getAllPostsByFollowedSellerWithinTwoWeeksOrderAsc() throws Exception {
        String order = "date_asc";
        Client client = new Client("Pepe");
        client.setUserId(0);
        usersRepository.save(client);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        usersRepository.save(seller1);
        usersRepository.save(seller2);

        client.followSeller(seller1);
        client.followSeller(seller2);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1, "Motocicleta", "Acuatico", "Mercedes", "Rojo", "Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1, seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);
        postsRepository.save(post1);
        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2, "Pepito", "Acuatico", "Mercedes", "Rojo", "Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2, seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);
        postsRepository.save(post2);

        List<Post> postsList = List.of(
                post2,
                post1
        );

        List<PostWithNoPromoAndDiscountDto> postsWithNoPromoAndDiscount = postsList.stream()
                .map(this::mapPostToPostWithNoPromoAndDiscount)
                .toList();
        FeedPostsDto feedPostsDto = new FeedPostsDto(client.getUserId(), postsWithNoPromoAndDiscount);
        List<FeedPostsDto> expectedFeed = List.of(feedPostsDto);

        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", client.getUserId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); //Se registra el módulo para evitar problemas con LocalDate

        List<FeedPostsDto> actualFeed = objectMapper.readValue(jsonResponse, new TypeReference<List<FeedPostsDto>>() {
        });

        assertNotNull(result);
        assertEquals(expectedFeed, actualFeed);
    }

    @Test
    void getAllPostsByFollowedSellerWithinTwoWeeksOrderDesc() throws Exception {
        String order = "date_desc";
        Client client = new Client("Pepe");
        client.setUserId(0);
        usersRepository.save(client);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        usersRepository.save(seller1);
        usersRepository.save(seller2);

        client.followSeller(seller1);
        client.followSeller(seller2);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1, "Motocicleta", "Acuatico", "Mercedes", "Rojo", "Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1, seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);
        postsRepository.save(post1);
        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2, "Pepito", "Acuatico", "Mercedes", "Rojo", "Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2, seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);
        postsRepository.save(post2);
        List<Post> postsList = List.of(
                post1,
                post2
        );
        List<FeedPostsDto> expectedFeed = getFeedPostsDtos(postsList, client);

        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", client.getUserId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); //Se registra el módulo para evitar problemas con LocalDate

        List<FeedPostsDto> actualFeed = objectMapper.readValue(jsonResponse, new TypeReference<List<FeedPostsDto>>() {
        });

        assertNotNull(result);
        assertEquals(expectedFeed, actualFeed);
    }

    private PostWithNoPromoAndDiscountDto mapPostToPostWithNoPromoAndDiscount(Post post) {
        return new PostWithNoPromoAndDiscountDto(
                post.getUserId(),
                post.getId(),
                post.getDate(),
                post.getProduct().getId(),
                post.getProduct().getName(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes(),
                post.getCategory(),
                post.getPrice()
        );
    }

    private List<FeedPostsDto> getFeedPostsDtos(List<Post> posts, Client client) {
        List<PostWithNoPromoAndDiscountDto> feedPosts = posts.stream()
                .map(this::mapPostToPostWithNoPromoAndDiscount)
                .toList();

        FeedPostsDto feedPostsDto = new FeedPostsDto(client.getUserId(), feedPosts);
        return List.of(feedPostsDto);
    }



    @Test
    void getAllPostsByFollowedSellerWithinTwoWeeksOrderClientNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 0))
                .andExpect(status().isNotFound());

    }

    @Test
    void getAllPostsByFollowedSellerWithinTwoWeeksOrderInvalidClientId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "pepe"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllPostsByFollowedSellersWithinTwoWeeksPostsAfterTwoWeeks() throws Exception {
        String order = "date_desc";
        Client client = new Client("Pepe");
        client.setUserId(0);
        usersRepository.save(client);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        usersRepository.save(seller1);
        usersRepository.save(seller2);

        client.followSeller(seller1);
        client.followSeller(seller2);

        LocalDate threeWeeksAgo = LocalDate.now().minusWeeks(3);

        Product product1 = new Product(1, "Motocicleta", "Acuatico", "Mercedes", "Rojo", "Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1, seller1.getUserId(), threeWeeksAgo, product1, 1, 40.0, false, 8.0);
        postsRepository.save(post1);
        Product product2 = new Product(2, "Pepito", "Acuatico", "Mercedes", "Rojo", "Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2, seller2.getUserId(), threeWeeksAgo, product2, 1, 80.0, false, 6.0);
        postsRepository.save(post2);

        List<PostWithNoPromoAndDiscountDto> posts = Collections.emptyList();

        FeedPostsDto feedPostsDto = new FeedPostsDto(client.getUserId(), posts);

        List<FeedPostsDto> expectedFeed = List.of(feedPostsDto);

        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", client.getUserId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); //Se registra el módulo para evitar problemas con LocalDate

        List<FeedPostsDto> actualFeed = objectMapper.readValue(jsonResponse, new TypeReference<List<FeedPostsDto>>() {
        });

        assertNotNull(result);
        assertEquals(expectedFeed, actualFeed);
    }

    private PostDTO map(Post post) {
        if (post == null) {
            return null;
        }
        if (post.getProduct() == null) {
            return new PostDTO(post.getId(), post.getDate(), null, null, null,
                    null, null, null, post.getCategory(), post.getPrice(),
                    post.isOnPromotion(), post.getDiscount());
        }
        return new PostDTO(post.getId(), post.getDate(), post.getProduct().getId(), post.getProduct().getName(),
                post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(),
                post.getProduct().getNotes(), post.getCategory(), post.getPrice(), post.isOnPromotion(),
                post.getDiscount());
    }

    @Test
    @DisplayName("Save post with status 200")
    void testSavePostSuccessfully() throws Exception {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);

        Seller seller = usersRepository.save(new Seller("Johnny Test"));
        CreatePostDTO post = this.prepareCreatePostDtoWithoutDiscount(seller.getUserId(), 1, today);

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(seller.getUserId()))
                .andExpect(jsonPath("$.date").value(formattedDate));
    }

    @Test
    @DisplayName("Save post with wrong parameters will return status 400")
    void testSavePostWithWrongParameters() throws Exception {
        LocalDate today = LocalDate.now();

        CreatePostDTO post = this.prepareCreatePostDtoWithoutDiscount(0, 0, today);

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Save post with wrong sellerId will return status 404")
    void testSavePostWithWrongSellerId() throws Exception {
        LocalDate today = LocalDate.now();

        CreatePostDTO post = this.prepareCreatePostDtoWithoutDiscount(999, 1, today);

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Count promo post by sellerId with status 200")
    void testCountPromoPostSuccessfully() throws Exception {
        LocalDate today = LocalDate.now();

        Seller seller = usersRepository.save(new Seller("Johnny Test"));
        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black",
                "Special Edition");
        Post post = new Post(1, seller.getUserId(), today, product, 100, 100000, true, 0.1);
        postsRepository.save(post);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count").param("user_id",
                        String.valueOf(seller.getUserId())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(seller.getUserId()))
                .andExpect(jsonPath("$.user_name").value(seller.getUserName()))
                .andExpect(jsonPath("$.promo_products_count").value(1));
    }

    @Test
    @DisplayName("Count promo post with wrong sellerId will return status 404")
    void testCountPromoPostWithWrongSellerId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count").param("user_id",
                        String.valueOf(999L)))
                .andExpect(status().isNotFound());
    }

    private CreatePostDTO prepareCreatePostDtoWithoutDiscount(Integer userId, Integer productId, LocalDate today){
        CreateProductDTO product = new CreateProductDTO(productId, "Silla Gamer", "Gamer", "Racer", "Red & Black",
                "Special Edition");
        return new CreatePostDTO(userId, today, product, 100, 100000, false, 0);
    }

    private <T> T map(MvcResult mvcResult, Class<T> clazz) {
        return Optional.ofNullable(mvcResult)
                .map(MvcResult::getResponse)
                .map(MockHttpServletResponse::getContentAsByteArray)
                .map(content -> map(content, clazz))
                .orElse(null);
    }

    private <T> T map(byte[] byteArray, Class<T> clazz) {
        try {
            return objectMapper.readValue(byteArray, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
