package com.social_media.social_media;

import com.github.javafaker.Faker;
import com.social_media.social_media.dto.request.PostPromoEndDateRequestDto;
import com.social_media.social_media.dto.response.*;
import com.social_media.social_media.dto.request.PostRequestDto;
import com.social_media.social_media.dto.request.ProductRequestDto;
import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import com.social_media.social_media.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Product createRandomProduct() {
        return new Product(
                faker.number().randomNumber(),
                faker.commerce().productName(),
                faker.commerce().department(),
                faker.company().name(),
                faker.color().name(),
                faker.lorem().sentence());
    }

    public static Post createRandomPost(Long userId) {
        return new Post(
                UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                userId,
                LocalDate.now(),
                createRandomProduct(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 0, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static Post createRandomPostWithPostId(Long postId) {
        return new Post(
                postId,
                faker.number().randomNumber(),
                LocalDate.now(),
                createRandomProduct(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 0, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static Post createRandomPostPromoWithPostId(Long userId, Long postId) {
        return new Post(
                postId,
                userId,
                LocalDate.now(),
                createRandomProduct(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 10, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static Post createRandomPostPromoWithPromotionEndDate(Long userId, Long postId, LocalDate date,
            LocalDate promotionEndDate) {
        return new Post(
                postId,
                userId,
                date,
                createRandomProduct(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 10, 50),
                promotionEndDate);
    }

    public static User createRandomUser() {
        return new User(
                UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                faker.name().username(),
                new ArrayList<>());
    }

    public static User createRandomUserWithFavorites(List<Long> favoritePosts) {
        return new User(
                UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                faker.name().username(),
                favoritePosts);
    }

    public static Follow createFollow(Long userId, long userIdToFollow) {
        return new Follow(userId, userIdToFollow);
    }

    public static FollowingResponseDto convertFollowToResponseDto(Follow follow) {
        return FollowingResponseDto.builder()
                .user_id(follow.getFollowerId())
                .userIdToFollow(follow.getFollowedId())
                .build();
    }

    public static Post createRandomPostNotUserId() {
        return new Post(
                faker.number().randomNumber(),
                faker.number().randomNumber(),
                LocalDate.now(),
                createRandomProduct(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 1, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static ProductRequestDto createRandomProductRequestDto() {
        return new ProductRequestDto(
                faker.number().randomNumber(),
                faker.commerce().productName(),
                faker.commerce().department(),
                faker.company().name(),
                faker.color().name(),
                faker.lorem().sentence());
    }

    public static ProductResponseDto createRandomProductResponseDto() {
        return new ProductResponseDto(
                faker.number().randomNumber(),
                faker.commerce().productName(),
                faker.commerce().department(),
                faker.company().name(),
                faker.color().name(),
                faker.lorem().sentence());
    }

    public static PostResponseDto createRandomPostResponseDto() {
        return new PostResponseDto(
                faker.number().randomNumber(),
                faker.number().randomNumber(),
                LocalDate.now(),
                createRandomProductResponseDto(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0));
    }

    public static PostRequestDto createRandomPostRequestDto() {
        return new PostRequestDto(
                faker.number().randomNumber(),
                LocalDate.now(),
                createRandomProductRequestDto(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0));
    }

    public static PostResponseDto convertPostToResponseDto(Post post, ProductResponseDto product) {
        return PostResponseDto.builder()
                .post_id(post.getPostId())
                .user_id(post.getUserId())
                .date(post.getDate())
                .product(product)
                .category(post.getCategory())
                .price(post.getPrice())
                .build();
    }

    public static PostRequestDto convertPostToRequestDto(Post post, ProductRequestDto product) {
        return PostRequestDto.builder()
                .user_id(post.getUserId())
                .date(post.getDate())
                .product(product)
                .category(post.getCategory())
                .price(post.getPrice())
                .build();
    }

    public static ProductRequestDto convertProductToRequestDto(Product product) {
        return ProductRequestDto.builder()
                .product_id(product.getProductId())
                .product_name(product.getProductName())
                .type(product.getType())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .build();
    }

    public static ProductResponseDto convertProductToResponseDto(Product product) {
        return ProductResponseDto.builder()
                .product_id(product.getProductId())
                .product_name(product.getProductName())
                .type(product.getType())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .build();
    }

    public static Post createRandomPostWithBrand(Long userId, String brand) {
        return new Post(
                faker.number().randomNumber(),
                userId,
                LocalDate.now(),
                createRandomProductWithBrand(brand),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 0, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static Product createRandomProductWithBrand(String brand) {
        return new Product(
                faker.number().randomNumber(),
                faker.commerce().productName(),
                faker.commerce().department(),
                brand,
                faker.color().name(),
                faker.lorem().sentence());
    }

    public static Post createRandomOldPost(Long userId) {
        return new Post(
                faker.number().randomNumber(),
                userId,
                LocalDate.now().minusWeeks(3),
                createRandomProduct(),
                random.nextInt(5) + 1,
                ThreadLocalRandom.current().nextDouble(10.0, 100.0),
                faker.number().randomDouble(2, 0, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static Post createRecentPost(Long userId) {
        return new Post(
                faker.number().randomNumber(), // Asume que faker.number().randomNumber() es adecuado para el ID
                userId,
                LocalDate.now().minusDays(random.nextInt(14)), // Fecha dentro de las últimas dos semanas
                createRandomProduct(),
                random.nextInt(5) + 1,
                Double.valueOf(faker.commerce().price(10.0, 100.0).replace(",", ".")),
                faker.number().randomDouble(2, 0, 50),
                LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
    }

    public static FollowersCountResponseDto convertFollowersToFollowersCountResponseDto(User user,
            List<Follow> followers) {
        return FollowersCountResponseDto
                .builder()
                .user_id(user.getUserId())
                .user_name(user.getName())
                .followers_count(followers.size())
                .build();
    }

    public static List<User> createTenRandomUsers() {
        return IntStream.range(0, 10)
                .mapToObj(i -> createRandomUser())
                .collect(Collectors.toList());
    }

    public static List<Follow> createTenFollowersForUser(Long userId, List<User> followers, boolean ascending) {
        Comparator<User> comparator = Comparator.comparing(User::getName);
        if (!ascending) {
            comparator = comparator.reversed();
        }

        followers.sort(comparator);

        return followers.stream()
                .map(user -> createFollow(user.getUserId(), userId))
                .collect(Collectors.toList());
    }

    public static FollowersResponseDto convertFollowersToResponseDto(User userFollowed, List<User> followers) {
        return FollowersResponseDto.builder()
                .user_id(userFollowed.getUserId())
                .user_name(userFollowed.getName())
                .followers(followers.stream().map(TestUtils::convertUserToResponseDto).toList())
                .build();
    }

    public static FollowedResponseDto convertFollowedToResponseDto(User userFollowed, List<User> followers) {
        return FollowedResponseDto.builder()
                .user_id(userFollowed.getUserId())
                .user_name(userFollowed.getName())
                .followed(followers.stream().map(TestUtils::convertUserToResponseDto).toList())
                .build();
    }

    public static UserResponseDto convertUserToResponseDto(User user) {
        return UserResponseDto.builder()
                .user_id(user.getUserId())
                .user_name(user.getName())
                .build();
    }

    public static PostPromoRequestDto convertPostPromoToRequestDto(Post postPromo) {
        return PostPromoRequestDto.builder()
                .user_id(postPromo.getUserId())
                .date(postPromo.getDate())
                .product(convertProductToRequestDto(postPromo.getProduct()))
                .category(postPromo.getCategory())
                .price(postPromo.getPrice())
                .has_promo(true)
                .discount(postPromo.getDiscount())
                .build();
    }

    public static PostPromoEndDateRequestDto convertPostPromoEndDateToRequestDto(Post postPromo) {
        return PostPromoEndDateRequestDto.builder()
                .user_id(postPromo.getUserId())
                .date(postPromo.getDate())
                .product(convertProductToRequestDto(postPromo.getProduct()))
                .category(postPromo.getCategory())
                .price(postPromo.getPrice())
                .has_promo(true)
                .discount(postPromo.getDiscount())
                .promotionEndDate(postPromo.getPromotionEndDate())
                .build();
    }

    public static PostPromoResponseDto convertPostPromoToResponseDto(Post postPromo) {
        return PostPromoResponseDto.builder()
                .post_id(postPromo.getPostId())
                .user_id(postPromo.getUserId())
                .date(postPromo.getDate())
                .product(convertProductToResponseDto(postPromo.getProduct()))
                .category(postPromo.getCategory())
                .price(postPromo.getPrice())
                .has_promo(true)
                .discount(postPromo.getDiscount())
                .build();
    }

    public static PostPromoEndDateResponseDto convertPostPromoEndDateToResponseDto(Post postPromo) {
        return PostPromoEndDateResponseDto.builder()
                .post_id(postPromo.getPostId())
                .user_id(postPromo.getUserId())
                .date(postPromo.getDate())
                .product(convertProductToResponseDto(postPromo.getProduct()))
                .category(postPromo.getCategory())
                .price(postPromo.getPrice())
                .has_promo(true)
                .discount(postPromo.getDiscount())
                .promotionEndDate(postPromo.getPromotionEndDate())
                .build();
    }

    public static List<Post> createListRandomPosts(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> createRandomPost(1L))
                .collect(Collectors.toList());
    }
}