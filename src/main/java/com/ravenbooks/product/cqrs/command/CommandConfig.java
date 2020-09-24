package com.ravenbooks.product.cqrs.command;

import org.axonframework.common.caching.Cache;
import com.ravenbooks.product.domain.product.ProductAggregate;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommandConfig {
    @Bean
    public Repository<ProductAggregate> productAggregateRepository(EventStore eventStore, Cache cache) {
        return EventSourcingRepository.builder(ProductAggregate.class)
                .cache(cache)
                .eventStore(eventStore)
                .build();
    }

    @Bean
    public Cache cache() {
        return new WeakReferenceCache();
    }
}
