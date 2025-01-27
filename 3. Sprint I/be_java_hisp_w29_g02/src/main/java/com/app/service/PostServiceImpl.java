package com.app.service;

import com.app.dto.request.PostDTO;
import com.app.dto.request.ProductDTO;
import com.app.dto.response.*;
import com.app.exception.*;
import com.app.model.Post;
import com.app.model.Product;
import com.app.model.User;
import com.app.repository.IPostRepository;
import com.app.repository.IUserRepository;
import com.app.util.DateOrder;
import com.app.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;

    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PromoProductsCountDTO searchPromoProductsCountByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userId)));
        if (!isASeller(user)) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.not_seller", userId));
        }
        return new PromoProductsCountDTO(userId, user.getName(), postRepository.findPromoProductsCountByUserId(userId));
    }

    private Boolean isASeller(User u) {
        return u.getIsSeller() && u.getPosts() != null;
    }

    @Override
    public PromoPostUserDTO searchListPromoProductsSinceDate(Integer userId, LocalDate since) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.seller.not_found", userId)));

        if (!user.getIsSeller()) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.not_seller", userId));
        }

        List<Post> sellerPostsWithPromo = postRepository.findPostsByUserIdWithPromoSince(userId, since);
        if (sellerPostsWithPromo.isEmpty()) {
            throw new EntityNotFoundException(MessageUtil.getMessage("error.post.no_promo_found_since", userId, since));
        }
        List<PostsWithProductDTO> postsWithPromo = sellerPostsWithPromo.stream()
                .map(post -> {
                    Product product = postRepository.findProductById(post.getProductId())
                            .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.product.not_found", post.getProductId())));

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

    @Override
    public Product addProduct(ProductDTO productToAdd) {
        Optional<Product> existentProductOpt = postRepository.findProductById(productToAdd.getProduct_id());
        if (existentProductOpt.isPresent()) {
            throw new ConflictException(MessageUtil.getMessage("error.product.already_exists", productToAdd.getProduct_id()));
        }

        return postRepository.saveProduct(
                productToAdd.getProduct_id(),
                productToAdd.getProduct_name(),
                productToAdd.getType(),
                productToAdd.getBrand(),
                productToAdd.getColor(),
                productToAdd.getNotes()
        );
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Optional<User> userOpt = userRepository.findById(postDTO.getUser_id());

        if (userOpt.isEmpty()) {
            throw new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", postDTO.getUser_id()));
        }

        User user = userOpt.get();

        if (user.getIsSeller() == null || !user.getIsSeller()) {
            user.setIsSeller(true);
            user.setPosts(new ArrayList<>());
        }

        Product product = addProduct(postDTO.getProduct());

        Integer nextId = searchNextId(postRepository.findPostsIds());
        postRepository.savePost(
                nextId,
                postDTO.getUser_id(),
                postDTO.getProduct().getProduct_id(),
                postDTO.getCategory(),
                postDTO.getPrice(),
                mapToLocalDate(postDTO.getDate()),
                postDTO.getHas_promo(),
                postDTO.getDiscount()
        );

        userRepository.saveProductId(product.getId(), user);

        return postDTO;
    }

    @Override
    public SuccessDTO addPromoPost(PostDTO postRequest) {
        if (!postRequest.getHas_promo()) {
            throw new BadRequestException(MessageUtil.getMessage("error.post.must_have_promo"));
        }

        createPost(postRequest);

        return new SuccessDTO(MessageUtil.getMessage("success.promo_post_created"));
    }

    @Override
    public PostListDTO searchPostsFromFollowedUsers(int userId, String dateOrder) {
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isEmpty()) {
            throw new EntityNotFoundException(MessageUtil.getMessage("error.user.not_found", userId));
        }

        List<Integer> followedUserIds = userRepository.getFollowedUserIds(userId);

        if (followedUserIds.isEmpty()) {
            throw new EntityNotFoundException(MessageUtil.getMessage("error.user.no_following", userId));
        }

        List<Post> followedPosts = searchUsersPosts(followedUserIds);
        LocalDate fromDate = LocalDate.now().minusWeeks(2);
        List<Post> recentPosts = postRepository.searchMostRecentPostsSortedBy(
                followedPosts,
                DateOrder.fromValue(dateOrder),
                fromDate
        );

        List<PostDTO> postDTOs = recentPosts.stream()
                .map(this::convertToPostDTO)
                .collect(Collectors.toList());

        if (postDTOs.isEmpty()) {
            throw new BadRequestException(MessageUtil.getMessage("error.user.following_no_posts"));
        }

        return new PostListDTO(postDTOs, userId);
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
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.getMessage("error.product.not_found", post.getProductId())));

        ProductDTO associatedProductDTO = createProductDTO(associatedProduct);

        return createPostDTO(post, associatedProductDTO);
    }

    private List<Post> searchUsersPosts(List<Integer> followedUserIds) {
        return followedUserIds.stream()
                .flatMap(followedId ->
                        postRepository.findPostsByUserId(followedId).stream()
                )
                .toList();
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

    private PostDTO createPostDTO(Post post, ProductDTO productDTO) {
        return new PostDTO(post.getId(), post.getUserId(), post.getDate().toString(), productDTO,
                post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount());
    }

    private ProductDTO createProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getType(),
                product.getBrand(), product.getColor(), product.getNotes());
    }

}
