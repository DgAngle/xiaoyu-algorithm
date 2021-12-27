package com.design.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/27 15:02
 */
public class IDCardFactory extends Factory {

    private List<Object> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    public List<Object> getOwners() {
        return owners;
    }
}
