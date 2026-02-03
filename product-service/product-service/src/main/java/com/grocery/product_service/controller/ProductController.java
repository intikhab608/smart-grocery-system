package com.grocery.product_service.controller;

import com.grocery.product_service.entity.Product;
import com.grocery.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts(){

        List<Product> products = productService.getProduct();
        return  ResponseEntity.status(HttpStatus.OK).body(products);

    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product productById = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productById);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product products = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProject(@RequestBody Product product,@PathVariable long id){

        Product updateProduct = productService.updateProduct(product,id);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

