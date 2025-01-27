package com.app.repository;

import com.app.model.Post;
import com.app.model.Product;
import com.app.util.DateOrder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    // <UserID, Posts>
    private final Map<Integer, List<Post>> posts = new HashMap<>();
    private final ArrayList<Product> products = new ArrayList<>();
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
                throw new FileNotFoundException("Products.json file not found in classpath.");
            }
            List<Product> productList = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {});
            products.addAll(productList);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load products data from Products.json", e);
        }
    }

    private void loadPosts(ObjectMapper objectMapper) {
        try {
            Resource resource = resourceLoader.getResource("classpath:Posts.json");
            if (!resource.exists()) {
                throw new FileNotFoundException("Posts.json file not found in classpath.");
            }
            List<Post> postList = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Post>>() {});
            for (Post post : postList) {
                posts.computeIfAbsent(post.getUserId(), k -> new ArrayList<>()).add(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load posts data from Posts.json", e);
        }
    }


    private Product createProduct(int id, String name, String type, String brand, String color, String notes) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setType(type);
        product.setBrand(brand);
        product.setColor(color);
        product.setNotes(notes);
        return product;
    }

    private Post createPost(int id, int userId, int productId, int category, double price, LocalDate date, boolean hasPromo, double discount) {
        Post post = new Post();
        post.setId(id);
        post.setUserId(userId);
        post.setProductId(productId);
        post.setCategory(category);
        post.setPrice(price);
        post.setDate(date);
        post.setHasPromo(hasPromo);
        post.setDiscount(discount);
        return post;
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
        return this.products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public Integer findPromoProductsCountByUserId(Integer userId) {
        return Math.toIntExact(posts.get(userId).stream()
                .filter(Post::getHasPromo)
                .count());
    }

    @Override
    public Product saveProduct(Integer id, String name, String type, String brand, String color, String notes) {
        Product createdProduct = createProduct(id, name, type, brand, color, notes);
        products.add(createdProduct);
        return createdProduct;
    }

    @Override
    public Post savePost(
            Integer postId,
            Integer userId,
            Integer productId,
            Integer category,
            Double price,
            LocalDate localDate,
            Boolean hasPromo,
            Double discount
    ) {
        Post createdPost = createPost(postId, userId, productId, category, price, localDate, hasPromo, discount);
        posts.putIfAbsent(userId, new ArrayList<>());
        posts.get(userId).add(createdPost);

        return createdPost;
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
        return posts.getOrDefault(userId, new ArrayList<>());
    }

    @Override
    public List<Post> searchMostRecentPostsSortedBy(List<Post> posts, DateOrder dateOrder, LocalDate fromDate) {
        return posts.stream()
                .filter(post -> post.getDate().isAfter(fromDate))
                .sorted(dateOrder == DateOrder.DATE_DESC || dateOrder == null
                        ? Comparator.comparing(Post::getDate).reversed()
                        : Comparator.comparing(Post::getDate))
                .toList();
    }
}
