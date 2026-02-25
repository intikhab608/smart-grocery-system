package com.grocery.OrderService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.OrderService.Entity.Order;
import com.grocery.OrderService.Repository.OrderRepo;
import com.grocery.OrderService.client.ProductClient;
import com.grocery.OrderService.client.UserClient;
import com.grocery.OrderService.dto.OrderFullResponse;
import com.grocery.OrderService.dto.ProductDTO;
import com.grocery.OrderService.dto.UserDTO;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }   

    
    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    public OrderFullResponse getCompleteOrder(Long orderId) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        UserDTO user = userClient.getUser(order.getUserId());
        ProductDTO product = productClient.getProduct(order.getProductId());

        OrderFullResponse response = new OrderFullResponse();
        response.setOrderId(order.getId());
        response.setOrderName(order.getOrderName());
        response.setStatus(order.getStatus());
        response.setQuantity(order.getQuantity());
        response.setUser(user);
        response.setProduct(product);

        return response;
    }

    public List<Order> getOrders(){
        return orderRepo.findAll();
    };

     public Order getOrderById(long id){
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id : " + getOrderById(id)));
    }

    public Order saveOrder(Order Order){
        return orderRepo.save(Order);
    }

    public Order updateOrder(Order updatedOrder, long id){

        Order existingOrder = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setOrderName(updatedOrder.getOrderName());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setStatus(updatedOrder.getStatus());

        return orderRepo.save(existingOrder);

    }

    public void delete(long id) {
        Order existing = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepo.delete(existing);
    }

}
