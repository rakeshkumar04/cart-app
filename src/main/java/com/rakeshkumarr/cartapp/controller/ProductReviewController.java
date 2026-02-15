package com.rakeshkumarr.cartapp.controller;

import com.rakeshkumarr.cartapp.dto.ProductReviewDTO;
import com.rakeshkumarr.cartapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/reviews")
public class ProductReviewController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody @Valid ProductReviewDTO reviewDTO){
        productService.addReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review Added");
    }
}
