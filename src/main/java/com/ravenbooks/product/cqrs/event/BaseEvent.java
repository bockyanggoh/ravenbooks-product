package com.ravenbooks.product.cqrs.event;

public class BaseEvent<T> {
    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
