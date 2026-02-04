package com.grocery.OrderService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grocery.OrderService.Entity.Order;
import com.grocery.OrderService.Repository.OrderRepo;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
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
