package com.bootcamp.be_java_hisp_w29_g07.integration;

import com.bootcamp.be_java_hisp_w29_g07.constants.Messages;
import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import com.bootcamp.be_java_hisp_w29_g07.controller.PostController;
import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoPostDTOOut;
import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilObjectMapper;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilPostFactory;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bootcamp.be_java_hisp_w29_g07.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w29_g07.repository.IPostRepository;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration test for the {@link PostController} controller.
 * This class contains integration tests for the endpoints in {@link PostController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IFollowRepository followRepository;

    /**
     * Instance of {@link MockMvc} that allows simulating HTTP requests and verifying controller responses.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Sets up the object writer for JSON serialization before each test.
     */
    @BeforeEach
    public void setUp() {

        followRepository.deleteAll();
        postRepository.deleteAll();
    }

    /**
     * Integration Test to verify that when a non-existent promotional post is created,
     * a success response entity is returned.
     */
    @Test
    public void givenNonExistentPromoPost_whenCreatePromoPost_thenReturnSuccessResponseEntity() throws Exception {
        User user = UtilUserFactory.getSeller("cmorales", 2);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setId(null);

        Post savedPost = UtilPostFactory.getPromoPost();
        savedPost.setUserId(user.getId());
        PromoPostDTOOut promoPostDTOOutExpected = UtilPostFactory.getPromoPostDTOOut(savedPost);

        MvcResult res = mockMvc.perform(post("/products/promo-post")
                        .content(UtilObjectMapper.getObjectWriter()
                                .writeValueAsString(UtilPostFactory.getPromoPostDTOIn(newPost)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();

        PromoPostDTOOut promoPostDTOOutRes = UtilObjectMapper.getObjectMapper().readValue(jsonRes, new TypeReference<PromoPostDTOOut>() {
        });
        promoPostDTOOutExpected.setPost_id(promoPostDTOOutRes.getPost_id());
        assertEquals(promoPostDTOOutExpected, promoPostDTOOutRes);
    }

    /**
     * Integration test to verify that posts from followed users are returned when no order parameter is provided.
     * <p>
     * This test follows two seller users, creates posts for them, and then retrieves the posts.
     * It verifies that the posts' dates fall within the last two weeks.
     * </p>
     */
    @Test
    public void givenExistingUserId_WhenFindListUsersFollowedPosts_ThenReturnSuccess() throws Exception {

        User userFollower = UtilUserFactory.getUser("gali", 1);
        User followedSellerA = UtilUserFactory.getSeller(2);
        User followedSellerB = UtilUserFactory.getSeller(4);

        followRepository.saveFollow(userFollower, followedSellerA);
        followRepository.saveFollow(userFollower, followedSellerB);

        List<Post> posts = UtilPostFactory.createUnorderedPosts();
        posts.forEach(post -> postRepository.savePost(post));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ValidationValues.DATE_PATTERN);
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        LocalDate today = LocalDate.now();

        String responseContent = mockMvc.perform(get("/products/followed/{userId}/list", userFollower.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts").isNotEmpty())
                .andReturn().getResponse().getContentAsString();

        List<String> dateStrings = JsonPath.read(responseContent, "$.posts[*].date");
        List<LocalDate> dates = dateStrings.stream()
                .map(dateStr -> LocalDate.parse(dateStr, formatter))
                .toList();

        dates.forEach(date -> {
            assertThat(date)
                    .as("The date %s should be between %s and %s", date, twoWeeksAgo, today)
                    .isAfterOrEqualTo(twoWeeksAgo)
                    .isBeforeOrEqualTo(today);
        });
    }

    /**
     * Integration Test to verify that posts from followed users are returned in descending order by date.
     * <p>
     * This test follows two seller users, creates posts for them, and then retrieves the posts.
     * It verifies that the posts are sorted in descending order (newest first).
     * </p>
     */
    @Test
    void givenExistingUnorderedPosts_whenFindListUsersFollowedPosts_thenReturnPostsOrderedByDateDesc() throws Exception {
        User userFollower = UtilUserFactory.getUser("user1", 1);
        User followedSeller1 = UtilUserFactory.getSeller(2);
        User followedSeller2 = UtilUserFactory.getSeller(4);
        String order = "date_desc";

        followRepository.saveFollow(userFollower, followedSeller1);
        followRepository.saveFollow(userFollower, followedSeller2);

        List<Post> posts = UtilPostFactory.createUnorderedPosts();
        posts.forEach(post -> postRepository.savePost(post));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ValidationValues.DATE_PATTERN);

        mockMvc.perform(get("/products/followed/{userId}/list", userFollower.getId())
                        .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts[0].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[1].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[2].date").isNotEmpty())
                .andDo(result -> {

                    String date1Str = JsonPath.read(result.getResponse().getContentAsString(), "$.posts[0].date");
                    String date2Str = JsonPath.read(result.getResponse().getContentAsString(), "$.posts[1].date");
                    String date3Str = JsonPath.read(result.getResponse().getContentAsString(), "$.posts[2].date");

                    LocalDate date1 = LocalDate.parse(date1Str, formatter);
                    LocalDate date2 = LocalDate.parse(date2Str, formatter);
                    LocalDate date3 = LocalDate.parse(date3Str, formatter);

                    assertTrue(date1.isAfter(date2));
                    assertTrue(date2.isAfter(date3));
                });
    }

    /**
     * Integration Test to verify that posts from followed users are returned in ascending order by date.
     * <p>
     * This test follows two seller users, creates posts for them, and then retrieves the posts.
     * It verifies that the posts are sorted in ascending order (oldest first).
     * </p>
     */
    @Test
    void givenExistingUnorderedPosts_whenFindListUsersFollowedPosts_thenReturnPostsOrderedByDateAsc() throws Exception {
        User userFollower = UtilUserFactory.getUser("user1", 1);
        User followedSeller1 = UtilUserFactory.getSeller(2);
        User followedSeller2 = UtilUserFactory.getSeller(4);
        String order = "date_asc";
        followRepository.saveFollow(userFollower, followedSeller1);
        followRepository.saveFollow(userFollower, followedSeller2);

        List<Post> posts = UtilPostFactory.createUnorderedPosts();
        posts.forEach(post -> postRepository.savePost(post));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ValidationValues.DATE_PATTERN);

        mockMvc.perform(get("/products/followed/{userId}/list", userFollower.getId())
                        .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts[0].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[1].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[2].date").isNotEmpty())
                .andDo(result -> {

                    String date1Str = JsonPath.read(result.getResponse().getContentAsString(), "$.posts[0].date");
                    String date2Str = JsonPath.read(result.getResponse().getContentAsString(), "$.posts[1].date");
                    String date3Str = JsonPath.read(result.getResponse().getContentAsString(), "$.posts[2].date");

                    LocalDate date1 = LocalDate.parse(date1Str, formatter);
                    LocalDate date2 = LocalDate.parse(date2Str, formatter);
                    LocalDate date3 = LocalDate.parse(date3Str, formatter);

                    assertTrue(date1.isBefore(date2));
                    assertTrue(date2.isBefore(date3));
                });
    }

    /**
     * Integration Test to verify that an invalid order type returns a 400 Bad Request error.
     */
    @Test
    void givenInvalidOrder_whenFindListUsersFollowedPosts_thenReturnBadRequest() throws Exception {
        Integer userFollowerId = 1;
        String invalidOrder = "wrong_order";

        mockMvc.perform(get("/products/followed/{userId}/list", userFollowerId)
                        .param("order", invalidOrder))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(Messages.DATE_ORDER_INVALID));
    }

    /**
     * Integration Test to verify that when an existing post ID is provided,
     * the endpoint returns a successful JSON response containing the expected post data.
     * The test checks that the response status is OK, the content type is JSON,
     * and that the response content contains the post's ID.
     */
    @Test
    public void givenExistingPostId_WhenFindPostById_ThenReturnSuccess() throws Exception {
        Post post = UtilPostFactory.getPostByUser(1, 1);
        postRepository.savePost(post);

        String responseContent = mockMvc.perform(get("/products/findPost/{id}", post.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        assertTrue(responseContent.contains(post.getId().toString()));
    }

    /**
     * Integration Test to verify that when a non-existent post ID is provided,
     * the endpoint returns a Not Found (404) response with a JSON error message indicating that no post was found.
     * The test validates the response status, content type, and that the error message matches the expected value.
     */
    @Test
    public void givenNonExistentPostId_WhenFindPostById_ThenReturnNotFound() throws Exception {
        mockMvc.perform(get("/products/findPost/{id}", 100))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(Messages.NO_POST_FOUND));
    }

    /**
     * Test that verifies the successful retrieval of the promotional post count for an existing user.
     * <p>
     * This test simulates the scenario where an existing user has one promotional post. It sends a GET request
     * to retrieve the promotional post count for the user and verifies that the response returns a `200 OK` status
     * with the correct promotional post count in the response body.
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnSuccessPromoPostCount() throws Exception {
        String userId = "2";

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setUserId(2);
        postRepository.savePost(newPost);

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.promo_products_count").value(1));
    }

    /**
     * Test that verifies the behavior when trying to retrieve the promotional post count for a non-existing user.
     * <p>
     * This test simulates the case where a non-existing user is requested by sending a GET request for the
     * promotional post count. It verifies that the response returns a `404 Not Found` status, with a message
     * indicating the user was not found.
     * </p>
     */
    @Test
    void givenNotExistingUserId_whenFindPromoPost_thenReturnUserException() throws Exception {
        String userId = "10";
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(String.format(Messages.USER_NOT_FOUND_MSG, 10)));
    }

    /**
     * Test that verifies the behavior when trying to retrieve the promotional post count for a non-seller user.
     * <p>
     * This test simulates the case where a user exists, but is not of type SELLER. It sends a GET request
     * to fetch the promotional post count for the user and ensures that the response returns a `400 Bad Request`
     * status with a message indicating the user is not a seller.
     * </p>
     */
    @Test
    void givenExistingNotSellerUserId_whenFindPromoPost_thenReturnUserException() throws Exception {
        String userId = "1";
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(Messages.USER_NOT_SELLER_MSG));
    }

    /**
     * Test that verifies the behavior when trying to retrieve the promotional post count for a user with no promotional posts.
     * <p>
     * This test simulates the case where an existing user has no promotional posts. It sends a GET request
     * to fetch the promotional post count for the user and ensures that the response returns a `404 Not Found`
     * status with a message indicating that no promotional posts were found for the user.
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnNoPromoPostException() throws Exception {
        String userId = "2";
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(String.format(Messages.NO_POST_FOUND, 2)));
    }

    /**
     * Integration Test to verify that when existing posts are retrieved by user ID,
     * the service returns a ListPostDTO containing the posts.
     */
    @Test
    public void givenExistingPosts_whenFindAllPostsBySellerId_thenReturnSuccessResponseEntity() throws Exception {
        Integer userIdSeller = 2;

        List<Post> postsExpected = UtilPostFactory.createUnorderedPosts();

        postsExpected.forEach(post -> {
            post.setUserId(userIdSeller);
            postRepository.savePost(post);
        });

        MvcResult res = mockMvc.perform(get("/products/posts/{userId}", userIdSeller))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();

        ListPostDTO listPostDTORes = UtilObjectMapper.getObjectMapper().readValue(jsonRes, new TypeReference<ListPostDTO>() {
        });
        assertNotNull(listPostDTORes);
        assertEquals(postsExpected.size(), listPostDTORes.getPosts().size());
        List<PostDTO> postsDTOExpected = postsExpected.stream()
                .map(p -> UtilObjectMapper.getObjectMapper()
                        .convertValue(p, PostDTO.class)).toList();
        Assertions.assertThat(listPostDTORes.getPosts()).containsExactlyInAnyOrderElementsOf(postsDTOExpected);
        assertEquals(userIdSeller, listPostDTORes.getUser_id());
    }


    /**
     * Integration Test to verify that when new posts are added to the repository,
     * the findAll endpoint returns the correct list of posts.
     * <p>
     * This test simulates the addition of new posts into the repository using a utility factory.
     * It then performs a GET request to retrieve all posts and verifies that the response contains
     * the correct number of posts along with the appropriate post IDs.
     * </p>
     */
    @Test
    void givenNewPost_whenAddPost_thenReturnNewPost() throws Exception {
        List<Post> posts = UtilPostFactory.createUnorderedPosts();
        posts.forEach(post -> postRepository.savePost(post));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ValidationValues.DATE_PATTERN);
        mockMvc.perform(get("/products/post/findAll"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(3)))
                .andExpect(jsonPath("$[0].post_id").value(posts.getFirst().getId()))
                .andExpect(jsonPath("$[1].post_id").value(posts.get(1).getId()))
                .andExpect(jsonPath("$[2].post_id").value(posts.get(2).getId()));
    }

    /**
     * Integration Test to verify that when a valid post is added,
     * the controller returns a ResponseEntity containing the expected PostSaveDTO with HTTP status OK.
     * <p>
     * This test simulates the creation of a new post
     * Additionally, it checks that the post has been correctly saved in the repository by
     * </p>
     */
    @Test
    void givenValidPost_whenAddPost_thenReturnPostSaveDTO() throws Exception {
        Post post = UtilPostFactory.getPost();
        String postJson = UtilObjectMapper.getObjectMapper().writeValueAsString(post);
        postRepository.savePost(post);
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(Messages.POST_CREATED_SUCCESSFULLY));

        Post savedPost = postRepository.findPostById(post.getId()).orElse(null);
        assertNotNull(savedPost);
        assertEquals(post.getId(), savedPost.getId());
        assertEquals(post.getUserId(), savedPost.getUserId());
    }

    /**
     * Integration Test to verify that when an invalid post with promotion is attempted to be added,
     * the controller returns a 400 Bad Request status and an appropriate error message.
     * <p>
     * This test simulates the creation of a post with the promotion flag set to true,
     * which is considered invalid according to the business rules. It populates a Post object
     * </p>
     */
    @Test
    void givenInvalidPostWithPromo_whenAddPost_thenReturnPostSaveDTO() throws Exception {
        Post post = UtilPostFactory.getPost();
        post.setHasPromo(true);
        String postJson = UtilObjectMapper.getObjectMapper().writeValueAsString(post);
        postRepository.savePost(post);
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(Messages.POST_CANNOT_HAVE_PROMOTION));
    }


    /**
     * Integration Test to verify that when an invalid post with promotion is attempted to be added,
     * the controller returns a 400 Bad Request status and an appropriate error message.
     * <p>
     * This test simulates the creation of a post with the Discount
     * which is considered invalid according to the business rules. It populates a Post object
     * </p>
     */
    @Test
    void givenInvalidPostWithDiscount_whenAddPost_thenReturnPostSaveDTO() throws Exception {
        Post post = UtilPostFactory.getPost();
        post.setDiscount(20.0);
        String postJson = UtilObjectMapper.getObjectMapper().writeValueAsString(post);
        postRepository.savePost(post);
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(Messages.POST_CANNOT_HAVE_DISCOUNT));
    }
}
