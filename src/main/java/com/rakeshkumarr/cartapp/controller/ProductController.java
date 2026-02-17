package com.rakeshkumarr.cartapp.controller;

import com.rakeshkumarr.cartapp.dto.ProductDTO;
import com.rakeshkumarr.cartapp.entity.Product;
import com.rakeshkumarr.cartapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        return productService.getAllProducts(page, size);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> searchProducts(@RequestParam(required = false) String category,
                                        @RequestParam(required = false) Double minPrice,
                                        @RequestParam(required = false) Double maxPrice,
                                        @RequestParam(required = false) String keyword,
                                        @RequestParam(required = false) Double ratings) {
        return productService.searchProducts(category, minPrice, maxPrice, keyword, ratings);
    }
}
