package com.app.repository;

import com.app.model.Post;
import com.app.model.Product;
import com.app.util.DateOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPostRepository {
    Integer findPromoProductsCountByUserId(Integer userId);
    List<Post> findPostsByUserIdWithPromoSince(Integer userId, LocalDate since);
    Optional<Product> findProductById(Integer id);
    Map<Integer, List<Post>> findAll();
    List<Post> findPostsByUserId(int userId);
    Product saveProduct(Integer id, String name, String type, String brand, String color, String notes);
    Post savePost(
            Integer postId,
            Integer userId,
            Integer id,
            Integer category,
            Double price,
            LocalDate localDate,
            Boolean hasPromo,
            Double discount
    );
    List<Integer> findPostsIds();
    List<Post> searchMostRecentPostsSortedBy(List<Post> followedPosts, DateOrder dateOrder, LocalDate fromDate);
}
