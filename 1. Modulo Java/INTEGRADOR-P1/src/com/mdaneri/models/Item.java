package com.mdaneri.models;

import java.util.Comparator;

public class Item implements Comparable<Item> {

    private Integer code;
    private String name;
    private Integer amount;
    private Double price;

    public Item(Integer code, String name, Integer amount, Double price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public int compareTo(Item o) {
        if (this.getCode().equals(o.getCode()))
            return this.amount.compareTo(o.getAmount());
        return this.getCode().compareTo(o.getCode());
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

}
