package com.rakeshkumarr.cartapp.dto;

import com.rakeshkumarr.cartapp.entity.Product;
import jakarta.persistence.*;

public class OrderItemDTO {

    private String name;
    private Integer quantity;
    private String image;
    private Double price;
    private Long productId;

    public OrderItemDTO(String name, Integer quantity, String image, Double price, Long productId) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
