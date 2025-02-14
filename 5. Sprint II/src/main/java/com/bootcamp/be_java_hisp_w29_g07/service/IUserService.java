package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.entity.User;

/**
 * This interface provides methods to retrieve user data by ID and verify the existence
 * of a user before performing operations.
 */
public interface IUserService {

    User findUserById(Integer userId);
    Boolean verifyUserExists(Integer userId);
}
