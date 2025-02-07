package com.app.repository;

import com.app.model.Post;
import com.app.model.Product;
import com.app.util.DateOrder;
import com.app.util.ResponseMessages;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    // <UserID, Posts>
    private final Map<Integer, List<Post>> posts = new HashMap<>();
    private final Map<Integer, Product> products = new HashMap<>();
    private final ResourceLoader resourceLoader;

    @Autowired
    public PostRepositoryImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        loadData();
    }

    private void loadData() {
        ObjectMapper mp = new ObjectMapper();
        mp.registerModule(new JavaTimeModule()); //Esto es porque no me compilaba por la fecha.
        loadProducts(mp);
        loadPosts(mp);
    }

    private void loadProducts(ObjectMapper objectMapper) {
        try {
            Resource resource = resourceLoader.getResource("classpath:Products.json");
            if (!resource.exists()) {

                throw new FileNotFoundException(ResponseMessages.PRODUCTS_FILE_NOT_FOUND.format());
            }
            List<Product> productList = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {
            });
            productList.forEach(product -> this.products.put(product.getId(), product) );
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(ResponseMessages.FAILED_TO_LOAD_PRODUCTS.format(), e);

        }
    }

    private void loadPosts(ObjectMapper objectMapper) {
        try {
            Resource resource = resourceLoader.getResource("classpath:Posts.json");
            if (!resource.exists()) {

                throw new FileNotFoundException(ResponseMessages.POSTS_FILE_NOT_FOUND.format());
            }
            List<Post> postList = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Post>>() {
            });

            for (Post post : postList) {
                posts.computeIfAbsent(post.getUserId(), k -> new ArrayList<>()).add(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(ResponseMessages.FAILED_TO_LOAD_POSTS.format(), e);
        }
    }

    public Map<Integer, List<Post>> findAll() {
        return posts;
    }

    @Override
    public List<Post> findPostsByUserIdWithPromoSince(Integer userId, LocalDate since) {
        List <Post> posts = this.posts.get(userId);

        if (posts == null || posts.isEmpty()) {
            return Collections.emptyList();
        }
        return posts.stream()
                .filter(post -> post.getDate() != null && ( post.getDate().isEqual(since) || post.getDate().isAfter(since)  ) &&  post.getHasPromo())
                .toList();
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return Optional.ofNullable(this.products.get(id));
    }

    @Override
    public List<Post> findPromoProductsCountByUserId(Integer userId) {
        return posts.get(userId).stream()
                .filter(Post::getHasPromo)
                .toList();
    }

    @Override
    public Product saveProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Post savePost(Post post) {
        posts.putIfAbsent(post.getUserId(), new ArrayList<>());
        posts.get(post.getUserId()).add(post);
        return post;
    }

    @Override
    public List<Integer> findPostsIds() {
        return posts.values().stream()
                .flatMap(List::stream)
                .map(Post::getId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findPostsByUserId(int userId) {
        return posts.get(userId);
    }

    @Override
    public List<Post> searchMostRecentPostsSortedBy(List<Post> posts, DateOrder dateOrder, LocalDate fromDate) {
        return posts.stream()
                .filter(post -> post.getDate().isAfter(fromDate) && !post.getDate().isAfter(LocalDate.now()))
                .sorted(dateOrder == DateOrder.DATE_DESC
                        ? Comparator.comparing(Post::getDate).reversed()
                        : Comparator.comparing(Post::getDate))
                .toList();
    }
}
