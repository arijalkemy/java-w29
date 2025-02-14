package com.meli.socialmeli.runner;

import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Product;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IProductRepository;
import com.meli.socialmeli.repository.ISellerRepository;
import com.meli.socialmeli.repository.IUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartUp {

    private IPostRepository postRepository;
    private IUserRepository userRepository;
    private ISellerRepository sellerRepository;
    private IProductRepository productRepository;

    public StartUp(IPostRepository postRepository, IUserRepository userRepository, ISellerRepository sellerRepository, IProductRepository productRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    private void loadRepositories() {
        System.out.println("Loading inital data");
        // Creamos los usuarios
        List<User> users = List.of(
                new User(1, "Pepito", new ArrayList<>()),
                new User(2, "Juanito", new ArrayList<>()),
                new User(3, "Fermino", new ArrayList<>()),
                new User(4, "Juanita", new ArrayList<>())
        );

        // Guardamos los usuarios en el repositorio
        users.forEach(user -> userRepository.save(user));

        // Creamos los vendedores
        List<User> followers1 = new ArrayList<>();
        followers1.addAll(List.of(users.get(0), users.get(1)));

        List<User> followers2 = new ArrayList<>();
        followers2.addAll(List.of(users.get(2), users.get(3)));

        List<User> followers3 = new ArrayList<>();
        followers3.addAll(List.of(users.get(1), users.get(2)));

        List<Seller> sellers = List.of(
                new Seller(1, "Don German", followers1),
                new Seller(2, "El Paisa", followers3),
                new Seller(3, "Panadería de la Esquina", followers2),
                new Seller(4, "D1", new ArrayList<>())
        );

        // Guardamos los vendedores en el repositorio
        sellers.forEach(seller -> sellerRepository.save(seller));

        // Asignamos los vendedores a los usuarios

        List<Seller> follows1 = new ArrayList<>();
        follows1.add(sellers.get(0));
        follows1.add(sellers.get(1));
        users.get(0).setFollows(follows1);

        List<Seller> follows2 = new ArrayList<>();
        follows2.add(sellers.get(2));
        users.get(1).setFollows(follows2);

        // Creamos los productos
        Product product1 = Product.builder()
                .id(1)
                .name("Juego")
                .type("Gamer")
                .brand("Box")
                .color("Black")
                .notes("Notes this is a game for box")
                .build();

        Product product2 = Product.builder()
                .id(2)
                .name("Mesa")
                .type("Gamer")
                .brand("Desk")
                .color("White")
                .notes("Notes this is a desk white")
                .build();

        Product product3 = Product.builder()
                .id(3)
                .name("Silla")
                .type("Oficina")
                .brand("ComfyChair")
                .color("Gris")
                .notes("Silla ergonómica para oficina")
                .build();

        Product product4 = Product.builder()
                .id(4)
                .name("Laptop")
                .type("Computadora")
                .brand("TechPro")
                .color("Plateado")
                .notes("Laptop de alto rendimiento")
                .build();

        Product product5 = Product.builder()
                .id(5)
                .name("Audífonos")
                .type("Accesorios")
                .brand("SoundMax")
                .color("Negro")
                .notes("Audífonos inalámbricos con cancelación de ruido")
                .build();

        Product product6 = Product.builder()
                .id(6)
                .name("Smartwatch")
                .type("Wearables")
                .brand("FitTech")
                .color("Azul")
                .notes("Smartwatch con monitor de actividad física")
                .build();

        Product product7 = Product.builder()
                .id(7)
                .name("Altavoz")
                .type("Audio")
                .brand("SoundBlast")
                .color("Rojo")
                .notes("Altavoz portátil con Bluetooth")
                .build();

        Product product8 = Product.builder()
                .id(8)
                .name("Tableta")
                .type("Computadora")
                .brand("TableTech")
                .color("Dorado")
                .notes("Tableta de alta resolución con lápiz óptico")
                .build();

        Product product9 = Product.builder()
                .id(9)
                .name("Cámara")
                .type("Fotografía")
                .brand("PixelPro")
                .color("Negro")
                .notes("Cámara digital de alta gama")
                .build();

        // Guardamos los productos
        productRepository.save(product1);
        productRepository.save(product2);

        // Creamos y guardamos las publicaciones
        List<Post> posts = List.of(
                Post.builder()
                        .id(1)
                        .date(LocalDate.now())
                        .price(1000.0)
                        .product(product1)
                        .seller(sellers.get(0))
                        .discount(0.1)
                        .hasPromo(true)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(2)
                        .date(LocalDate.now())
                        .price(200.0)
                        .product(product1)
                        .seller(sellers.get(0))
                        .discount(0.0)
                        .hasPromo(false)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(3)
                        .date(LocalDate.now())
                        .price(300.0)
                        .product(product2)
                        .seller(sellers.get(1))
                        .discount(0.2)
                        .hasPromo(true)
                        .category(200)
                        .build(),

                Post.builder()
                        .id(4)
                        .date(LocalDate.now())
                        .price(150.0)
                        .product(product1)
                        .seller(sellers.get(1))
                        .discount(0.0)
                        .hasPromo(false)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(5)
                        .date(LocalDate.now())
                        .price(400.0)
                        .product(product2)
                        .seller(sellers.get(2))
                        .discount(0.15)
                        .hasPromo(true)
                        .category(200)
                        .build(),

                Post.builder()
                        .id(6)
                        .date(LocalDate.now())
                        .price(500.0)
                        .product(product1)
                        .seller(sellers.get(2))
                        .discount(0.1)
                        .hasPromo(true)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(7)
                        .date(LocalDate.now())
                        .price(130.0)
                        .product(product2)
                        .seller(sellers.get(0))
                        .discount(0.05)
                        .hasPromo(false)
                        .category(200)
                        .build(),

                Post.builder()
                        .id(8)
                        .date(LocalDate.now())
                        .price(600.0)
                        .product(product1)
                        .seller(sellers.get(0))
                        .discount(0.20)
                        .hasPromo(true)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(9)
                        .date(LocalDate.now())
                        .price(250.0)
                        .product(product2)
                        .seller(sellers.get(1))
                        .discount(0.0)
                        .hasPromo(false)
                        .category(200)
                        .build(),

                Post.builder()
                        .id(10)
                        .date(LocalDate.now())
                        .price(750.0)
                        .product(product1)
                        .seller(sellers.get(2))
                        .discount(0.1)
                        .hasPromo(true)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(11)
                        .date(LocalDate.of(2025, 1, 27))
                        .price(1000.0)
                        .product(product1)
                        .seller(sellers.get(0))
                        .discount(0.1)
                        .hasPromo(true)
                        .category(100)
                        .build(),

                Post.builder()
                        .id(12)
                        .date(LocalDate.of(2025, 1, 20))
                        .price(200.0)
                        .product(product2)
                        .seller(sellers.get(1))
                        .discount(0.0)
                        .hasPromo(false)
                        .category(200)
                        .build(),

                Post.builder()
                        .id(13)
                        .date(LocalDate.of(2025, 1, 10))
                        .price(300.0)
                        .product(product3)
                        .seller(sellers.get(0))
                        .discount(0.2)
                        .hasPromo(true)
                        .category(300)
                        .build(),

                Post.builder()
                        .id(14)
                        .date(LocalDate.of(2025, 1, 25))
                        .price(150.0)
                        .product(product4)
                        .seller(sellers.get(1))
                        .discount(0.0)
                        .hasPromo(false)
                        .category(400)
                        .build(),

                Post.builder()
                        .id(15)
                        .date(LocalDate.of(2025, 1, 15))
                        .price(400.0)
                        .product(product5)
                        .seller(sellers.get(0))
                        .discount(0.15)
                        .hasPromo(true)
                        .category(500)
                        .build(),

                Post.builder()
                        .id(16)
                        .date(LocalDate.of(2025, 1, 5))
                        .price(500.0)
                        .product(product6)
                        .seller(sellers.get(1))
                        .discount(0.1)
                        .hasPromo(true)
                        .category(600)
                        .build(),

                Post.builder()
                        .id(17)
                        .date(LocalDate.of(2025, 1, 22))
                        .price(130.0)
                        .product(product7)
                        .seller(sellers.get(0))
                        .discount(0.05)
                        .hasPromo(false)
                        .category(700)
                        .build(),

                Post.builder()
                        .id(18)
                        .date(LocalDate.of(2025, 1, 18))
                        .price(600.0)
                        .product(product8)
                        .seller(sellers.get(1))
                        .discount(0.2)
                        .hasPromo(true)
                        .category(800)
                        .build(),

                Post.builder()
                        .id(19)
                        .date(LocalDate.of(2025, 1, 12))
                        .price(250.0)
                        .product(product9)
                        .seller(sellers.get(0))
                        .discount(0.0)
                        .hasPromo(false)
                        .category(900)
                        .build(),

                Post.builder()
                        .id(20)
                        .date(LocalDate.of(2025, 1, 24))
                        .price(750.0)
                        .product(product1)
                        .seller(sellers.get(1))
                        .discount(0.1)
                        .hasPromo(true)
                        .category(100)
                        .build()
        );

        // Guardamos las publicaciones en el repositorio
        posts.forEach(post -> postRepository.save(post));
    }

}
