package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.models.Comment;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public interface IPostRepository {
    void save(Post post);

    Boolean existsProductById(Integer id);

    List<Post> postFromUsers(List<User> userList);

    List<Post> findPostsWithPromoByUser(Integer userId);

    List<Post> findPostByFilter(Integer category, Double priceMin, Double priceMax, String productBrand, String productType);

    List<Post> findPostsWithPromoByUserOptional(Integer userId);

    List<Post> findPostsWithPromoByUserOptional();

    List<Post> findPostBySeller(Integer userID);

    Optional<Post> findById(Integer id);

    void update(Post post);

    List<Comment> findAllCommentsByPostId(Integer postId);

    Map<Integer, Integer> countPostsByCategory(Integer idUser);

    Map<Integer, Integer> countPostsByCategory();
}
