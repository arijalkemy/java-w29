package com.links.links.Repository;

import com.links.links.Entity.Link;

public interface ILinksRepository {

    Link getLink(Integer id);
    void deleteLink(Integer id);
    Integer createLink(Link link);

    void visitLink(Integer id);
}
