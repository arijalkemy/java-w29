package com.app.repository;

import com.app.model.User;
import com.app.util.NameOrder;
import com.app.util.ResponseMessages;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final Map<Integer, User> users = new HashMap<>();
    private final ResourceLoader resourceLoader;

    @Autowired
    public UserRepositoryImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        loadData();
    }

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    private void loadData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = resourceLoader.getResource("classpath:Users.json");
            if (!resource.exists()) {
                throw new FileNotFoundException(ResponseMessages.USERS_FILE_NOT_FOUND.format());
            }
            List<User> listUsers = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<User>>() {
            });
            for (User user : listUsers) {
                users.put(user.getId(), user);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(ResponseMessages.FAILED_TO_LOAD_USERS.format(), e);
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findSellerById(Integer id) {
        User user = users.get(id);
        if (user != null && user.getIsSeller()) {
            return Optional.of(user);
        }

        return Optional.empty();
    }

    @Override
    public Integer findFollowersCountById(int userId) {
        List<Integer> userFollowers = users.get(userId).getFollowers();
        return userFollowers == null ? 0 : userFollowers.size();
    }

    @Override
    public Boolean deleteFollowedSeller(int userId, int userIdToUnfollow) {
        return users.get(userId).getFollowing().removeIf(id -> id.equals(userIdToUnfollow)) &&
                users.get(userIdToUnfollow).getFollowers().removeIf(id -> id.equals(userId));
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    @Override
    public Boolean savePostId(Integer postId, User user) {
        return user.getPosts().add(postId);
    }

    @Override
    public List<Integer> getFollowedUserIds(int userId) {
        User user = users.get(userId);
        return user.getFollowing();
    }

    @Override
    public List<User> findAll() {
        return this.users.values().stream().toList();
    }

    @Override
    public List<User> findFollowingUsersList(Integer userId, String order) {
        User user = users.get(userId);
        return user.getFollowing().stream()
                .map(followedId -> findById(followedId).get())
                .sorted((u1, u2) -> {
                    if ("NAME_DESC".equalsIgnoreCase(order)) {
                        return u2.getName().compareTo(u1.getName());
                    } else if ("NAME_ASC".equalsIgnoreCase(order)) {
                        return u1.getName().compareTo(u2.getName());
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findFollowersUsersList(Integer userId, String order) {
        User user = users.get(userId);
        return user.getFollowers().stream()
                .map(followerId -> findById(followerId).get())
                .sorted((u1, u2) -> {
                    if ("NAME_DESC".equalsIgnoreCase(order)) {
                        return u2.getName().compareTo(u1.getName());
                    } else if ("NAME_ASC".equalsIgnoreCase(order)) {
                        return u1.getName().compareTo(u2.getName());
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<User> sortUsersByName(List<User> users, NameOrder order) {
        return users.stream()
                .sorted((s1, s2) ->
                        NameOrder.NAME_ASC == order
                                ? s1.getName().compareToIgnoreCase(s2.getName())
                                : s2.getName().compareToIgnoreCase(s1.getName())
                )
                .toList();
    }
}
