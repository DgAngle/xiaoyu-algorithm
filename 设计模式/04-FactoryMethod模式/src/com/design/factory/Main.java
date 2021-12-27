package com.design.factory;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/27 15:15
 */
public class Main {
    public static void main(String[] args) {
        IDCardFactory idFactory = new IDCardFactory();
        Product yaYi = idFactory.createProduct("芽衣");
        Product qiYana = idFactory.createProduct("琪亚娜");
        Product bigSister = idFactory.createProduct("学姐");
        Product smallSister = idFactory.createProduct("学妹");

        yaYi.use();
        qiYana.use();
        bigSister.use();
        smallSister.use();
    }
}
