package com.newrishman.controllers;

import com.newrishman.domain.Book;
import com.newrishman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService service;

    @Autowired
    public void setBookService(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> booksa() {
        List<Book> books = service.findAll();
        return books;
    }

    @PostMapping("/save")
    public void updateBook(@RequestParam String bookName, @RequestParam String bookAuthor, @RequestParam int price) {
        service.saveBook(new Book(bookName, bookAuthor, price));
    }

    @GetMapping("/edit/{id}")
    public Book edit(@PathVariable long id) {
        Book book = service.getBookById(id);
        return book;
    }

    @PostMapping("/update")
    public void saveNote(@RequestParam long id, @RequestParam String bookName,
                         @RequestParam String bookAuthor, @RequestParam int price) {
        service.updateBook(id, bookName, bookAuthor, price);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteBook(id);
    }

}

