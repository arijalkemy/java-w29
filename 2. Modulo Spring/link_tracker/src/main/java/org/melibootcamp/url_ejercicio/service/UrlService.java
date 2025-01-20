package org.melibootcamp.url_ejercicio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.melibootcamp.url_ejercicio.dto.request.UrlDTORequest;
import org.melibootcamp.url_ejercicio.dto.response.UrlDTO;
import org.melibootcamp.url_ejercicio.dto.response.UrlDeleteDTO;
import org.melibootcamp.url_ejercicio.dto.response.UrlRedirectDto;
import org.melibootcamp.url_ejercicio.entity.Url;
import org.melibootcamp.url_ejercicio.exception.InvalidCredentialsException;
import org.melibootcamp.url_ejercicio.exception.InvalidUrlException;
import org.melibootcamp.url_ejercicio.exception.NotFoundException;
import org.melibootcamp.url_ejercicio.repository.UrlRepositoryImpl;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepositoryImpl urlRepository;
    private final ObjectMapper objectMapper;
    private final ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder;

    public UrlDTO setUrlValid(UrlDTORequest urlDTORequest){
        if (isValidURL(urlDTORequest.getUrl())){
            return objectMapper.convertValue(urlRepository.saveUrl(objectMapper.convertValue(urlDTORequest, Url.class)),UrlDTO.class);
        }else{
            throw new InvalidUrlException("La url es invalida");
        }
    }

    public String getUrl(Integer id,String password){
       Optional<Url> url = urlRepository.findById(id);

       if (url.isEmpty()){
           throw new NotFoundException("No se encontro una Url");
       } else if (!url.get().getPassword().equals(password)) {
           throw new InvalidCredentialsException("Credenciales Incorrectas");
       }
        url.get().setNumRedirect(url.get().getNumRedirect() + 1);
       return url.get().getUrl();
    }

    public UrlRedirectDto getNumRedirects(Integer id){
        Optional<Url> url = urlRepository.findById(id);
        if (url.isEmpty()){
            throw new NotFoundException("No se encontro una Url");
        }

        return objectMapper.convertValue(url, UrlRedirectDto.class);
    }

    public UrlDeleteDTO invalidUrlDTO(Integer id){
        Integer idDeleted = urlRepository.deleteUrl(id);
        if (idDeleted == null){
            throw new NotFoundException("No se encontro una Url");
        }
        return new UrlDeleteDTO("Se elimino Correctamente",idDeleted);
    }

    private static final String URL_REGEX =
            "^(https?:\\/\\/)?([\\w\\-]+(\\.[\\w\\-]+)+)(:[0-9]{1,5})?(\\/[^\\s]*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean isValidURL(String url) {
        if (url == null || url.isEmpty()) {
            return false; // Las cadenas nulas o vacías no son válidas.
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
}
