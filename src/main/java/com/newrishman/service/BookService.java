package com.newrishman.service;

import com.newrishman.domain.Book;

import java.util.List;

public interface BookService {

    Book getBookById(long id);

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBook(long id);

    List<Book> findAll();
}