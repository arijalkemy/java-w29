package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.socialmeli.models.Comment;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@Repository
public class PostRepository implements IPostRepository {

    private List<Post> posts = new ArrayList<>();

    @PostConstruct
    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        file = ResourceUtils.getFile("classpath:posts.json");
        this.posts = objectMapper.readValue(file, new TypeReference<>() {});
    }

    @Override
    public void save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    @Override
    public void update(Post post) {
        posts = posts.stream()
                .map(p -> p.getId().equals(post.getId()) ? post : p)
                .toList();
    }

    @Override
    public List<Comment> findAllCommentsByPostId(Integer postId) {
        return posts.stream()
                .filter(p -> p.getId().equals(postId))
                .map(Post::getComments)
                .findFirst()
                .orElse(List.of());
    }

    @Override
    public Boolean existsProductById(Integer id) {
        return posts.stream().anyMatch(p->p.getProduct().getId().equals(id));
    }

    @Override
    public List<Post> postFromUsers(List<User> userList) {
        return posts.stream()
                .filter(post -> userList.contains(post.getUser()))
                .toList();
    }

    @Override
    public List<Post> findPostsWithPromoByUser(Integer userId) {
        return posts.stream()
                .filter(post -> post.getHasPromo() && post.getUser().getId().equals(userId))
                .toList();
    }

    @Override
    public List<Post> findPostByFilter(Integer category, Double priceMin, Double priceMax, String productBrand, String productType) {
        return posts.stream()
                .filter(p -> category == null || p.getCategory().equals(category))
                .filter(p -> priceMin == null || p.getPrice() >= priceMin)
                .filter(p -> priceMax == null || p.getPrice() <= priceMax)
                .filter(p -> productBrand == null || p.getProduct().getBrand().equalsIgnoreCase(productBrand))
                .filter(p -> productType == null || p.getProduct().getType().equalsIgnoreCase(productType))
                .toList();
    }

    @Override
    public List<Post> findPostsWithPromoByUserOptional(Integer userId) {
        return posts.stream()
                .filter(post -> post.getHasPromo() && post.getUser().getId().equals(userId))
                .toList();
    }

    @Override
    public List<Post> findPostsWithPromoByUserOptional() {
        return posts.stream()
                .filter(Post::getHasPromo)
                .toList();
    }

    @Override
    public List<Post> findPostBySeller(Integer userID) {
        return posts.stream()
                .filter(p-> p.getUser().getId().equals(userID))
                .toList();
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    @Override
    public Map<Integer, Integer> countPostsByCategory(Integer idUser) {
        Map<Integer, Integer> report = new HashMap<>();
        posts.forEach(post -> {
            if (post.getUser().getId().equals(idUser)) {
                report.put(post.getCategory(), report.getOrDefault(post.getCategory(), 0) + 1);
            }
        });
        return report;
    }

    @Override
    public Map<Integer, Integer> countPostsByCategory() {
        Map<Integer, Integer> report = new HashMap<>();
        posts.forEach(post ->
                report.put(post.getCategory(), report.getOrDefault(post.getCategory(), 0) + 1)
        );
        return report;
    }
}
