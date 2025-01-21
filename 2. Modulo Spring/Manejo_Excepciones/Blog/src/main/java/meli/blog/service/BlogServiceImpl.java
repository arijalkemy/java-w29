package meli.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.blog.dto.BlogDto;
import meli.blog.entity.Blog;
import meli.blog.exceptions.BadRequestException;
import meli.blog.exceptions.NotFoundException;
import meli.blog.repositiry.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogservice{

    @Autowired
    IBlogRepository repository;


    @Override
    public Integer create(BlogDto blogDto) {
        ObjectMapper mapper = new ObjectMapper();
        Blog blog = mapper.convertValue(blogDto, Blog.class);
        Blog findBlog =repository.findById(blogDto.getId());
        if(findBlog != null){
           throw new BadRequestException("Blog ya se encuentra creado");
        }
        repository.save(blog);
        return blog.getId();
    }

    @Override
    public Blog findBlog(Integer id) {
        Blog findRepository = repository.findById(id);
        if(findRepository == null){
            throw new NotFoundException("No se encontro blog");
        }
        return findRepository;
    }

    @Override
    public List<Blog> getAll() {
        List<Blog> listBlog = repository.findAll();
        if(listBlog.isEmpty()){
            throw new NotFoundException("no existen blogs");
        }
        return listBlog;

    }
}
