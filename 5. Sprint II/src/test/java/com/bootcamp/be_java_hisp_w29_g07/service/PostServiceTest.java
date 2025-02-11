package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.Enum.UserType;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoCountPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoPostDTOOut;
import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g07.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g07.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilObjectMapper;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilPostFactory;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test class for {@link PostServiceImpl}.
 * This class contains unit tests for the methods in {@link PostServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    /**
     * Mocked instance of {@link IUserService} to simulate user service operations.
     */
    @Mock
    private IUserService userService;

    /**
     * Mocked instance of {@link IPostRepository} to simulate post repository operations.
     */
    @Mock
    private IPostRepository postRepository;

    /**
     * Mocked instance of {@link IFollowService} used for testing the follow service without
     * interacting with the actual repository implementation.
     */
    @Mock
    private IFollowService followService;

    /**
     * Injected instance of {@link PostServiceImpl} with mocked dependencies.
     */
    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void addPost() {
    }

    @Test
    void findPostById() {
    }

    @Test
    void findAll() {
    }

    /**
     * Unit Test to verify that posts from followed users are returned in descending order by date.
     * <p>
     * This test mocks the retrieval of followed users and their posts.
     * It verifies that the posts are sorted in descending order (newest first).
     * </p>
     */
    @Test
    void givenExistingUnorderedPosts_whenFindListUsersFollowedPostsByUserId_thenReturnPostsOrderedByDateDesc() {
        Integer userId = 1;
        String order = "date_desc";
        List<Integer> followedUserIds = List.of(2, 4);
        List<Post> posts = UtilPostFactory.createUnorderedPosts();

        when(userService.verifyUserExists(userId)).thenReturn(true);
        when(followService.findFollowedByUserId(userId)).thenReturn(followedUserIds);
        when(postRepository.findPostsByUserIdsAndLastTwoWeeks(followedUserIds)).thenReturn(posts);

        ListPostDTO result = postService.findListUsersFollowedPostsByUserId(userId, order);

        assertNotNull(result);
        assertEquals(3, result.getPosts().size());
        assertTrue(result.getPosts().get(0).getDate().isAfter(result.getPosts().get(1).getDate()));
        assertTrue(result.getPosts().get(1).getDate().isAfter(result.getPosts().get(2).getDate()));

        verify(postRepository, times(1)).findPostsByUserIdsAndLastTwoWeeks(followedUserIds);

    }

    /**
     * Unit Test to verify that posts from followed users are returned in ascending order by date.
     * <p>
     * This test mocks the retrieval of followed users and their posts.
     * It verifies that the posts are sorted in ascending order (oldest first).
     * </p>
     */
    @Test
    void givenExistingUnorderedPosts_whenFindListUsersFollowedPostsByUserId_thenReturnPostsOrderedByDateAsc() {
        Integer userId = 1;
        String order = "date_asc";
        List<Integer> followedUserIds = List.of(2, 4);
        List<Post> posts = UtilPostFactory.createUnorderedPosts();

        when(userService.verifyUserExists(userId)).thenReturn(true);
        when(followService.findFollowedByUserId(userId)).thenReturn(followedUserIds);
        when(postRepository.findPostsByUserIdsAndLastTwoWeeks(followedUserIds)).thenReturn(posts);

        ListPostDTO result = postService.findListUsersFollowedPostsByUserId(userId, order);

        assertNotNull(result);
        assertEquals(3, result.getPosts().size());
        assertTrue(result.getPosts().get(0).getDate().isBefore(result.getPosts().get(1).getDate()));
        assertTrue(result.getPosts().get(1).getDate().isBefore(result.getPosts().get(2).getDate()));

        verify(postRepository, times(1)).findPostsByUserIdsAndLastTwoWeeks(followedUserIds);

    }

    /**
     * Unit Test to verify that the service continues normally when the order type is valid.
     */
    @Test
    void givenValidOrder_whenFindListUsersFollowedPostsByUserId_thenContinueNormally() {
        Integer userId = 1;
        String order = "date_desc";
        List<Integer> followedUserIds = List.of(2, 4);
        List<Post> posts = UtilPostFactory.createUnorderedPosts();

        when(userService.verifyUserExists(userId)).thenReturn(true);
        when(followService.findFollowedByUserId(userId)).thenReturn(followedUserIds);
        when(postRepository.findPostsByUserIdsAndLastTwoWeeks(followedUserIds)).thenReturn(posts);

        ListPostDTO result = postService.findListUsersFollowedPostsByUserId(userId, order);

        assertNotNull(result);
        assertEquals(3, result.getPosts().size());
        verify(userService, times(1)).verifyUserExists(userId);
        verify(followService, times(1)).findFollowedByUserId(userId);
        verify(postRepository, times(1)).findPostsByUserIdsAndLastTwoWeeks(followedUserIds);
    }

    /**
     * Unit Test to verify that an exception is thrown when the order type is invalid.
     */
    @Test
    void givenInvalidOrder_whenFindListUsersFollowedPostsByUserId_thenThrowException() {
        Integer userId = 1;
        String invalidOrder = "random_order";
        assertThrows(
                BadRequestException.class,
                () -> postService.findListUsersFollowedPostsByUserId(userId, invalidOrder));
    }

    /**
     * Unit Test to verify that when a valid user ID is provided,
     * the service returns a ListPostDTO containing the posts from followed users.
     * <p>
     * This test mocks the user existence check, retrieval of followed user IDs,
     * and fetching of posts from the repository, then asserts that the returned DTO
     * is not null and contains the expected posts.
     * </p>
     */
    @Test
    void givenExistingUserId_WhenFindListUsersFollowedPostsByUserId_ThenReturnPostsList() {
        Integer userId = 1;
        List<Integer> userFollowingIds = Arrays.asList(1, 2, 3);
        List<Post> posts = Arrays.asList(UtilPostFactory.getPostByUser(2, 1));
        when(userService.verifyUserExists(userId)).thenReturn(true);
        when(followService.findFollowedByUserId(userId)).thenReturn(userFollowingIds);
        when(postRepository.findPostsByUserIdsAndLastTwoWeeks(userFollowingIds)).thenReturn(posts);

        ListPostDTO postsDto = postService.findListUsersFollowedPostsByUserId(userId, null);

        assertNotNull(postsDto);
        assertEquals(posts.size(), postsDto.getPosts().size());
        verify(userService).verifyUserExists(userId);
        verify(followService).findFollowedByUserId(userId);
        verify(postRepository).findPostsByUserIdsAndLastTwoWeeks(userFollowingIds);
    }

    /**
     * Unit Test to verify that when a non-existent user ID is provided,
     * the service throws a NotFoundException while attempting to retrieve the list of followed posts.
     */
    @Test
    void givenNonExistentUserId_WhenFindListUsersFollowedPostsByUserId_ThenReturnNotFoundException() {
        Integer userId = 1;
        when(userService.verifyUserExists(userId)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> postService.findListUsersFollowedPostsByUserId(userId, null));
        verify(userService).verifyUserExists(userId);
    }

    /**
     * Unit Test to verify that when a valid user exists but does not follow any users,
     * the service throws a NotFoundException while attempting to retrieve followed posts.
     */
    @Test
    void givenNonExistentFollowedUserId_WhenFindListUsersFollowedPostsByUserId_ThenReturnNotFoundException() {
        Integer userId = 1;
        List<Integer> userFollowingIds = new ArrayList<>();
        when(userService.verifyUserExists(userId)).thenReturn(true);
        when(followService.findFollowedByUserId(userId)).thenReturn(userFollowingIds);

        assertThrows(NotFoundException.class, () -> postService.findListUsersFollowedPostsByUserId(userId, null));
        verify(userService).verifyUserExists(userId);
        verify(followService).findFollowedByUserId(userId);
    }

    /**
     * Unit Test to verify that when no posts from followed users exist in the last two weeks,
     * the service throws a NotFoundException.
     */
    @Test
    void givenNonExistentPostInLastTwoWeeks_WhenFindListUsersFollowedPostsByUserId_ThenReturnNotFoundException() {
        Integer userId = 1;
        List<Integer> userFollowingIds = Arrays.asList(1, 2, 3);
        List<Post> posts = new ArrayList<>();
        when(userService.verifyUserExists(userId)).thenReturn(true);
        when(followService.findFollowedByUserId(userId)).thenReturn(userFollowingIds);
        when(postRepository.findPostsByUserIdsAndLastTwoWeeks(userFollowingIds)).thenReturn(posts);

        assertThrows(NotFoundException.class, () -> postService.findListUsersFollowedPostsByUserId(userId, null));
        verify(userService).verifyUserExists(userId);
        verify(followService).findFollowedByUserId(userId);
        verify(postRepository).findPostsByUserIdsAndLastTwoWeeks(userFollowingIds);
    }

    /**
     * Unit Test to verify that when an existing post ID is provided,
     * the service returns a PostDTO containing the correct post data.
     */
    @Test
    void givenExistingPostId_WhenFindPostById_ThenReturnPostDTO() {
        Integer postId = 1;
        Post post = UtilPostFactory.getPostByUser(1,1);
        when(postRepository.findPostById(postId)).thenReturn(Optional.of(post));

        PostDTO postDTO = postService.findPostById(postId);

        assertNotNull(postDTO);
        assertEquals(post.getId(), postDTO.getPost_id());
        verify(postRepository).findPostById(postId);
    }

    /**
     * Unit Test to verify that when a non-existent post ID is provided,
     * the service throws a NotFoundException.
     */
    @Test
    void givenNonExistentPostId_WhenFindPostById_ThenReturnNotFoundException() {
        Integer postId = 10;
        when(postRepository.findPostById(postId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> postService.findPostById(postId));
        verify(postRepository).findPostById(postId);
    }

    /**
     * Test that verifies the correct count of promotional posts for a given user when
     * the user is of type SELLER.
     * <p>
     * This test sets up a mock user of type SELLER and simulates the retrieval of promotional
     * post count through `postService.findPromoPostCountByUserId`. It then checks that the
     * response contains the correct user information and the expected count of promotional posts.
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnPromoPostCount() {
        Integer userId = 4;
        User user = UtilUserFactory.getUser(userId);
        user.setUserType(UserType.SELLER);
        Integer countPromoPost = 2;
        when(userService.findUserById(userId)).thenReturn(user);
        when(postRepository.findPromoPostCountByUserId(userId)).thenReturn(2L);

        PromoCountPostDTO response = postService.findPromoPostCountByUserId(userId);

        assertNotNull(response);
        assertEquals(response.getUser_id(), user.getId());
        assertEquals(response.getUser_name(), user.getUsername());
        assertEquals(countPromoPost, response.getPromo_products_count());
    }

    /**
     * Test that verifies the behavior when trying to find promotional posts for a non-existing user.
     * <p>
     * This test simulates the case where a user does not exist by making the `userService.findUserById`
     * method throw a `NotFoundException`. It then verifies that the `NotFoundException` is thrown when
     * attempting to get the promotional post count for that user.
     * </p>
     */
    @Test
    void givenNotExistingUserId_whenFindPromoPost_thenReturnUserException() {
        Integer userId = 10;
        when(userService.findUserById(userId)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> postService.findPromoPostCountByUserId(userId));
        verify(userService, atLeastOnce()).findUserById(userId);
    }

    /**
     * Test that verifies the behavior when trying to find promotional posts for a non-seller user.
     * <p>
     * This test simulates the case where a user exists but is not of type SELLER. It checks that
     * when a non-seller user tries to fetch the promotional post count, a `BadRequestException` is thrown.
     * The test ensures that the service behaves correctly by throwing the appropriate exception for this user type.
     * </p>
     */
    @Test
    void givenExistingNotSellerUserId_whenFindPromoPost_thenReturnUserException() {
        Integer userId = 1;
        User user = UtilUserFactory.getUser(userId);
        user.setUserType(UserType.USER);
        when(userService.findUserById(userId)).thenReturn(user);
        when(postRepository.findPromoPostCountByUserId(userId)).thenReturn(0L);

        assertThrows(BadRequestException.class, () -> postService.findPromoPostCountByUserId(userId));
        verify(userService, atLeastOnce()).findUserById(userId);
        verify(postRepository, atLeastOnce()).findPromoPostCountByUserId(userId);
    }

    /**
     * Unit Test that verifies the behavior when trying to find promotional posts for a seller user with no promotional posts.
     * <p>
     * This test simulates the case where a seller user exists, but there are no promotional posts for that user
     * (i.e., the post count is zero). It ensures that when no promotional posts are found, a `NotFoundException`
     * is thrown.
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnNoPromoPostException() {
        Integer userId = 2;
        User user = UtilUserFactory.getUser(userId);
        user.setUserType(UserType.SELLER);
        when(userService.findUserById(userId)).thenReturn(user);
        when(postRepository.findPromoPostCountByUserId(userId)).thenReturn(0L);

        assertThrows(NotFoundException.class, () -> postService.findPromoPostCountByUserId(userId));
        verify(userService, atLeastOnce()).findUserById(userId);
        verify(postRepository, atLeastOnce()).findPromoPostCountByUserId(userId);
    }

    /**
     * Unit Test to verify that when a non-existent promotional post is created,
     * a PromoPostDTOOut is returned.
     */
    @Test
    void givenNonExistentPromoPost_whenCreatePromoPost_thenReturnPromoPostDTOOut() {
        User user = UtilUserFactory.getSeller("cmorales", 2);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setId(null);

        Post savedPost = UtilPostFactory.getPromoPost();
        savedPost.setUserId(user.getId());
        PromoPostDTOOut promoPostDTOOutExpected = UtilPostFactory.getPromoPostDTOOut(savedPost);

        when(userService.findUserById(user.getId())).thenReturn(user);
        when(postRepository.savePost(newPost)).thenReturn(savedPost);

        PromoPostDTOOut promoPostDTOOutRes = postService.createPromoPost(UtilPostFactory.getPromoPostDTOIn(newPost));

        verify(userService).findUserById(user.getId());
        verify(postRepository).savePost(newPost);
        assertEquals(promoPostDTOOutExpected, promoPostDTOOutRes);
    }

    /**
     * Unit Test to verify that when a non-seller user attempts to create a promotional post,
     * a BadRequestException is thrown.
     */
    @Test
    void givenNonSellerUser_whenCreatePromoPost_thenReturnBadRequestException() {
        User user = UtilUserFactory.getUser("alargo", 1);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setUserId(user.getId());
        newPost.setId(null);

        when(userService.findUserById(user.getId())).thenReturn(user);

        assertThrows(BadRequestException.class, () -> postService.createPromoPost(UtilPostFactory.getPromoPostDTOIn(newPost)));
        verify(userService).findUserById(user.getId());
    }

    /**
     * Unit Test to verify that when a new post without a promo is created,
     * a BadRequestException is thrown.
     */
    @Test
    void givenNewPostWithoutPromo_whenCreatePromoPost_thenReturnBadRequestException() {
        User user = UtilUserFactory.getSeller("cmorales", 2);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setUserId(user.getId());
        newPost.setId(null);
        newPost.setHasPromo(false);

        when(userService.findUserById(user.getId())).thenReturn(user);

        assertThrows(BadRequestException.class, () -> postService.createPromoPost(UtilPostFactory.getPromoPostDTOIn(newPost)));
        verify(userService).findUserById(user.getId());
    }

    /**
     * Unit Test to verify that when a new post without a discount is created,
     * a BadRequestException is thrown.
     */
    @Test
    void givenNewPostWithoutDiscount_whenCreatePromoPost_thenReturnBadRequestException() {
        User user = UtilUserFactory.getSeller("cmorales", 2);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setUserId(user.getId());
        newPost.setId(null);
        newPost.setDiscount(null);

        when(userService.findUserById(user.getId())).thenReturn(user);

        assertThrows(BadRequestException.class, () -> postService.createPromoPost(UtilPostFactory.getPromoPostDTOIn(newPost)));
        verify(userService).findUserById(user.getId());
    }

    /**
     * Unit Test to verify that when a new post with a discount of zero is created,
     * a BadRequestException is thrown.
     */
    @Test
    void givenNewPostWithDiscountZero_whenCreatePromoPost_thenReturnBadRequestException() {
        User user = UtilUserFactory.getSeller("cmorales", 2);

        Post newPost = UtilPostFactory.getPromoPost();
        newPost.setUserId(user.getId());
        newPost.setId(null);
        newPost.setDiscount(0.0);

        when(userService.findUserById(user.getId())).thenReturn(user);

        assertThrows(BadRequestException.class, () -> postService.createPromoPost(UtilPostFactory.getPromoPostDTOIn(newPost)));
        verify(userService).findUserById(user.getId());
    }

    /**
     * Unit Test to verify that when existing posts are retrieved by user ID,
     * the service returns a ListPostDTO containing the posts.
     */
    /**
     * Unit Test to verify that when findAll is called on the PostService,
     * it returns a list of PostDTOs correctly mapped from the Post entities in the repository.
     * <p>
     * This test simulates a scenario where two posts are created and saved in the repository.
     * It verifies that the service returns a non-null list of PostDTOs,
     * with the expected size and correct user IDs and product names for each post.
     * </p>
     */
    @Test
    void givenExistingPosts_whenFindAllPostBySellerId_thenReturnPostList() {

        User user = UtilUserFactory.getSeller("cmorales", 2);
        List<Post> postsExpected = UtilPostFactory.createUnorderedPosts();
        postsExpected.forEach(p -> {
            p.setUserId(user.getId());
            postRepository.savePost(p);
        });
        List<PostDTO> postsDTOExpected = postsExpected.stream()
                .map(p -> UtilObjectMapper.getObjectMapper()
                        .convertValue(p, PostDTO.class)).toList();
        when(userService.findUserById(user.getId())).thenReturn(user);
        when(postRepository.findAllPostsByUserId(user.getId())).thenReturn(postsExpected);

        ListPostDTO listPostDTO = postService.findAllPostBySellerId(user.getId());
        verify(userService).findUserById(user.getId());
        verify(postRepository).findAllPostsByUserId(user.getId());

        assertNotNull(listPostDTO);
        assertEquals(postsExpected.size(), listPostDTO.getPosts().size());
        assertThat(listPostDTO.getPosts()).containsExactlyInAnyOrderElementsOf(postsDTOExpected);
        assertEquals(user.getId(), listPostDTO.getUser_id());
    }

    /**
     * Unit Test to verify that when a non-seller user attempts to retrieve all posts by user ID,
     * a BadRequestException is thrown.
     */
    @Test
    void givenUserNonSeller_whenFindAllPostBySellerId_thenReturnBadRequestException() {

        User user = UtilUserFactory.getUser("cmorales", 2);
        when(userService.findUserById(user.getId())).thenReturn(user);

        assertThrows(BadRequestException.class, () -> postService.findAllPostBySellerId(user.getId()));
        verify(userService).findUserById(user.getId());
        List<Post> posts = new ArrayList<>();

        Post post1 = UtilPostFactory.getPost();
        Post post2 = UtilPostFactory.getPost();
        post1.setUserId(1);
        post2.setId(2);
        post2.getProduct().setName("cars");

        posts.add(post1);
        posts.add(post2);

        when(postRepository.findAll()).thenReturn(posts);

        List<PostDTO> result = postService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.getFirst().getUser_id());
        assertEquals(2, result.get(1).getUser_id());
        assertEquals("Laptop", result.getFirst().getProduct().getName());
        assertEquals("cars", result.get(1).getProduct().getName());

        verify(postRepository).findAll();
    }

    /**
     * Unit Test to verify that when findAll is called on the PostService,
     * it returns a list of PostDTOs correctly mapped from the Post entities in the repository.
     * <p>
     * This test simulates a scenario where two posts are created and saved in the repository.
     * It verifies that the service returns a non-null list of PostDTOs,
     * with the expected size and correct user IDs and product names for each post.
     * </p>
     */
    @Test
    void givenExistingPost_whenFindAll_thenReturnListOfPostDTOs() {
        List<Post> posts = new ArrayList<>();

        Post post1 = UtilPostFactory.getPost();
        Post post2 = UtilPostFactory.getPost();
        post1.setUserId(1);
        post2.setId(2);
        post2.getProduct().setName("cars");

        posts.add(post1);
        posts.add(post2);

        when(postRepository.findAll()).thenReturn(posts);

        List<PostDTO> result = postService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.getFirst().getUser_id());
        assertEquals(2, result.get(1).getUser_id());
        assertEquals("Laptop", result.getFirst().getProduct().getName());
        assertEquals("cars", result.get(1).getProduct().getName());

        verify(postRepository).findAll();
    }
}