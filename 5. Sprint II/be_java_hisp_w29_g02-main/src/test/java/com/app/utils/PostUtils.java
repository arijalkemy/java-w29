package com.app.utils;

import com.app.model.Post;
import com.app.model.Product;
import com.app.model.User;
import com.app.util.DateOrder;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostUtils {

    public static int getUserId() {
        return getBuyer().getId();
    }

    public static int getFollowedUserId() {
        return 2;
    }

    private static User getBuyer() {
        return new User(
                1,
                "Juli",
                false,
                List.of(),
                List.of(),
                List.of(2)
        );
    }

    public static User getPromoUser() {
        return new User(
                3,
                "Juan",
                true,
                List.of(), List.of(), List.of()
        );
    }

    public static Optional<User> getUserOpt() {
        return Optional.of(getBuyer());
    }

    public static List<Integer> getFollowedUsersIds() {
        return getBuyer().getFollowing();
    }

    public static List<Post> getFollowedUsersPosts() {
        return Arrays.asList(
                new Post(1, 2, 1, 1, 10.0, LocalDate.now().minusDays(5), false, 0.0),
                new Post(2, 2, 2, 1, 20.0, LocalDate.now().minusDays(7), true, 0.1),
                new Post(3, 2, 3, 1, 30.0, LocalDate.now().minusDays(15), false, 0.0)
        );
    }

    public static List<Post> getPostsInLastTwoWeeks() {
        return Arrays.asList(
                new Post(2, 2, 2, 1, 20.0, LocalDate.now().minusDays(3), true, 0.1),
                new Post(1, 2, 1, 1, 10.0, LocalDate.now().minusDays(7), false, 0.0)
        );
    }

    public static List<Post> getPostsOutsideLastTwoWeeks() {
        return List.of(
                new Post(3, 2, 3, 1, 30.0, LocalDate.now().minusDays(15), false, 0.0)
        );
    }

    public static List<Post> getAscPostsInLastTwoWeeks() {
        return getPostsInLastTwoWeeks().reversed();
    }

    public static Product getProductById(Integer id) {
        Map<Integer, Product> productMap = new HashMap<>();

        productMap.put(1, new Product(1, "pepe", "1", "1", "1", "1"));
        productMap.put(2, new Product(2, "pepito", "2", "2", "2", "2"));
        productMap.put(3, new Product(3, "pepita", "3", "3", "3", "3"));

        return productMap.get(id);
    }

    public static DateOrder getAscOrder() {
        return DateOrder.fromValue(getAscOrderString());
    }

    public static DateOrder getDescOrder() {
        return DateOrder.fromValue(getDescOrderString());
    }

    public static LocalDate getTwoWeeksFromNow() {
        return LocalDate.now().minusWeeks(2);
    }

    public static String getAscOrderString() {
        return "DATE_ASC";
    }

    public static String getDescOrderString() {
        return "DATE_DESC";
    }

    public static String getBadOrderString() {
        return "BAD_ORDER";
    }

    // T-0009 US-00011
    public static List<Post> createPromoPosts() {
        return Stream.of(true, true, true, false)
                .map(hasPromo -> {
                    Post post = new Post();
                    post.setHasPromo(hasPromo);
                    return post;
                })
                .collect(Collectors.toList());
    }
}
