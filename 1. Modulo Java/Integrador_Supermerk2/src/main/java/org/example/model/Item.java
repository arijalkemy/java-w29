package org.example.model;

public class Item {

    private int code;
    private String name;
    private int cantBuy;
    private int costUnit;

    public Item(int code, String name, int cantBuy, int costUnit) {
        this.code = code;
        this.name = name;
        this.cantBuy = cantBuy;
        this.costUnit = costUnit;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantBuy() {
        return cantBuy;
    }

    public void setCantBuy(int cantBuy) {
        this.cantBuy = cantBuy;
    }

    public int getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(int costUnit) {
        this.costUnit = costUnit;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", cantBuy=" + cantBuy +
                ", costUnit=" + costUnit +
                '}';
    }
}
