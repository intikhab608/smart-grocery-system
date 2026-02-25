package com.grocery.OrderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grocery.OrderService.dto.ProductDTO;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/product/{id}")
    ProductDTO getProduct(@PathVariable("id") Long id);
}

