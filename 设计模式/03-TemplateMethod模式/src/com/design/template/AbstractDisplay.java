package com.design.template;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/21 17:54
 */
public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
