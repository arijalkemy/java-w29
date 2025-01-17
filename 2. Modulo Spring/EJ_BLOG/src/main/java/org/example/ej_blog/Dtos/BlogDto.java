package org.example.ej_blog.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private Integer idBlog;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
