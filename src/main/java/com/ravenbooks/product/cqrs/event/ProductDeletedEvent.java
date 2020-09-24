package com.ravenbooks.product.cqrs.event;

public class ProductDeletedEvent extends BaseEvent<String>{
    public ProductDeletedEvent(String id) {
        super(id);
    }
}
