package org.example.manejo_excepciones_1_vivo.repository;

import lombok.AllArgsConstructor;
import org.example.manejo_excepciones_1_vivo.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RepositoryBlogImpl implements IRepositoryBlog{

    List<EntradaBlog> entradaBlogList;

    @Override
    public EntradaBlog createBlog(EntradaBlog entradaBlog) {
        entradaBlogList.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public List<EntradaBlog> getBlogs() {
        return entradaBlogList;
    }

    @Override
    public EntradaBlog getBlogById(Integer id) {
        return entradaBlogList.get(id);
    }
}
