package com.ravenbooks.product.controller;

import com.ravenbooks.product.domain.product.Product;
import com.ravenbooks.product.service.ProductQueryService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/products")
@Api(value = "Products Queries", produces = "application/json", consumes = "application/json")
@AllArgsConstructor
public class ProductsQueryController {
    private final ProductQueryService queryService;

    @GetMapping
    public ResponseEntity getAllProductsApi() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public CompletableFuture<Product> getProductApi(@PathVariable String id) {
        return queryService.findById(id);
    }

    @GetMapping(value = "/{id}/events")
    public List<Object> listEventsForProduct(@PathVariable String id) {
        return this.queryService.listEventsForProduct(id);
    }

}
