package com.app.repository;

import com.app.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import com.app.util.NameOrder;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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
                throw new FileNotFoundException("Users.json file not found in classpath.");
            }
            List<User> listUsers = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<User>>() {});
            for (User user : listUsers) {
                users.put(user.getId(), user);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load users data from Users.json", e);
        }
    }

    private User createUser(Integer id, String name, Boolean isSeller, List<Integer> posts, List<Integer> followers, List<Integer> following) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setIsSeller(isSeller);
        user.setFollowing(new ArrayList<>(following));
        if(isSeller) {
            user.setPosts(new ArrayList<>(posts));
            user.setFollowers(new ArrayList<>(followers));
        }else {
            return user;
        }

        return user;
    }

    @Override
    public Optional<User> findById(Integer id){
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
        List<Integer> following = users.get(userId).getFollowing();
        boolean stateFollowing = following != null && following.removeIf(id -> id.equals(userIdToUnfollow));
        List<Integer> followers = users.get(userIdToUnfollow).getFollowers();
        boolean stateFollowers = followers != null && followers.removeIf(id -> id.equals(userId));

        //Rollback
        if(stateFollowing && !stateFollowers) {
            following.add(userIdToUnfollow);
            return false;
        }

        if(!stateFollowing && stateFollowers) {
            followers.add(userId);
            return false;
        }

        return stateFollowing && stateFollowers;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    @Override
    public Boolean savePostId(Integer productId, User user) {
        return user.getPosts().add(productId);
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
    public List<User> findFollowingUsersList(Integer userId) {
        User user = users.get(userId);
        return user.getFollowing().stream()
                .map(followedId ->
                    findById(followedId).get())
                .toList();
    }

    @Override
    public List<User> findFollowersUsersList(Integer userId) {
        User user = users.get(userId);
        return user.getFollowers().stream()
                .map(followerId ->
                        findById(followerId).get())
                .toList();
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
