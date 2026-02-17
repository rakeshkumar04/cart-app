package com.rakeshkumarr.cartapp.service;

import com.rakeshkumarr.cartapp.dto.ProductDTO;
import com.rakeshkumarr.cartapp.dto.ProductImageDTO;
import com.rakeshkumarr.cartapp.dto.ProductReviewDTO;
import com.rakeshkumarr.cartapp.entity.Product;
import com.rakeshkumarr.cartapp.entity.ProductReview;
import com.rakeshkumarr.cartapp.repository.ProductRepository;
import com.rakeshkumarr.cartapp.repository.ProductReviewRepository;
import com.rakeshkumarr.cartapp.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public Map<String, Object> getAllProducts(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);
        List<ProductDTO> productDTOS = products.stream().map(this::convertToDTO).collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("products", productDTOS);
        response.put("totalProducts", products.getTotalElements());
        return response;
    }

    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found with the id " + id)
        );
        
        return convertToDTO(product);
    }

    public List<ProductDTO> searchProducts(String category, Double minPrice, Double maxPrice, String keyword, Double ratings){
        Specification <Product> spec = Specification.where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.priceBetween(minPrice, maxPrice))
                .and(ProductSpecification.hasNameOrDescriptionLike(keyword))
                .and(ProductSpecification.ratingGreaterThan(ratings));
        return productRepository.findAll(spec)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public void addReview(ProductReviewDTO reviewDTO){
        Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow(
                () -> new RuntimeException("Product Not Found")
        );

        ProductReview review = new ProductReview();
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setProduct(product);
        productReviewRepository.save(review);
    }

    public ProductDTO convertToDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setRatings(product.getRatings());
        dto.setSeller(product.getSeller());
        dto.setStock(product.getStock());
        dto.setNumOfReviews(product.getNumOfReviews());

        List<ProductReviewDTO> reviewDtos = product.getReviews().stream().map(review -> {
            ProductReviewDTO reviewDTO = new ProductReviewDTO();
            reviewDTO.setProductId(review.getId());
            reviewDTO.setComment(review.getComment());
            reviewDTO.setRating(review.getRating());
            return reviewDTO;
        }).collect(Collectors.toList());
        dto.setReviews(reviewDtos);

        List<ProductImageDTO> imageDtos = product.getImages().stream().map(image -> {
            ProductImageDTO imageDto = new ProductImageDTO(image.getPublicId());
            return imageDto;
        }).collect(Collectors.toList());
        dto.setImages(imageDtos);

        return dto;
    }
}
