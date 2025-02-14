package com.felix.wide_tech_backend.services;

import com.felix.wide_tech_backend.entity.Products;
import com.felix.wide_tech_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Products> getProducts() {
        return productRepo.findAll();
    }
}
