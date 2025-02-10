package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.response.MessageDto;
import com.socialmeli.socialmeli.dto.response.PostIdDto;
import com.socialmeli.socialmeli.dto.response.ProductListDto;
import com.socialmeli.socialmeli.dto.response.ProductSaleCountDto;
import com.socialmeli.socialmeli.enums.Message;
import com.socialmeli.socialmeli.exception.AlreadyExistsException;
import com.socialmeli.socialmeli.exception.NotFoundException;
import com.socialmeli.socialmeli.exception.UserNotSellerException;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.IFollowRepository;
import com.socialmeli.socialmeli.repositories.IPostRepository;
import com.socialmeli.socialmeli.repositories.IUserRepository;
import com.socialmeli.socialmeli.utils.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final IPostRepository postRepository;

    private final IUserRepository userRepository;

    private final IFollowRepository followRepository;

    // US 0010
    @Override
    public MessageDto savePostSale(PostSaleDto postDto) {
        User user = getUserIfExists(postDto.getIdUser());

        if (postRepository.existsProductById(postDto.getProduct().getId())) {
            throw new AlreadyExistsException(Message.PRODUCT_ALREADY_EXISTS.getStr());
        }

        if (!user.getIsSeller()) {
            user.setIsSeller(true);
            userRepository.update(user);
        }

        postRepository.save(MyMapper.toPost(user, postDto));
        return new MessageDto(Message.POST_PUBLISHED.getStr());
    }

    // US 0005
    @Override
    public MessageDto savePost(PostDto postDto) {
        User user = getUserIfExists(postDto.getUserId());

        if (postRepository.existsProductById(postDto.getProduct().getId())) {
            throw new AlreadyExistsException(Message.PRODUCT_ALREADY_EXISTS.getStr());
        }

        if (!user.getIsSeller()) {
            user.setIsSeller(true);
            userRepository.update(user);
        }

        postRepository.save(MyMapper.toPost(user, postDto));
        return new MessageDto(Message.POST_PUBLISHED.getStr());
    }

    // US 0011
    @Override
    public ProductSaleCountDto getProductSaleCountByUser(Integer userId) {
        User user = getUserIfExists(userId);

        if (!user.getIsSeller()) {
            throw new UserNotSellerException(Message.USER_NOT_SELLER.format(user.getName()));
        }

        List<Post> posts = postRepository.findPostsWithPromoByUser(userId);

        if (posts.isEmpty()) {
            throw new UserNotSellerException(Message.USER_WITHOUT_POSTS.format(user.getName()));
        }

        return new ProductSaleCountDto(userId, user.getName(), posts.size());
    }

    // US 0006
    @Override
    public ProductListDto getRecentPostFromUsers(String order, Integer userId) {
        User user = getUserIfExists(userId);
        List<User> followed = followRepository.findFollowedUsers(user);
        List<Post> postsFromFollows = postRepository.postFromUsers(followed);
        List<PostIdDto> postsSinceLastWeek = filterPostsSince(postsFromFollows, LocalDate.now().minusWeeks(2));

        if (Objects.equals(order, "date_asc")) {
            postsSinceLastWeek = postsSinceLastWeek.stream().sorted(Comparator.comparing(PostIdDto::getDate)).toList();
        } else {
            postsSinceLastWeek = postsSinceLastWeek.stream()
                    .sorted(Comparator.comparing(PostIdDto::getDate).reversed())
                    .toList();
        }

        return new ProductListDto(userId, postsSinceLastWeek);
    }

    private User getUserIfExists(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.USER_NOT_FOUND.format(id)));
    }

    private List<PostIdDto> filterPostsSince(List<Post> posts, LocalDate date) {
        List<PostIdDto> postDtos = posts.stream().map(MyMapper::toPostIdDto).toList();
        postDtos = postDtos.stream().filter(postDto -> postDto.getDate().isAfter(date)
                || postDto.getDate().equals(date)).toList();
        return postDtos;
    }
}
