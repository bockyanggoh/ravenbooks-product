package com.ravenbooks.product.cqrs.command;


import com.ravenbooks.product.cqrs.event.ProductUpdatedEvent;

public class DeleteProductCommand extends BaseCommand<String> {
    public DeleteProductCommand(String id) {
        super(id);
    }
}
