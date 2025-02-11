package com.bootcamp.be_java_hisp_w29_g07.controller;

import com.bootcamp.be_java_hisp_w29_g07.Enum.UserType;
import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.request.PromoPostDTOIn;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoCountPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoPostDTOOut;
import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g07.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g07.service.IPostService;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilPostFactory;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Unit test class for {@link PostController}.
 */
@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    /**
     * Mocked instance of {@link IPostService} to simulate post service operations.
     */
    @Mock
    private IPostService postService;

    /**
     * Injected instance of {@link PostController} with mocked dependencies.
     */
    @InjectMocks
    private PostController postController;

    /**
     * Unit Test to verify that when a non-existent promotional post is created,
     * a success response entity is returned.
     */
    @Test
    public void givenNonExistentPromoPost_whenCreatePromoPost_thenReturnSuccessResponseEntity() {
        User user = UtilUserFactory.getSeller("cmorales", 2);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setId(null);

        Post savedPost = UtilPostFactory.getPromoPost();
        savedPost.setUserId(user.getId());
        PromoPostDTOOut promoPostDTOOutExpected = UtilPostFactory.getPromoPostDTOOut(savedPost);

        PromoPostDTOIn promoPostDTOIn = UtilPostFactory.getPromoPostDTOIn(newPost);
        when(postService.createPromoPost(promoPostDTOIn)).thenReturn(promoPostDTOOutExpected);

        ResponseEntity<PromoPostDTOOut> responseEntity = postController.createPromoPost(promoPostDTOIn);

        verify(postService).createPromoPost(promoPostDTOIn);
        assertEquals(promoPostDTOOutExpected, responseEntity.getBody());
    }

    /**
     * Unit Test to verify that when a valid user ID is provided,
     * the controller returns a ResponseEntity containing the expected ListPostDTO with HTTP status OK.
     */
    @Test
    public void givenExistingUserId_whenFindListUsersFollowedPosts_ThenReturnSuccessResponseEntity() {
        Integer userIdA = 1;
        Integer userIdB = 2;
        List<PostDTO> postDTOList = UtilPostFactory.getPostDTOList(userIdB);
        ListPostDTO listPostDTO = new ListPostDTO(userIdA, postDTOList);
        when(postService.findListUsersFollowedPostsByUserId(userIdA, null))
                .thenReturn(listPostDTO);

        ResponseEntity<ListPostDTO> response = postController.findListUsersFollowedPosts(userIdA, null);

        verify(postService, atLeastOnce()).findListUsersFollowedPostsByUserId(userIdA, null);
        assertNotNull(response.getBody());
        assertEquals(listPostDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Test that verifies the successful retrieval of the promotional post count for a seller user.
     * <p>
     * This test simulates the scenario where a seller user exists and has a promotional post count.
     * It ensures that when the promotional post count is fetched, the correct data is returned
     * with a `200 OK` status and the expected promotional post count in the response body.
     * </p>
     *
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnSuccessPromoPostCount() {
        Integer userId = 4;
        User user = UtilUserFactory.getUser(userId);
        user.setUserType(UserType.SELLER);
        PromoCountPostDTO expected = new PromoCountPostDTO(user.getId(), user.getUsername(), 2);
        when(postService.findPromoPostCountByUserId(userId)).thenReturn(expected);

        ResponseEntity<?> response = postController.getPromoPostCountById(userId);

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    /**
     * Test that verifies the behavior when trying to retrieve the promotional post count for a non-existing user.
     * <p>
     * This test simulates the scenario where a user does not exist by making the `postService.findPromoPostCountByUserId`
     * method throw a `NotFoundException`. It ensures that when attempting to fetch the promotional post count for
     * a non-existing user, a `NotFoundException` is thrown, and the correct exception handling is triggered in the controller.
     * </p>
     */
    @Test
    void givenNotExistingUserId_whenFindPromoPost_thenReturnUserException() {
        Integer userId = 10;
        when(postService.findPromoPostCountByUserId(userId)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> postController.getPromoPostCountById(userId));
        verify(postService, atLeastOnce()).findPromoPostCountByUserId(userId);
    }

    /**
     * Test that verifies the behavior when trying to retrieve the promotional post count for a non-seller user.
     * <p>
     * This test simulates the case where a user exists, but is not a seller. It ensures that when
     * a non-seller user attempts to fetch the promotional post count, a `BadRequestException` is thrown.
     * The test also ensures that the exception is handled correctly in the controller.
     * </p>
     */
    @Test
    void givenExistingNotSellerUserId_whenFindPromoPost_thenReturnUserException() {
        Integer userId = 1;
        when(postService.findPromoPostCountByUserId(userId)).thenThrow(BadRequestException.class);

        assertThrows(BadRequestException.class, () -> postController.getPromoPostCountById(userId));
        verify(postService, atLeastOnce()).findPromoPostCountByUserId(userId);
    }

    /**
     * Test that verifies the behavior when attempting to retrieve the promotional post count for a user
     * who has no promotional posts.
     * <p>
     * This test simulates the scenario where a user exists, but the `findPromoPostCountByUserId` method
     * throws a `NotFoundException` due to no promotional posts being available for that user. The test ensures
     * that the exception is properly thrown and that the service method is called at least once.
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnNoPromoPostException() {
        Integer userId = 2;
        when(postService.findPromoPostCountByUserId(userId)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> postService.findPromoPostCountByUserId(userId));
        verify(postService, atLeastOnce()).findPromoPostCountByUserId(userId);
    }

    /**
     * Unit Test to verify that when a valid post ID is provided,
     * the controller returns a ResponseEntity containing the expected PostDTO with HTTP status OK.
     */
    @Test
    public void givenExistingPostId_WhenFindPostById_ThenReturnSuccessResponseEntity(){
        Integer postId = 1;
        PostDTO postDTO = UtilPostFactory.getPostDTO(1);
        when(postService.findPostById(postId)).thenReturn(postDTO);

        ResponseEntity<?> response = postController.findPostById(postId);

        verify(postService, atLeastOnce()).findPostById(postId);
        assertNotNull(response.getBody());
        assertEquals(postDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Unit Test to verify that when a valid seller ID is provided,
     * the controller returns a ResponseEntity containing the expected ListPostDTO with HTTP status OK.
     */
    @Test
    public void givenExistingPosts_whenFindAllPostsBySellerId_thenReturnSuccessResponseEntity(){
        Integer userIdSeller = 2;
        List<PostDTO> postDTOList = UtilPostFactory.getPostDTOList(userIdSeller);
        ListPostDTO listPostDTO = new ListPostDTO(userIdSeller, postDTOList);

        when(postService.findAllPostBySellerId(userIdSeller)).thenReturn(listPostDTO);

        ResponseEntity<ListPostDTO> responseEntity = postController.findAllPostsBySellerId(userIdSeller);

        verify(postService).findAllPostBySellerId(userIdSeller);
        assertNotNull(responseEntity.getBody());
        assertThat(responseEntity.getBody().getPosts()).containsExactlyInAnyOrderElementsOf(postDTOList);
        assertEquals(userIdSeller, responseEntity.getBody().getUser_id());
    }

    /**
     * Unit Test to verify that when the getAll endpoint is called,
     * it returns a list of PostDTOs with HTTP status OK.
     * <p>
     * This test simulates a request to retrieve all posts.
     * It verifies that the response body is not null, that the HTTP status
     * is 200 OK, and that the returned list of PostDTOs matches the expected data.
     * </p>
     */
    @Test
    public void givenExistingPost_whenGetAll_thenReturnListOfPostDTOs()
    {
        List<PostDTO> mockResponse = new ArrayList<>();
        PostDTO post1 = UtilPostFactory.getPostDto();
        PostDTO post2 = UtilPostFactory.getPostDto();
        post1.setUser_id(1);
        post2.setUser_id(2);
        post2.getProduct().setName("cars");

        mockResponse.add(post1);
        mockResponse.add(post2);

        when(postService.findAll()).thenReturn(mockResponse);

        ResponseEntity<List<PostDTO>> response = postController.getAll();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse,response.getBody());
    }
}
