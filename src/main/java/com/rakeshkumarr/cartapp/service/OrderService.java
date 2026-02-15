package com.rakeshkumarr.cartapp.service;

import com.rakeshkumarr.cartapp.dto.CreateOrderRequest;
import com.rakeshkumarr.cartapp.dto.OrderCreated;
import com.rakeshkumarr.cartapp.dto.OrderItemDTO;
import com.rakeshkumarr.cartapp.entity.Order;
import com.rakeshkumarr.cartapp.entity.OrderItem;
import com.rakeshkumarr.cartapp.entity.Product;
import com.rakeshkumarr.cartapp.repository.OrderRepository;
import com.rakeshkumarr.cartapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    ProductRepository productRepo;

    @Autowired
    OrderRepository orderRepo;

    public OrderCreated createOrder(CreateOrderRequest orderRequest){
        Order order = new Order();
        order.setStatus("PENDING");
        double totalItemAmount = 0;

        for(OrderItemDTO item: orderRequest.getOrderItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setImage(item.getImage());
            orderItem.setPrice(item.getPrice());
            Product product = productRepo.findById(item.getProductId()).orElseThrow(
                    () -> new RuntimeException("Product Not Found")
            );
            orderItem.setProduct(product);
            totalItemAmount += item.getPrice() * item.getQuantity();

            order.getOrderItems().add(orderItem);
        }
        order.setTotalItemAmount(totalItemAmount);
        double totalAmount = 0;
        double taxAmount = totalItemAmount * 0.05;
        totalAmount = totalItemAmount + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);
        String refId = "ORD-" + UUID.randomUUID().toString().substring(0,8);
        order.setReferenceId(refId);


        orderRepo.save(order);
        return new OrderCreated(refId);
    }

    public Order getOrder(String referenceId) {
        return orderRepo.findByReferenceId(referenceId).orElseThrow(
                () -> new RuntimeException("No Order Found with Ref Id")
        );
    }
}
