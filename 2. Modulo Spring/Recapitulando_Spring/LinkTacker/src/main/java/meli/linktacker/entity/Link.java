package meli.linktacker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    Integer id;
    String link;
    Integer views;
    Boolean invalid;
    String password;
}
