package com.social_media.social_media.service.user;

import com.social_media.social_media.dto.response.FollowingResponseDto;
import com.social_media.social_media.dto.response.FollowedResponseDto;
import com.social_media.social_media.dto.response.FollowersResponseDto;
import com.social_media.social_media.dto.response.UserResponseDto;
import com.social_media.social_media.dto.response.ProductResponseDto;
import com.social_media.social_media.dto.response.SellersPostsByFollowerResponseDto;
import com.social_media.social_media.dto.response.StockResponseDto;
import com.social_media.social_media.dto.response.PostPromoEndDateResponseDto;
import com.social_media.social_media.dto.response.PostDetailResponseDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.dto.response.PostResponseDto;
import com.social_media.social_media.dto.response.PromoProductsResponseDto;
import com.social_media.social_media.dto.response.FollowSuggestionResponseDto;
import com.social_media.social_media.dto.response.UserWithFavoritesPostResponseDto;
import com.social_media.social_media.dto.response.UserFavoritesResponseDto;
import com.social_media.social_media.dto.response.FollowersCountResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.exception.BadRequestFollowException;
import com.social_media.social_media.repository.follow.IFollowRepository;
import com.social_media.social_media.repository.post.IPostRepository;
import com.social_media.social_media.utils.MessagesExceptions;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.exception.NotSellerException;

import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.social_media.social_media.repository.user.IUserRepository;

import static com.social_media.social_media.utils.ComparatorOrder.getComparator;
import static com.social_media.social_media.utils.MessagesExceptions.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;
    private final IFollowRepository followRepository;

    @Override
    public void unfollowSeller(Long userId, Long userIdToUnfollow) {
        // validar si el user id ya está siguiendo al seller especificado (si existe registro)
        Optional<Follow> follow = followRepository.existsByFollowerAndFollowed(userId, userIdToUnfollow);
        if (follow.isEmpty()) {
            throw new BadRequestFollowException(MessagesExceptions.NOT_FOLLOW_ALREADY_EXISTS);
        }

        followRepository.deleteFollow(follow.get());
    }

    @Override
    public FollowersResponseDto searchFollowers(Long userId, String order) {
        Optional<User> followedUser = userRepository.findById(userId);

        if (followedUser.isEmpty()) {
            throw new NotFoundException(MessagesExceptions.SELLER_ID_NOT_EXIST);
        }

        List<Follow> followersFind = followRepository.findFollowers(userId);
        List<UserResponseDto> followers = followersFind.stream()
                .map(follow -> userRepository.findById(follow.getFollowerId())
                        .map(followerFound -> UserResponseDto.builder()
                                .user_id(followerFound.getUserId())
                                .user_name(followerFound.getName())
                                .build())
                        .orElse(null))
                .filter(Objects::nonNull)
                .sorted(getComparator(order, UserResponseDto::getUser_name))
                .toList();

        return new FollowersResponseDto(followedUser.get().getUserId(), followedUser.get().getName(), followers);
    }

    @Override
    public FollowedResponseDto searchFollowed(Long userId, String order) {
        Optional<User> followerUser = userRepository.findById(userId);

        if (followerUser.isEmpty()) {
            throw new NotFoundException(MessagesExceptions.USER_NOT_FOUND);
        }

        List<Follow> followedFind = followRepository.findFollowed(userId);
        List<UserResponseDto> followed = followedFind.stream()
                .map(follow -> userRepository.findById(follow.getFollowedId())
                        .map(followedFound -> UserResponseDto.builder()
                                .user_id(followedFound.getUserId())
                                .user_name(followedFound.getName())
                                .build())
                        .orElse(null))
                .filter(Objects::nonNull)
                .sorted(getComparator(order, UserResponseDto::getUser_name))
                .toList();

        return new FollowedResponseDto(followerUser.get().getUserId(), followerUser.get().getName(), followed);
    }

    @Override
    public FollowingResponseDto followSeller(Long userId, Long userIdToFollow) {
        Optional<Follow> followExist = followRepository.existsByFollowerAndFollowed(userId, userIdToFollow);

        // validar que el mismo id de user no se siga
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestFollowException(MessagesExceptions.THE_USER_CANNOT_FOLLOW_THEMSELVES);
        }

        // validar si el user id ya está siguiendo al seller especificado
        if (followExist.isPresent()) {
            throw new BadRequestFollowException(MessagesExceptions.FOLLOW_ALREADY_EXISTS);
        }

        // validar que el usuario que intenta seguir si es un seller buscando si existe
        // al menos un post
        if (postRepository.findByUserId(userIdToFollow).isEmpty()) {
            throw new BadRequestFollowException(MessagesExceptions.FOLLOWED_USER_NOT_SELLER);
        }

        Follow follow = followRepository.addFollow(userId, userIdToFollow);

        return FollowingResponseDto.builder()
                .user_id(follow.getFollowerId())
                .userIdToFollow(follow.getFollowedId())
                .build();
    }

    @Override
    public FollowersCountResponseDto searchFollowersCount(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty())
            throw new NotFoundException(SELLER_ID_NOT_EXIST);

        if (postRepository.findPostBySellerId(userId).isEmpty())
            throw new NotSellerException(FOLLOWED_USER_NOT_SELLER);

        List<Follow> listFilteredFollower = followRepository.findFollowers(userId);
        User user = userOptional.get();

        return FollowersCountResponseDto
                .builder()
                .user_id(user.getUserId())
                .user_name(user.getName())
                .followers_count(listFilteredFollower.size())
                .build();
    }

    @Override
    public List<FollowSuggestionResponseDto> searchFollowSuggestions(Long userId, Integer limit) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));

        // Obtener las marcas favoritas del usuario
        List<String> favouriteBrands = searchUserFavoritesPost(userId).getFavorites().stream()
                .map(post -> post.getProduct().getBrand().toUpperCase())
                .distinct().toList();
        if(favouriteBrands.isEmpty()) throw new NotFoundException(NO_FAVOURITE_POSTS);

        // Encontrar vendedores que venden esas marcas
        Map<Long, List<String>> sellersWithBrands = postRepository.findSellersByBrands(favouriteBrands);

        // Obtener los IDs de los usuarios seguidos por el usuario actual
        Set<Long> followedIds = followRepository.findFollowed(userId).stream()
                .map(Follow::getFollowedId)
                .collect(Collectors.toSet());

        // Filtrar vendedores que no han sido seguidos por el usuario, y que no sean el propio usuario
        Map<Long, List<String>> filteredSuggestions = sellersWithBrands.entrySet().stream()
                .filter(entry -> !followedIds.contains(entry.getKey()) && entry.getKey() != userId)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if(filteredSuggestions.isEmpty()) throw new NotFoundException(NO_SUGGESTIONS);

        return filteredSuggestions.entrySet().stream()
                .map(entry -> FollowSuggestionResponseDto.builder()
                        .user_id(entry.getKey())
                        .user_name(userRepository.findNameById(entry.getKey()))
                        .brandsSold(entry.getValue())
                        .build())
                .sorted(Comparator.comparing((FollowSuggestionResponseDto sug) -> sug.getBrandsSold().size()).reversed())
                .limit(limit)
                .toList();
    }

    @Override
    public UserWithFavoritesPostResponseDto updateUserFavoritesPost(Long userId, Long postId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException(MessagesExceptions.USER_NOT_FOUND));

        postRepository.findById(postId).orElseThrow(() -> new NotFoundException(POST_NOT_FOUND));

        if (userRepository.findFavoritePostsById(userId).contains(postId))
            throw new BadRequestFollowException(POST_ALREADY_FAVORITE);

        User updateUser = userRepository.update(userId, postId);

        List<Post> favoritePosts = updateUser.getFavoritePosts().stream()
                .map(postRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return UserWithFavoritesPostResponseDto.builder()
                .user_id(updateUser.getUserId())
                .user_name(updateUser.getName())
                .favorite_posts(favoritePosts)
                .build();
    }

    @Override
    public UserFavoritesResponseDto searchUserFavoritesPost(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException(MessagesExceptions.USER_NOT_FOUND));

        List<Long> favoritePosts = userRepository.findFavoritePostsById(userId);

        List<Post> posts = favoritePosts.stream()
                .map(postRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        List<PostPromoResponseDto> postsDto = posts.stream()
                .map(post -> PostPromoResponseDto.builder()
                        .post_id(post.getPostId())
                        .user_id(post.getUserId())
                        .date(post.getDate())
                        .product(ProductResponseDto.builder()
                                .product_id(post.getProduct().getProductId())
                                .product_name(post.getProduct().getProductName())
                                .type(post.getProduct().getType())
                                .brand(post.getProduct().getBrand())
                                .color(post.getProduct().getColor())
                                .notes(post.getProduct().getNotes())
                                .build())
                        .category(post.getCategory())
                        .price(post.getPrice())
                        .has_promo(post.getDiscount() != 0.0)
                        .discount(post.getDiscount())
                        .build()
                ).toList();


        return UserFavoritesResponseDto.builder().favorites(postsDto).build();
    }
}
