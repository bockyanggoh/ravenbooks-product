package com.ravenbooks.product.service;

import com.ravenbooks.product.cqrs.command.CreateProductCommand;
import com.ravenbooks.product.cqrs.command.UpdateProductStocksCommand;
import com.ravenbooks.product.domain.product.Product;
import com.ravenbooks.product.model.CreateProductRequest;
import com.ravenbooks.product.model.UpdateProductStocksRequest;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ProductCommandService {
    private final CommandGateway commandGateway;

    public CompletableFuture<Product> createProduct(CreateProductRequest req) {
        return this.commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                req,
                LocalDateTime.now(),
                null
        ));
    }

    public CompletableFuture<Product> updateProductStocks(String id, UpdateProductStocksRequest req) {
        return this.commandGateway.send(new UpdateProductStocksCommand(
                id,
                req.getStockChangeAmount()
        ));
    }
}
