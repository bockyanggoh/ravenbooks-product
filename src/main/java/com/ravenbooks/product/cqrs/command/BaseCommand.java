package com.ravenbooks.product.cqrs.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class BaseCommand<T> {
    @TargetAggregateIdentifier
    public final T id;

}
