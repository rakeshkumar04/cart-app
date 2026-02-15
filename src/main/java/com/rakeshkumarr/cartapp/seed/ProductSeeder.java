package com.rakeshkumarr.cartapp.seed;

import com.rakeshkumarr.cartapp.entity.Product;
import com.rakeshkumarr.cartapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0){
            List<Product> demoProducts = List.of(
                    new Product(
                            null,
                            "Apple iPhone 15 Pro",
                            999.0,
                            "A17 Pro Chip Titanium Design",
                            "Smartphones",
                            4.9,
                            "Apple Store",
                            5,
                            List.of("/products/1.jpg")),

                    new Product(
                            null,
                            "Samsung Galaxy S24 Ultra",
                            1199.0,
                            "200MP Camera Snapdragon 8 Gen 3",
                            "Smartphones",
                            4.8,
                            "Samsung Store",
                            5,
                            List.of("/products/2.jpg")),

                    new Product(
                            null,
                            "Dell XPS 15",
                            1599.0,
                            "Premium Laptop Intel i9 13th Gen",
                            "Laptops",
                            4.8,
                            "Dell Store",
                            5,
                            List.of("/products/3.jpg")),

                    new Product(
                            null,
                            "MacBook Air M3",
                            1399.0,
                            "Lightweight Laptop Apple M3 Chip",
                            "Laptops",
                            4.9,
                            "Apple Store",
                            5,
                            List.of("/products/4.jpg")),

                    new Product(
                            null,
                            "Sony WH-1000XM5",
                            349.0,
                            "Noise Cancelling Headphones",
                            "Audio",
                            4.8,
                            "Amazon",
                            5,
                            List.of("/products/5.jpg")),


                    new Product(
                            null,
                            "JBL Flip 6",
                            129.0,
                            "Portable Bluetooth Speaker",
                            "Audio",
                            4.6,
                            "Flipkart",
                            4,
                            List.of("/products/6.jpg")),

                    new Product(
                            null,
                            "Samsung 27\" Odyssey G5",
                            329.0,
                            "Curved Gaming Monitor 144Hz",
                            "Monitors",
                            4.6,
                            "Samsung Store",
                            4,
                            List.of("/products/7.jpg")),

                    new Product(
                            null,
                            "LG UltraFine 4K",
                            499.0,
                            "4K IPS Professional Monitor",
                            "Monitors",
                            4.7,
                            "LG Store",
                            4,
                            List.of("/products/8.jpg")),

                    new Product(
                            null,
                            "Apple Watch Series 9",
                            399.0,
                            "Smartwatch Health Tracking",
                            "Wearables",
                            4.8,
                            "Apple Store",
                            5,
                            List.of("/products/9.jpg")),

                    new Product(
                            null,
                            "Samsung Galaxy Watch 6",
                            349.0,
                            "Android Smartwatch Fitness Tracking",
                            "Wearables",
                            4.6,
                            "Flipkart",
                            4,
                            List.of("/products/10.jpg"))

            );
            productRepository.saveAll(demoProducts);
            System.out.println("Seeded Demo Products");
        }
        else {
            System.out.println("Products Already Exists Skipping Seed");
        }
    }
}
