package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g07.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w29_g07.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class implements the {@link IUserService} interface and provides
 * the business logic related to user operations.
 * It interacts with the {@link IUserRepository} to fetch user data
 * and handle exceptions when users are not found.
 */
@Service
public class UserServiceImpl implements IUserService{

    /**
     * The User repository for accessing user data.
     */
    private final IUserRepository userRepository;

    /**
     * Instantiates a new User service implementation with the specified user repository.
     *
     * @param userRepository the repository to interact with user data
     */
    public UserServiceImpl (IUserRepository userRepository){

        this.userRepository = userRepository;
    }

    /**
     * Finds a user by their unique ID.
     *
     * @param userId the unique identifier of the user to find
     * @return the {@link User} object associated with the given ID
     * @throws NotFoundException if no user is found with the specified ID
     */
    @Override
    public User findUserById(Integer userId) {
        Optional<User> user = userRepository.getUserById(userId);
        if (user.isEmpty()){
            throw new NotFoundException(String.format(Messages.USER_NOT_FOUND_MSG, userId));
        }
        return user.get();

    }

    @Override
    public Boolean verifyUserExists(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException(String.format(Messages.USER_NOT_FOUND_MSG, userId));
        }
        return true;
    }
}
