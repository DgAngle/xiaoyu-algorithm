package com.design.adapter;

/**
 * 实际情况
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/20 18:21
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    // 用括弧展示
    public void showWithParen() {
        System.out.println("( " + this.string + " )");

    }

    // 用星状体展示
    public void showWithAster() {
        System.out.println("* " + this.string + " *");
    }
}
