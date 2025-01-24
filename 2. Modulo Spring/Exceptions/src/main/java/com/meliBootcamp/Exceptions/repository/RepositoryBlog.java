package com.meliBootcamp.Exceptions.repository;

import com.meliBootcamp.Exceptions.entity.Blog;
import com.meliBootcamp.Exceptions.exceptions.AlreadyExistException;
import com.meliBootcamp.Exceptions.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryBlog  implements  IRepositoryBlog{
    private List<Blog> listaBlogs=new ArrayList<>();

    @Override
    public void guardarBlog(Blog blog) {
        if (listaBlogs.stream().anyMatch(blog1 -> blog1.getId().equals(blog.getId()))){
            throw new AlreadyExistException("Ya existe un post con ese id");
        }
        listaBlogs.add(blog);
    }

    @Override
    public Blog buscarBlog(String id) {
        Optional<Blog>blog= listaBlogs.stream().filter(b-> b.getId().equals(id)).findFirst();
        if (blog.isEmpty()){
            throw new NotFoundException("No existe ningun post con ese id");
        }
        return blog.get();
    }

    @Override
    public List<Blog> buscarBlogs() {
        return listaBlogs;
    }


}
