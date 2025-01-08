package com.jmismail.ecommerce.controllers;

import com.jmismail.ecommerce.dto.CreateProductDto;
import com.jmismail.ecommerce.models.Product;
import com.jmismail.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProductsController {
    final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    List<Product> products = List.of(
            new Product("1", "Dell laptop", "Laptop", 120000, "INR"),
            new Product("2", "Macbook Air M1", "Laptop", 180000, "INR")
    );


    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.products;
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable String productId){
        System.out.println(productId);

        return this.products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/products/{productId}")
    public String updateProduct(){
        return  "Product Updated";
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody @Valid CreateProductDto createProductDto){
        System.out.println(createProductDto.toString());
        return  this.productService.createProduct(createProductDto);
    }
}
