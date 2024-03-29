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
    public List<Book> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Long add(@RequestBody Book book) {
        return service.saveBook(book).getId();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable long id) {
        return service.getBookById(id);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        service.updateBook(book);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteBook(id);
    }

}

