package com.ravenbooks.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {

    @GetMapping("/placeholder")
    public ResponseEntity placeholder() {
        return ResponseEntity.ok().build();
    }
}