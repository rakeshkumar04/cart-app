package com.rakeshkumarr.cartapp.dto;

public class ProductImageDTO {
    private String url;

    public ProductImageDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
