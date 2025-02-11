package com.bootcamp.be_java_hisp_w29_g07.util;

import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.bootcamp.be_java_hisp_w29_g07.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.bootcamp.be_java_hisp_w29_g07.dto.request.ProductDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.request.PromoPostDTOIn;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.PromoPostDTOOut;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Factory class for creating {@link Post}, {@link Product} and {@link PostDTO} objects with predefined values.
 * This class is used to simplify the creation of {@link Post} instances and their associated DTOs,
 * particularly in test scenarios where mock posts and products are required.
 */

public class UtilPostFactory {

    /**
     * Creates a new {@link Post} instance for the given user and week offset.
     *
     * @param userId the ID of the user associated with the post.
     * @param week   the number of weeks to subtract from the current date to set the post's date.
     * @return a {@link Post} object with predefined values.
     */
    public static Post getPostByUser(Integer userId, Integer week) {
        return new Post(1, userId, LocalDate.now().minusWeeks(week), getProduct(userId + 1), 3, 100.0, false, 0.0);
    }

    /**
     * Creates a new {@link Product} instance with generic values.
     *
     * @param id the ID to assign to the product.
     * @return a {@link Product} object with generic attributes.
     */
    public static Product getProduct(Integer id) {
        return new Product(id, "Generic Product", "Generic Type", "Generic brand", "white", "N/A");
    }

    /**
     * Creates a list of {@link PostDTO} objects for the given user by converting {@link Post} instances.
     *
     * @param userId the ID of the user for which the posts are generated.
     * @return a list of {@link PostDTO} objects.
     */
    public static List<PostDTO> getPostDTOList(Integer userId) {
        List<Post> listPost = Arrays.asList(
                UtilPostFactory.getPostByUser(userId, 1),
                UtilPostFactory.getPostByUser(userId, 1)
        );

        return listPost.stream()
                .map(post -> UtilObjectMapper.getObjectMapper().convertValue(post, PostDTO.class))
                .toList();
    }

    public static PostDTO getPostDTO(Integer userId) {
        return UtilObjectMapper.getObjectMapper().convertValue(UtilPostFactory.getPostByUser(userId, 1), PostDTO.class);
    }

    /**
     * Creates a list of unordered {@link Post} instances.
     * This method is useful for testing scenarios where the order of posts is not predetermined.
     *
     * @return a list of {@link Post} objects.
     */
    public static List<Post> createUnorderedPosts() {
        return Arrays.asList(
                new Post(1, 4, LocalDate.now().minusDays(10), null, 101, 0.0, false, 0.0),
                new Post(2, 4, LocalDate.now().minusDays(2), null, 101, 0.0, false, 0.0),
                new Post(3, 2, LocalDate.now(), null, 101, 0.0, false, 0.0)
        );
    }

    /**
     * Creates a new instance of {@link Post} with predefined values.
     *
     * @return a {@link Post} object with default values.
     */
    public static Post getPost() {
        Product product = new Product(
                1,
                "Laptop",
                "Electronics",
                "Dell",
                "Black",
                "15 inch screen Intel i7"
        );

        return new Post(
                1,
                2,
                LocalDate.of(2024, 2, 6),
                product,
                5,
                200.0,
                false,
                0.0
        );
    }

    /**
     * Converts a {@link Post} object to a {@link PromoPostDTOIn} object.
     *
     * @param post the post to convert.
     * @return a {@link PromoPostDTOIn} object with values from the specified post.
     */
    public static PromoPostDTOIn getPromoPostDTOIn(Post post) {
        PromoPostDTOIn promoPostDTOIn = new PromoPostDTOIn();
        promoPostDTOIn.setHas_promo(post.getHasPromo());
        promoPostDTOIn.setUser_id(post.getUserId());
        promoPostDTOIn.setCategory(post.getCategory());
        promoPostDTOIn.setDate(post.getDate());
        promoPostDTOIn.setPrice(post.getPrice());
        promoPostDTOIn.setDiscount(post.getDiscount());
        promoPostDTOIn.setProduct(UtilObjectMapper.getObjectMapper().convertValue(post.getProduct(), ProductDTO.class));
        return promoPostDTOIn;
    }

    /**
     * Converts a {@link Post} object to a {@link PromoPostDTOOut} object.
     *
     * @param post the post to convert.
     * @return a {@link PromoPostDTOOut} object with values from the specified post.
     */
    public static PromoPostDTOOut getPromoPostDTOOut(Post post) {
        return UtilObjectMapper.getObjectMapper().convertValue(post, PromoPostDTOOut.class);
    }

    /**
     * Creates a new instance of {@link Post} with predefined values and promotional details.
     *
     * @return a {@link Post} object with promotional details.
     */
    public static Post getPromoPost() {
        Post promoPost = getPost();
        promoPost.setHasPromo(true);
        promoPost.setDiscount(2.0);
        return promoPost;
    }

    /**
     * Creates a new instance of {@link PostDTO} with predefined values.
     *
     * @return a {@link PostDTO} object with default values.
     */
    public static PostDTO getPostDto() {
        Product product = new Product(
                1,
                "Laptop",
                "Electronics",
                "Dell",
                "Black",
                "15-inch screen, Intel i7"
        );

        return new PostDTO(
                1,
                2,
                LocalDate.of(2024, 2, 6),
                product,
                5,
                200.0,
                false,
                0.0
        );
    }



}

