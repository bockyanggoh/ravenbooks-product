package com.ravenbooks.product.cqrs.command;


import com.ravenbooks.product.model.CreateProductRequest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
public class CreateProductCommand extends BaseCommand<String>{
    String productName;
    String productDescription;
    String imgUrl;
    String isbn;
    int stocks;
    LocalDateTime createdTs;
    LocalDateTime updatedTs;


    public CreateProductCommand(String id, CreateProductRequest request, LocalDateTime createdTs, LocalDateTime updatedTs) {
        super(id);
        this.productName = request.getProductName();
        this.productDescription = request.getProductDescription();
        this.imgUrl = request.getImgUrl();
        this.isbn = request.getIsbn();
        this.stocks = request.getStocks();
        this.createdTs = createdTs;
        this.updatedTs = updatedTs;
    }

    public CreateProductCommand(String id) {
        super(id);
    }
}

