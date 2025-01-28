package com.social_media.social_media.service.post;

import com.social_media.social_media.dto.response.ProductResponseDto;
import com.social_media.social_media.dto.response.SellersPostsByFollowerResponseDto;
import com.social_media.social_media.dto.response.StockResponseDto;
import com.social_media.social_media.dto.response.PostPromoEndDateResponseDto;
import com.social_media.social_media.dto.response.PostDetailResponseDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.dto.response.PostResponseDto;
import com.social_media.social_media.dto.response.PromoProductsResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.InvalidPromotionEndDateException;
import com.social_media.social_media.exception.NotSellerException;
import com.social_media.social_media.repository.follow.IFollowRepository;
import com.social_media.social_media.utils.MessagesExceptions;
import com.social_media.social_media.dto.request.PostRequestDto;
import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.dto.request.IPostRequestDto;
import com.social_media.social_media.dto.request.ProductRequestDto;
import com.social_media.social_media.dto.request.PostPromoEndDateRequestDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import com.social_media.social_media.entity.Stock;
import com.social_media.social_media.enums.PostType;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.user.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.social_media.social_media.repository.post.IPostRepository;
import com.social_media.social_media.repository.stock.IStockRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.social_media.social_media.utils.ComparatorOrder.getComparator;
import static com.social_media.social_media.utils.MessagesExceptions.SELLER_ID_NOT_EXIST;

import static com.social_media.social_media.utils.MessagesExceptions.*;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IFollowRepository followRepository;

    private final IStockRepository stockRepository;

    @Override
    public PostPromoEndDateResponseDto createPostPromoEndDate(PostPromoEndDateRequestDto postPromoEndDateRequestDto) {
        if (postPromoEndDateRequestDto.getPromotionEndDate().isBefore(postPromoEndDateRequestDto.getDate())) {
            throw new InvalidPromotionEndDateException(END_DATE_BEFORE_PUBLICATION_DATE);

        }
        Post post = createPostCommon(postPromoEndDateRequestDto, postPromoEndDateRequestDto.getDiscount(),
                postPromoEndDateRequestDto.getPromotionEndDate());
        postRepository.add(post);
        return buildPostPromoEndDateResponseDto(post);
    }

    @Override
    public PostResponseDto createPost(PostRequestDto postProductRequestDto) {
        Post post = createPostCommon(postProductRequestDto, 0.0, null);
        postRepository.add(post);
        return buildPostResponseDto(post);
    }

    @Override
    public PostPromoResponseDto createPostPromo(PostPromoRequestDto postPromoRequestDto) {
        Post post = createPostCommon(postPromoRequestDto, postPromoRequestDto.getDiscount(), null);
        postRepository.add(post);
        return buildPostPromoResponseDto(post);
    }

    @Override
    public SellersPostsByFollowerResponseDto searchFollowedPostsFromLastTwoWeeks(Long userId, String order) {
        Optional<User> oUser = userRepository.findById(userId);
        if (oUser.isEmpty()) {
            throw new NotFoundException(MessagesExceptions.USER_NOT_FOUND);
        }

        LocalDate lastTwoWeeks = LocalDate.now().minusWeeks(2);

        List<Long> followedIds = followRepository.findFollowed(userId).stream().map(Follow::getFollowedId).toList();
        if (followedIds.isEmpty()) {
            throw new NotFoundException(MessagesExceptions.NO_FOLLOWERS_FOUND + userId);
        }
        List<Post> posts = followedIds.stream()
                .flatMap(followedId -> postRepository.findByIdSince(followedId, lastTwoWeeks).stream()).toList();

        if (posts.isEmpty()) {
            throw new NotFoundException(MessagesExceptions.NO_RECENT_POSTS_FOUND + userId);
        }

        List<PostResponseDto> postsDto = posts.stream()
                .map(this::buildPostResponseDto)
                .sorted(getComparator(order, PostResponseDto::getDate, PostResponseDto::getPost_id))
                .toList();
        return SellersPostsByFollowerResponseDto.builder().user_id(userId).posts(postsDto).build();
    }

    @Override
    public PromoProductsResponseDto searchSellersWithPromoPosts(Long userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new NotFoundException(SELLER_ID_NOT_EXIST);
        }

        if (postRepository.findPostBySellerId(userId).isEmpty()) {
            throw new NotSellerException(FOLLOWED_USER_NOT_SELLER);
        }

        List<Post> post = postRepository.findWithFilters(PostType.PROMO, userId);
        return PromoProductsResponseDto.builder()
                .user_id(userId)
                .user_name(userRepository.findById(userId).get().getName())
                .promo_products_count(post.size())
                .build();
    }

    private Post createPostCommon(IPostRequestDto postRequestDto, Double discount, LocalDate endDate) {
        if (userRepository.findById(postRequestDto.getUser_id()).isEmpty()) {
            throw new NotFoundException(SELLER_ID_NOT_EXIST);
        }

        return Post.builder()
                .postId(Integer.toUnsignedLong(postRepository.findWithFilters(PostType.ALL, null).size() + 1))
                .userId(postRequestDto.getUser_id())
                .date(postRequestDto.getDate())
                .product(buildProduct(postRequestDto.getProduct()))
                .category(postRequestDto.getCategory())
                .price(postRequestDto.getPrice())
                .discount(discount)
                .promotionEndDate(endDate)
                .build();
    }

    // Method to build a Product object from a ProductRequestDto object
    private Product buildProduct(ProductRequestDto productRequestDto) {
        return Product.builder()
                .productId(productRequestDto.getProduct_id())
                .productName(productRequestDto.getProduct_name())
                .type(productRequestDto.getType())
                .brand(productRequestDto.getBrand())
                .color(productRequestDto.getColor())
                .notes(productRequestDto.getNotes())
                .build();
    }

    // Method to build a PostResponseDto object from a Post object
    private PostResponseDto buildPostResponseDto(Post post) {
        return PostResponseDto.builder()
                .post_id(post.getPostId())
                .user_id(post.getUserId())
                .date(post.getDate())
                .product(buildProductResponseDto(post.getProduct()))
                .category(post.getCategory())
                .price(post.getPrice())
                .build();
    }

    // Method to build a PostPromoResponseDto object from a Post object
    private PostPromoResponseDto buildPostPromoResponseDto(Post post) {
        return PostPromoResponseDto.builder()
                .post_id(post.getPostId())
                .user_id(post.getUserId())
                .date(post.getDate())
                .product(buildProductResponseDto(post.getProduct()))
                .category(post.getCategory())
                .price(post.getPrice())
                .discount(post.getDiscount())
                .has_promo(true)
                .build();
    }

    // Method to build a ProductResponseDto object from a Product object
    private ProductResponseDto buildProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .product_id(product.getProductId())
                .product_name(product.getProductName())
                .type(product.getType())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .build();
    }

    // Method to build a PostPromoEndDateResponseDto object from a Post object
    private PostPromoEndDateResponseDto buildPostPromoEndDateResponseDto(Post post) {
        return PostPromoEndDateResponseDto.builder()
                .post_id(post.getPostId())
                .user_id(post.getUserId())
                .date(post.getDate())
                .product(buildProductResponseDto(post.getProduct()))
                .category(post.getCategory())
                .price(post.getPrice())
                .discount(post.getDiscount())
                .has_promo(true)
                .promotionEndDate(post.getPromotionEndDate())
                .build();
    }

    @Override
    public PostDetailResponseDto searchById(Long postId) {
        Optional<Post> postFound = this.postRepository.findById(postId);

        if (postFound.isEmpty()) {
            throw new NotFoundException(MessagesExceptions.POST_NOT_FOUND);
        }

        Stock stockFound = this.stockRepository.findByPostId(postId).orElse(null);

        return PostDetailResponseDto.builder()
                .user_id(postFound.get().getUserId())
                .post_id(postFound.get().getPostId())
                .date(postFound.get().getDate())
                .product(ProductResponseDto.builder()
                        .product_id(postFound.get().getProduct().getProductId())
                        .product_name(postFound.get().getProduct().getProductName())
                        .type(postFound.get().getProduct().getType())
                        .brand(postFound.get().getProduct().getBrand())
                        .color(postFound.get().getProduct().getColor())
                        .notes(postFound.get().getProduct().getNotes())
                        .build())
                .category(postFound.get().getCategory())
                .price(postFound.get().getPrice())
                .discount(postFound.get().getDiscount())
                .has_promo(postFound.get().getDiscount() > 0 ? true : false)
                .stock(stockFound != null ? StockResponseDto.builder().units(stockFound.getUnits()).build() : null)
                .build();
    }

}
