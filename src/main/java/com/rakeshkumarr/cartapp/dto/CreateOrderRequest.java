package com.rakeshkumarr.cartapp.dto;

import java.util.List;

public class CreateOrderRequest {
    private List<OrderItemDTO> orderItems;

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
