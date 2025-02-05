package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.controller.UserController;
import com.project.be_java_hisp_w29_g10.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
}
