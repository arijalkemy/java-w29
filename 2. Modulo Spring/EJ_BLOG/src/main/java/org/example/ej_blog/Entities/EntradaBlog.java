package org.example.ej_blog.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {

    private Integer idBlog;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;

}
