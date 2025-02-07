package com.app.util;

public enum ResponseMessages {

    // Error Messages
    ERROR_USER_NOT_FOUND("User with ID %d not found."),
    ERROR_SELLER_NOT_FOUND("Seller with ID %d not found."),
    ERROR_USER_NOT_SELLER("User with ID %d is not a seller."),
    ERROR_USER_ID_MATCH("The user ID %d cannot be the same as the target user ID."),
    ERROR_USER_ALREADY_FOLLOWING("User with ID %d is already following the seller with ID %d."),
    ERROR_USER_UNFOLLOW_FAILED("User with ID %d is not following seller with ID %d."),
    ERROR_INVALID_ORDER("The 'order' parameter can only be 'name_asc' or 'name_desc'."),
    ERROR_INVALID_DATE_ORDER("The 'order' parameter can only be 'date_asc' or 'date_desc'."),
    ERROR_PRODUCT_ALREADY_EXISTS("Product with ID %d already exists."),
    ERROR_PRODUCT_NOT_FOUND("Product with ID %d not found."),
    ERROR_POST_NO_PROMO_FOUND_SINCE("No promo posts found for seller with ID %d since %s."),
    ERROR_USER_NO_FOLLOWING("User with ID %d does not follow any other users."),
    ERROR_USER_FOLLOWING_NO_POSTS("Followed users have no posts."),
    ERROR_POST_MUST_HAVE_PROMO("Post must have a promo."),


    // Success Messages
    SUCCESS_PROMO_POST_CREATED("Promo post was successfully created."),
    SUCCESS_USER_UNFOLLOWED("Unfollowed successfully."),
    SUCCESS_USER_FOLLOWED("User with ID %d is now following seller with ID %d."),
    SUCCESS_POST_CREATED("Post was successfully created."),

    // File Handling Messages
    PRODUCTS_FILE_NOT_FOUND("Products.json file not found in classpath."),
    FAILED_TO_LOAD_PRODUCTS("Failed to load products data from Products.json"),
    POSTS_FILE_NOT_FOUND("Posts.json file not found in classpath."),
    FAILED_TO_LOAD_POSTS("Failed to load posts data from Posts.json"),
    USERS_FILE_NOT_FOUND("Users.json file not found in classpath."),
    FAILED_TO_LOAD_USERS("Failed to load users data from Users.json");

    private final String message;

    ResponseMessages(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
