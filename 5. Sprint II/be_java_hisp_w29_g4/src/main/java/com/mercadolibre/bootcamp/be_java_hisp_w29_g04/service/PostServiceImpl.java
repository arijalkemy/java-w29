package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PromoPostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PostsBySellersFollowedDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PromosByUserCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.BadRequestException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.InvalidOrderException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.InvalidRelationshipException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.NotFoundException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.PostOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository.IPostRepository;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils.IUserValidation;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IUserService userService;
    private final IUserValidation userValidation;

    /** R-005: Crear un nuevo Post de un producto vinculado a un usuario.
     *
     * @param postDto      Información del Post a subir.
     * @validation      Verifica que el usuario sea un vendedor
     * @return          Mensaje de confirmación
     * **/
    @Override
    public MessageDto createPost(PostDto postDto) {
        User user = userService.findById(postDto.getUserId());
        if (!userValidation.isSeller(user)) throw new BadRequestException("The user is not a seller.");
        postRepository.save(dtoToPost(postDto));
        return new MessageDto("The post was created successfully");
    }

    @Override
    public MessageDto createPromoPost(PromoPostDto promoPostDto) {
        User user = userService.findById(promoPostDto.getUserId());
        if(!userValidation.isSeller(user)) throw new BadRequestException("The user who wants to create the post is not a seller");
        postRepository.save(dtoToPost(promoPostDto));
        return new MessageDto("The post was created successfully");
    }

    @Override
    public PromosByUserCountDto getPromoCount(Integer userId) {
        User user = userService.findById(userId);
        if (!userValidation.isSeller(user)) throw new InvalidRelationshipException("Only sellers identifiers are allowed");
        return new PromosByUserCountDto(userId, user.getUsername(), getPromoPostsBySellerId(userId).size());
    }

    /** R-005: Obtener publicaciones ordenadas de vendedores seguidos por un usuario.
     *
     * @param userId     Usuario que verá las publicaciones.
     * @param order      Orden que debe mantener la lista (fecha de subida)
     * @validation       Verifica que el usuario sea un vendedor
     * @return           Muestra el cuerpo del Post como Dto.
     * **/

    @Override
    public PostsBySellersFollowedDto getPostsOfFollowedSeller(Integer userId, PostOrderTypeEnum order) {
        User user = userService.findById(userId);
        if (!userValidation.isCommonUser(user)) throw new BadRequestException("Only users can get sellers posts.");

        List<Integer> following = user.getFollow();
        if (following.isEmpty()) throw new NotFoundException("This user do not follow any seller.");
        return new PostsBySellersFollowedDto(
                userId,
                getLastWeeksPosts(following, order)
        );
    }

    @Override
    public PostOrderTypeEnum getPostOrderType(String order) {
        if (!order.equalsIgnoreCase(PostOrderTypeEnum.UNORDERED.name()) && Arrays.stream(PostOrderTypeEnum.values()).noneMatch(v -> v.name().equalsIgnoreCase(order))) throw new InvalidOrderException("Invalid order.");
        return PostOrderTypeEnum.valueOf(order.toUpperCase());
    }

    private List<PostDto> getLastWeeksPosts(List<Integer> sellersId, PostOrderTypeEnum order) {
        return sellersId.stream()
                .flatMap(id -> postRepository.getUserPosts(id).stream())
                .filter(p -> twoWeeksFilter(p.getCreatedAt()))
                .sorted(order.getComparator())
                .map(this::postToDto)
                .toList();
    }

    private boolean twoWeeksFilter(LocalDate createdAt) {
        return createdAt.isAfter(LocalDate.now().minusWeeks(2).minusDays(1));
    }

    @Override
    public List<PostDto> getUserPosts(Integer userId) {
        List<Post> optionalPost = postRepository.getUserPosts(userId);

        if (optionalPost.isEmpty())
            throw new NotFoundException("No entity with the given id");

        return optionalPost.stream().map(this::postToDto).collect(Collectors.toList());
    }

    @Override
    public List<PromoPostDto> getPromoPostsBySellerId(Integer seller_id) {
        if (!userValidation.isSeller(userService.findById(seller_id))) throw new BadRequestException("Only sellers have posts!");

        List<Post> promoPosts = postRepository.getPromoPostsBySellerId(seller_id);
        if (promoPosts.isEmpty()) throw new NotFoundException("Seller doesn't have any promo");

        return promoPosts
                .stream()
                .map(this::postToPromoDto)
                .toList();
    }

    // #------------------ CRUD METHODS ------------------#
    @Override
    public List<PostDto> findAll() {
        return postRepository
                .findAll()
                .stream()
                .map(this::postToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Integer postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isEmpty())
            throw new NotFoundException("Post not found");

        return postToDto(optionalPost.get());
    }

    @Override
    public PostDto save(PostDto postDto) {
        Optional<Post> optionalPost = postRepository.save(dtoToPost(postDto));
        if (optionalPost.isEmpty()) throw new BadRequestException("Coudn't save the post");
        return postToDto(optionalPost.get());
    }


    @Override
    public MessageDto delete(Integer id) {
        if (id == null || !postRepository.delete(id)) throw new NotFoundException("Entity delete failed");
        return new MessageDto("Post deleted successfully");
    }

    @Override
    public PostDto update(PostDto postDto) {
        Optional<Post> updatedPost = postRepository
                .update(dtoToPost(postDto));
        if (updatedPost.isEmpty()) throw new BadRequestException("Post update failed");
        return postToDto(updatedPost.get());
    }

    // #------------------ MAPPING METHODS ------------------#

    private Post dtoToPost (PostDto postDto) {
        return PostMapper.dtoToPost(postDto);
    }

    private Post dtoToPost (PromoPostDto postDto) {
        return PostMapper.dtoToPost(postDto);
    }

    private PostDto postToDto (Post post) {
        return PostMapper.postToDto(post);
    }

    private PromoPostDto postToPromoDto (Post post) {
        return PostMapper.postToPromoDto(post);
    }
}
