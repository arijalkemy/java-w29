package sprint1.be_java_hisp_w29_g9.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import sprint1.be_java_hisp_w29_g9.entities.Post;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.entities.User;

@Repository
public class UserSellerImpRepo implements IUserSellerRepo {
  private List<Map<User, Seller>> userSellerList = new ArrayList<>();

  public UserSellerImpRepo() throws IOException {
    InputStream inputData = IUserSellerRepo.class.getClassLoader().getResourceAsStream("data.json");
    ObjectMapper mapper = new ObjectMapper();
    Map<String, List<?>> data = mapper.readValue(inputData, new TypeReference<Map<String, List<?>>>(){});
    List<User> userList = mapper.convertValue(data.get("users"), new TypeReference<List<User>>(){});
    List<Seller> sellerList = mapper.convertValue(data.get("sellers"), new TypeReference<List<Seller>>(){});
    this.addSellerToUser(userList.get(0), sellerList.get(0));
    this.addSellerToUser(userList.get(1), sellerList.get(0));
    this.addSellerToUser(userList.get(1), sellerList.get(1));
  }

  @Override
  public Boolean addSellerToUser(User user, Seller seller) {
      HashMap<User, Seller> newUserSellerMap = new HashMap<>();
      newUserSellerMap.put(user, seller);
      return userSellerList.add(newUserSellerMap);
  }

  @Override
  public List<User> getSellerFollowersById(Integer sellerId) {
    return userSellerList.stream()
            .flatMap(map -> map.entrySet().stream())
            .filter(entry -> entry.getValue().getId().equals(sellerId))
            .map(Map.Entry::getKey)
            .toList();
  }

  @Override
  public List<Seller> getUserFollowedById(Integer userId) {
    return userSellerList.stream()
      .flatMap(map -> map.entrySet().stream())
      .filter(entry -> entry.getKey().getUser_id().equals(userId))
      .map(Map.Entry::getValue)
      .toList();
  }

  @Override
  public Boolean addSellerPost(Seller seller, Post post) {
    return seller.getPosts().add(post);
  }

  @Override
  public Boolean removeSellerFollower(Integer userId, Integer sellerId) {
    return userSellerList.removeIf(userSellerMap ->
            userSellerMap.entrySet().stream().anyMatch(userSellerEntry ->
                    userSellerEntry.getValue().getId().equals(sellerId) &&
                            userSellerEntry.getKey().getUser_id().equals(userId)));
//    Optional<Map<User, Seller>> userSellerMap = userSellerList.stream()
//            .flatMap(map -> map.entrySet().stream())
//            .filter(entry-> entry.getValue().getId().equals(sellerId) &&
//                           entry.getKey().getUser_id().equals(userId))
//            .findFirst();

  }

  @Override
  public Optional<Seller> getSellerById(Integer sellerId) {
    return userSellerList.stream()
      .flatMap(map -> map.values().stream())
      .filter(seller -> seller.getId().equals(sellerId))
      .findFirst();
  }

  @Override
  public Optional<User> getUserById(Integer userId) {
    return userSellerList.stream()
      .flatMap(map -> map.keySet().stream())
      .filter(user -> user.getUser_id().equals(userId))
      .findFirst();
  }

  @Override
  public List<Seller> getAllSellers() {
    return userSellerList.stream()
            .flatMap(map -> map.values().stream())
            .distinct().toList();
  }

}
