package com.newrishman.service;

import com.newrishman.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    Book getBookById(Long id);

    void saveBook(Book book);

    void updateBook(Long id, String bookName, String bookAuthor, int price);

    void deleteBook(Long id);

    List<Book> findAll();
}