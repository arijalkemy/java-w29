# Sprint 1 - Group 2 - IT Bootcamp wave 29 - Mercado Libre

## Members

- Fabiana Aguero
- Julian Castro
- Martin Mallol
- Angelo Padron
- Daniel Reynaga Rejas
- Eliseo Sanz

## Main functionalities per User Story

### US0001

#### Overview

Follow a specific seller.

#### Main methods

- **User service:**
  - `followUser(int userId, int userIdToFollow)`: Finds the User object by id and adds the seller id 
  provided by parameter into their following list. The main user id is also added into the seller's
  followers list. A `SuccessDTO` is returned if no exception was thrown.
  
  The function can throw 2 types of exceptions: `EntityNotFoundException` and `BadRequestException`.

- **User repository:**
  - `Optional<User> findById(Integer id)`: Finds a user by id. It returns an `Optional<User>` because
  a User with that id can be non-existent.

### US0002

#### Overview

Get the number of followers a seller has.

#### Main methods

- **User service:**
  - `FollowersCountDTO searchFollowersCount(int userId)`: Finds the user by id and then it searches 
  for the amount of followers they have. It propotionates error handling by throwing the corresponding 
  Exceptions, such as: `EntityNotFoundException` _(no user with that id was found)_ and 
  `BadRequestException` _(the user is not a seller)_.
  
  It returns a FollowersCountDTO:
  ```json
  {
    "user_id": 1,
    "user_name": "A Fantastic Seller", 
    "followers_count": 20
  }
  ```

- **User repository:**
  - `Optional<User> findById(Integer id)`.
  - `Integer findFollowersCountById(int userId)`. Returns the amount of followers of a certain user, if 
  possible. If not, it returns 0.

### US0003 & US0008

### Overview

- US0003: Get the seller's followers.
- US0008: Sort them alphabetically (or reversed) by name.

#### Main methods

- **User service:**
  - `FollowerListDTO searchFollowerList(int userId, String order)`: It searches a user's followers list.
  After doing so, it sorts the list by name alphabetically, or reversed (depending on the provided 
  order).
   
  It returns a FollowerListDTO. If the provided user isn't a seller, a `EntityNotFoundException` 
  is thrown. 
  - `List<UserDTO> sortUsers(List<User> users, String order)`: It receives an order and checks if it's 
  valid. The order can only be valid if it's _"name_asc"_ or _"name_desc"_. If it's not, no sorting 
  is applied.
  
  The sorting is done with the repo's `sortUsersByName` method. Afterward, the sorted list is converted
  from a List<User> into a List<UserDTO> and returned.

- **User repository:**
  - `Optional<User> findSellerById(Integer userId)`: If no seller with that id is found, it returns 
  an empty Optional. If it is, then that seller is returned.
  - `List<User> findFollowersUsersList(Integer userId)`: Finds the user by id and returns their 
  followers list.
  - `List<User> sortUsersByName(List<User> users, NameOrder order)`: Sorts the user list received by the
  NameOrder condition. The `NameOrder` value can be `NAME_ASC` or `NAME_DESC`. 

### US0004

### Overview

- US0004: Gets a user's followed sellers.
- US0008: Sort them alphabetically (or reversed) by name.

#### Main methods

- **User service:**
  - `FollowedListDTO searchFollowedList(int userId, String order)`: Same logic as `searchFollowerList`
  but it returns the user's followed list instead of their followers. Checking if the user is a seller
  is not necessary, all users can follow a seller, but only sellers can be followed.

- **User repository:**
  - `List<User> findFollowingUsersList(Integer userId)`: Finds the user by id and returns their
    followed list.

### US0005

### Overview

Creates a new post and a new product.

#### Main methods

- Post service:
  - `PostDTO createPost(PostDTO postDTO)`: It searches for the post's user and checks whether they are a 
  seller or not. If they aren't, now they are (their `isSeller` attribute is set to `true`). The 
  received `PostDTO` product is created and added into the products DB. After that the post object is 
  created and stored into the posts DB. Its id is added to the user's post ids list.
  
  Finally, the `PostDTO` is returned. If no user was found, `EntityNotFoundException` is thrown.
  - `Integer searchNextId(List<Integer> ids)`: It returns the minimum free id number 
    _(the minimum number that is not included in the ids list)_.
  

- **Post repository:**
  - `List<Integer> findPostsIds()`: Gets all stored posts ids.
  - `Post savePost(
            Integer postId,
            Integer userId,
            Integer id,
            Integer category,
            Double price,
            LocalDate localDate,
            Boolean hasPromo,
            Double discount
    );`: Creates the post with the received parameters and stores it into the posts map. If the user
  didn't have any posts before, the list is created. If it did, the post is added to the existent list.

- **User repository:**
  - `Boolean savePostId(Integer posttId, User user)`: Saves post id into the user's post id list. 

### US0006 & US0009

### Overview

- US0006: Gets the post list from a user's followed sellers. All posts have a 2-week maximum age.
- US0009: Orders a post list by date (ascending or descending).

#### Main methods

- **Post service:**
  - `PostListDTO searchPostsFromFollowedUsers(int userId, String dateOrder)`: Returns the user's 
  followed list posts that were published two weeks ago at max. Depending on the dateOrder, this 
  list can be sorted by date ascending or date descending order. Exceptions can be thrown if the 
  user with the userId passed as a parameter does not exist (`EntityNotFoundException`). If the 
  followed users list is empty (`EntityNotFoundException` as well), or if no followed user has
  published a post in the last fourteen days (`BadRequestException`)

- **Post repository:**
  - `List<Post> searchMostRecentPostsSortedBy(List<Post> followedPosts, DateOrder dateOrder, LocalDate fromDate)`:
  It filters the received `Post` by only keeping the posts that are more recent than the 
  received date. Afterward, it sorts the list based on a dateOrder. Its value can be `DATE_ASC` or 
  `DATE_DESC`.

- **User repository:**
  - `Optional<User> findById(Integer id)`.
  - `List<Integer> getFollowedUserIds(int userId)`: Returns a user's followed user ids.

### US0007

### Overview

Unfollows a seller.

#### Main methods

- **User service:**
  - `SuccessDTO deleteFollowedSeller(int userId, int userIdToUnfollow)`: Gets both users by id and 
  deletes the link between them. Meaning that the first user is removed from the second's followers list,
  and the second one is removed from the first's followed list.
  
  The method returns a SuccessDTO on success. Errors are handled with the following exceptions:
  `BadRequestException` _(a user cannot unfollow themselves)_, `EntityNotFoundException` 
  _(user not found, link between both users not found)_ and `ForbiddenException` 
  _(user is not a seller)_.

- **User repository:**
  - `Optional<User> findById(Integer id)`.
  - `Boolean deleteFollowedSeller(int userId, int userIdToUnfollow)`: Gets first user following list 
  and second user followers list. If possible, first user gets removed from the second's followers 
  list, and second user gets removed from the first's following list.

### US0010

### Overview

Publishes a post that has a promo.

#### Main methods

- **Post service:**
  - `SuccessDTO addPromoPost(PostDTO postRequest)`: It creates the new post only if it has a promo.
  If it doesn't a `BadRequestException` is thrown. A `SuccessDTO`is returned if no errors occurred.

### US0011

### Overview

Get the promos of a seller.

#### Main methods

- **Post service:**
  - `PromoProductsCountDTO searchPromoProductsCountByUserId(Integer userId)`: Returns a 
  `PromoProductsCountDTO` that provides the _user id_, _username_ and _promo products count_.

- **Post repository:**
  - `Integer findPromoProductsCountByUserId(Integer userId)`: Filters the user's promo posts from 
  their posts. After that, it counts it and returns the obtained value.

### US0012

### Overview

Gets the list of a seller's promo products since a certain date.

#### Main methods

- **Post service:**
  - `PromoPostUserDTO searchListPromoProductsSinceDate(Integer userId, LocalDate since)`: If the 
  provided user exists and is a seller, it returns a `PromoPostUserDTO` that basically contains
  some of the user data and a `List<PostsWithProductDTO>` for their posts. 

  `EntityNotFoundException` _(user does not exist, does not have promo posts, 
  or no promo since the selected date exist)_, `BadRequestException` _(the user is not a seller)_ 
  can be thrown if there was a problem. 

- **Post repository:**
  - `List<Post> findPostsByUserIdWithPromoSince(Integer userId, LocalDate since)`: Returns the list
  of posts from the user that were published after a certain _"since date"_. If no post was found,
  it returns an empty list.
  - `findProductById`: Returns the corresponding `Product` object.