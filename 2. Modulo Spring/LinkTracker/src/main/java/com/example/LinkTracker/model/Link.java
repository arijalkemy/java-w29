package com.example.LinkTracker.model;

import com.example.LinkTracker.dto.LinkDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String url;
    private Integer linkId;
    private Boolean isValid;
    private static Integer linkIdCounter = 1;
    private Integer visitCounter;

    public static Link convertFromDTO(LinkDTO link){
        return new Link(link.url());
    }

    public Link(String url) {
        this.url = url;
        this.linkId = linkIdCounter++;
        this.isValid = true;
        this.visitCounter = 0;
    }
}
