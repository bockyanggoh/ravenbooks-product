package com.ravenbooks.product.domain.product;

import com.ravenbooks.product.cqrs.event.ProductCreatedEvent;
import com.ravenbooks.product.model.CreateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ProcessingGroup("iem")
public class IEMHandler {
    @EventHandler
    public void handleEvent(ProductCreatedEvent event) {
        log.info(event.id);
    }
}
