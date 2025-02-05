package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    List<Post> findAll();
    Optional<Post> findById(Integer id);
    Optional<Post> save(Post t);
    Optional<Post> update(Post t);
    boolean delete(Integer id);
    List<Post> getPromoPostsBySellerId(Integer seller_id);


    List<Post> getUserPosts(Integer id);
}
