package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is an implementation of the IPostRepository interface.
 * It provides concrete methods for saving posts, finding posts by various criteria,
 * counting promotional posts, and retrieving posts based on user-following data.
 */
@Repository
public class PostRepositoryImpl implements IPostRepository {
    /**
     * The list of posts.
     */
    private List<Post> posts = new ArrayList<>();
    /**
     * The constant idCounter.
     * This counter is used to assign unique IDs to new posts.
     */
    private static int idCounter = 1;

    /**
     * Initializes the repository and loads posts from a JSON file.
     * @throws IOException the io exception if there is an error loading the posts
     */
    public PostRepositoryImpl() throws IOException {
        loadPostsJson();
    }

    /**
     * Counts the number of posts with promotions for a given user.
     *
     * @param userId the user id of the user whose promotional posts are counted
     * @return the count of promotional posts by the specified user
     */
    @Override
    public Long findPromoPostCountByUserId(Integer userId) {
        return (long) posts.stream()
                .filter(post -> post.getUserId().equals(userId))
                .filter(Post::getHasPromo)
                .toList()
                .size();
    }

    /**
     * Saves a new post to the repository. It assigns a unique ID
     * @param post the post to be saved
     * @return the saved Post instance
     */
    @Override
    public Post savePost(Post post) {
        post.setId(findNextId());
        posts.add(post);
        return post;
    }

    /**
     * retrieves a post by its ID.
     * If the post is found, it returns an Optional containing the Post instance;
     * @param id the id of the post to find
     * @return an Optional containing the Post instance if found, otherwise empty
     */
    @Override
    public Optional<Post> findPostById(Integer id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    /**
     * Retrieves all the posts stored in the repository.
     * @return a list of all Post instances
     */
    @Override
    public List<Post> findAll() {
        return posts;
    }

    /**
     * Returns the next available ID for a new post.
     * @return the next unique ID
     */
    @Override
    public Integer findNextId() {
        return idCounter++;
    }

    /**
     * Retrieves posts from users that the given user is following,
     * @param userFollowing a list of user IDs that the user is following
     * @return a list of Post instances from followed users that were created
     *         within the last two weeks
     */
    @Override
    public List<Post> findPostsByUserIdsAndLastTwoWeeks(List<Integer> userFollowing) {
        return posts.stream().filter(post -> userFollowing.contains(post.getUserId()) &&
                        post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .toList();
    }

    /**
     * Retrieves all the posts stored in the repository by user's id
     * @return a list of all Post by user's id
     */
    @Override
    public List<Post> findAllPostsByUserId(Integer userId){
        return posts.stream().filter(post -> post.getUserId().equals(userId)).toList();
    }

    @Override
    public void deleteAll() {
        this.posts.clear();
    }

    /**
     * Loads posts from a JSON file located in the classpath.
     * @throws IOException the io exception if there is an error loading the JSON file
     */
    private void loadPostsJson() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        List<Post> postsJson;

        file = ResourceUtils.getFile("classpath:posts.json");
        postsJson = objectMapper.readValue(file, new TypeReference<List<Post>>() {
        });

        posts = postsJson;
        if (!posts.isEmpty()) {
            idCounter = posts.stream().mapToInt(Post::getId).max().orElse(0) + 1;
        }
    }
}
