package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.UserOrderTypeEnum;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> save(User t);
    Optional<User> update(User t);
    boolean delete(Integer id);
    Optional<User> findById(Integer id);
    List<User> findAll();

    Optional<List<User>> getListOfFollows(Integer userId, UserOrderTypeEnum orderType);
}
