package com.meli.socialmeli.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.constants.OrderType;
import com.meli.socialmeli.constants.PostOrder;
import com.meli.socialmeli.dto.response.ResponseDto;
import com.meli.socialmeli.exception.NotFoundOrderException;
import org.springframework.stereotype.Service;

import com.meli.socialmeli.dto.NumberOfProductsInSaleDto;
import com.meli.socialmeli.dto.PostDto;
import com.meli.socialmeli.dto.ProductDto;
import com.meli.socialmeli.dto.response.PostFromFollowedDto;
import com.meli.socialmeli.dto.response.ProductsOfSellerDto;
import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Product;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.exception.ConflictException;
import com.meli.socialmeli.exception.NoSellersFollowedException;
import com.meli.socialmeli.exception.NotFoundException;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IProductRepository;
import com.meli.socialmeli.repository.ISellerRepository;
import com.meli.socialmeli.repository.IUserRepository;

@Service
public class PostServiceImpl implements IPostService {

    private IPostRepository postRepository;
    private IProductRepository productRepository;
    private IUserRepository userRepository;
    private ISellerRepository sellerRepository;

    public PostServiceImpl(
            IPostRepository postRepository,
            IProductRepository productRepository,
            IUserRepository userRepository,
            ISellerRepository sellerRepository
    ) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public ResponseDto addPost(PostDto post) {
        Optional<Seller> seller = this.sellerRepository.getById(post.getUserId());

        if (seller.isEmpty()) {
            throw new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", post.getUserId().toString()));
        }

        ProductDto productDto = post.getProduct();
        Product productToSave = Product.builder()
                .id(productDto.getProductId())
                .name(productDto.getProductName())
                .type(productDto.getType())
                .brand(productDto.getBrand())
                .color(productDto.getColor())
                .notes(productDto.getNotes())
                .build();

        Optional<Product> productSaved = this.productRepository.save(productToSave);

        if (productSaved.isEmpty()) {
            throw new ConflictException(Messages.POST_CONFLICT);
        }

        Post postToSave = Post.builder()
                .date(post.getDate())
                .price(post.getPrice())
                .product(productSaved.get())
                .seller(seller.get())
                .hasPromo(false)
                .category(post.getCategory())
                .build();

        Optional<Post> postSaved = this.postRepository.save(postToSave);

        if (postSaved.isEmpty()) {
            throw new ConflictException(Messages.POST_CONFLICT);
        }

        return ResponseDto.builder().message(Messages.SUCCESS).build();
    }

    @Override
    public ResponseDto addPromoPost(PostDto promoPostDto) {
        Seller seller = sellerRepository.getById(promoPostDto.getUserId()).orElseThrow(() -> new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", promoPostDto.getUserId().toString())));

        Product product = productRepository.save(
                Product.builder()
                        .id(promoPostDto.getProduct().getProductId())
                        .name(promoPostDto.getProduct().getProductName())
                        .brand(promoPostDto.getProduct().getBrand())
                        .color(promoPostDto.getProduct().getColor())
                        .notes(promoPostDto.getProduct().getNotes())
                        .type(promoPostDto.getProduct().getType())
                        .build()
        ).orElseThrow(() -> new ConflictException(Messages.PRODUCT_CONFLICT));


        Post post = Post.builder()
                .date(promoPostDto.getDate())
                .price(promoPostDto.getPrice())
                .product(product)
                .seller(seller)
                .category(promoPostDto.getCategory())
                .hasPromo(true)
                .discount(promoPostDto.getDiscount())
                .build();

        if(postRepository.save(post).isEmpty())
            throw new ConflictException(Messages.POST_CONFLICT);

        return  ResponseDto.builder().message(Messages.SUCCESS).build();
    }

    private PostOrder getPostOrder(Integer orderValue) {
        return Arrays.stream(PostOrder.values())
                .filter(order -> order.getValueFromOrder() == orderValue)
                .findFirst()
                .orElse(PostOrder.DESCENDING);
    }

    @Override
    public PostFromFollowedDto getPostsFromFollowedUsers(Integer userId, Integer order) {
        User user = userRepository.getById(userId).orElseThrow(() -> new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", userId.toString())));
        if (user.getFollows().isEmpty()) {
            throw new NoSellersFollowedException(Messages.USER_WITHOUT_FOLLOWERS);
        }

        if (order == OrderType.NOT_FOUND.getValue()) {
            throw new NotFoundOrderException(Messages.ORDER_NOT_FOUND);
        }

        List<Post> postList = postRepository.getPostsBySellers(user.getFollows());

        Comparator<Post> comparator = getPostOrder(order).getComparator();

        List<PostDto> postDtoList = postList.stream()
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .sorted(comparator)
                .map(post -> PostDto.builder()
                .userId(post.getSeller().getId())
                .id(post.getId())
                .date(post.getDate())
                .product(ProductDto.builder()
                        .productId(post.getProduct().getId())
                        .productName(post.getProduct().getName())
                        .type(post.getProduct().getType())
                        .brand(post.getProduct().getBrand())
                        .color(post.getProduct().getColor())
                        .notes(post.getProduct().getNotes())
                        .build())
                .category(post.getCategory())
                .price(post.getPrice())
                .hasPromo(post.getHasPromo())
                .discount(post.getDiscount())
                .build())
                .toList();

        if(postDtoList.isEmpty())
            throw new NotFoundException(Messages.NOT_FOUNDED_POST);

        return PostFromFollowedDto.builder()
                .userId(user.getId())
                .posts(postDtoList)
                .build();

    }

    private List<PostDto> getPostDtoList(List<Post> posts) {
        return posts.stream().map(post -> PostDto.builder()
                .userId(post.getSeller().getId())
                .date(post.getDate())
                .price(post.getPrice())
                .hasPromo(post.getHasPromo())
                .discount(post.getDiscount())
                .category(post.getCategory())
                .product(ProductDto.builder()
                        .productId(post.getProduct().getId())
                        .productName(post.getProduct().getName())
                        .type(post.getProduct().getType())
                        .brand(post.getProduct().getBrand())
                        .color(post.getProduct().getColor())
                        .notes(post.getProduct().getNotes())
                        .build())
                .build())
                .toList();
    }

    @Override
    public List<PostDto> filterPostsByPrice(Double minPrice, Double maxPrice) {
        List<Post> postsByPrice = minPrice != null && maxPrice != null
                ? postRepository.getPostsByPrice(minPrice, maxPrice)
                : minPrice != null
                ? postRepository.getPostsByMinPrice(minPrice)
                : postRepository.getPostsByMaxPrice(maxPrice);

        if(postsByPrice.isEmpty())
            throw new NotFoundException(Messages.NOT_FOUNDED_POST);

        return getPostDtoList(postsByPrice);
    }

    @Override
    public NumberOfProductsInSaleDto getNumberOfProductsInSaleBySellerId(Integer userId) {
        Optional<Seller> seller = sellerRepository.getById(userId);
        if (seller.isPresent()){
            String name = sellerRepository.getById(userId).get().getName();
            Long count = postRepository.getCountPostInSaleBySellerId(userId);
            return new NumberOfProductsInSaleDto(userId,name,count);
        }
        throw new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", userId.toString()));
    }

    @Override
    public ProductsOfSellerDto getAllProductsInSaleBySellerId(Integer userId) {
        Optional<Seller> seller = sellerRepository.getById(userId);
        if (seller.isEmpty()) {
            throw new NotFoundException(Messages.USER_NOT_FOUND.replace("%s", userId.toString()));
        }

        List<Post> postsInSale = this.postRepository.getPostsInSaleBySellerId(seller.get().getId());

        List<PostDto> postsInSaleDto = getPostDtoList(postsInSale);

        return new ProductsOfSellerDto(
                seller.get().getId(),
                seller.get().getName(),
                postsInSaleDto
        );
    }
}
