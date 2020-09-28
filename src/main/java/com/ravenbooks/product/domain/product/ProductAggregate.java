package com.ravenbooks.product.domain.product;

import com.ravenbooks.product.cqrs.command.CreateProductCommand;
import com.ravenbooks.product.cqrs.command.DeleteProductCommand;
import com.ravenbooks.product.cqrs.command.UpdateProductCommand;
import com.ravenbooks.product.cqrs.command.UpdateProductStocksCommand;
import com.ravenbooks.product.cqrs.event.ProductCreatedEvent;
import com.ravenbooks.product.cqrs.event.ProductStocksUpdatedEvent;
import com.ravenbooks.product.cqrs.event.ProductUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String productName;
    private String productDescription;
    private String imgUrl;
    private String isbn;
    private int stocks;
    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;

    @CommandHandler
    public ProductAggregate(CreateProductCommand cmd) {
        apply(new ProductCreatedEvent(
                cmd.getId(),
                cmd.getProductName(),
                cmd.getProductDescription(),
                cmd.getImgUrl(),
                cmd.getIsbn(),
                cmd.getStocks(),
                cmd.getCreatedTs(),
                cmd.getUpdatedTs()
        ));
    }

    @CommandHandler
    public void handle(UpdateProductStocksCommand cmd) {
            if(cmd.getStocksUpdateAmount() == 0) {
            throw new IllegalArgumentException("Product Stocks update amount cannot be 0.");
        }
        stocks += cmd.getStocksUpdateAmount();
        apply(new ProductStocksUpdatedEvent(cmd.id, cmd.getStocksUpdateAmount()));
    }



    @CommandHandler
    public void handle(DeleteProductCommand cmd) {
        if (cmd.id.equals(id)) {
            AggregateLifecycle.markDeleted();
        } else {
            throw new IllegalArgumentException("Record not found, failed to delete.");
        }
    }

    @CommandHandler
    public void handle(UpdateProductCommand cmd) {
        AggregateLifecycle.
        apply(new ProductStocksUpdatedEvent(cmd.id, cmd.getStocksUpdateAmount()));
    }

    @EventSourcingHandler
    public void handle(ProductCreatedEvent event) {
        this.id = event.id;
        this.productName = event.getProductName();
        this.productDescription = event.getProductDescription();
        this.imgUrl = event.getImgUrl();
        this.isbn = event.getIsbn();
        this.createdTs = event.getCreatedTs();
        this.updatedTs = event.getUpdatedTs();
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent event) {
        this.productName = event.getProductName();
        this.productDescription = event.getProductDescription();
        this.isbn = event.getIsbn();
        this.imgUrl = event.getImgUrl();
        this.updatedTs = event.getUpdatedTs();
    }

    @EventSourcingHandler
    public void on(ProductStocksUpdatedEvent event) {
        this.stocks = event.getNewStocksAmount();
    }
}
