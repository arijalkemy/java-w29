package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.integration;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.Seller;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    /*Mati */
    private static final List<String> ORDER_PARAM = List.of("name_asc", "name_desc", "unordered");
    private static List<String> getOrderParams() {
        return ORDER_PARAM;
    }

    /* Pablo */
    @Test
    @DisplayName("Follow Seller - OK")
    void followSellerOkTest() throws Exception{
        //Arrange
        int commonId = 5;
        int sellerId = 1;

        //Act and Assertions
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",commonId,sellerId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Followed seller successfully"));
    }

    @Test
    @DisplayName("Follow Seller - Invalid User Id")
    void followSellerInvalidUserTest() throws Exception{
        //Arrange
        int invalidCommonId = 999;
        int sellerId = 1;

        //Act and Assertions
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",invalidCommonId,sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existing user with the provided id"));

    }

    @Test
    @DisplayName("Follow Seller - Invalid Seller ID")
    void followSeller_InvalidSellerId() throws Exception {
        // Arrange
        int commonId = 4;
        int invalidSellerId = 999;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", commonId, invalidSellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existing user with the provided id"));

    }

    @Test
    @DisplayName("Follow Seller - Follow Already Exists")
    void followSeller_AlreadyExists() throws Exception {
        // Arrange
        int commonId = 6;
        int sellerId = 1;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", commonId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Follow already exists"));

    }

    @Test
    @DisplayName("Follow Seller - Invalid Relationship Not Common User")
    void followSeller_NotCommonUser() throws Exception {
        // Arrange
        int notCommonUserId = 1;
        int sellerId = 2;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", notCommonUserId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid user id"));

    }

    @Test
    @DisplayName("Follow Seller - Invalid Relationship Not Seller User")
    void followSeller_NotSellerUser() throws Exception {
        // Arrange
        int commonId = 4;
        int notSellerUserId = 5;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", commonId, notSellerUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid seller id"));

    }

    /* US-003 Tai */

    @Test
    @DisplayName("Unfollow seller: successful")
    void unfollowSeller_updatedSuccesfully_test() throws Exception {
        Integer USER_RELATED_ID = 4;
        Integer SELLER_ID = 1;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", USER_RELATED_ID, SELLER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Unfollowed seller successfully"));
    }

    @Test
    @DisplayName("Unfollow seller: invalid relation (not following)")
    void unfollowSeller_invalidRelation_throwsMessageDTO() throws Exception {
        Integer SELLER_ID = 1;
        Integer USER_ID = 4;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", USER_ID, SELLER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Follow does not exist"));
    }

    @Test
    @DisplayName("Unfollow seller: invalid user id")
    void unfollowSeller_invalidUserId_throwsMessageDTO() throws Exception {
        Integer SELLER_ID = 1;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 100 , SELLER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existing user with the provided id"));
    }

    /*US0002 Nico */

    @Test
    @DisplayName("getFollowersCount happy path")
    public void test_getFollowersCount_ok () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("techStore"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2))
        ;
    }

    @Test
    @DisplayName("getFollowersCount InvalidRelationshipException")
    public void test_getFollowersCount_InvalidRelationshipException () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Only sellers have followers"));
    }

    @Test
    @DisplayName("getFollowersCount BadRequest")
    public void test_getFollowersCount_BadRequest () throws Exception {
        Seller sellerTest = new Seller("nicoStore");
        userRepository.save(sellerTest);
        sellerTest.setFollow(Arrays.asList());
        userRepository.update(sellerTest);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",sellerTest.getUserId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No followers for the given user"));
    }

    /*US0006 Nico */
    @Test
    @DisplayName("getPostsOfFollowedSelle happy path")
    public void test_getPostsOfFollowedSeller_ok() throws Exception {
        DateTimeFormatter europeanFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = LocalDate.now().format(europeanFormatter);

        String expectedJson = String.format("""
        {
            "user_id": 4,
            "posts": [
                {
                    "product": {
                        "product_id": 1,
                        "product_name": "MacBook Pro",
                        "type": "Electronics",
                        "brand": "Apple",
                        "color": "Space Gray",
                        "notes": "Latest model"
                    },
                    "category": 100,
                    "price": 1104.9915,
                    "user_id": 1,
                    "date": "%s"
                }
            ]
        }
        """, formattedDate);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }

    @Test
    @DisplayName("getPostsOfFollowedSeller BadRequest")
    public void test_getPostsOfFollowedSeller_BadRequest () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Only users can get sellers posts."));
    }

    @Test
    @DisplayName("getPostsOfFollowedSeller NotFoundException")
    public void test_getPostsOfFollowedSeller_NotFoundException () throws Exception {
        CommonUser commonUser = new CommonUser("Nico");
        userRepository.save(commonUser);
        commonUser.setFollow(Arrays.asList());
        userRepository.update(commonUser);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",commonUser.getUserId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("This user do not follow any seller."));
    }

    /**
     * Test de Integración US-0004 y US-0008 Happy Path
     * Verifica que el endpoint de obtención de seguidores funcione correctamente.
     * Se espera una respuesta exitosa con código HTTP 200
     * y que el contenido sea de tipo JSON.
     */
    @DisplayName("Validamos US 0004 y 0008, debe retornar 200 y con cada tipo de ordenamiento")
    @ParameterizedTest
    @MethodSource("getOrderParams")
    public void test_findFollowersByUser_Ok(String orderParam) throws Exception{
        //Arrange
        int userId = 4;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)  // Pasa el PathVariable userId
                        .param("order", orderParam))
                .andDo(print())// Agrega el RequestParam "order"
                .andExpect(status().isOk())  // Verifica que la respuesta sea 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));  // Verifica que el contenido sea JSON

    }


    /**
     * Test de Integración US-0003 y US-0008 Happy Path
     * Verifica que el endpoint de obtención de seguidos funcione correctamente.
     * Se espera una respuesta exitosa con código HTTP 200
     * y que el contenido sea de tipo JSON.
     * @throws Exception Si ocurre algún error durante la ejecución del test.
     */
    @DisplayName("Validamos US 0003 y 0008, debe retornar 200 y con cada tipo de ordenamiento")
    @ParameterizedTest
    @MethodSource("getOrderParams")
    public void test_findFollowingsByUser_Ok(String orderParam) throws Exception{
        //Arrange
        int userId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)  // Pasa el PathVariable userId
                        .param("order", orderParam))
                .andDo(print())// Agrega el RequestParam "order"
                .andExpect(status().isOk())  // Verifica que la respuesta sea 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));  // Verifica que el contenido sea JSON
    }

    @Test
    public void test_findFollowingsByUser_NoOk() throws Exception{
        //Arrange
        int userId = 1;
        String orderParam = "test";
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)  // Pasa el PathVariable userId
                        .param("order", orderParam))
                .andDo(print())// Agrega el RequestParam "order"
                .andExpect(status().isBadRequest())  // Verifica que la respuesta sea bad request
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));  // Verifica que el contenido sea JSON
    }

    // #------------------ CRUD CONTROLLERS ------------------#

    @Test
    @DisplayName("BONUS: Create user - successful")
    void createUser_success() throws Exception {
        String requestJson = "{\n" +
                "    \"user_id\": 15,\n" +
                "    \"user_name\": \"newUser\"\n }";
        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.user_id").value(15))
                .andExpect(jsonPath("$.user_name").value("newUser"));
    }

    @Test
    @DisplayName("BONUS: Get user - successful")
    void getUser_success() throws Exception {
        int userId = 1;
        mockMvc.perform(get("/users/{userId}", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value("techStore"));
    }

    @Test
    @DisplayName("BONUS: Update user - successful")
    void updateUser_success() throws Exception {
        User user = new CommonUser("userToUpdate");
        user.setUserId(16);
        userRepository.save(user);
        String requestJson = "{\n" +
                "    \"user_id\": 15,\n" +
                "    \"user_name\": \"updatedUser\"\n}";
        mockMvc.perform(MockMvcRequestBuilders.put("/users/{userId}", 16)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_name").value("updatedUser"));
    }

    @Test
    @DisplayName("BONUS: Delete user - successful")
    void deleteUser_success() throws Exception {
        User user = new CommonUser("userToDelete");
        user.setUserId(15);
        userRepository.save(user);
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{userId}", 15))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("User deleted successfully"));
    }
}