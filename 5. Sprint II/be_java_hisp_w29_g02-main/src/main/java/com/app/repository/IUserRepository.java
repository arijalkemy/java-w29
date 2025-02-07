package com.app.repository;

import com.app.model.User;
import com.app.util.NameOrder;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    User save(User user);
    Optional<User> findById(Integer id);
    Optional<User> findSellerById(Integer id);

    Integer findFollowersCountById(int userId);

    Boolean deleteFollowedSeller(int userId, int userIdToUnfollow);

    Boolean savePostId(Integer productId, User user);

    List<Integer> getFollowedUserIds(int userId);

    List<User> findAll();

    List<User> findFollowingUsersList(Integer userId, String order);

    List<User> findFollowersUsersList(Integer userId, String order);

    List<User> sortUsersByName(List<User> users, NameOrder order);
}
