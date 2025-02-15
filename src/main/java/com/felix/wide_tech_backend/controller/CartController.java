package com.felix.wide_tech_backend.controller;

import com.felix.wide_tech_backend.dto.CustomResponse;
import com.felix.wide_tech_backend.entity.Carts;
import com.felix.wide_tech_backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<?> getCarts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        CustomResponse customResponse = new CustomResponse();
        Map<String, String> message = new HashMap<>();

        try{
            message.put("en", "Success");
            message.put("id", "Sukses");
            Page<Carts> res = cartService.getCarts(page, size);
            customResponse.CustomResponse(HttpStatus.OK, message, res);
            return ResponseEntity.ok(customResponse);
        } catch (Exception e) {
            message.put("en", "Failed to get data");
            message.put("id", "Gagal mengambil data");
            customResponse.CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, message, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
        }
    };

    @PostMapping
    public ResponseEntity<?> createOrders(@RequestBody List<Carts> newOrders) {
        CustomResponse customResponse = new CustomResponse();
        Map<String, String> message = new HashMap<>();

        try{
            message.put("en", "Success");
            message.put("id", "Sukses");
            cartService.createCarts(newOrders);
            customResponse.CustomResponse(HttpStatus.OK, message, null);
            return ResponseEntity.ok(customResponse);
        } catch (Exception e) {
            message.put("en", "Failed to get data");
            message.put("id", "Gagal mengambil data");
            customResponse.CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, message, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
        }

    };



}
