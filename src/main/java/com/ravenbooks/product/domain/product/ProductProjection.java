package com.ravenbooks.product.domain.product;

import com.ravenbooks.product.cqrs.event.ProductCreatedEvent;
import com.ravenbooks.product.cqrs.event.ProductDeletedEvent;
import com.ravenbooks.product.cqrs.event.ProductStocksUpdatedEvent;
import com.ravenbooks.product.cqrs.event.ProductUpdatedEvent;
import com.ravenbooks.product.cqrs.query.FindProductQuery;
import com.ravenbooks.product.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ProductProjection {
    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        log.info("Creating Product for id {}", event.id);
        var product = new Product(
                event.id,
                event.getProductName(),
                event.getProductDescription(),
                event.getImgUrl(),
                event.getIsbn(),
                event.getStocks(),
                event.getCreatedTs(),
                event.getUpdatedTs()
        );
        this.productRepository.save(product);
    }

    @EventHandler
    public void on(ProductUpdatedEvent event) throws ProductNotFoundException {
        log.info("Updating Product for id {}", event.id);
        Optional<Product> retrieved = this.productRepository.findById(event.id);
        if(retrieved.isEmpty())
            throw new ProductNotFoundException(event.id);
        var product = retrieved.get();
        product.setProductName(event.getProductName());
        product.setProductDescription(event.getProductDescription());
        product.setImgUrl(event.getImgUrl());
        product.setIsbn(event.getIsbn());
        product.setUpdatedTs(event.getUpdatedTs());
        this.productRepository.save(product);
    }

    @EventHandler
    public void on(ProductStocksUpdatedEvent event) throws ProductNotFoundException {
        log.info("Updating Product Stocks for id {}", event.id);
        Optional<Product> retrieved = this.productRepository.findById(event.id);
        if (retrieved.isEmpty())
            throw new ProductNotFoundException(event.id);
        var product = retrieved.get();
        product.setStocks(product.getStocks() + event.getNewStocksAmount());
        this.productRepository.save(product);
    }

    @EventHandler
    public void on(ProductDeletedEvent event) throws ProductNotFoundException{
        log.info("Updating Product Stocks for id {}", event.id);
        Optional<Product> retrieved = this.productRepository.findById(event.id);
        if (retrieved.isEmpty())
            throw new ProductNotFoundException(event.id);
        this.productRepository.delete(retrieved.get());
    }

    @QueryHandler
    public Product handle(FindProductQuery query) {
        return this.productRepository.findById(query.getId()).orElse(null);
    }

}
