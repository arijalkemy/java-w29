package com.thiagoschreck.local.melisocial.exception;

public class UserNotFollowingSellerException extends RuntimeException {
    public UserNotFollowingSellerException(Integer userId, Integer userIdToUnfollow) {
        super(String.format("User %d is not following seller %d", userId, userIdToUnfollow));
    }
}
