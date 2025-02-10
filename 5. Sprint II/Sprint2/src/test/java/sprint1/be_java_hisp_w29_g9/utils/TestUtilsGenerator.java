package sprint1.be_java_hisp_w29_g9.utils;

import com.fasterxml.jackson.databind.ObjectWriter;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.PostDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductsFollowedDTO;
import sprint1.be_java_hisp_w29_g9.entities.Post;
import sprint1.be_java_hisp_w29_g9.entities.Product;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static Seller getSellerWithPosts(String name){
        // Crear productos
        Product laptop = new Product(201, "Laptop", "Electronics", "Dell", "Silver", "15-inch screen");
        Product headphones = new Product(202, "Headphones", "Accessories", "Sony", "Black", "Noise-canceling");
        Product smartphone = new Product(203, "Smartphone", "Electronics", "Samsung", "Black", "128GB storage");

        // Crear posts
        Post post1 = new Post(101, "2025-02-03", laptop, "Technology", 800.0, true, 10.0);
        Post post2 = new Post(102, "2025-01-01", headphones, "Audio", 200.0, false, 0.0);
        Post post3 = new Post(103, "2025-01-20", smartphone, "Technology", 700.0, true, 5.0);

        List<Post>  posts = new ArrayList<>(Arrays.asList(post1,post2,post3));
        // Crear usuario
        return  new Seller(100, posts,name);
    }

    public static List<Post> createPostsWithDecreasingDates(Integer numPosts) {
        List<Post> posts = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < numPosts; i++) {
            LocalDate postDate = currentDate.minusDays(i);

            Post post = new Post(i + 1,
                    postDate.toString(),
                    new Product(i + 1,
                            "Producto" + (i + 1),
                            "Tipo",
                            "Marca",
                            "Color",
                            "Nota"),
                    "Categoria",
                    100.0,
                    false,
                    0.0
            );
            posts.add(post);
        }

        return posts;
    }

    public static List<PostDTO> createPostsDtoWithDecreasingDates(Integer numPosts,Integer userId) {
        List<PostDTO> posts = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < numPosts; i++) {
            LocalDate postDate = currentDate.minusDays(i);

            PostDTO post = new PostDTO(
                    userId,
                    i+1,
                    postDate.toString(),
                    new ProductDTO(i + 1,
                            "Producto" + (i + 1),
                            "Tipo",
                            "Marca",
                            "Color",
                            "Nota"),
                    "Categoria",
                    100.0
            );
            posts.add(post);
        }

        return posts;
    }

    public static List<PostDTO> createPostsDtoWithIncreasingDates(Integer numPosts,Integer userId) {
        List<PostDTO> posts = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (int i = numPosts; i >0; i--) {
            LocalDate postDate = currentDate.minusDays(i-1);

            PostDTO post = new PostDTO(
                    userId,
                    i,
                    postDate.toString(),
                    new ProductDTO(i ,
                            "Producto" + (i),
                            "Tipo",
                            "Marca",
                            "Color",
                            "Nota"),
                    "Categoria",
                    100.0
            );
            posts.add(post);
        }

        return posts;
    }




}
