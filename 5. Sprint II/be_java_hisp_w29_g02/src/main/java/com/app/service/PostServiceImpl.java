package com.app.service;

import com.app.dto.request.PostDTO;
import com.app.dto.request.ProductDTO;
import com.app.dto.response.*;
import com.app.exception.BadRequestException;
import com.app.exception.ConflictException;
import com.app.exception.EntityNotFoundException;
import com.app.model.Post;
import com.app.model.Product;
import com.app.model.User;
import com.app.repository.IPostRepository;
import com.app.repository.IUserRepository;
import com.app.util.DateOrder;
import com.app.util.MessageUtil;
import com.app.util.ResponseMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;

    @Override
    public PromoProductsCountDTO searchPromoProductsCountByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userId)));
        if (!isASeller(user)) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_NOT_SELLER.format(userId));
        }
        return new PromoProductsCountDTO(userId, user.getName(), postRepository.findPromoProductsCountByUserId(userId).size());
    }

    private Boolean isASeller(User u) {
        return u.getIsSeller() && u.getPosts() != null;
    }

    @Override
    public PromoPostUserDTO searchListPromoProductsSinceDate(Integer userId, LocalDate since) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_SELLER.format(userId)));

        if (!user.getIsSeller()) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_NOT_SELLER.format(userId));
        }

        List<Post> sellerPostsWithPromo = postRepository.findPostsByUserIdWithPromoSince(userId, since);
        if (sellerPostsWithPromo.isEmpty()) {
            throw new EntityNotFoundException(ResponseMessages.ERROR_POST_NO_PROMO_FOUND_SINCE.format(userId, since));
        }
        List<PostsWithProductDTO> postsWithPromo = sellerPostsWithPromo.stream()
                .map(post -> {
                    Product product = postRepository.findProductById(post.getProductId())
                            .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_PRODUCT_NOT_FOUND.format(post.getProductId())));

                    ProductDTO productDTO = createProductDTO(product);
                    return new PostsWithProductDTO(
                            userId,
                            post.getProductId(),
                            post.getDate(),
                            productDTO,
                            post.getCategory(),
                            post.getPrice(),
                            post.getHasPromo(),
                            post.getDiscount()
                    );
                })
                .toList();

        return new PromoPostUserDTO(userId, user.getName(), postsWithPromo);
    }

    private Product addProduct(ProductDTO productToAdd) {
        Optional<Product> existentProductOpt = postRepository.findProductById(productToAdd.getProduct_id());
        if (existentProductOpt.isPresent()) {
            throw new ConflictException(ResponseMessages.ERROR_PRODUCT_ALREADY_EXISTS.format(productToAdd.getProduct_id()));
        }

        Product product = new Product(productToAdd.getProduct_id(),
                productToAdd.getProduct_name(),
                productToAdd.getType(),
                productToAdd.getBrand(),
                productToAdd.getColor(),
                productToAdd.getNotes());

        return postRepository.saveProduct(product);
    }

    @Override
    public SuccessDTO createPost(PostDTO postDTO) {
        Optional<User> userOpt = userRepository.findById(postDTO.getUser_id());

        if (userOpt.isEmpty()) {
            throw new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(postDTO.getUser_id()));
        }

        User user = userOpt.get();

        if (!user.getIsSeller()) {
            user.setIsSeller(true);
        }

        addProduct(postDTO.getProduct());

        Integer nextId = searchNextId(postRepository.findPostsIds());
        Post post = new Post(
                nextId,
                postDTO.getUser_id(),
                postDTO.getProduct().getProduct_id(),
                postDTO.getCategory(),
                postDTO.getPrice(),
                mapToLocalDate(postDTO.getDate()),
                postDTO.getHas_promo(),
                postDTO.getDiscount());
        Post createdPost = postRepository.savePost(post);

        userRepository.savePostId(createdPost.getId(), user);

        return new SuccessDTO(ResponseMessages.SUCCESS_POST_CREATED.format());
    }

    @Override
    public SuccessDTO addPromoPost(PostDTO postRequest) {
        if (!postRequest.getHas_promo() || postRequest.getDiscount() == 0.0) {
            throw new BadRequestException(ResponseMessages.ERROR_POST_MUST_HAVE_PROMO.format());
        }

        createPost(postRequest);
        return new SuccessDTO(ResponseMessages.SUCCESS_PROMO_POST_CREATED.format());
    }

    @Override
    public PostListDTO searchPostsFromFollowedUsers(int userId, String dateOrder) {
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_USER_NOT_FOUND.format(userId)));

        List<Integer> followedUserIds = userRepository.getFollowedUserIds(userId);
        if (followedUserIds.isEmpty()) {
            throw new EntityNotFoundException(ResponseMessages.ERROR_USER_NO_FOLLOWING.format(userId));
        }

        // Busco los posts de los seguidos
        List<Post> followedPosts = followedUserIds.stream()
                .map(postRepository::findPostsByUserId)
                .flatMap(List::stream)
                .toList();
        if (followedPosts.isEmpty()) {
            throw new BadRequestException(ResponseMessages.ERROR_USER_FOLLOWING_NO_POSTS.format());
        }

        LocalDate fromDate = LocalDate.now().minusWeeks(2);
        List<Post> recentPosts = postRepository.searchMostRecentPostsSortedBy(
                followedPosts,
                getValidatedOrder(dateOrder),
                fromDate
        );

        List<PostDTO> postDTOs = recentPosts.stream()
                .map(this::convertToPostDTO)
                .toList();

        return new PostListDTO(userId, postDTOs);
    }

    private DateOrder getValidatedOrder(String dateOrder) {
        if (!DateOrder.DATE_ASC.getValue().equalsIgnoreCase(dateOrder) &&
                !DateOrder.DATE_DESC.getValue().equalsIgnoreCase(dateOrder)) {
            throw new BadRequestException(ResponseMessages.ERROR_INVALID_DATE_ORDER.format(""));
        }

        return DateOrder.fromValue(dateOrder);
    }

    @Override
    public List<PostDTO> searchAll() {
        Map<Integer, List<Post>> postsStorage = postRepository.findAll();

        return postsStorage.values().stream()
                .flatMap(List::stream)
                .map(this::convertToPostDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> searchAllProducts() {
        List<PostDTO> allPosts = this.searchAll();
        return allPosts.stream()
                .map(PostDTO::getProduct)
                .toList();
    }

    private PostDTO convertToPostDTO(Post post) {
        Product associatedProduct = postRepository.findProductById(post.getProductId())
                .orElseThrow(() -> new EntityNotFoundException(ResponseMessages.ERROR_PRODUCT_NOT_FOUND.format(post.getProductId())));

        ProductDTO productDTO = new ProductDTO(associatedProduct.getId(), associatedProduct.getName(), associatedProduct.getType(),
                associatedProduct.getBrand(), associatedProduct.getColor(), associatedProduct.getNotes());

        return new PostDTO(post.getId(), post.getUserId(), post.getDate().toString(), productDTO,
                post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount());
    }

    private Integer searchNextId(List<Integer> ids) {
        return IntStream.iterate(1, i -> i + 1)
                .filter(id -> !ids.contains(id))
                .findFirst()
                .orElse(1);
    }

    private LocalDate mapToLocalDate(String dateString) {
        String[] splittedDate = dateString.split("-");

        int day = Integer.parseInt(splittedDate[0]);
        int month = Integer.parseInt(splittedDate[1]);
        int year = Integer.parseInt(splittedDate[2]);

        return LocalDate.of(year, month, day);
    }

    private ProductDTO createProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getType(),
                product.getBrand(), product.getColor(), product.getNotes());
    }

}
