package sprint1.be_java_hisp_w29_g9.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.SellerFollowersCountResponseDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.UserFollowedResponseDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.UserFollowersDTO;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.entities.User;
import sprint1.be_java_hisp_w29_g9.exceptions.BadRequestException;
import sprint1.be_java_hisp_w29_g9.exceptions.NotFoundException;
import sprint1.be_java_hisp_w29_g9.repositories.UserSellerImpRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements IUserService {
    private final UserSellerImpRepo user_seller_repo;
    private final ObjectMapper objectMapper;
    private final MessageSource messageSourceBean;

    @Override
    public UserFollowersDTO getFollowersList(Integer sellerId,String order){

        Optional<Seller> seller = user_seller_repo.getSellerById(sellerId);

        List<User> followers = user_seller_repo.getSellerFollowersById(sellerId);

        if(order != null){
            followers = orderUsers(followers,order);
        }
        if (seller.isEmpty()){
            throw new NotFoundException(messageSourceBean.getMessage("seller_not_found", null, null));
        } else if (followers.isEmpty()) {
            throw new NotFoundException(messageSourceBean.getMessage("not_followers", null, null));
        }

        return convertUserToUserFollowersDTO(seller.get(),followers);
    }

    @Override
    public UserFollowedResponseDTO userFollowed(Integer userId, String order){
        Optional<User> user = user_seller_repo.getUserById(userId);
        List<Seller> sellers = user_seller_repo.getUserFollowedById(userId);

        if(user.isEmpty()){
            throw new NotFoundException(messageSourceBean.getMessage("user_not_found", null, null));
        }

        if(sellers.isEmpty()){
            throw new NotFoundException(messageSourceBean.getMessage("not_followed", null, null));
        }

        if(order != null){
            sellers = orderSellers(sellers,order);
        }
        return new UserFollowedResponseDTO(userId, user.get().getUser_id().toString(), sellers);
    }

    @Override
    public void followUser(Integer userId, Integer sellerId) {
        Optional<Seller> seller_t = user_seller_repo.getSellerById(sellerId);
        Optional<User> user_t = user_seller_repo.getUserById(userId);
        if(user_t.isEmpty()){
            throw new BadRequestException(messageSourceBean.getMessage("user_not_found", null, null));
        } else if (seller_t.isEmpty()) {
            throw new BadRequestException(messageSourceBean.getMessage("seller_not_found", null, null));
        } else if (user_seller_repo.getSellerFollowersById(sellerId).stream().anyMatch(user -> user.getUser_id().equals(userId))) {
            throw new BadRequestException(messageSourceBean.getMessage("already_followed", null, null));
        }
        user_seller_repo.addSellerToUser(user_t.get(), seller_t.get());
    }

    private UserFollowersDTO convertUserToUserFollowersDTO(Seller seller,List<User> followers){
        return new UserFollowersDTO(
                seller.getId(),
                seller.getUser_name(),
                followers
        );
    }

    private List<User> orderUsers(List<User> users, String order){
        return switch (order) {
            case "name_asc" -> users
                    .stream()
                    .sorted(Comparator.comparing(User::getFullname))
                    .toList();
            case "name_desc" -> users
                    .stream()
                    .sorted(Comparator.comparing(User::getFullname).reversed())
                    .toList();
            default -> users;
        };
    }

    private List<Seller> orderSellers(List<Seller> sellers, String order){
        return switch (order) {
            case "name_asc" -> sellers
                    .stream()
                    .sorted(Comparator.comparing(Seller::getUser_name))
                    .toList();
            case "name_desc" -> sellers
                    .stream()
                    .sorted(Comparator.comparing(Seller::getUser_name).reversed())
                    .toList();
            default -> sellers;
        };
    }

    @Override
    public SellerFollowersCountResponseDTO numberOfFollowersForSeller(Integer seller_id) {
        Optional<Seller> seller = user_seller_repo.getSellerById(seller_id);
        if(seller.isEmpty()){
            throw new NotFoundException(messageSourceBean.getMessage("seller_not_found", null, null));
        }
        List<User> users = user_seller_repo.getSellerFollowersById(seller_id);
        return new SellerFollowersCountResponseDTO(seller_id, seller.get().getUser_name(), users.size());
    }

    @Override
    public boolean unfollowUser(Integer userId, Integer userIdToUnfollow) {
        Optional<User> user = user_seller_repo.getUserById(userId);
        Optional<Seller> seller = user_seller_repo.getSellerById(userIdToUnfollow);

        if (user.isEmpty()){
            throw new NotFoundException(messageSourceBean.getMessage("user_not_found", null, null));
        } else if (seller.isEmpty()) {
            throw new NotFoundException(messageSourceBean.getMessage("seller_not_found", null, null));
        }
        return user_seller_repo.removeSellerFollower(userId,userIdToUnfollow);
    }
}
