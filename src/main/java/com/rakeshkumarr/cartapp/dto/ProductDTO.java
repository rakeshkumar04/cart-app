package com.rakeshkumarr.cartapp.dto;

import com.rakeshkumarr.cartapp.entity.ProductImage;
import com.rakeshkumarr.cartapp.entity.ProductReview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public class ProductDTO {

    private Long id;

    private String name;

    private Double price;


    private String description;

    private String category;

    private Double ratings = 0.0;

    private String seller;

    private Integer stock;

    private Integer numOfReviews = 0;

    private List<ProductImageDTO> images;

    private List<ProductReviewDTO> reviews;

    public ProductDTO() {
        super();
    }

    public List<ProductImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDTO> images) {
        this.images = images;
    }

    public List<ProductReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public ProductDTO(Long id, String name, Double price, String description, String category, Double ratings, String seller, Integer stock) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        this.numOfReviews = numOfReviews;
    }


}
