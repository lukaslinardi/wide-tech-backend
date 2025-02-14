package com.felix.wide_tech_backend.repository;

import com.felix.wide_tech_backend.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> { }