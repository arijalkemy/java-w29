package com.social_media.social_media.repository.post;

import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.enums.PostType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Optional;

public interface IPostRepository {
    Optional<Post> findById(Long postId);

    List<Post> findByUserId(Long userId);

    List<Post> findPostBySellerId(Long userIdToFollow);

    List<Post> findByIdSince(Long followedId, LocalDate lastTwoWeeks);

    Post add(Post post);

    List<Post> findWithFilters(PostType postType, Long userId);

    Map<Long, List<String>> findSellersByBrands(List<String> favouriteBrands);
}
