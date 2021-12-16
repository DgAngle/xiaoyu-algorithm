package com.design.iterator;

/**
 * Iterator(迭代器)模式 测试类
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/16 16:25
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("《Around the World in 80 Days》")); // 《环游世界80天》
        bookShelf.appendBook(new Book("《Bible》")); // 《圣经》
        bookShelf.appendBook(new Book("《Cinderella》")); // 《灰姑娘》
        bookShelf.appendBook(new Book("《Daddy Long Legs》"));// 《长腿爸爸》
        bookShelf.appendBook(new Book("《Daddy Long Legs 2》"));// 《长腿爸爸》
        bookShelf.appendBook(new Book("《Daddy Long Legs 3》"));// 《长腿爸爸》
        bookShelf.appendBook(new Book("《Daddy Long Legs 4》"));// 《长腿爸爸》
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
