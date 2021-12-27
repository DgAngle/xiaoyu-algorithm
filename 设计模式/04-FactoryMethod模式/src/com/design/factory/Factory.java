package com.design.factory;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/27 14:54
 */
public abstract class Factory {
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
