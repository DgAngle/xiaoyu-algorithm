package com.design.iterator;

/**
 * 书架迭代类
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/16 17:17
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) return true;
        return false;
    }

    @Override
    public Object next() {
        return bookShelf.getBookAt(index++);
    }
}
