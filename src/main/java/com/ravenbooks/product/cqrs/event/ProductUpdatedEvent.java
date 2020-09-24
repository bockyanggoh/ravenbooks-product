package com.ravenbooks.product.cqrs.event;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ProductUpdatedEvent extends BaseEvent<String>{
    String productName;
    String productDescription;
    String imgUrl;
    String isbn;
    LocalDateTime updatedTs;

    public ProductUpdatedEvent(String id, String productName, String productDescription, String imgUrl, String isbn, LocalDateTime updatedTs) {
        super(id);
        this.productName = productName;
        this.productDescription = productDescription;
        this.imgUrl = imgUrl;
        this.isbn = isbn;
        this.updatedTs = updatedTs;
    }
}
