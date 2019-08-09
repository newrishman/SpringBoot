package com.newrishman.domain;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue

    private Long id;
    @Column(name = "Book_Name")
    private String bookName;
    @Column(name = "Book_Author")
    private String bookAuthor;
    @Column(name = "Book_Price")
    private int price;

    public Book() {
    }

    public Book( String bookName, String bookAuthor, int price) {

        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName(String bookName) {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor(String bookAuthor) {
        return this.bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getPrice(int price) {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", price=" + price +
                '}';
    }


}
