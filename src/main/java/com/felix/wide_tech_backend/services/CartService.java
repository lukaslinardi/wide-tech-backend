package com.felix.wide_tech_backend.services;

import com.felix.wide_tech_backend.entity.Carts;
import com.felix.wide_tech_backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Page<Carts> getCarts(int page, int size) {
        return cartRepository.findAll(PageRequest.of(page, size));
    };

    public void createCarts(List<Carts> carts) {
        cartRepository.saveAll(carts);
    };


}
