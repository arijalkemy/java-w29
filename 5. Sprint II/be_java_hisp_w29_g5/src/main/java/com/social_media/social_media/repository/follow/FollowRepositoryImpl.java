package com.social_media.social_media.repository.follow;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.exception.DataLoadException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.social_media.social_media.utils.MessagesExceptions.INVALID_FOLLOW_ENTITY;

@Repository
public class FollowRepositoryImpl implements IFollowRepository {
    private Map<UUID, Follow> follows;

    public FollowRepositoryImpl() {
        try {
            loadDataBase();
        } catch (IOException e) {
            throw new DataLoadException(INVALID_FOLLOW_ENTITY);
        }
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Follow> followList;

        file = ResourceUtils.getFile("classpath:follows.json");
        followList = objectMapper.readValue(file, new TypeReference<>() {
        });

        follows = followList.stream().collect(Collectors.toMap(follow -> UUID.randomUUID(), follow -> follow));
    }

    @Override
    public void deleteFollow(Follow followToDelete) {
        // Encuentra la key (UUID) y elimina el registro
        follows.entrySet().removeIf(entry -> entry.getValue().equals(followToDelete));
    }

    @Override
    public Follow addFollow(Long followerId, Long followedId) {
        Follow newFollow = Follow.builder()
                .followerId(followerId)
                .followedId(followedId)
                .build();
        follows.put(UUID.randomUUID(), newFollow);

        return newFollow;
    }

    @Override
    public Optional<Follow> existsByFollowerAndFollowed(Long userId, Long userIdToFollow) {
        return follows.values().stream()
                .filter(f -> f.getFollowerId().equals(userId) && f.getFollowedId().equals(userIdToFollow))
                .findFirst();
    }

    @Override
    public List<Follow> findFollowed(Long userId) {
        List<Follow> followedsFind = new ArrayList<>();
        follows.forEach((__, follow) -> {
            if (follow.getFollowerId().equals(userId)) {
                followedsFind.add(follow);
            }
        });

        return followedsFind;
    }

    @Override
    public List<Follow> findFollowers(Long userId) {
        List<Follow> followersFind = new ArrayList<>();
        this.follows.forEach((__, follow) -> {
            if (follow.getFollowedId().equals(userId)) {
                followersFind.add(follow);
            }
        });

        return followersFind;
    }
}
