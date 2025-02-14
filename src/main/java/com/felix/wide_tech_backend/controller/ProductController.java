package com.felix.wide_tech_backend.controller;

import com.felix.wide_tech_backend.dto.CustomResponse;
import com.felix.wide_tech_backend.entity.Products;
import com.felix.wide_tech_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        CustomResponse customResponse = new CustomResponse();
        Map<String, String> message = new HashMap<>();

        try{
            message.put("en", "Success");
            message.put("id", "Sukses");
            List<Products> res = productService.getProducts();
            customResponse.CustomResponse(HttpStatus.OK, message, res);
            return ResponseEntity.ok(customResponse);
        } catch (Exception e) {
            message.put("en", "Failed to get data");
            message.put("id", "Gagal mengambil data");
            customResponse.CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, message, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
        }

    };

}
