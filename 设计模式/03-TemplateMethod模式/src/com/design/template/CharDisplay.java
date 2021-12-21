package com.design.template;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/21 17:56
 */
public class CharDisplay extends AbstractDisplay {
    private Character ch;

    public CharDisplay(Character ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);

    }

    @Override
    public void close() {
        System.out.println(">>");

    }
}
