package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.UserOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.Seller;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    private final InMemoryStorageImpl memoryStorage;

    public UserRepository() {
        this.memoryStorage = InMemoryStorageImpl.getInstance();
    }

    public Optional<List<User>> getListOfFollows(Integer userId, UserOrderTypeEnum orderType) {
        return Optional.of(memoryStorage.getUsersById().get(userId)
                .getFollow()
                .stream()
                .map(uid -> findById(uid).get())
                .sorted(orderType.getComparator())
                .collect(Collectors.toList()));
    }
    // #------------------ CRUD METHODS ------------------#

    @Override
    public Optional<User> save(User user) {
        memoryStorage.getUsersById().put(user.getUserId(), user);
        return Optional.ofNullable(memoryStorage.getUsersById().get(user.getUserId()));
    }

    @Override
    public Optional<User> update(User user) {
        return Optional.ofNullable(memoryStorage.getUsersById().replace(user.getUserId(), user));
    }

    @Override
    public boolean delete(Integer id) {
        Map<Integer, User> usersById = memoryStorage.getUsersById();

        if (!usersById.containsKey(id))
            return false;

        User user = memoryStorage.getUsersById().get(id);

        user.getFollow().removeIf(u -> u.equals(id));
        usersById.remove(id);

        return true;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(memoryStorage.getUsersById().get(id));
    }

    @Override
    public List<User> findAll() {
        return memoryStorage.getUsersById().values().stream().toList();
    }

}
