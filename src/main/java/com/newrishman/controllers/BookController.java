package com.newrishman.controllers;

import com.newrishman.domain.Book;
import com.newrishman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private BookService service;

    @Autowired
    public void setBookService(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<Book> books() {
        List<Book> books = service.findAll();
        return books;
    }

    @PostMapping("/save")
    public void updateBook(@RequestParam String bookName, @RequestParam String bookAuthor, @RequestParam int price) {
        service.saveBook(new Book(bookName, bookAuthor, price));
    }

    @GetMapping("/edit/{id}")
    public Book edit(@PathVariable Long id) {
        Book book = service.getBookById(id);
        return book;
    }

    @PostMapping("/update")
    public void saveNote(@RequestParam Long id, @RequestParam String bookName,
                         @RequestParam String bookAuthor, @RequestParam int price) {
        service.updateBook(id, bookName, bookAuthor, price);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBook(id);
    }

}

