package org.example.link_tracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Link {
    private static int pass = 1234;
    private static int nextId = 1;
    private int id;
    private String url;
    private int countRedirects;

    public Link(String url) {
        this.url = url;
        this.id = nextId++;
    }

    public void sumRedirect() {
        countRedirects++;
    }

    public boolean validatePass(int code){
        return code == Link.pass;
    }
}
