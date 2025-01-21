package spring_recap_p2.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import spring_recap_p2.entities.Link;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
  List<Link> links = new ArrayList<>();

  @Override
  public Boolean addLink(Link new_link) {
    if(links.stream().anyMatch(link -> link.getUrl().matches(new_link.getUrl())))
      return false;
    return links.add(new_link);
  }

  @Override
  public List<Link> getLinks() {
    return links;
  }

  @Override
  public Optional<Link> getLink(String link_id) {
    return links.stream()
      .filter(link -> link.getLink_id().matches(link_id))
      .findFirst();
  }

  @Override
  public Boolean deleteLink(String link_id) {
    return links.removeIf(link -> link.getLink_id().matches(link_id));
  }
}
