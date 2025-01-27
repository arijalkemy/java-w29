package com.bootcamp.be_java_hisp_w29_g07.controller;

import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.request.PromoPostDTOIn;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListPostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PostSaveDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoPostDTOOut;
import com.bootcamp.be_java_hisp_w29_g07.service.IPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class defines a set of endpoints for managing posts.
 */
@RestController
@RequestMapping("/products")
@Tag(name = "Post")
public class PostController {

    /**
     * The Post service.
     */
    private final IPostService postService;

    /**
     * Constructor that instantiates a new Post controller.
     *
     * @param postService the post service
     */
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    /**
     * Counts the number of promotional posts a user has.
     *
     * @param userId the user ID
     * @return a {@link ResponseEntity} containing the count of promotional posts
     */
    @Operation(summary = "Count the number of posts a user has")
    @GetMapping("promo-post/count")
    private ResponseEntity<?> getPromoPostCountById(@RequestParam("user_id") Integer userId) {
        return new ResponseEntity<>(postService.findPromoPostCountByUserId(userId), HttpStatus.OK);
    }

    /**
     * Finds a post by its ID.
     *
     * @param id the ID of the post
     * @return a {@link ResponseEntity} containing the post details
     */
    @Operation(summary = "Search for a post by ID")
    @GetMapping("/findPost/{id}")
    public ResponseEntity<?> findPostById(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    /**
     * Retrieves all posts.
     *
     * @return a {@link ResponseEntity} containing a list of all posts
     */
    @Operation(summary = "Get all posts")
    @GetMapping("/post/findAll")
    public ResponseEntity<List<PostDTO>> getAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    /**
     * Adds a new post.
     *
     * @param posDto the post data transfer object
     * @return a {@link ResponseEntity} confirming the addition of the post
     */
    @Operation(summary = "Add new post")
    @PostMapping("/post")
    public ResponseEntity<PostSaveDTO> addPost(@RequestBody PostDTO posDto) {
        return new ResponseEntity<>(postService.addPost(posDto), HttpStatus.OK);
    }

    /**
     * Creates a new promotional post.
     *
     * @param promoPostDTOIn the promotional post data transfer object
     * @return a {@link ResponseEntity} containing the created promotional post
     */
    @Operation(summary = "Add new promo post")
    @PostMapping("/promo-post")
    private ResponseEntity<PromoPostDTOOut> createPromoPost(@RequestBody PromoPostDTOIn promoPostDTOIn) {
        return new ResponseEntity<>(postService.createPromoPost(promoPostDTOIn), HttpStatus.OK);
    }

    /**
     * Retrieves a list of posts from users followed by a specific user, with optional sorting.
     *
     * @param userId the ID of the user
     * @param order  the order for sorting (optional)
     * @return a {@link ResponseEntity} containing the list of followed users' posts
     */
    @Operation(summary = "list of followers by user id")
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListPostDTO> findListUsersFollowedPosts(
            @PathVariable Integer userId,
            @RequestParam(value = "order", required = false) String order
    ) {
        return new ResponseEntity<>(postService.findListUsersFollowedPostsByUserId(userId, order), HttpStatus.OK);
    }

    /**
     * Retrieves a list of posts by seller's id
     *
     * @param sellerId seller's id
     * @return a {@link ResponseEntity} containing the list of seller's posts
     */
    @Operation(summary = "List posts by seller")
    @GetMapping("/posts/{userId}")
    private ResponseEntity<ListPostDTO> findAllPostsBySellerId(@PathVariable(name="userId") Integer sellerId) {
        return new ResponseEntity<>(postService.findAllPostBySellerId(sellerId), HttpStatus.OK);
    }

}