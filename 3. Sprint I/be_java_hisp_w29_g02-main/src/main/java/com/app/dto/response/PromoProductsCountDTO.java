package com.app.dto.response;

// US 0011
public class PromoProductsCountDTO {

    private Integer user_id;

    private String user_name;

    private Integer promo_products_count;

    public PromoProductsCountDTO(Integer user_id, String user_name, Integer promo_products_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.promo_products_count = promo_products_count;
    }

    public PromoProductsCountDTO() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getPromo_products_count() {
        return promo_products_count;
    }

    public void setPromo_products_count(Integer promo_products_count) {
        this.promo_products_count = promo_products_count;
    }
}
