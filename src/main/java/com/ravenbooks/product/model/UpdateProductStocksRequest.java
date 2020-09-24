package com.ravenbooks.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductStocksRequest {
    @Min(1)
    @Max(10000)
    private int stockChangeAmount;
}
