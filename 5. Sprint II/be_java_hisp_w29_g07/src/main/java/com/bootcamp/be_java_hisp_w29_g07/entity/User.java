package com.bootcamp.be_java_hisp_w29_g07.entity;

import com.bootcamp.be_java_hisp_w29_g07.Enum.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents a user in Melisocial.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class User {
    /**
     * The unique identifier for the user.
     */
    private Integer id;
    /**
     * The username of the user.
     */
    private String username;
    /**
     * The first name of the user.
     */
    private String name;
    /**
     * The last name of the user.
     */
    private String lastname;
    /**
     * The email address of the user.
     */
    private String email;
    /**
     * The type of the user.
     */
    private UserType userType;
}
