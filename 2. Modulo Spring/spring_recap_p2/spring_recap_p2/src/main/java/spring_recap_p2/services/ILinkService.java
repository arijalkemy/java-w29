package spring_recap_p2.services;

import java.net.URI;

import spring_recap_p2.dtos.createLinkDTO.RequestDTOCreateLink;
import spring_recap_p2.dtos.createLinkDTO.ResponseDTOCreateLink;
import spring_recap_p2.dtos.linkMetricsDTO.ResponseDTOMetricsLink;

public interface ILinkService {
  public ResponseDTOCreateLink createLink(RequestDTOCreateLink request_dto);
  public URI redirect(String link_id, String passord);
  public ResponseDTOMetricsLink linkMetrics(String link_id);
  public String deleteLink(String link_id);
}
