package spring_recap_p2.repositories;

import java.util.List;
import java.util.Optional;

import spring_recap_p2.entities.Link;

public interface ILinkRepository {
  public Boolean addLink(Link link);
  public List<Link> getLinks();
  public Optional<Link> getLink(String link_id);
  public Boolean deleteLink(String link_id);
}
