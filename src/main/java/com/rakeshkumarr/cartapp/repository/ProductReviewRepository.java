package com.rakeshkumarr.cartapp.repository;

import com.rakeshkumarr.cartapp.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
