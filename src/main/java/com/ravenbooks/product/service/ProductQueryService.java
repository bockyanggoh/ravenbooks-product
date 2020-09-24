package com.ravenbooks.product.service;

import com.ravenbooks.product.cqrs.query.FindProductQuery;
import com.ravenbooks.product.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductQueryService {
    private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public CompletableFuture<Product> findById(String productId) {
        return this.queryGateway.query(
                new FindProductQuery(productId),
                ResponseTypes.instanceOf(Product.class)
        );
    }

    public List<Object> listEventsForProduct(String productId) {
        log.info(productId);
        return this.eventStore
                .readEvents(productId)
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }
}
