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
        return Optional.ofNullable(memoryStorage.getUsersById().put(user.getUserId(), user));
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

    // #------------------ LOAD METHOD ------------------#
    private Map<Integer, User> generateSampleUsers() {
        Map<Integer, User> sampleUsers = new HashMap<>();

        // Crear vendedores
        Seller seller1 = new Seller("techStore");
        Seller seller2 = new Seller("sportsShop");
        Seller seller3 = new Seller("furnitureDealer");

        // Crear usuarios comunes
        CommonUser user1 = new CommonUser("john_doe");      //id4
        CommonUser user2 = new CommonUser("jane_smith");    //id5
        CommonUser user3 = new CommonUser("mike_wilson");   //id6

        // Configurar follows para vendedores
        seller1.setFollow(new ArrayList<>(List.of(4, 6)));
        seller2.setFollow(new ArrayList<>(List.of(5)));
        seller3.setFollow(new ArrayList<>(List.of(5, 6)));

        // Configurar follows para usuarios comunes
        user1.setFollow(new ArrayList<>(List.of(1)));
        user2.setFollow(new ArrayList<>(List.of(2, 3)));
        user3.setFollow(new ArrayList<>(List.of(1, 3)));


        // Agregar todos los usuarios al mapa
        sampleUsers.put(seller1.getUserId(), seller1);
        sampleUsers.put(seller2.getUserId(), seller2);
        sampleUsers.put(seller3.getUserId(), seller3);
        sampleUsers.put(user1.getUserId(), user1);
        sampleUsers.put(user2.getUserId(), user2);
        sampleUsers.put(user3.getUserId(), user3);

        return sampleUsers;
    }
}
