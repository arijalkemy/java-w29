package com.mdaneri;

import com.mdaneri.interfaces.Documentable;

public class PDFBook implements Documentable {

    private final String data;

    public PDFBook(String data) {
        this.data = data;
    }

    @Override
    public String getContent() {
        return data;
    }


}
