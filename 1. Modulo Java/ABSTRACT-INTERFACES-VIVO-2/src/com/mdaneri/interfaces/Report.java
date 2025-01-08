package com.mdaneri.interfaces;

public class Report implements Documentable{

    private final String data;

    public Report(String data) {
        this.data = data;
    }

    @Override
    public String getContent() {
        return data;
    }


}
