package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowingDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.BadRequestException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.DuplicateFoundException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.InvalidRelationshipException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.NotFoundException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.UserOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository.IUserRepository;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils.IUserValidation;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IUserValidation userValidation;
    /** R-001: Un usuario sigue a un vendedor
     * @param userId:         Id del usuario
     * @param sellerId: Id del vendedor
     * @return Mensaje, no se solicita cuerpo.
     */
    @Override
    public MessageDto followSeller (Integer userId, Integer sellerId) {
        User commonUser = findById(userId);
        User seller = findById(sellerId);
        if (!userValidation.isCommonUser(commonUser)) throw new InvalidRelationshipException("Invalid user id");
        if (!userValidation.isSeller(seller)) throw new InvalidRelationshipException("Invalid seller id");
        if (checkFollow(findById(userId), seller)) throw new BadRequestException("Follow already exists");

        return follow(userId, sellerId);
    }

    public boolean checkFollow(User follower, User followed) {
        return verifyFollow(follower, followed.getUserId()) && verifyFollow(followed, follower.getUserId());
    }

    private boolean verifyFollow(User user, Integer idFollower) {
        return user
                .getFollow()
                .stream()
                .anyMatch(id -> id.equals(idFollower));
    }

    @Override
    public MessageDto unfollowSeller (Integer userId, Integer sellerId) {
        User commonUser = findById(userId);
        User seller = findById(sellerId);
        if (!userValidation.isCommonUser(commonUser)) throw new InvalidRelationshipException("Invalid user id");
        if (!userValidation.isSeller(seller)) throw new InvalidRelationshipException("Invalid seller id");
        if (!checkFollow(commonUser, seller)) throw new BadRequestException("Follow does not exist");

        return unfollow(userId, sellerId);
    }

    private MessageDto createMessage(String message) {
        return new MessageDto(message);
    }

    /** R-002: Obtener cantidad de usuarios que siguen a un vendedor
     * **/
    public FollowersCountDto getFollowersCount(Integer userId) {
        User seller = findById(userId);

        if(!userValidation.isSeller(seller)) throw new InvalidRelationshipException("Only sellers have followers");

        List<User> followers = userRepository.getListOfFollows(userId, UserOrderTypeEnum.UNORDERED)
                .orElseThrow(() -> new NotFoundException("Followers not found for the given seller"));
        if (followers.isEmpty()) {
            throw new NotFoundException("No followers for the given user");
        }
        return new FollowersCountDto(seller.getUserId(), seller.getUsername(), followers.size());
    }

    /** R-003: Obtener los usuarios que siguen a un vendedor.
     *
     * @param userId    Id del usuario a buscar
     * @param orderType Tipo de orden a aplicar (opcional)
     * @validation Verifica que el usuario exista y que sea de tipo vendedor
     * @return Lista de usuarios que siguen al usuario
     * **/
    @Override
    public FollowersDto getUsersBySeller(Integer userId, String orderType) {
        UserOrderTypeEnum orderTypeEnum = isOrderTypeValid(orderType);
        User seller = findById(userId);
        if (!userValidation.isSeller(seller)) throw new InvalidRelationshipException("Only sellers have followers");

        List<Integer> followers = seller.getFollow();
        if (followers.isEmpty()) throw new NotFoundException("No followers for the given user");
        return new FollowersDto(
                seller.getUserId(),
                seller.getUsername(),
                getFollowUsers(followers, orderTypeEnum)
        );
    }

    /** R-004: Obtener los vendedores seguidos por un usuario.
     *
     * @param userId        Id del usuario a buscar
     * @param orderType     Tipo de orden a aplicar
     * @validation          Verifica que el usuario exista y que sea de tipo vendedor
     * @return              Lista de vendedores (FollowingDto) que sigue el usuario
     * **/
    @Override
    public FollowingDto getSellersByUser(Integer userId, String orderType) {
        UserOrderTypeEnum orderTypeEnum = isOrderTypeValid(orderType);
        User follower = findById(userId);
        if (!userValidation.isCommonUser(follower)) throw new InvalidRelationshipException("Only users can follow");

        List<Integer> following = follower.getFollow();
        if (following.isEmpty()) throw new NotFoundException("No sellers for the given user");
        return new FollowingDto(
                follower.getUserId(),
                follower.getUsername(),
                getFollowUsers(following, orderTypeEnum)
        );
    }

    private List<UserDto> getFollowUsers(List<Integer> followIds, UserOrderTypeEnum orderType) {
        return followIds
                .stream()
                .map(this::findById)
                .sorted(orderType.getComparator())
                .map(this::userToDto)
                .toList();
    }

    private UserDto userToDto(User user) {
        return UserMapper.userToDto(user);
    }

    private User dtoToUser(UserDto userDto) {
        return UserMapper.dtoToUser(userDto);
    }

    @Override
    public MessageDto follow(Integer userId, Integer sellerId) {
        User user = findById(userId);
        User seller = findById(sellerId);
        user.addFollow(sellerId);
        seller.addFollow(userId);
        update(userToDto(user));
        update(userToDto(seller));
        return createMessage("Followed seller successfully");
    }


    @Override
    public MessageDto unfollow(Integer userId, Integer sellerId) {
        User user = findById(userId);
        User seller = findById(sellerId);
        user.removeFollow(sellerId);
        seller.removeFollow(userId);
        update(userToDto(user));
        update(userToDto(seller));
        return createMessage("Unfollowed seller successfully");
    }

    // #------------------ CRUD METHODS ------------------#


    @Override
    public User findById(Integer userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existing user with the provided id")) ;
    }

    @Override
    public UserDto save(UserDto user) {
        if(userRepository.findById(user.getUserId()).isPresent()) {
            throw new DuplicateFoundException("User already exists");
        }

        return userToDto(userRepository.save(dtoToUser(user))
                .orElseThrow(() -> new BadRequestException("User save failed")));
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = findById(userDto.getUserId());

        user.setUsername(userDto.getUserName());

        return userToDto(userRepository.update(user)
                .orElseThrow(() -> new BadRequestException("User update failed")));
    }


    @Override
    public UserDto findDtoById(Integer id) {
        return userToDto(findById(id));
    }

    @Override
    public boolean delete(Integer userId) {
        if(!userRepository.delete(userId)) throw new BadRequestException("User delete failed");
        return true;
    }


    @Override
    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserOrderTypeEnum isOrderTypeValid(String orderType) {
        try{
            return UserOrderTypeEnum.valueOf(orderType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid order type");
        }
    }
}