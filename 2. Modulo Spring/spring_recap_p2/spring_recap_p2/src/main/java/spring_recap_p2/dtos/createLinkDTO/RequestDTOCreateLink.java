package spring_recap_p2.dtos.createLinkDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTOCreateLink {
  private String url;
  private String password;
}
