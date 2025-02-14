package com.bootcamp.be_java_hisp_w29_g07.util;

import com.bootcamp.be_java_hisp_w29_g07.Enum.UserType;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;

/**
 * Factory class for creating {@link User} objects with predefined values.
 * This class is used to simplify the creation of {@link User} instances, particularly
 * in test scenarios where mock users are needed.
 */
public class UtilUserFactory {

    /**
     * Creates a new instance of {@link User} with a predefined set of values.
     *
     * @param username the username to assign to the new user.
     * @return a {@link User} object with the specified username and default values for other fields.
     */
    public static User getUser(String username) {
        return new User(9999, username, "userName", "userLastName", "test@mercadolibre.com", UserType.USER);
    }

    /**
     * Creates a new instance of {@link User} with a predefined set of values.
     *
     * @param id the id to assign to the new user.
     * @return a {@link User} object with the specified id and default values for other fields.
     */
    public static User getUser(Integer id) {
        return new User(id, "username", "userName", "userLastName", "test@mercadolibre.com", UserType.USER);
    }

    /**
     * Creates a new instance of {@link User} with a predefined set of values.
     *
     * @param username the username to assign to the new user.
     * @param id the id to assign to the new user.
     * @return a {@link User} object with the specified username and id and default values for other fields.
     */
    public static User getUser(String username, Integer id) {
        return new User(id, username, "userName", "userLastName", "test@mercadolibre.com", UserType.USER);
    }

    /**
     * Creates a new instance of {@link User} with a predefined set of values and a specified ID.
     * The user type is set to {@link UserType#SELLER}.
     *
     * @param username the username to assign to the new user.
     * @param id the ID to assign to the new user.
     * @return a {@link User} object with the specified username, ID, and default values for other fields.
     */
    public static User getSeller(String username, Integer id) {
        return new User(id, username, "userName", "userLastName", "test@mercadolibre.com", UserType.SELLER);
    }


    /**
     * Creates a new instance of {@link User} representing a seller with predefined values.
     *
     * @param id the unique identifier to assign to the new seller user.
     * @return a {@link User} object with the specified id and default values for username, name, last name,
     *         email, and user type set as {@link UserType#SELLER}.
     */
    public static User getSeller(Integer id) {
        return new User(
                id,
                "jfeo",
                "Juan Steven",
                "Feo",
                "jfeo@meli.com",
                UserType.SELLER);
    }

}
