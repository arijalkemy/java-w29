package sprint1.be_java_hisp_w29_g9.services;

import sprint1.be_java_hisp_w29_g9.dtos.users.response.SellerFollowersCountResponseDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.UserFollowedResponseDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.UserFollowersDTO;

public interface IUserService {
    public UserFollowersDTO getFollowersList(Integer sellerId,String order);
    public UserFollowedResponseDTO userFollowed (Integer userId, String order);
    public void followUser(Integer userId, Integer sellerId);
    public SellerFollowersCountResponseDTO numberOfFollowersForSeller(Integer userId);
    boolean unfollowUser(Integer userId, Integer userIdToUnfollow);
}