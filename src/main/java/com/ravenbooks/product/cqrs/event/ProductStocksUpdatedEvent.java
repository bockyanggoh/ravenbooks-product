package com.ravenbooks.product.cqrs.event;

import lombok.Value;

@Value
public class ProductStocksUpdatedEvent extends BaseEvent<String> {
    int newStocksAmount;
    public ProductStocksUpdatedEvent(String id, int newStocksAmount) {
        super(id);
        this.newStocksAmount = newStocksAmount;
    }
}
