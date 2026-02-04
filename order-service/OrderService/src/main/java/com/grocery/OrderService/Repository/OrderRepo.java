package com.grocery.OrderService.Repository;

import org.springframework.stereotype.Repository;
import com.grocery.OrderService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
