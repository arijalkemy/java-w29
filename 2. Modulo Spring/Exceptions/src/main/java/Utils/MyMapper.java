package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meliBootcamp.Exceptions.dto.BlogDTO;
import com.meliBootcamp.Exceptions.entity.Blog;

public class MyMapper {
    public static Blog dtoABLog(BlogDTO dto){
        return new ObjectMapper().convertValue(dto, Blog.class);
    }
    public static BlogDTO blogADto(Blog blog){
        return new ObjectMapper().convertValue(blog, BlogDTO.class);
    }
}
