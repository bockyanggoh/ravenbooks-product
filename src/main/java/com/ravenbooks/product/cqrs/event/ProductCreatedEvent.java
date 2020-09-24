package com.ravenbooks.product.cqrs.event;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ProductCreatedEvent extends BaseEvent<String>{
    String productName;
    String productDescription;
    String imgUrl;
    String isbn;
    int stocks;
    LocalDateTime createdTs;
    LocalDateTime updatedTs;

    public ProductCreatedEvent(String id, String productName, String productDescription, String imgUrl, String isbn, int stocks, LocalDateTime createdTs, LocalDateTime updatedTs) {
        super(id);
        this.productName = productName;
        this.productDescription = productDescription;
        this.imgUrl = imgUrl;
        this.isbn = isbn;
        this.stocks = stocks;
        this.createdTs = createdTs;
        this.updatedTs = updatedTs;
    }
}
