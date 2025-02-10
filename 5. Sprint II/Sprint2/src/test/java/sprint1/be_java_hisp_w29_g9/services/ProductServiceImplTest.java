package sprint1.be_java_hisp_w29_g9.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.PostDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductsFollowedDTO;
import sprint1.be_java_hisp_w29_g9.entities.Post;
import sprint1.be_java_hisp_w29_g9.entities.Product;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.exceptions.BadRequestException;

import sprint1.be_java_hisp_w29_g9.exceptions.NotFoundException;
import sprint1.be_java_hisp_w29_g9.repositories.UserSellerRepoImp;
import sprint1.be_java_hisp_w29_g9.utils.TestUtilsGenerator;


import sprint1.be_java_hisp_w29_g9.repositories.UserRepoImp;
import sprint1.be_java_hisp_w29_g9.repositories.UserSellerRepoImp;
import sprint1.be_java_hisp_w29_g9.utils.TestUtilsGenerator;

import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    UserSellerRepoImp userSellerRepoImp;

    @Mock
    MessageSource messageSourceBean;

    @InjectMocks
    ProductServiceImp productServiceImp;

    @Test
    public void getPostsFollowedByDateTestAsc(){
        //Arrange
        Integer userIdParam = 1;
        String orderParam = "date_asc";

        List<Seller> sellerResponse = new ArrayList<>(List.of(
                new Seller(1, TestUtilsGenerator.createPostsWithDecreasingDates(3),"Jose")
        ));
        ProductsFollowedDTO productsFollowedDTOExpected = new ProductsFollowedDTO(
                userIdParam,
                TestUtilsGenerator.createPostsDtoWithIncreasingDates(3,userIdParam)

        );
        Mockito.when(userSellerRepoImp.getUserFollowedById(userIdParam)).thenReturn(sellerResponse);
        //Act
        ProductsFollowedDTO productsFollowedDTOActual = productServiceImp.getPostsFollowedByDate(userIdParam,orderParam);
        //Assert

        System.out.println(productsFollowedDTOActual.getPosts().size());
    
        assertEquals(productsFollowedDTOExpected,productsFollowedDTOActual);
    }

    @Test
    public void getPostsFollowedByDateTestDesc(){
        //Arrange
        Integer userIdParam = 1;
        String orderParam = "date_desc";
        List<Seller> sellerResponse = new ArrayList<>(List.of(
                new Seller(1, TestUtilsGenerator.createPostsWithDecreasingDates(3),"Jose")
        ));
        ProductsFollowedDTO productsFollowedDTOExpected = new ProductsFollowedDTO(
                userIdParam,
                TestUtilsGenerator.createPostsDtoWithDecreasingDates(3,userIdParam)

        );
        Mockito.when(userSellerRepoImp.getUserFollowedById(userIdParam)).thenReturn(sellerResponse);
        //Act
        ProductsFollowedDTO productsFollowedDTOActual = productServiceImp.getPostsFollowedByDate(userIdParam,orderParam);
        //Assert
        assertEquals(productsFollowedDTOExpected,productsFollowedDTOActual);
    }

    @Test
    public void getPostsFollowedByDateTestOrderNoOk(){
        //Arrange
        Integer userIdParam = 1;
        String orderParam = "invalid_order";
        String message = "El Usuario no fue encontrado o no sigue a ningun Vendedor";
        List<Seller> sellerResponse = new ArrayList<>(List.of(
                new Seller(1, TestUtilsGenerator.createPostsWithDecreasingDates(3),"Jose")
        ));
        Mockito.when(messageSourceBean.getMessage("type_of_order_not_exist", null, null)).thenReturn(message);
        Mockito.when(userSellerRepoImp.getUserFollowedById(userIdParam)).thenReturn(sellerResponse);
        //Act and Assert
        assertThrows(BadRequestException.class,()->productServiceImp.getPostsFollowedByDate(userIdParam,orderParam));
    }

    @Test
    public void getPostsFollowedByDateTestUserNotFound(){
        //Arrange
        Integer userIdParam = 999;
        String orderParam = "date_desc";
        String message = "El tipo de ordenamiento es incorrecto";
        List<Seller> sellerResponse = new ArrayList<>();
        Mockito.when(messageSourceBean.getMessage("user_not_found_any_seller", null, null)).thenReturn(message);
        Mockito.when(userSellerRepoImp.getUserFollowedById(userIdParam)).thenReturn(sellerResponse);
        //Act and Assert
        assertThrows(BadRequestException.class,()->productServiceImp.getPostsFollowedByDate(userIdParam,orderParam));
    }


    @Test
    public void promoPublicationsCountByUserNotPromos(){
        //Arrange
        Integer userIdParam = 1;
        String message = "El vendedor no tiene Promociones.";
        Optional<Seller> sellerResponse = Optional.of(new Seller(1,List.of(),"Juan"));
        Mockito.when(messageSourceBean.getMessage("not_promotions",null,null)).thenReturn(message);
        Mockito.when(userSellerRepoImp.getSellerById(userIdParam)).thenReturn(sellerResponse);
        //Act and Arrange
        Assertions.assertThrows(NotFoundException.class,()-> productServiceImp.promoPublicationsCountByUser(userIdParam));
    }

    //T-0005 Holmes
    @Test
    public void getPostsFollowedByDateException() {
        // Arrange
        Integer userId = 1;
        String order = "date_asc";


        when(userSellerRepoImp.getUserFollowedById(userId)).thenReturn(Collections.emptyList());
        when(messageSourceBean.getMessage("user_not_found_any_seller", null, null))
                .thenReturn("El Usuario no fue encontrado o no sigue a ningun Vendedor.");


        // Act y Assert
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            productServiceImp.getPostsFollowedByDate(userId, order);
        });

        // Verificamos que el mensaje de la excepción sea el esperado
        //assertEquals("El Usuario no fue encontrado o no sigue a ningun Vendedor.", thrown.getMessage());
    }

    @Test
    public void getPostsFollowedByDate() {
        // Arrange
        Integer userId = 1;
        String order = "date_asc";

        Seller seller = new Seller();
        seller.setId(1);
        seller.setUser_name("SellerName");

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setDate(LocalDate.now().minusDays(1).toString());
        post1.setCategory("Category1");
        post1.setProduct(new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"));

        seller.setPosts(Arrays.asList(post1));

        Mockito.when(userSellerRepoImp.getUserFollowedById(userId)).thenReturn(Arrays.asList(seller));

        // Act // Assert
        ProductsFollowedDTO result = productServiceImp.getPostsFollowedByDate(userId, order);
        assertNotNull(result);
        assertEquals(userId, result.getUser_id());
        assertEquals(1, result.getPosts().size());
        assertEquals("Product1", result.getPosts().get(0).getProduct().getProduct_name());

    }

    @Test
    public void getPostsFollowedByDate_WhenNoRecentPosts_ShouldReturnEmptyPosts() {
        // Arrange
        Integer userId = 1;
        String order = "date_desc";

        Seller seller = new Seller();
        seller.setId(1);
        seller.setUser_name("SellerName");

        Post post1 = new Post();
        post1.setPost_id(1);
        post1.setDate(LocalDate.now().minusDays(15).toString()); // Un post que no es reciente
        post1.setCategory("Category1");
        post1.setProduct(new Product(1, "Product2", "Type1", "Brand2", "Color2", "Notes2"));

        seller.setPosts(Arrays.asList(post1));

        when(userSellerRepoImp.getUserFollowedById(userId)).thenReturn(Arrays.asList(seller));

        // Act
        ProductsFollowedDTO result = productServiceImp.getPostsFollowedByDate(userId, order);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUser_id());
        assertEquals(0, result.getPosts().size());
    }

}
