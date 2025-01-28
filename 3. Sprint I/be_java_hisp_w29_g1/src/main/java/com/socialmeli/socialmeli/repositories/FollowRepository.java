package com.socialmeli.socialmeli.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.dto.response.UserFollowerCountDto;
import com.socialmeli.socialmeli.models.Follow;
import com.socialmeli.socialmeli.models.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FollowRepository implements IFollowRepository {

    List<Follow> follows = new ArrayList<>();

    @PostConstruct
    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:follows.json");
        this.follows = objectMapper.readValue(file, new TypeReference<>() {});
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
        return follows.stream()
                .filter(f-> f.getUserFollowed().getId().equals(id))
                .toList();
    }

    @Override
    public List<Follow> findAllByIdFollower(Integer id) {
        return follows.stream()
                .filter(f-> f.getUserFollower().getId().equals(id))
                .toList();
    }

    @Override
    public List<UserFollowerCountDto> findTopSellers() {

        Set<User> followed = follows
                .stream()
                .map(Follow::getUserFollowed)
                .collect(Collectors.toSet());

        List<UserFollowerCountDto> userFollowerCountDtos = new ArrayList<>();

        followed.forEach(user -> {
            userFollowerCountDtos.add(
                    new UserFollowerCountDto(user.getId(),user.getName(), findAllByIdFollowed(user.getId()).size())
            );
        });

        return userFollowerCountDtos.stream()
                .sorted(Comparator.comparing(UserFollowerCountDto::followersCount)
                .reversed())
                .toList();
    }

    @Override
    public List<User> findFollowedUsers(User user) {
        return follows.stream()
                .filter(follow -> follow.getUserFollower().equals(user))
                .map(Follow::getUserFollowed)
                .toList();
    }
}
