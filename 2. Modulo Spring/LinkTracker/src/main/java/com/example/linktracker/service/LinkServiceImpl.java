package com.example.linktracker.service;

import com.example.linktracker.dto.request.LinkDto;
import com.example.linktracker.dto.response.SuccessLinkDto;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exceptions.NotValidUrl;
import com.example.linktracker.repository.ILinkRepository;
import com.example.linktracker.repository.LinkRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class LinkServiceImpl implements ILinkService{
    private LinkRepositoryImpl linkRepository;
    private static final String URL_PATTERN =
            "^(https?:\\/\\/)?([\\w\\-]+(\\.[\\w\\-]+)+)([\\w\\-\\._~:\\/\\?#\\[\\]@!\\$&'\\(\\)\\*\\+,;=]*)?$";
    private static final Pattern pattern = Pattern.compile(URL_PATTERN);

    public static boolean isValidURL(String url) {
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    @Override
    public SuccessLinkDto create(LinkDto entity) {
        if (    entity.getUrl().startsWith("https://") &&
                !isValidURL(entity.getUrl())
        )
            throw new NotValidUrl("URL no es valida");
        Link link = Link.builder().url(entity.getUrl()).password("12345").counter(0).build();
        link = linkRepository.save(link);
        return SuccessLinkDto.builder().linkId(link.getId()).build();
    }

    @Override
    public LinkDto getLink(Integer id) {
        Link link = linkRepository.findById(id);
        return LinkDto.builder().url(link.getUrl()).build();
    }
}
