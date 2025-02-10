package com.app.repository;

import com.app.model.Post;
import com.app.model.Product;
import com.app.util.DateOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPostRepository {

    List<Post> findPromoProductsCountByUserId(Integer userId);

    List<Post> findPostsByUserIdWithPromoSince(Integer userId, LocalDate since);
    Optional<Product> findProductById(Integer id);
    Map<Integer, List<Post>> findAll();
    List<Post> findPostsByUserId(int userId);
    Product saveProduct(Product product);
    Post savePost(Post post);
    List<Integer> findPostsIds();
    List<Post> searchMostRecentPostsSortedBy(List<Post> followedPosts, DateOrder dateOrder, LocalDate fromDate);
}
