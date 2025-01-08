package com.jmismail.ecommerce.services;

import com.jmismail.ecommerce.dto.CreateProductDto;
import com.jmismail.ecommerce.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public Product createProduct(CreateProductDto createProductDto){




        return  new Product("1", createProductDto.getName(),
                createProductDto.getDescription(),
                createProductDto.getPrice(),
                createProductDto.getDescription());
    }
}
