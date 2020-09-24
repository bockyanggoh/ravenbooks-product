package com.ravenbooks.product.domain.product;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    EventSourcingRepository<ProductAggregate> productAggregateEventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository
                .builder(ProductAggregate.class)
                .eventStore(eventStore)
                .build();
    }
}
