package com.links.links.Service;

import com.links.links.Dto.LinkDto;
import com.links.links.Entity.Link;

public  interface ILinkService {

    LinkDto getLink(Integer id);
    void deleteLink(Integer id);
    Integer createLink(LinkDto link);
}
