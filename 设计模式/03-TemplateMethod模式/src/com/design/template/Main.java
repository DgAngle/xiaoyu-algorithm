package com.design.template;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/21 18:01
 */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay ad1 = new CharDisplay('*');
        AbstractDisplay ad2 = new StringDisplay("我要变优秀!");
        ad1.display();
        ad2.display();
    }
}
