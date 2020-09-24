package com.ravenbooks.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    @NotNull
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productDescription;
    @NotEmpty
    private String imgUrl;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String isbn;
    @Min(1)
    @Max(500000)
    private int stocks;
}
