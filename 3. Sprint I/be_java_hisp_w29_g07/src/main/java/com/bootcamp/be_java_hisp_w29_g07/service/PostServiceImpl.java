package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.request.PromoPostDTOIn;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g07.Enum.UserType;
import com.bootcamp.be_java_hisp_w29_g07.constants.Messages;
import com.bootcamp.be_java_hisp_w29_g07.entity.Post;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g07.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g07.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w29_g07.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w29_g07.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class provides the business logic for managing posts, including adding new posts,
 * retrieving posts, handling promotional posts, and sorting posts. It interacts with the
 * repositories and services to handle data operations and ensure the rules of the application
 * are enforced.
 */
@Service
public class PostServiceImpl implements IPostService {

    /**
     * The Post repository for managing post-related operations.
     */
    private final IPostRepository postRepository;
    /**
     * The User repository for managing user-related operations.
     */
    private final IUserRepository userRepository;
    /**
     * The Follow repository for managing follow-related operations.
     */
    private final IFollowService followService;
    /**
     * The Mapper for converting between DTOs and entities.
     */
    private final ObjectMapper mapper;
    /**
     * The User service for retrieving and validating user information.
     */
    private final IUserService userService;

    /**
     * Initializes the required repositories and services, as well as configures
     * the {@link ObjectMapper} to handle date and time serialization.
     *
     * @param postRepository   the post repository
     * @param userRepository   the user repository
     * @param followRepository the follow repository
     * @param userService      the user service
     */
    public PostServiceImpl(
            IPostRepository postRepository,
            IUserRepository userRepository,
            IFollowService followService,
            IUserService userService
    ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.followService = followService;
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.findAndRegisterModules();
        this.userService = userService;
    }

    /**
     * Validates the post details and ensures the user creating the post is a seller.
     * Throws exceptions if the post contains invalid promotional details or if the user
     * does not have the correct permissions.
     *
     * @param post the post DTO containing post details
     * @return the {@link PostSaveDTO} containing a success message and the saved post
     */
    @Override
    public PostSaveDTO addPost(PostDTO post) {
        User user = userService.findUserById(post.getUser_id());
        if(user.getUserType().equals(UserType.USER)){
            throw new BadRequestException(Messages.USER_NOT_SELLER_MSG);
        }
        if(Objects.isNull(post.getHas_promo()) || post.getHas_promo()  ){
            throw new BadRequestException(Messages.POST_CANNOT_HAVE_PROMOTION);
        }
        if(Objects.isNull(post.getDiscount()) || post.getDiscount() > 0.0){
            throw new BadRequestException(Messages.POST_CANNOT_HAVE_DISCOUNT);
        }
        Post postCreated = mapper.convertValue(post, Post.class);
        postRepository.savePost(postCreated);
        return new PostSaveDTO(Messages.POST_CREATED_SUCCESSFULLY,
                mapper.convertValue(postCreated, PostDTO.class));
    }

    /**
     * Finds a post by its ID.
     *
     * @param id the ID of the post
     * @return an Optional containing the {@link PostDTO} if found, or empty if not found
     */
    @Override
    public PostDTO findPostById(Integer id) {
        Optional<Post> post = postRepository.findPostById(id);
        if (post.isEmpty()) {
            throw new NotFoundException(Messages.NO_POST_FOUND);
        }
        return mapper.convertValue(post.get(), PostDTO.class);
    }

    /**
     * Retrieves all posts.
     *
     * @return a list of PostDTO objects representing all posts
     */
    @Override
    public List<PostDTO> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(p -> mapper.convertValue(p, PostDTO.class))
                .toList();
    }

    /**
     * Retrieves the list of posts from users followed by a specific user.
     * Filters posts created in the last two weeks and applies sorting based on the provided order.
     *
     * @param userId the ID of the user
     * @param order  the sorting order (e.g., "date_asc" or "date_desc")
     * @return a {@link ListPostDTO} containing the user ID and the list of posts
     * @throws NotFoundException if the user follows no one or if no posts are found
     */
    @Override
    public ListPostDTO findListUsersFollowedPostsByUserId(Integer userId, String order) {

        userService.verifyUserExists(userId);

        List<Integer> userFollowing = followService.findFollowedByUserId(userId);
        if (userFollowing.isEmpty()) {
            throw new NotFoundException(String.format(Messages.USER_HAS_NOT_FOLLOWED_MSG, userId));
        }

        List<Post> posts = postRepository.findPostsByUserIdsAndLastTwoWeeks(userFollowing);
        if (posts.isEmpty()) {
            throw new NotFoundException(String.format(Messages.USER_HAS_NOT_POSTS_MSG, userId));
        }

        List<Post> orderedPosts = this.applySorting(posts, order);
        List<PostDTO> postDTOS = orderedPosts.stream().map(post -> mapper.convertValue(post, PostDTO.class)).toList();
        return new ListPostDTO(userId, postDTOS);
    }

    /**
     * Applies sorting to a list of posts based on the provided order.
     *
     * @param posts the list of posts to be sorted
     * @param order the sorting order (e.g., "date_asc" or "date_desc")
     * @return the sorted list of posts
     */
    private List<Post> applySorting(List<Post> posts, String order) {
        if (Objects.isNull(order)){
            order = "date_desc";
        }

        return switch (order.toLowerCase()) {
            case "date_asc" -> posts.stream()
                    .sorted(Comparator.comparing(Post::getDate))
                    .toList();
            case "date_desc" -> posts.stream()
                    .sorted(Comparator.comparing(Post::getDate).reversed())
                    .toList();
            default -> posts;
        };
    }

    /**
     * Finds the count of promotional posts created by a specific user.
     *
     * @param userId the user ID
     * @return a {@link PromoCountPostDTO} containing the user ID, username, and promotional post count
     * @throws NotFoundException if the user or posts are not found
     * @throws BadRequestException if the user is not a seller
     */

    @Override
    public PromoCountPostDTO findPromoPostCountByUserId(Integer userId) {
        User user = userService.findUserById(userId);
        long count = postRepository.findPromoPostCountByUserId(userId);

        if(user.getUserType().equals(UserType.USER)){
            throw new BadRequestException(Messages.USER_NOT_SELLER_MSG);
        }

        if (count == 0) {
            throw new NotFoundException(String.format(Messages.NO_POST_FOUND, userId));
        }
        return new PromoCountPostDTO(user.getId(), user.getUsername(), (int) count);
    }

    /**
     * Creates a promotional post.
     * Validates the input data and ensures the user is authorized to create promotional posts.
     *
     * @param promoPostDTOIn the DTO containing the promotional post details
     * @return the {@link PromoPostDTOOut} containing the details of the created promotional post
     * @throws BadRequestException if the input data is invalid
     */

    @Override
    public PromoPostDTOOut createPromoPost(PromoPostDTOIn promoPostDTOIn) {
        User user = userService.findUserById(promoPostDTOIn.getUser_id());
        if(user.getUserType().equals(UserType.USER)){
            throw new BadRequestException(Messages.USER_NOT_SELLER_MSG);
        }
        if (!promoPostDTOIn.getHas_promo()) {
            throw new BadRequestException(Messages.POST_HAS_NO_PROMOTION);
        }
        if (Objects.isNull(promoPostDTOIn.getDiscount()) || promoPostDTOIn.getDiscount() <= 0) {
            throw new BadRequestException(Messages.POST_HAS_NO_DISCOUNT);
        }

        Post postCreated = postRepository.savePost(mapper.convertValue(promoPostDTOIn, Post.class));
        return mapper.convertValue(postCreated, PromoPostDTOOut.class);
    }


    /**
     * Retrieves a posts list by seller id
     *
     * @param sellerId the seller id
     * @return a {@link ListPostDTO} containing the seller ID and posts list
     * @throws NotFoundException if the user is not found
     * @throws BadRequestException if the user is not a seller
     */
    @Override
    public ListPostDTO findAllPostBySellerId(Integer sellerId){
        User sellerFound = userService.findUserById(sellerId);
        if(sellerFound.getUserType().equals(UserType.USER)){
            throw new BadRequestException(Messages.USER_NOT_SELLER_MSG);
        }

        ListPostDTO listPostDTO = new ListPostDTO();
        listPostDTO.setUser_id(sellerFound.getId());
        listPostDTO.setPosts(postRepository.findAllPostsByUserId(sellerFound.getId())
                .stream().map(p -> mapper.convertValue(p, PostDTO.class)).toList());
        return listPostDTO;
    }
}
