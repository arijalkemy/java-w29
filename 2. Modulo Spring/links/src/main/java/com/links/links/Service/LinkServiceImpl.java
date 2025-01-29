package com.links.links.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.links.links.Dto.LinkDto;
import com.links.links.Entity.Link;
import com.links.links.Repository.ILinksRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class LinkServiceImpl implements ILinkService{

    private final ILinksRepository repository;

    public LinkServiceImpl(ILinksRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto getLink(Integer id) {
        repository.stream().
        if()

        return null;
    }

    @Override
    public void deleteLink(Integer id) {

    }


    @Override
    public Integer createLink(LinkDto link) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex );
        Matcher matcher = pattern.matcher(link.getUrl());
         if(matcher.matches()){
            ObjectMapper om = new ObjectMapper();
            return repository.createLink(om.convertValue(link,Link.class));

         }else {
             return 0;
        }

    }
}
