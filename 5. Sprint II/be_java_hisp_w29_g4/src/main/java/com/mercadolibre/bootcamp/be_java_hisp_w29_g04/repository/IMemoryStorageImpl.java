package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

import java.util.List;
import java.util.Map;

public interface IMemoryStorageImpl {
    Map<Integer, User> getUsersById();

    Map<Integer, List<Post>> getPosts();
}
