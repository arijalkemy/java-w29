package org.example.manejo_excepciones_1_vivo.controller;

import lombok.AllArgsConstructor;
import org.example.manejo_excepciones_1_vivo.dto.request.EntradaBlogRequestDto;
import org.example.manejo_excepciones_1_vivo.dto.response.EntradaBlogResponseDto;
import org.example.manejo_excepciones_1_vivo.services.ServicesBlogImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/blog")
public class ControllerBlog {
    private final ServicesBlogImpl servicesBlog;

    @RequestMapping("")
    public ResponseEntity<EntradaBlogResponseDto> createBlog(@RequestBody EntradaBlogRequestDto entradaBlog) {
        return new ResponseEntity<>(servicesBlog.createBlog(EntradaBlogRequestDto.builder()
                .tituloBlog(entradaBlog.getTituloBlog())
                .nombreAutor(entradaBlog.getNombreAutor())
                .fechaPublicacion(entradaBlog.getFechaPublicacion())
                .build()), HttpStatus.CREATED);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<EntradaBlogResponseDto>> getBlogs() {
        return new ResponseEntity<>(servicesBlog.getBlogs(), HttpStatus.OK);

    }

    @RequestMapping("/{id}")
    public ResponseEntity<EntradaBlogResponseDto> getBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(servicesBlog.getBlogById(id), HttpStatus.OK);
    }

}
