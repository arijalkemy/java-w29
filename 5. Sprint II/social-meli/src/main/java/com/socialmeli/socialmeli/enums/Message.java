package com.socialmeli.socialmeli.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    // Mensajes de éxito
    USER_FOLLOWED("%s followed successfully"),
    USER_UNFOLLOWED("%s unfollowed successfully"),
    POST_PUBLISHED("Post published successfully"),
    COMMENT_PUBLISHED("Comment published successfully"),

    // Mensajes de error
    USER_NOT_FOUND("User with ID %d not found"),
    USER_NOT_SELLER("%s is not a seller"),
    USER_NOT_FOLLOWED("%s is not followed by %s"),
    USER_ALREADY_FOLLOWED("%s is already followed by %s"),
    CANNOT_UNFOLLOW_SELF("You cannot unfollow yourself"),
    CANNOT_FOLLOW_SELF("You cannot follow yourself"),
    PRODUCT_ALREADY_EXISTS("A post with this product already exists"),
    POST_NOT_FOUND("Post with ID %d not found"),
    USER_WITHOUT_POSTS("No promotional posts found for %s"),
    NO_POSTS_CURRENTLY("No promotional posts currently"),
    FILTER_ERROR("A filter value is wrong"),
    FILTER_LIST_EMPTY("No post meets the selected filters"),
    NO_SELLERS("No sellers found");

    private final String str;

    public String format(Object... args) {
        return String.format(str, args);
    }
}
