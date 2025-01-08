package com.jmismail.ecommerce.controllers;

import com.jmismail.ecommerce.dto.CreateProductDto;
import com.jmismail.ecommerce.models.Product;
import com.jmismail.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {
    final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    List<Product> products = List.of();


    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productService.listProducts();
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> getProduct(@PathVariable String productId){
        return this.productService.getProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@RequestBody @Valid CreateProductDto createProductDto,
                                 @PathVariable String productId ){

        System.out.println(productId);

        return  this.productService.updateProduct(
                productId,
                new Product(
                        createProductDto.getName(),
                        createProductDto.getDescription(),
                        createProductDto.getPrice(),
                        "INR"
                )
        );
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody @Valid CreateProductDto createProductDto){
        System.out.println(createProductDto.toString());

        return  this.productService.createProduct(
                new Product(
                        createProductDto.getName(),
                        createProductDto.getDescription(),
                        createProductDto.getPrice(),
                        "INR"
                )
        );
    }
}
