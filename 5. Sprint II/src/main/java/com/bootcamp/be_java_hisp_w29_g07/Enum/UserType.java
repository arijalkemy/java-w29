package com.bootcamp.be_java_hisp_w29_g07.Enum;

/**
 * The enum UserType defines the types of users in the system.
 * <ul>
 *     <li>{@link #USER}: Represents a standard user.</li>
 *     <li>{@link #SELLER}: Represents a seller.</li>
 * </ul>
 */
public enum UserType {

    /**
     * Represents a standard user.
     */
    USER(1, "User"),

    /**
     * Represents a seller.
     */
    SELLER(2, "Seller");

    /**
     * The unique identifier for the user type.
     */
    private final Integer id;

    /**
     * The descriptive name of the user type.
     */
    private final String userType;

    /**
     * Instantiates a new UserType with its ID and descriptive name.
     *
     * @param id       the unique identifier for the user type
     * @param userType the descriptive name of the user type
     */
    UserType(Integer id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    /**
     * Gets the unique identifier for the user type.
     *
     * @return the user type ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the descriptive name of the user type.
     *
     * @return the user type name
     */
    public String getUserType() {
        return userType;
    }
}
