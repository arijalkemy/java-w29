package com.links.links.Repository;

import com.links.links.Entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinksRepository{

    private List<Link> myLinks;

    public LinkRepositoryImpl(List<Link> myLinks) {
        this.myLinks = myLinks;
    }

    @Override
    public Link (Integer id) {
        Optional<Link> exist = myLinks.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
        if(exist.isPresent()){
            return null;
        }
        return null;

    }

    @Override
    public void deleteLink(Integer id) {

    }

    @Override
    public Integer createLink(Link link) {
        myLinks.add(link);
        return link.getId();
    }

    @Override
    public void visitLink(Integer id) {
       Link currentLink = myLinks.stream().filter(x-> x.getId().equals(id)).findFirst().get();
       currentLink.setCounter(currentLink.getCounter()+1);
    }
}
