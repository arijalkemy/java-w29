package com.thiagoschreck.local.melisocial.exception;

public class UserAlreadyFollowingSellerException extends RuntimeException {
    public UserAlreadyFollowingSellerException(Integer userId, Integer userIdToUnfollow) {
        super(String.format("User %d is following seller %d", userId, userIdToUnfollow));
    }
}
