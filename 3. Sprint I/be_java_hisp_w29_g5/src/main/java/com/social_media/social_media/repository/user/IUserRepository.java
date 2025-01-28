package com.social_media.social_media.repository.user;

import java.util.List;
import java.util.Optional;

import com.social_media.social_media.entity.User;
import org.yaml.snakeyaml.util.Tuple;

public interface IUserRepository {
    Optional<User> findById(Long userId);

    User update(Long UserId, Long idNewPost);

    List<Long> findFavoritePostsById(Long userId);

    String findNameById(Long userId);
}
