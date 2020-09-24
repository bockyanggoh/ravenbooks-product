package com.ravenbooks.product.controller;

import com.ravenbooks.product.domain.product.Product;
import com.ravenbooks.product.model.CreateProductRequest;
import com.ravenbooks.product.model.UpdateProductStocksRequest;
import com.ravenbooks.product.service.ProductCommandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductsCommandController {
    private final ProductCommandService productCommandService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<Product> createProductApi(@Valid @RequestBody CreateProductRequest req) {
        return this.productCommandService.createProduct(req);
    }

    @PostMapping("/{id}/stocks")
    public CompletableFuture<Product> updateProductStocksApi(@PathVariable String id, @Valid @RequestBody UpdateProductStocksRequest req) {
        return this.productCommandService.updateProductStocks(id, req);
    }

    @PostMapping("/{id}")
    public ResponseEntity updateProductApi(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductApi(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}
