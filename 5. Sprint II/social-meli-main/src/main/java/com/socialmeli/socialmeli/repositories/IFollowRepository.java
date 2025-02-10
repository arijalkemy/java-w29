package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.models.Follow;
import com.socialmeli.socialmeli.models.User;
import java.util.List;

public interface IFollowRepository {
    List<User> findFollowedUsersById(Integer id);

    void add(Follow follow);

    boolean exists(Follow follow);

    void delete(Follow follow);

    List<Follow> findAllByIdFollowed(Integer id);

    List<Follow> findAllByIdFollower(Integer id);
}
