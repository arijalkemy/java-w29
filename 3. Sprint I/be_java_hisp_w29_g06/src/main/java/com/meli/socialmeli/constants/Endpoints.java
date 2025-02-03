package com.meli.socialmeli.constants;

public class Endpoints {
    public final static String BASE_USERS = "/users";
    public final static String BASE_POSTS = "/products";
    public final static String BASE_SELLER = "/sellers";
    public final static String POSTS_POST = "/post";
    public final static String POSTS_PROMO_POST = "/promo-post";
    public final static String POSTS_PROMO_POST_COUNT = "/promo-post/count";
    public final static String POSTS_FOLLOWED_LIST = "/followed/{userId}/list";
    public final static String POSTS_PROMO_LIST = "/promo-post/list";
    public final static String USERS_FOLLOW = "/{userId}/follow/{sellerId}";
    public final static String USERS_UNFOLLOW = "/{userId}/unfollow/{userIdToUnfollow}";
    public final static String USERS_FOLLOWERS_LIST = "/{userId}/followers/list";
    public final static String USERS_FOLLOWED_LIST = "/{userId}/followed/list";
    public final static String USERS_FOLLOWERS_COUNT = "/users/{userId}/followers/count";
    public final static String POSTS_FILTER_BY_PRICE = "/price";

}
