package spring_recap_p2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
  private String url;
  private String password;
  private String link_id;
  private Integer redirects = 0;
}
