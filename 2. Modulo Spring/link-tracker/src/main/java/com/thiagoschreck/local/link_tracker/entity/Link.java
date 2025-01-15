package com.thiagoschreck.local.link_tracker.entity;

public class Link {
    private final String url;
    private int id;
    private boolean disabled;
    private int amountOfRedirects;
    private final String password;

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
        disabled = false;
        amountOfRedirects = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean isEnabled) {
        disabled = isEnabled;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public int getAmountOfRedirects() {
        return amountOfRedirects;
    }

    public void visit() {
        amountOfRedirects++;
    }

}
