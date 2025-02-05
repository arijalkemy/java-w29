package com.org.meli.ejercicioBlog.repository;

import com.org.meli.ejercicioBlog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    private List<EntradaBlog> entradasBlog;

    public BlogRepositoryImpl() {
        entradasBlog = new ArrayList<>();
        entradasBlog.add(new EntradaBlog(1, "Hola! Este es mi blog", "Juan Perez", LocalDate.of(2000, 2, 28)));
        entradasBlog.add(new EntradaBlog(2, "Bienvenidos a mi blog", "María López", LocalDate.of(2015, 5, 10)));
        entradasBlog.add(new EntradaBlog(3, "El viaje de mis sueños", "Carlos García", LocalDate.of(2018, 12, 15)));
        entradasBlog.add(new EntradaBlog(4, "Recetas saludables", "Ana Fernández", LocalDate.of(2021, 7, 25)));
        entradasBlog.add(new EntradaBlog(5, "Mis libros favoritos", "Pedro Martínez", LocalDate.of(2019, 3, 8)));
        entradasBlog.add(new EntradaBlog(6, "Consejos de programación", "Sofía Gómez", LocalDate.of(2023, 10, 5)));
    }

    @Override
    public Optional<EntradaBlog> getBlogById(Integer id) {
        return entradasBlog.stream().filter(entradaBlog -> entradaBlog.getId().equals(id)).findFirst();
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradasBlog;
    }

    @Override
    public void addEntrada(EntradaBlog entradaBlog) {
        entradasBlog.add(entradaBlog);
    }
}
