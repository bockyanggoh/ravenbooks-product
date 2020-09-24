package com.ravenbooks.product.exception;

public class ProductNotFoundException extends Throwable{

    public ProductNotFoundException(String uuid) {
        super("Cannot find Product with Id of " + uuid);
    }
}
