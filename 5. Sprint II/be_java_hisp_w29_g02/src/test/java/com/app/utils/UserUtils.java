package com.app.utils;

import com.app.dto.response.UserDTO;
import com.app.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserUtils {

    // T-0003 US-0008
    public static Optional<User> createUser() {
        ArrayList<Integer> followersIds = new ArrayList<>();
        followersIds.add(2);
        followersIds.add(4);
        followersIds.add(3);
        followersIds.add(2);
        followersIds.add(4);
        followersIds.add(3);
        return Optional.of(new User(1, "Juli", Boolean.TRUE, null, followersIds, followersIds));
    }

    // T-0003 US-0008
    public static List<User> createFollowerList() {
        List<User> followerList = new ArrayList<>();
        followerList.add(new User(3, "Carlos", null, null, null, null));
        followerList.add(new User(4, "Benecio", null, null, null, null));
        followerList.add(new User(2, "Alfredo", null, null, null, null));
        return followerList;
    }

    // T-0003 US-0008
    public static List<User> createFollowedList() {
        List<User> followedList = new ArrayList<>();
        followedList.add(new User(3, "Carlos", null, null, null, null));
        followedList.add(new User(4, "Benecio", null, null, null, null));
        followedList.add(new User(2, "Alfredo", null, null, null, null));
        return followedList;
    }


    public static List<UserDTO> getFollowedByDavidNalbandian(List<User> users) {
        Optional<User> nalbandian = users.stream()
                .filter(user -> user.getId().equals(12004))
                .findFirst();

        if (nalbandian.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> followingIds = nalbandian.get().getFollowing();

        return users.stream()
                .filter(user -> followingIds.contains(user.getId()))
                .map(user -> new UserDTO(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }

}
