package com.grocery.product_service.service;

import com.grocery.product_service.ProductServiceApplication;
import com.grocery.product_service.entity.Product;
import com.grocery.product_service.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getProduct(){
        return productRepo.findAll();
    };

    public Product getProductById(long id){
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("product not found with id : " + getProductById(id)));
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Product updatedProduct, long id){

        Product existingProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setPrice(updatedProduct.getPrice());

        return productRepo.save(existingProduct);

    }

    public void delete(long id) {
        Product existing = productRepo.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
        productRepo.delete(existing);
    }
}
