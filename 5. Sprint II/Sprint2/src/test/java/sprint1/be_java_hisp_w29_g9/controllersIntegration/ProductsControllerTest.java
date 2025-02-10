package sprint1.be_java_hisp_w29_g9.controllersIntegration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import sprint1.be_java_hisp_w29_g9.dtos.products.responses.PostDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductsFollowedDTO;
import sprint1.be_java_hisp_w29_g9.entities.Post;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.repositories.IUserSellerRepo;
import sprint1.be_java_hisp_w29_g9.repositories.UserSellerRepoImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerTest {

  @Autowired
  private IUserSellerRepo user_seller_repo;

  @Autowired
  private ObjectMapper object_mapper;

  @Autowired
  private MockMvc mockMvc;

  @AfterEach
  void tearDown(){
    user_seller_repo.loadData();
  }
  
  @Test
  void testGetSellerPosts() {

  }

  @Test
  void testNewPromoPublication() throws Exception {

    String postJson = "{"
            + "\"user_id\": 1,"
            + "\"date\": \"2025-02-06\","
            + "\"product\": {"
            + "\"product_id\": 2,"
            + "\"product_name\": \"Silla Gamer\","
            + "\"type\": \"Gamer\","
            + "\"brand\": \"Racer\","
            + "\"color\": \"Red and Black\","
            + "\"notes\": \"Edicion Especial\""
            + "},"
            + "\"category\": 100,"
            + "\"price\": 1500.5,"
            + "\"has_promo\": true,"
            + "\"discount\": 0.25"
            + "}";


    this.mockMvc.perform(post("/products/promo-post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(postJson))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void testNewPromoPublicationMessageNotReadable() throws Exception {
    String postJson = "{a"
      + "\"user_id\": 1,"
      + "\"date\": \"2025-02-06\","
      + "\"product"
      + "\"product_id\": 2,"
      + "\"product_name\": \"Silla Gamer\","
      + "\"type\": \"Gamer\","
      + "\"brandaa\": \"Racer\","
      + "\"color\": \"Red and Black\","
      + "\"notes\": \"Edicion Especial\""
      + "},"
      + "\"category\": 100,"
      + "\"price\": 1500.5,"
      + "\"has_promo\": true,"
      + "\"discount\": 0.25"
      + "}";
    this.mockMvc.perform(post("/products/promo-post")
      .content(postJson).contentType(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isUnprocessableEntity());

      
  }

  @Test
  void testNewPublicationValidRequest() throws Exception {
    String requestBody = """
            {
                "user_id": 1,
                "date": "2021-04-29",
                "product": {
                    "product_id": 1,
                    "product_name": "Silla Gamer",
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red and Black",
                    "notes": "Special Edition"
                },
                "category": 100,
                "price": 1500.50
            }
        """;

    mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void testNewPublicationInvalidRequest() throws Exception {
    String requestBody = """
            {
                "user_id": 1,
                "date": "2021-04-29",
                "product": {
                    "product_id": 1,
                    "product_name": "Silla Gamer",
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red & Black",
                    "notes": "Special Edition"
                },
                "category": 100,
                "price": 1500.50
            }
        """;

    mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
            .andDo(print())
            .andExpect(status().isBadRequest());
  }


  @Test
  void testPromoDiscount() throws Exception {
    mockMvc.perform(get("/products/promo-post/discount")
                    .param("discount", "1.0")
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void testPromoDiscountNotFound() throws Exception {
    mockMvc.perform(get("/products/promo-post/discount")
                    .param("discount", "50.0")
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound());
  }

  @Test
  void testPromoPublicationsCountByUser() throws Exception{
    this.mockMvc
            .perform(get("/products/promo-post/count?user_id={userId}",1))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.promo_products_count").value(2));
  }

  @Test
  void testPromoPublicationsCountByUserNotFound() throws Exception{
    this.mockMvc
            .perform(get("/products/promo-post/count?user_id={userId}",999))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("El Vendedor no fue encontrado."));
  }

  @Test
  void testPublicationsByUserOrdered() throws Exception {
    //Arrange
    Integer user_id = 2;
    AtomicInteger days = new AtomicInteger(0);
    user_seller_repo.getUserFollowedById(user_id).forEach(seller -> {
      seller.getPosts().forEach(post -> {
        post.setDate(LocalDate.now().minusDays(days.getAndIncrement()).toString());
      });
    });
    //Act
    String string_asc = this.mockMvc.perform(get("/products/followed/{userId}/list", user_id)
      .param("order", "date_asc"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn()
      .getResponse()
      .getContentAsString();
    String result_desc = this.mockMvc.perform(get("/products/followed/{userId}/list", user_id)
      .param("order", "date_desc"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn()
      .getResponse()
      .getContentAsString();
    ProductsFollowedDTO data_asc = object_mapper.readValue(string_asc, ProductsFollowedDTO.class);
    ProductsFollowedDTO data_desc = object_mapper.readValue(result_desc, ProductsFollowedDTO.class);
    //Assert
    List<PostDTO> postsAsc = data_asc.getPosts();
    List<PostDTO> postsDesc = data_desc.getPosts();
    assertTrue(postsAsc.size() > 0);
    assertTrue(postsAsc.size() == postsDesc.size());
    Collections.reverse(postsDesc);
    assertEquals(postsAsc, postsDesc);
  }

  void testPromoPublicationsCountByNotPromos() throws Exception{
    this.mockMvc
            .perform(get("/products/promo-post/count?user_id={userId}",2))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("El vendedor no tiene Promociones."));
  }

  @Test
  void testPublicationsByUser() throws Exception {
    mockMvc.perform(get("/products/followed/{userId}/list", 1))
            .andDo(print())
            .andExpect(status().isOk());
    // TODO: mejorar las aserciones
  }

  @Test
  void testPublicationsByUserBadRequest() throws Exception {
    mockMvc.perform(get("/products/followed/{userId}/list", 124521))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("El Usuario no fue encontrado o no sigue a ningun Vendedor."));
  }

  @Test
  void testGetSellerPostsValid() throws Exception {
    mockMvc.perform(get("/products/posts/{seller_id}", 1)
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void testGetSellerPostsInvalid() throws Exception {
    mockMvc.perform(get("/products/posts/{seller_id}", 9999)
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound());
  }
}
