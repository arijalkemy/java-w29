package com.mdaneri;

import com.mdaneri.interfaces.Documentable;

public class Curriculum implements Documentable {

    private final String data;

    public Curriculum(String data) {
        this.data = data;
    }

    @Override
    public String getContent() {
        return data;
    }

}
