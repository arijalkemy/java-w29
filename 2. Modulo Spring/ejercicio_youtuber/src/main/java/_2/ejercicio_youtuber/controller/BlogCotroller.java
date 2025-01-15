package _2.ejercicio_youtuber.controller;

import _2.ejercicio_youtuber.dto.BlogDTO;
import _2.ejercicio_youtuber.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogCotroller {
    private final BlogService blogService;

    public BlogCotroller(BlogService blogService) {
        this.blogService = blogService;
    }

    //Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente
    // mostrando su “Id”. (URI: /blog).

    @PostMapping("blog/")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blogDTO) {
        blogService.saveBlog(blogDTO);
        return ResponseEntity.ok("Blog creado con éxito, id: " + blogDTO.getId());
    }

    //Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo.
    // (URI: /blog/{id}).
    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable long id) {
        return ResponseEntity.ok("El blog encontrado es : " + blogService.findBlogById(id));
    }

    //Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        return ResponseEntity.ok(blogService.findAllBlogs());
    }

}
