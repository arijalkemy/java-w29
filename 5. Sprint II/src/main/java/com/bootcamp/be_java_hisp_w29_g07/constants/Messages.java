package com.bootcamp.be_java_hisp_w29_g07.constants;

/**
 * This class defines a set of constant messages used throughout the application.
 * These messages are primarily for exceptions, validations, and informative feedback.
 */
public class Messages {

    /**
     * Message indicating that a user with the given ID was not found.
     */
    public static final String USER_NOT_FOUND_MSG = "User with id %d not found";

    /**
     * Message indicating that a user must be a seller to perform an action.
     */
    public static final String USER_NOT_SELLER_MSG = "User must be a seller";

    /**
     * Message indicating that a user with the given ID has no posts.
     */
    public static final String NO_POST_FOUND = "This user with id %d has no posts made";

    /**
     * Message indicating that a user cannot follow themselves.
     */
    public static final String USER_NOT_FOLLOW_THEMSELVES_MSG = "Users cannot follow themselves";

    /**
     * Message indicating that a seller is already followed by the user.
     */
    public static final String USER_ALREADY_FOLLOW_SELLER = "The seller is already followed";

    /**
     * Message confirming that a user has unfollowed another user.
     */
    public static final String USER_HAS_UNFOLLOWED_USER = "The user with id: %d has unfollowed user with id: %d.";

    /**
     * Message indicating that a user is not following another user.
     */
    public static final String USER_IS_NOT_FOLLOWING_USER = "The user with id: %d is not following the user with id: %d";

    /**
     * Message indicating that a user has no followings.
     */
    public static final String USER_HAS_NOT_FOLLOWED_MSG = "User %d has no followings";

    /**
     * Message indicating that users followed by a user have no posts.
     */
    public static final String USER_HAS_NOT_POSTS_MSG = "Followed by the user %d have no posts";

    /**
     * Message indicating that a post does not have a promotion.
     */
    public static final String POST_HAS_NO_PROMOTION = "The post does not have a promotion";

    /**
     * Message indicating that a post does not have a discount.
     */
    public static final String POST_HAS_NO_DISCOUNT = "The post does not have a discount";

    /**
     * Message confirming that a post was created successfully.
     */
    public static final String POST_CREATED_SUCCESSFULLY = "Post was created successfully";

    /**
     * Message confirming that a user follows another user.
     */
    public static final String USER_FOLLOW_SELLER = "User %s follows user %s";

    /**
     * Message indicating that a post cannot have a promotion.
     */
    public static final String POST_CANNOT_HAVE_PROMOTION = "The post cannot have a promotion";

    /**
     * Message indicating that a post cannot have a discount.
     */
    public static final String POST_CANNOT_HAVE_DISCOUNT = "The post cannot have a discount";

    /**
     * Message indicating that a seller cannot follow another seller.
     */
    public static final String SELLER_CANNOT_FOLLOW_SELLER = "A seller cannot follow another seller";

    /**
     * Message indicating that the specified order type doesn't exist.
     */
    public static final String ORDER_DOES_NOT_EXIST = "The type of ordering indicated does not exist";

    public static final String DATE_ORDER_INVALID = "Invalid date order";
}
