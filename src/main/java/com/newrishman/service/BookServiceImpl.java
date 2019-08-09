package com.newrishman.service;

import com.newrishman.domain.Book;
import com.newrishman.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    @Autowired
    public void setProductRepository(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book getBookById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void saveBook(Book book) {
        repository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book update = repository.getOne(book.getId());
        update.setBookAuthor(book.getBookAuthor());
        update.setBookName(book.getBookName());
        update.setPrice(book.getPrice());
        repository.save(update);
    }

    @Override
    public void deleteBook(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }
}
