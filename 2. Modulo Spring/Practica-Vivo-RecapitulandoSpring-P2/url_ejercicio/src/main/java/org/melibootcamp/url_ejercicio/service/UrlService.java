package org.melibootcamp.url_ejercicio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.melibootcamp.url_ejercicio.dto.request.UrlDTORequest;
import org.melibootcamp.url_ejercicio.dto.response.UrlDTO;
import org.melibootcamp.url_ejercicio.dto.response.UrlStatisticsDto;
import org.melibootcamp.url_ejercicio.entity.Url;
import org.melibootcamp.url_ejercicio.exception.InvalidPasswordException;
import org.melibootcamp.url_ejercicio.exception.InvalidUrlException;
import org.melibootcamp.url_ejercicio.exception.NotFoundException;
import org.melibootcamp.url_ejercicio.repository.UrlRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepositoryImpl urlRepository;
    private final ObjectMapper objectMapper;

    public UrlDTO setUrlValid(UrlDTORequest urlDTORequest) {
        if (isValidURL(urlDTORequest.getUrl())) {
            return objectMapper.convertValue(urlRepository.saveUrl(objectMapper.convertValue(urlDTORequest, Url.class)),
                    UrlDTO.class);
        } else {
            throw new InvalidUrlException("La url es invalida");
        }

    }

    public UrlDTO setUrlValid(UrlDTORequest urlDTORequest, String password) {
        if (isValidURL(urlDTORequest.getUrl())) {
            return objectMapper.convertValue(
                    urlRepository.saveUrlWithPassword(objectMapper.convertValue(urlDTORequest, Url.class), password),
                    UrlDTO.class);
        } else {
            throw new InvalidUrlException("La url es invalida");
        }

    }

    public String getUrl(Integer id) {
        Optional<Url> url = urlRepository.findById(id);

        if (url.isEmpty()) {
            throw new NotFoundException("No se encontro una Url");
        }

        if (url.get().getPassword() != null) {
            throw new InvalidPasswordException("Contraseña invalida");

        }

        urlRepository.addVisit(id);
        return url.get().getUrl();
    }

    public String getUrlPassword(Integer id, String password) {
        Optional<Url> url = urlRepository.findById(id);

        if (url.isEmpty()) {
            throw new NotFoundException("No se encontro una Url");
        }

        if (!password.equals(url.get().getPassword())) {
            throw new InvalidPasswordException("Contraseña invalida");
        }

        urlRepository.addVisit(id);
        return url.get().getUrl();
    }

    public UrlStatisticsDto getUrlStatisticsDto(Integer id) {
        Optional<Url> url = urlRepository.findById(id);

        if (url.isEmpty()) {
            throw new NotFoundException("No se encontro una Url");
        }

        return new UrlStatisticsDto(url.get().getId(), url.get().getUrl(), url.get().getVisits());
    }

    private static final String URL_REGEX = "^(https?:\\/\\/)?([\\w\\-]+(\\.[\\w\\-]+)+)(:[0-9]{1,5})?(\\/[^\\s]*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean isValidURL(String url) {
        if (url == null || url.isEmpty()) {
            return false; // Las cadenas nulas o vacías no son válidas.
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

    public void invalidateUrl(Integer id) {
        this.urlRepository.deleteUrl(id);
    }
}
