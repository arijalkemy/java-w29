package com.social_media.social_media.repository.post;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.enums.PostType;
import org.springframework.lang.Nullable;
import com.social_media.social_media.exception.DataLoadException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.social_media.social_media.utils.MessagesExceptions.INVALID_POST_ENTITY;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private Map<Long, Post> posts;

    public PostRepositoryImpl() {
        try {
            loadDataBase();
        } catch (IOException e) {
            throw new DataLoadException(INVALID_POST_ENTITY);
        }
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<Post> postList;

        file = ResourceUtils.getFile("classpath:posts.json");
        postList = objectMapper.readValue(file, new TypeReference<>() {
        });

        posts = postList.stream().collect(Collectors.toMap(Post::getPostId, post -> post));
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return Optional.ofNullable(this.posts.get(postId));
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        List<Post> filteredPosts = new ArrayList<>();
        this.posts.forEach((__, post) -> {
            if (post.getUserId().equals(userId)) {
                filteredPosts.add(post);
            }
        });
        return filteredPosts;
    }

    @Override
    public Post add(Post post) {
        posts.put(post.getPostId(), post);
        return post;
    }

    @Override
    public List<Post> findWithFilters(PostType postType, Long userId) {
        List<Post> postList = new ArrayList<>();
        posts.forEach((__, post) -> {
            boolean matchesType = postType == PostType.ALL ||
                    (postType == PostType.NORMAL && post.getDiscount() == 0) ||
                    (postType == PostType.PROMO && post.getDiscount() != 0);

            boolean matchesUser = (userId == null || post.getUserId().equals(userId));

            if (matchesType && matchesUser) {
                postList.add(post);
            }
        });
        return postList;
    }

    @Override
    public List<Post> findByIdSince(Long userId, LocalDate lastTwoWeeks) {
        List<Post> postsFind = new ArrayList<>();
        posts.forEach((__, post) -> {
            if (post.getUserId().equals(userId) && !post.getDate().isBefore(lastTwoWeeks)) {
                postsFind.add(post);
            }
        });
        return postsFind;
    }

    @Override
    public List<Post> findPostBySellerId(Long userIdToFollow) {
        List<Post> filteredPosts = new ArrayList<>();
        posts.forEach((__, post) -> {
            if (post.getUserId().equals(userIdToFollow)) {
                filteredPosts.add(post);
            }
        });
        return filteredPosts;
    }

    @Override
    public Map<Long, List<String>> findSellersByBrands(List<String> favouriteBrands) {
        Map<Long, List<String>> sellersWithBrands = new HashMap<>();
        posts.forEach((__, post) -> {
            String postBrand = post.getProduct().getBrand().toUpperCase();
            if (favouriteBrands.contains(postBrand)) {
                sellersWithBrands.compute(post.getUserId(), (k, brands) -> addBrandTo(brands, postBrand));
            }
        });
        return sellersWithBrands;
    }

    private List<String> addBrandTo(@Nullable List<String> brands, String postBrand) {
        if (brands == null) {
            brands = new ArrayList<>();
        }
        if (!brands.contains(postBrand)) {
            brands.add(postBrand);
        }
        return brands;
    }
}
