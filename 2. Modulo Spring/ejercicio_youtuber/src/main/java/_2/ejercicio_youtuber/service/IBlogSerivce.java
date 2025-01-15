package _2.ejercicio_youtuber.service;

import _2.ejercicio_youtuber.dto.BlogDTO;
import _2.ejercicio_youtuber.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogSerivce {
    Long saveBlog(BlogDTO blogDTO);
    Optional<List<BlogDTO>> findAllBlogs();
    BlogDTO findBlogById(long id);

}
