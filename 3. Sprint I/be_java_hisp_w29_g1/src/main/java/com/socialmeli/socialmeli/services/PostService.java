package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.request.CommentRequestDto;
import com.socialmeli.socialmeli.dto.response.*;
import com.socialmeli.socialmeli.enums.Message;
import com.socialmeli.socialmeli.enums.Order;
import com.socialmeli.socialmeli.exception.AlreadyExistsException;
import com.socialmeli.socialmeli.exception.BadRequestException;
import com.socialmeli.socialmeli.exception.NotFoundException;
import com.socialmeli.socialmeli.exception.UserNotSellerException;
import com.socialmeli.socialmeli.models.Comment;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.IFollowRepository;
import com.socialmeli.socialmeli.repositories.IPostRepository;
import com.socialmeli.socialmeli.repositories.IUserRepository;
import com.socialmeli.socialmeli.utils.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final IPostRepository postRepository;

    private final IUserRepository userRepository;

    private final IFollowRepository followRepository;

    @Override
    public MessageDto savePostSale(PostSaleDto postDto) {
        User user = getUserIfExists(postDto.getIdUser());

        throwIfProductExists(postDto.getProduct().getId());
        updateUserToSellerIfNotSeller(user);

        postRepository.save(MyMapper.toPost(user, postDto));
        return new MessageDto(Message.POST_PUBLISHED.getStr());
    }

    @Override
    public MessageDto savePost(PostDto postDto) {
        User user = getUserIfExists(postDto.getUserId());

        throwIfProductExists(postDto.getProduct().getId());
        updateUserToSellerIfNotSeller(user);

        postRepository.save(MyMapper.toPost(user, postDto));
        return new MessageDto(Message.POST_PUBLISHED.getStr());
    }

    @Override
    public ProductSaleCountDto getProductSaleCountByUser(Integer userId) {
        User user = getUserIfExists(userId);

        throwIfNotSeller(user);

        List<Post> posts = postRepository.getPostsWithPromoByUser(userId);

        throwIfPostsIsEmpty(posts, user);

        return new ProductSaleCountDto(userId, posts.getFirst().getUser().getName(), posts.size());
    }

    // US 0015
    @Override
    public  List<PostIdDto> getFilteredPosts(String category, String priceRange, String productBrand, String productType) {
        Double priceMin = null;
        Double priceMax = null;
        Integer categoryNum = null;

        if (category != null){
            try {
                categoryNum = Integer.parseInt(category);
            } catch (NumberFormatException ignored) {
                throw new BadRequestException(Message.FILTER_ERROR.getStr());
            }
        }

        if (priceRange != null) {
            List<String > prices = List.of(priceRange.split("-"));
            try {
                priceMin = Double.parseDouble(prices.get(0));
                priceMax = Double.parseDouble(prices.get(1));
                if(priceMin >= priceMax) {
                    priceMin = null;
                    priceMax = null;
                }
            } catch (NumberFormatException | NullPointerException e) {
                throw new BadRequestException(Message.FILTER_ERROR.getStr());
            }
        }

        List<Post> posts = postRepository.findPostByFilter(categoryNum, priceMin, priceMax, productBrand, productType);
        if (posts.isEmpty()){
            throw new NotFoundException(Message.FILTER_LIST_EMPTY.getStr());
        }

        return posts.stream().map(MyMapper::toPostIdDto).toList();
    }

    // US 0018
    @Override
    public CategoryCountByUserDto getCategoryReportByUser(Integer idUser) {
        User user = getUserIfExists(idUser);

        throwIfNotSeller(user);

        List<CategoryCountDto> report = postRepository.countPostsByCategory(idUser)
                .entrySet()
                .stream()
                .map(entry -> new CategoryCountDto(entry.getKey(), entry.getValue()))
                .toList();

        return new CategoryCountByUserDto(user.getId(), user.getName(), report);
    }

    // US 0019
    @Override
    public List<CategoryCountDto> getCategoryReportForAll() {
        return postRepository.countPostsByCategory()
                .entrySet()
                .stream()
                .map(entry -> new CategoryCountDto(entry.getKey(), entry.getValue()))
                .toList();
    }

    // US 0012
    @Override
    public List<ProductsPromotionDto> getProductSaleCount(Integer userId) {
        if (userId != null) {
            return findProductSaleCount(userId);
        } else {
            return findProductSaleCount();
        }
    }

    // US 0014
    @Override
    public CommentsListDto getCommentsById (Integer postId){
        getPostIfExits(postId);
        List<CommentResponseDto> comments = postRepository
                .findAllCommentsByPostId(postId)
                .stream()
                .map(MyMapper::toCommentResponseDto)
                .toList();
        return new CommentsListDto(postId, comments);
    }

    // US 0006
    @Override
    public ProductListDto getRecentPostFromUsers(String order, Integer userId) {
        if (!order.equalsIgnoreCase(String.format("date_%s", Order.ASC.getString())) &&
                !order.equalsIgnoreCase( String.format("date_%s", Order.DESC.getString()))) {
            throw new BadRequestException(Message.INVALID_ORDER.getStr());
        }
        User user= getUserIfExists(userId);
        List<User> followed= followRepository.getFollowedUsers(user);
        List<Post> postsFromFollows = postRepository.postFromUsers(followed);
        List<PostIdDto> postsSinceLastWeek = filterPostsSince(postsFromFollows, LocalDate.now().minusWeeks(2));

        if (Objects.equals(order, "date_asc")){
            postsSinceLastWeek = postsSinceLastWeek.stream().sorted(Comparator.comparing(PostIdDto::getDate)).toList();
        }
        else{
            postsSinceLastWeek = postsSinceLastWeek.stream().sorted(Comparator.comparing(PostIdDto::getDate).reversed()).toList();
        }

        return new ProductListDto(userId, postsSinceLastWeek);
    }

    // US 0013
    @Override
    public MessageDto addComment(Integer postId, CommentRequestDto commentDto) {
        User user = getUserIfExists(commentDto.getUserId());
        Post post = getPostIfExits(postId);

        Comment newComment = new Comment(user, commentDto.getContent());

        post.getComments().add(newComment);
        postRepository.update(post);

        return new MessageDto(Message.COMMENT_PUBLISHED.getStr());
    }

    // US 0017
    @Override
    public List<RankingPostSellerDto> getRankingSellerForPost() {
        List<User> listSellers = userRepository.findUserSeller();

        if (listSellers.isEmpty()){
            throw new NotFoundException(Message.NO_SELLERS.getStr());
        }

        List<RankingPostSellerDto> listRanking = new ArrayList<>();

        for (User seller : listSellers) {
            List<Post> listPostBySeller = postRepository.findPostBySeller(seller.getId());
            RankingPostSellerDto dto = new RankingPostSellerDto(seller.getId(), seller.getName(), listPostBySeller.size());
            listRanking.add(dto);
        }

        return listRanking
                .stream()
                .sorted((r1, r2) -> Integer.compare(r2.getPostCount(), r1.getPostCount()))
                .toList();
    }

    private void throwIfProductExists(Integer id) {
        if (postRepository.existsProductById(id)) {
            throw new AlreadyExistsException(Message.PRODUCT_ALREADY_EXISTS.getStr());
        }
    }

    private void updateUserToSellerIfNotSeller(User user) {
        if (!user.getIsSeller()) {
            user.setIsSeller(true);
            userRepository.update(user);
        }
    }

    private User getUserIfExists(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.USER_NOT_FOUND.format(id)));
    }

    private List<PostIdDto> filterPostsSince(List<Post> posts, LocalDate date) {
        List<PostIdDto> postDtos = posts.stream().map(MyMapper::toPostIdDto).toList();
        postDtos = postDtos.stream().filter(postDto -> postDto.getDate().isAfter(date) || postDto.getDate().equals(date)).toList();
        return postDtos;
    }

    private Post getPostIfExits(Integer postId) {
        return postRepository.findById(postId).orElseThrow(() ->
                new NotFoundException(Message.POST_NOT_FOUND.format(postId)));
    }

    private void throwIfNotSeller(User user) {
        if (!user.getIsSeller()){
            throw new UserNotSellerException(Message.USER_NOT_SELLER.format(user.getName()));
        }
    }

    private void throwIfPostsIsEmpty(List<Post> posts, User user) {
        if (posts.isEmpty()){
            throw new UserNotSellerException(Message.USER_WITHOUT_POSTS.format(user.getName()));
        }
    }

    private void throwIfNoPostCurrently(List<Post> posts) {
        if (posts.isEmpty()){
            throw new UserNotSellerException(Message.NO_POSTS_CURRENTLY.getStr());
        }
    }

    private List<ProductsPromotionDto> findProductSaleCount(Integer userId) {
        User user = getUserIfExists(userId);
        throwIfNotSeller(user);

        List<Post> posts = postRepository.getPostsWithPromoByUserOptional(userId);
        throwIfPostsIsEmpty(posts, user);

        List<PostIdSaleDto> postDtos = posts.stream()
                .map(MyMapper::toPostIdSaleDto)
                .toList();

        ProductsPromotionDto productsPromotionDto = new ProductsPromotionDto(user.getId(), user.getName(), postDtos);

        return List.of(productsPromotionDto);
    }

    private List<ProductsPromotionDto> findProductSaleCount() {
        List<Post> allPromoPosts = postRepository.getPostsWithPromoByUserOptional();
        throwIfNoPostCurrently(allPromoPosts);

        Map<User, List<Post>> groupedPosts = allPromoPosts.stream()
                .collect(Collectors.groupingBy(Post::getUser));

        return groupedPosts.entrySet().stream()
                .map(entry -> {
                    User user = entry.getKey();
                    List<Post> userPosts = entry.getValue();
                    List<PostIdSaleDto> postDtos = userPosts.stream()
                            .map(MyMapper::toPostIdSaleDto)
                            .toList();

                    return new ProductsPromotionDto(user.getId(), user.getName(), postDtos);
                }).collect(Collectors.toList());
    }
}
