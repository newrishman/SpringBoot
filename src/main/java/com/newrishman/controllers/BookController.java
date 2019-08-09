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
    public List<Book> books() {
        List<Book> books = service.findAll();
        System.out.println(books);
        return books;
    }

    @PostMapping("/save/")
    public void saveNote(@RequestParam String bookName, @RequestParam String bookAuthor, @RequestParam int price) {
        service.saveBook(new Book(bookName, bookAuthor, price));
    }

    @GetMapping("/edit/{id}")
    public Book edit(@PathVariable long id) {
        Book book = service.getBookById(id);
        return book;
    }

    @PutMapping("/update")
    public void updateNote(@RequestParam long id, @RequestParam String bookName,
                         @RequestParam String bookAuthor, @RequestParam int price) {
        service.updateBook(id, bookName, bookAuthor, price);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteBook(id);
    }

}

