package com.felix.wide_tech_backend.repository;

import com.felix.wide_tech_backend.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Page<Products> findAll(Pageable pageable);
}