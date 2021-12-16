package com.design.iterator;

import java.util.ArrayList;

/**
 * 书架
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/16 16:55
 */
public class BookShelf implements Aggregate {
    // private Book[] books;
    private final ArrayList<Book> books;
    private int last = 0;

    public BookShelf(int maxSize) {
        // this.books = new Book[maxSize];
        this.books = new ArrayList<>(maxSize);
    }

    public Book getBookAt(int index) {
        // return books[index];
        return books.get(index);
    }

    public void appendBook(Book book) {
        // this.books[last] = book;
        this.books.add(book);
        this.last++;
    }

    public int getLength() {
        return this.last;
    }


    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
