package com.ravenbooks.product.cqrs.command;

import com.ravenbooks.product.model.UpdateProductStocksRequest;
import lombok.Value;

@Value
public class UpdateProductStocksCommand extends BaseCommand<String> {
    int stocksUpdateAmount;

    public UpdateProductStocksCommand(String id, int stocksUpdateAmount) {
        super(id);
        this.stocksUpdateAmount = stocksUpdateAmount;
    }
}
