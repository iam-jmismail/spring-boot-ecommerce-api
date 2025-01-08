package com.jmismail.ecommerce.services;

import com.jmismail.ecommerce.models.Product;
import com.jmismail.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product createProduct(Product product){

        // Check Product already exists
        Optional<Product> existingProduct = productRepository.findByName(product.getName());

        if(existingProduct.isPresent()){
                throw  new RuntimeException("Product already exists");
        }


        return productRepository.save(product);
    }

    public List<Product> listProducts(){
        return  productRepository.findAll();
    }

    public  Optional<Product> getProduct(String productId){
        Optional<Product> product = productRepository.findById(productId);

        if(product.isEmpty())  throw  new RuntimeException("Invalid Product Id");

        return  product;
    }

    public Product updateProduct(String productId, Product product){

        Product existingProduct = this.getProduct(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        if(product.getName() != null){
            existingProduct.setName(product.getName());
        }

        if(product.getDescription() != null){
            existingProduct.setDescription(product.getDescription());
        }

        if(product.getPrice() > 0){
            existingProduct.setPrice(product.getPrice());
        }
        return productRepository.save(existingProduct);

    }
}
