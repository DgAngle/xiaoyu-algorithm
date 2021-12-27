package com.design.factory;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/27 14:59
 */
public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("制作 " + owner + " 的 ID 卡.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用 " + owner + " 的 ID 卡.");
    }

    public String getOwner() {
        return owner;
    }
}
