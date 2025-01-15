package _2.ejercicio_youtuber.service;

import _2.ejercicio_youtuber.dto.BlogDTO;
import _2.ejercicio_youtuber.exceptions.BlogExist;
import _2.ejercicio_youtuber.exceptions.BlogNotFound;
import _2.ejercicio_youtuber.model.EntradaBlog;
import _2.ejercicio_youtuber.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements  IBlogSerivce{

    private IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveBlog(BlogDTO blogDTO) {
        //BUSCAR EL CLIENTE POR ID
        Optional<EntradaBlog> entradaBlog = repository.getBlogById(blogDTO.getId());
        if (entradaBlog.isPresent()) {
            String message = String.format("El Blog con id %d ya existe.", blogDTO.getId());
            throw new BlogExist(message);
        }else {
            ObjectMapper mapper = new ObjectMapper();
            EntradaBlog entradaBlog1 = mapper.convertValue(blogDTO, EntradaBlog.class);
            repository.saveBlog(entradaBlog1);
            return blogDTO.getId();
        }

    }


    @Override
    public Optional<List<BlogDTO>> findAllBlogs() {
        List<EntradaBlog> listEB = repository.getAllBlogs();
        if (listEB.isEmpty()) {
            throw new BlogNotFound("no hay blog's creados.");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            List<BlogDTO> blogDTOs = new ArrayList<>();
            for (EntradaBlog entradaBlog : listEB) {
                BlogDTO blogDTO = mapper.convertValue(entradaBlog, BlogDTO.class);
                blogDTOs.add(blogDTO);
            }
            return Optional.of(blogDTOs);
        }

    }


    @Override
    public BlogDTO findBlogById(long id) {
        Optional<EntradaBlog> entradaBlog = repository.getBlogById(id);
        if (entradaBlog.isPresent()) {
            ObjectMapper mapper = new ObjectMapper();
            BlogDTO blogDTO = mapper.convertValue(entradaBlog.get(), BlogDTO.class);
            return blogDTO;
        }else{
            String message = String.format("El Blog con id %d no existe.", id);
            throw new BlogNotFound(message);
        }
    }
}
