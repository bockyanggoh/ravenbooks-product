package com.ravenbooks.product.cqrs.command;

import lombok.Value;

@Value
public class UpdateProductCommand extends BaseCommand<String>{

    int stocksUpdateAmount;
    public UpdateProductCommand(String id, int stocksUpdateAmount) {
        super(id);
        this.stocksUpdateAmount = stocksUpdateAmount;
    }
}
