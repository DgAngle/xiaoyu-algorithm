package com.design.adapter;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/20 18:20
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
