package com.rakeshkumarr.cartapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductReviewDTO {
    @NotNull(message = "Product Id is required")
    private Long productId;

    @NotBlank(message = "Comment cannot be Blank")
    private String comment;

    @NotNull(message = "Rating is Required")
    private Double rating;

    public ProductReviewDTO() {
        super();
    }

    public ProductReviewDTO(Long productId, String comment, Double rating) {
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
