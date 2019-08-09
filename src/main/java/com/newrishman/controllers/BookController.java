package com.newrishman.controllers;

import com.newrishman.domain.Book;
import com.newrishman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService service;

    @Autowired
    public void setBookService(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> books() { return service.findAll(); }

    @PostMapping("/save/")
    public void saveNote(Book book) {
        service.saveBook(book);
    }

    @GetMapping("/edit/{id}")
    public Book edit(@PathVariable long id) { return service.getBookById(id); }

    @PutMapping("/update")
    public void updateNote(Book book) {

        if (book.getId() == 0) {
            service.saveBook(book);
        } else {
            service.updateBook(book);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteBook(id);
    }

}

