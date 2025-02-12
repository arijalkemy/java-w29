package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilPostFactory;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PostRepositoryTest {
    /**
     * Instance of {@link IPostRepository} that is being tested.
     * It is initialized with a concrete implementation before each test.
     */
    private IPostRepository postRepository;

    /**
     * Set up the test environment before each test method is run.
     * Initializes the {@link IPostRepository} with its concrete implementation {@link PostRepositoryImpl}.
     * This ensures that a fresh instance is created for each test.
     */
    @BeforeEach
    public void setUp() throws IOException {
        this.postRepository = new PostRepositoryImpl();
        postRepository.deleteAll();
    }

    /**
     * Test that checks if the correct count of promotional posts is returned for a given user.
     * <p>
     * This test creates a post associated with an existing user, marks it as a promotional post,
     * and then checks if the method `findPromoPostCountByUserId` returns the correct number of
     * promotional posts for that user.
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnPromoPostCount() {
        Integer userId = 4;
        Long expected = 1L;
        Post postA = UtilPostFactory.getPostByUser(userId, 1);
        postA.setHasPromo(true);
        postRepository.savePost(postA);

        Long response = postRepository.findPromoPostCountByUserId(userId);

        assertEquals(expected, response);
    }

    /**
     * Test that checks if the correct count of non-promotional posts is returned for a given user.
     * <p>
     * This test creates a post associated with an existing user, marks it as a non-promotional post,
     * and then checks if the method `findPromoPostCountByUserId` returns the correct count of
     * promotional posts (which should be zero in this case).
     * </p>
     */
    @Test
    void givenExistingUserId_whenFindPromoPost_thenReturnNonPromoPostCount() {
        Integer userId = 4;
        Long expected = 0L;
        Post postA = UtilPostFactory.getPostByUser(userId, 1);
        postA.setHasPromo(false);
        postRepository.savePost(postA);

        Long response = postRepository.findPromoPostCountByUserId(userId);

        assertEquals(expected, response);
    }

    /**
     * Unit Test to verify that when an existing user ID is provided,
     * the repository returns a list of posts from followed users created in the last two weeks.
     * The test asserts that the post list is not null, contains the expected number of posts,
     * and that each post's date is before the current date.
     */
    @Test
    void givenExistingUserId_whenFindPostsByUserIdsLastTwoWeeks_thenReturnPostList() {
        List<Integer> usersFollowing = new ArrayList<>();
        usersFollowing.add(1);
        usersFollowing.add(2);
        usersFollowing.add(3);
        Post postA = UtilPostFactory.getPostByUser(usersFollowing.get(0), 1);
        Post postB = UtilPostFactory.getPostByUser(usersFollowing.get(1), 1);
        Post postC = UtilPostFactory.getPostByUser(usersFollowing.get(2), 3);
        postRepository.savePost(postA);
        postRepository.savePost(postB);
        postRepository.savePost(postC);

        List<Post> postList = postRepository.findPostsByUserIdsAndLastTwoWeeks(usersFollowing);

        Assertions.assertNotNull(postList);
        assertEquals(2, postList.size());
        assertThat(postList)
                .allSatisfy(post -> assertThat(post.getDate()).isBefore(LocalDate.now()));
    }

    /**
     * Unit Test to verify that when a non-existent user ID is provided,
     * the repository returns an empty list of posts from followed users created in the last two weeks.
     */
    @Test
    void givenNonExistentUserId_whenFindPostsByUserIdsLastTwoWeeks_thenReturnEmptyPostList() {
        List<Integer> usersFollowing = new ArrayList<>();
        usersFollowing.add(999);
        Post postA = UtilPostFactory.getPostByUser(1, 1);
        postRepository.savePost(postA);

        List<Post> postList = postRepository.findPostsByUserIdsAndLastTwoWeeks(usersFollowing);

        assertTrue(postList.isEmpty());
    }

    /**
     * Unit Test to verify that when existent user IDs are provided,
     * if none of the posts from these users fall within the last two weeks,
     * the repository returns an empty post list.
     */
    @Test
    void givenExistentUserId_whenFindPostsByUserIdsLastTwoWeeks_thenReturnPostList() {
        List<Integer> usersFollowing = new ArrayList<>();
        usersFollowing.add(1);
        usersFollowing.add(2);
        Post postA = UtilPostFactory.getPostByUser(usersFollowing.get(0), 2);
        Post postB = UtilPostFactory.getPostByUser(usersFollowing.get(1), 3);
        postRepository.savePost(postA);
        postRepository.savePost(postB);

        List<Post> postList = postRepository.findPostsByUserIdsAndLastTwoWeeks(usersFollowing);

        assertTrue(postList.isEmpty());
    }

    /**
     * Unit Test to verify that when existing posts are present for a given user ID,
     * the repository returns a list of posts for that user.
     * The test asserts that the actual list of posts matches the expected list of posts
     * in any order.
     */
    @Test
    void givenExistingPosts_whenFindAllPostsByUserId_thenReturnPostList() {
        List<Post> postsExpected = UtilPostFactory.createUnorderedPosts();
        postsExpected.forEach(p -> {
            p.setUserId(1);
            postRepository.savePost(p);
        });

        List<Post> postsActual = postRepository.findAllPostsByUserId(1);

        assertThat(postsActual).containsExactlyInAnyOrderElementsOf(postsExpected);
    }

    /**
     * Unit Test to verify that when no posts exist for a given user ID,
     * the repository returns an empty list of posts.
     * The test asserts that the actual list of posts is empty.
     */
    @Test
    void givenNonExistingPosts_whenFindAllPostsByUserId_thenReturnPostListEmpty() {
        List<Post> postsActual = postRepository.findAllPostsByUserId(1);

        assertTrue(postsActual.isEmpty());
    }

    /**
     * Unit Test to verify that when an existing post ID is provided,
     * the repository returns an Optional containing the post with the matching ID.
     */
    void givenExistingUserId_WhenFindPostById_ThenReturnOptional() {
        Integer postId = 1;
        Post post = UtilPostFactory.getPostByUser(1, 1);
        postRepository.savePost(post);

        Optional<Post> optionalPost = postRepository.findPostById(postId);

        Assertions.assertTrue(optionalPost.isPresent());
        Assertions.assertEquals(postId, optionalPost.get().getId());
    }

    /**
     * Unit Test to verify that when a non-existing post ID is provided,
     * the repository returns an Optional.
     */
    @Test
    void givenNonExistentUserId_WhenFindPostById_ThenReturnOptional() {
        Integer postId = 10;
        Post post = UtilPostFactory.getPostByUser(1, 1);
        postRepository.savePost(post);

        Optional<Post> optionalPost = postRepository.findPostById(postId);

        Assertions.assertTrue(optionalPost.isEmpty());
    }

    /**
     * Unit Test to verify that when findAll is called,
     * it returns a list of posts currently in the repository with correct user and product details.
     * <p>
     * This test creates two posts with specified user IDs and product names,
     * saves them to the repository, and verifies that the repository returns
     * the correct number of posts along with their expected attributes.
     * </p>
     */
    @Test
    void givenExistingPost_whenFindAll_thenReturnListOfPosts() {
        List<Post> posts = new ArrayList<>();
        Post post1 = UtilPostFactory.getPost();
        Post post2 = UtilPostFactory.getPost();

        post1.setUserId(1);
        post2.setId(2);
        post2.getProduct().setName("cars");

        posts.add(post1);
        posts.add(post2);

        posts.forEach(post -> postRepository.savePost(post));
        List<Post> result = postRepository.findAll();

        assertEquals(posts.size(), result.size());
        assertEquals(1, result.getFirst().getUserId());
        assertEquals("Laptop", result.getFirst().getProduct().getName());
        assertEquals("cars", result.get(1).getProduct().getName());
    }


    /**
     * Unit Test to verify that when a new post is added to the repository,
     * the correct post instance with assigned ID is returned.
     * <p>
     * This test creates a new post using a utility factory,
     * saves it to the repository, and verifies that the returned post
     * contains the expected attributes, including the unique generated ID.
     * </p>
     */
    @Test
    void givenExistentPost_whenSavePost_thenReturnNewPost() {
        Post expectedPost = UtilPostFactory.getPost();

        Post responsePost = postRepository.savePost(expectedPost);
        expectedPost.setId(responsePost.getId());
        assertEquals(expectedPost, responsePost);
    }

}