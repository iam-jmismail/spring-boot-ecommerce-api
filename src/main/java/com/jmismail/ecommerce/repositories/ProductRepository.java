package com.jmismail.ecommerce.repositories;

import com.jmismail.ecommerce.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
 // Custom Query Methods if any
}
