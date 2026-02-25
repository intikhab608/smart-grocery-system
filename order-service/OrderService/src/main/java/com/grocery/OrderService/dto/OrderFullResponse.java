package com.grocery.OrderService.dto;



import com.grocery.OrderService.Enum.OrderStatus;

import lombok.Data;

@Data
public class OrderFullResponse {

    private Long orderId;
    private String orderName;
    private OrderStatus status;
    private Long quantity;

    private UserDTO user;
    private ProductDTO product;
}

