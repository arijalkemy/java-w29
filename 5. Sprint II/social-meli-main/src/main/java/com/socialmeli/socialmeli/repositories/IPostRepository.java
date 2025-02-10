package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import java.util.List;

public interface IPostRepository {
    void save(Post post);

    Boolean existsProductById(Integer id);

    List<Post> postFromUsers(List<User> userList);

    List<Post> findPostsWithPromoByUser(Integer userId);
}
