package com.grocery.OrderService.Controller;

import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.grocery.OrderService.Service.OrderService;
import com.grocery.OrderService.dto.OrderFullResponse;
import com.grocery.OrderService.Entity.Order;

@RestController
public class OrderController {

   private final OrderService orderService;

    public OrderController(OrderService orderService){
         this.orderService = orderService;
    }

     @GetMapping("/fullorders/{id}")
    public OrderFullResponse getFullOrder(@PathVariable Long id) {
        return orderService.getCompleteOrder(id);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders());
    }


    @GetMapping("orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable long id){
        Order orderById = orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderById);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> saveorder(@RequestBody Order order){
        Order orders = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateProject(@RequestBody Order order,@PathVariable long id){

        Order updateorder = orderService.updateOrder(order,id);
        return ResponseEntity.status(HttpStatus.OK).body(updateorder);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteorder(@PathVariable long id){
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
