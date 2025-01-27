package sprint1.be_java_hisp_w29_g9.repositories;

import java.util.List;
import java.util.Optional;

import sprint1.be_java_hisp_w29_g9.entities.Post;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.entities.User;

public interface IUserSellerRepo {
  Boolean addSellerToUser(User user, Seller seller);
  List<User> getSellerFollowersById(Integer sellerId);
  List<Seller> getUserFollowedById(Integer userId);
  Boolean addSellerPost(Seller seller, Post post);
  Boolean removeSellerFollower(Integer userId, Integer sellerId);
  Optional<Seller> getSellerById(Integer sellerId);
  Optional<User> getUserById(Integer userId);
  List<Seller> getAllSellers();
}
