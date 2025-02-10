package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.models.Follow;
import com.socialmeli.socialmeli.models.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Getter
public class FollowRepository implements IFollowRepository {

    private List<Follow> follows = new ArrayList<>();

    @PostConstruct
    public void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:follows.json");
        this.follows = objectMapper.readValue(file, new TypeReference<>() { });
    }

    @Override
    public void add(Follow follow) {
        follows.add(follow);
    }

    @Override
    public boolean exists(Follow follow) {
        return follows.stream().anyMatch(existingFollow -> existingFollow.equals(follow));
    }

    @Override
    public void delete(Follow follow) {
        follows.remove(follow);
    }

    @Override
    public List<Follow> findAllByIdFollowed(Integer id) {
        return follows
                .stream()
                .filter(f -> f.getUserFollowed().getId().equals(id))
                .toList();
    }

    @Override
    public List<Follow> findAllByIdFollower(Integer id) {
        return follows
                .stream()
                .filter(f -> f.getUserFollower().getId().equals(id))
                .toList();
    }

    @Override
    public List<User> findFollowedUsers(User user) {
        return follows.stream().filter(follow -> follow.getUserFollower().equals(user))
                .map(Follow::getUserFollowed).toList();
    }
}
